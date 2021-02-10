Steps To Execute Testcases Locally
----------------------------------

For Windows(only)
-----------------
1. Install Git and Java IDE eg: Ecllipse
2. Create a New folder in drive
3. Enter the folder
4. Right Click-->Git bash
5. Clone git repository
  "git clone https://username@bitbucket.org/harcourtconsulting/cedallion-functional-qa.git"
  -Change the username in the above command
  -Enter login information if promted
  -Clone command can also be found in user's bitbucket account
6. Download Drivers for 
  -Chrome: chromedirver.exe  Link: https://chromedriver.chromium.org/
  -FireFox: geckodriver.exe  Link: https://github.com/mozilla/geckodriver/
7. Create a New folder "Drivers" inside the project folder and put both driver files in it
8. Open IDE(Ecllipse) and import the project folder
9. Right Click testing.xml -->Open with text editor
10.Add/Uncomment testcases for Chrome and Firefox in testing.xml then save file
11.Open pom.xml Right Click-->Run as Maven Test


Additional Info
----------------
-Excel file for TestData for all the testcases can be found in testData folder
-Test case Reports can be found in ExtentReport folder


