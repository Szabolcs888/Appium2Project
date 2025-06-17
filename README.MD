# Appium 2 Project 
**Note: I will update RAEDME and the videos in a few days because more developments have been made in the project.**

The Appium 2 project was created for learning purposes, so that I could practice and improve my knowledge as a junior software tester. I wanted to create a test framework similar to the ones used in the workplace. During the development, I gained a lot of new experience and faced several challenges. Those who are familiar with mobile testing and Appium know how many things have to fall into place for everything to work properly (I am thinking here primarily of the countless prerequisites required for Appium to work, the installation and configuration of the Appium server and Appium Doctor, or the for contacting elements present on the page but not yet visible on the screen, etc.). I conducted the testing on a real mobile phone, a Xiaomi Redmi note 8t, and in the "cloud", on BrowserStack, which I will demonstrate in the videos below.

I built the framework from scratch, the core of which is provided by Java - Appium 2 - Selenium - TestNg - Log4J. It is able to upload the server logo, logging, screenshots of failed tests, reports (Extent reports, Emailable report) to the server and send them by email. Also, if the Appium server is not running in the background, it starts automatically from code. Tests read test data from file(s). The tests have been classified into groups and can be started from a file (you can see, for example, the "Smoke" test in the example video). The log messages are also structured; those that are included in tests of multiple test classes are outsourced to separate classes, both in the test and page sections. PMD and SpotBugs provided assistance in improving the code quality.

Of course, there are still countless opportunities for development and refinement. My next goals are parallel test execution and CI/CD integration (e.g. with Jenkins).

## Tech Stack
- **Java 22.0**
- **Maven 3.9.9**
- **Appium 2.19.0**
- **Appium Java Client 9.4.0**
- **Selenium 4.32.0**
- **TestNG 7.10.2**
- **Log4j 2.24.0**
- **Extent reports 5.1.2**
- **Sendgrid 4.10.3 (email sending)**
- **Netlify-CLI 18.0.4 (file upload to server)**
<br>

