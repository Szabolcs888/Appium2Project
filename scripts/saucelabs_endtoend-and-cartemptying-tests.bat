@echo off

:: Go to the root of the project (one level up from the scripts folder)
cd /d %~dp0..
echo Running from: %cd%

:: Test run
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testng-configs/testng-saucelabs_endtoend-and-cartemptying-tests.xml

pause