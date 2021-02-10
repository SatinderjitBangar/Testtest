pipeline {
    options {
        buildDiscarder(logRotator(numToKeepStr: '1', artifactNumToKeepStr: '1'))
    }
    parameters {
        string(name: 'branch', defaultValue: 'master', description: 'choose the branch to test (master / release/1.0.0.x)')
    }
    agent any
    stages {
        stage('CleanWorkspace') {
            steps {
                cleanWs()
            }
        }
        stage('Test') {
            steps {
                dir("${env.WORKSPACE}/test") {
                        git branch: "${params.branch}", credentialsId: 'tdyck', url: 'git@bitbucket.org:harcourtconsulting/cedallion-functional-qa.git'
                        sh """
                                    mkdir -p ${env.WORKSPACE}/test/Drivers;
                                    mkdir -p ${env.WORKSPACE}/test/ExtentReport;

                                    #firefox
                                    #https://github.com/mozilla/geckodriver/releases

                                    #chrome
                                    #https://chromedriver.chromium.org/downloads

                                    #edge (not supported on linux amd64).  I suppose I'll need to spin up a windows box for this...
                                    #https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
                                    #sed -i 's@edgepath =.*@edgepath = Drivers/msedgedriver.exe@g' ${env.WORKSPACE}/test/Configuration/config.properties

                                    cp -r ${env.WORKSPACE}/../Drivers/* ${env.WORKSPACE}/test/Drivers
                                    sed -i 's@chromepath =.*@chromepath = Drivers/chromedriver@g' ${env.WORKSPACE}/test/Configuration/config.properties
                                    sed -i 's@ffpath =.*@ffpath = Drivers/geckodriver@g' ${env.WORKSPACE}/test/Configuration/config.properties
                                    sed -i 's@os =.*@os = linux@g' ${env.WORKSPACE}/test/Configuration/config.properties

                                    # MSEdge doesn't support linux, so removing the test case.
                                    sed -i '/.*CPM_MSEdgeTestSuite.*/,/test>/{/^#/!{//!d}}' ${env.WORKSPACE}/test/testng.xml

                                    mvn clean test -DsuiteXmlFile=testng.xml
                        """
                }
            }
        }
    }
    post {
    	always {
	    echo "uploading results"
	    sh """
	        mkdir /usr/share/nginx/html/${BUILD_NUMBER}
	        cp -r ${env.WORKSPACE}/test/ /usr/share/nginx/html/nginx/${BUILD_NUMBER}
  		sudo /bin/systemctl reload nginx.service
	    """
            echo "Success!"
            //slackSend channel: '#builds', message: 'Build success!'
	}
        failure {
            echo "whoops"
	    sh 'echo  "There was a failure in the QA Cedallion Jenkins job, please check http://jenkins.cedallion.com/job/cedallion-functional-qa/" | mailx -vvv -s "QA Cedallion Jenkins Failure" qa@cedallion.com'
        }
    }
}
