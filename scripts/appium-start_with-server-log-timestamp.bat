@echo off
cd /d %~dp0..

:: Generate a date and timestamp using PowerShell
for /f %%a in ('powershell -NoProfile -Command "Get-Date -Format \"yyyy-MM-dd_HH-mm-ss\""') do set timestamp=%%a

set LOGFILE=logs/appium-server/appium-server-%timestamp%.log

:: If Appium is already running, do not restart it
netstat -ano | findstr :4723 >nul
if %ERRORLEVEL% == 0 (
    echo Appium is already running on port 4723!
    pause
    exit /b
)

echo Logging to %LOGFILE%
appium --log "%LOGFILE%" --log-level info --local-timezone