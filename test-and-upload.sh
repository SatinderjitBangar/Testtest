mvn clean test -DsuiteXmlFile=testng.xml
dirs=("ExtentReport" "Screenshots" "log" "testng.xml" "Configuration" "pom.xml" "target")
thedate=$(date +%s)
branch=$(git rev-parse --abbrev-ref HEAD)
for dir in ${dirs[@]}; do
  scp -r $dir someuser@165.227.41.115:/usr/share/nginx/html/nginx/windows-$(git rev-parse --abbrev-ref HEAD)-${thedate}
done
# Send email notification?
ssh someuser@165.227.41.115 'echo  "Please view the test result here: http://jenkins.cedallion.com/nginx/windows-${branch}-${thedate}" | mailx -vvv -s "Cedallion test case completed or failed" hardeep@busyqa.com kruthika.busyqa@gmail.com'