**Tested applications:** 
- **Sauce Labs app** [(MyDemoAppRN.1.3.0.build-244)](https://github.com/saucelabs/my-demo-app-rn/releases/ "link title") <br>
- **CURA Healthcare Service** [(Katalon demo webpage)](https://katalon-demo-cura.herokuapp.com// "link title") <br>
- **Battery Alarm app (v76)** [(Battery Alarm webpage)](https://www.batteryalarm.app/ "link title")
- **Chrome version: 137.0.7151.89**
<br>

>I deliberately did not put the files containing the test data in .gitignore, because they are fictitious and not private data. And I didn't include the file containing the data necessary for sending emails either, because what I uploaded was just a template, without my own data. In order for email sending to work, it is necessary to fill out the file with the data (if this is not fulfilled, the last method of tearDownSuite() must be commented out).

## Screenshots of the tests
<table>
<tr>
<td>
<img src="https://github.com/user-attachments/assets/ab09e32f-1bd4-436a-acaf-0233c53d481f" alt="Kép 1" width="300"/>
<br>
EndToEnd test (Sauce Labs)
</td>
<td>
<img src="https://github.com/user-attachments/assets/4c24d286-97eb-4bbd-a281-610fb9269b27" alt="Kép 2" width="300"/>
<br>
Login tests (Cura Healthcare)
</td>
<td>
<img src="https://github.com/user-attachments/assets/2004eedb-2a4a-4710-9356-9cb9c6a750ee" alt="Kép 3" width="300"/>
<br>
Page access tests (Battery Alarm)
</td>
</tr>
</table>

## Videos of the tests
<table>
<tr>
<td>
<a href="https://www.youtube.com/watch?v=r-YOHGOQKfM">
<img src="https://img.youtube.com/vi/r-YOHGOQKfM/hqdefault.jpg" alt="Video 1" width="300" />
<br>
EndToEnd and Appointment tests (Cura)
</a>
</td>
<td>
<a href="https://www.youtube.com/watch?v=1mExaSGeGFo">
<img src="https://img.youtube.com/vi/1mExaSGeGFo/hqdefault.jpg" alt="Video 2" width="300" />
<br>
EndToEnd and Cart empt. tests (Sauce Labs)
</a>
</td>
<td>
<a href="https://www.youtube.com/watch?v=M16hOy4muHU">
<img src="https://img.youtube.com/vi/M16hOy4muHU/hqdefault.jpg" alt="Video 2" width="300" />
<br>
Dropd. and Feedb.popup tests (Sauce Labs)
</a>
</td>
</tr>
<tr>
<td>
<a href="https://www.youtube.com/watch?v=o6Hq22I1mVU">
<img src="https://img.youtube.com/vi/o6Hq22I1mVU/hqdefault.jpg" alt="Video 2" width="300" />
<br>
Smoke test (all 3 app/run from a batch file)
</a>
</td>
<td>
<a href="https://www.youtube.com/watch?v=VM3N6wN20q4">
<img src="https://img.youtube.com/vi/VM3N6wN20q4/hqdefault.jpg" alt="Video 3" width="300" />
<br>
Languages and Alarm tests (Battery Alarm)
</a>
</td>
<td>
<a href="https://www.youtube.com/watch?v=4P3-qimxOKI">
<img src="https://img.youtube.com/vi/4P3-qimxOKI/hqdefault.jpg" alt="Video 1" width="300" />
<br>
Logintests with Data Provider (Cura)
</a>
</td>
</tr>
</table>

_notes:_
>My computer had a hard time with video recording, the processor was often at 100%, so the tests ran slower than usual. Therefore, I had to cut the given video in some places (typically, opening the app took longer than average at the beginning of the test).

>The testFingerPrintPageAccess breaks because the popup is not handled. When I wrote the test, the test was successful because the popup does not always pop up. I intentionally didn't fix it afterwards so that there would be an example of a failed test screenshot.

#
#
<br>

# Appium 2 Project 
**Megjegyzés: a RAEDME-t és a videókat néhány napon belül frissítem, mert több fejlesztés történt a projektben.**
 
Az Appium 2 projekt tanulási célból készült, hogy junior szoftvertesztelőként gyakorolhassam és fejlesszem tudásomat. Egy olyan tesztkeretrendszert szerettem volna létrehozni, amely hasonlít a munkahelyi környezetben használtakhoz. A fejlesztés során rengeteg új tapasztalatot szereztem és több kihívással is szembesültem. Akik ismerik a mobiltesztelést, az Appiumot, tudják, hogy mennyi mindennek kell a helyére kerülnie ahhoz, hogy minden megfelelően működjön (gondolok itt elsősorban az Appium működéséhez szükséges számtalan előfeltételre, az Appium server és az Appium Doctor telepítésére, konfigurálására, ill. már használat közben az oldalon jelenlévő, de a képernyőn még nem látható elementekkel való kontaktálásra, vagy a nem megnyíló appra, stb.). A tesztelést egy valós mobiltelefonon, egy Xiaomi Redmi note 8t-n, és "felhőben", BrowserStacken végeztem, melyet fentebb videókban be is mutatok.

A keretrendszert a nulláról építettem, melynek magját a Java - Appium 2 - Selenium - TestNg - Log4J adja. Képes a server logot, a logolást, a failed tesztek screenshotjait, a reportokat (Extent reports, Emailable report) szerverre feltölteni és emailben elküldeni. Ill., ha nem fut a háttérben az Appium server, akkor elindul automatikusan kódból. A tesztek a tesztadatokat fájl(ok)ból olvassák be. A teszteket groupokba is soroltam és elindíthatóak fájlból is (látható pl. a "Smoke" teszt példavideóban). A log üzenetek is struktúrálva vannak; amelyek több tesztosztály tesztjeiben is szerepelnek, külön osztályokba vannak kiszervezve, mind a test, mind a page szekcióban. A kód minőségének javításában a PMD és a SpotBugs nyújtottak segítséget.

Természetesen számtalan fejlesztési és finomítási lehetőség van még. A következő céljaim a párhuzamos tesztfuttatás és a CI/CD integráció (pl. Jenkins-vel).
<br>

## Tech Stack
- **Java 22.0**
- **Maven 3.9.9**
- **Appium 2.19.0**
- **Appium Java Client 9.4.0**
- **Selenium 4.32.0**
- **TestNG 7.10.2**
- **Log4j 2.24.0**
- **Extent reports 5.1.2**
- **Sendgrid 4.10.3 (email küldés)**
- **Netlify-CLI 18.0.4 (fájlfeltöltés szerverre)**
<br>

**Tesztelt alkalmazások:** 
- **Sauce Labs app** [(MyDemoAppRN.1.3.0.build-244)](https://github.com/saucelabs/my-demo-app-rn/releases/ "link title") <br>
- **CURA Healthcare Service** [(Katalon demo webpage)](https://katalon-demo-cura.herokuapp.com// "link title") <br>
- **Battery Alarm app (v76)** [(Battery Alarm webpage)](https://www.batteryalarm.app/ "link title")
- **Chrome version: 137.0.7151.89**
<br>

_Megjegyzések:_
>  A tesztadatokat tartalmazó fileokat direkt nem tettem a .gitignore-ba, mert fiktív és nem privát adatok. És az emailküldéshez szükséges adatokat tartalmazó file-t sem, mert amit feltöltöttem, csak egy sablon, a saját adataim nélkül. Ahhoz, hogy működjön az emailküldés, szükséges kitölteni a filet az adatokkal (ha ez nem teljesül, akkor ki kell kommentelni a tearDownSuite() utolsó metódusát).

> A testFingerPrintPageAccess azért törik el, mert a felugró popup nincs lekezelve. A teszt írásakor sikeres volt a teszt futása, mert nem minden esetben ugrik fel a popup. Szándékosan nem javítottam ki utólag, hogy legyen példa failed teszt screenshot-ra.
 
> A videófelvétellel már nehezen bírt a gépem, sokszor 100%-on volt a processzor, így lassabban futottak a tesztek a megszokottnál. Ezért helyenként meg kellett vágnom az adott videót (jellemzően a teszt elején az app megnyitása vett hosszabb időt igénybe az átlagosnál).
