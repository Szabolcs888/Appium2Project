@echo off

:: Go to the root of the project (one level up from the scripts folder)
cd /d %~dp0..
echo Running from: %cd%

:: Set runtime environment to Java 22
set JAVA_HOME=C:\Program Files\Java\jdk-22
set PATH=%JAVA_HOME%\bin;%PATH%

:: Test run
mvn test -Dsurefire.suiteXmlFiles=src/test/resources/testng-configs/testng-smoke.xml

pause