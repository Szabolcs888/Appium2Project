# Appium 2 Project
This is an Appium 2 project that I created for learning and development purposes as a junior tester. During the process, I gained a lot of new experience and faced quite a few challenges, since anyone who knows Appium knows how much has to fall into place for everything to work well. I performed the testing on a real mobile phone, a Xiaomi Redmi note 8t, which I present in the videos below.

I built the test framework from scratch, the core of which is provided by Java - Appium 2 - Selenium - testNg - log4J. It is able to upload the server logo, logging, screenshots of failed tests, reports (Extent reports, Emailable report) to the server and send them by email. Also, if the Appium server is not running in the background, it starts automatically from code. Tests read test data from file(s). The tests have been classified into groups and can be started from a file (you can see, for example, the "Smoke" test in the example video). Of course, there are still countless opportunities for development and refinement. My next goal is CI/CD integration (e.g. with Jenkins).

## Tech Stack
- **Java 22.0**
- **Appium 2.12.0**
- **Appium Java Client 9.3.0**
- **TestNG 7.10.2**
- **Log4j 2.24.0**
- **Extent reports 5.1.2**
- **Netlify (file upload to server)**
- **Sendgrid (email sending)**
<br>

**Tested applications (two native and one webapp):** <br>
- [Saucelab App (MyDemoAppRN.1.3.0.build-244)](https://github.com/saucelabs/my-demo-app-rn/releases/ "link title") <br>
- [CURA Healthcare Service (Katalon demo webpage)](https://katalon-demo-cura.herokuapp.com// "link title") <br>
- [Battery Alarm v73 app)](https://www.batteryalarm.app/ "link title")

I deliberately did not put the files containing the test data in .gitignore, because they are fictitious and not private data. And I didn't include the file containing the data necessary for sending emails either, because what I uploaded was just a template, without my own data. In order for email sending to work, it is necessary to fill out the file with the data (if this is not fulfilled, the last method of tearDownSuite() must be commented out).

## Videos of the tests
<table>
<tr>
<td>
<a href="https://www.youtube.com/watch?v=fIGTZE3TzqU">
<img src="https://img.youtube.com/vi/fIGTZE3TzqU/hqdefault.jpg" alt="Video 1" width="300" />
<br>
EndToEnd and Appointment tests (Cura)
</a>
</td>
<td>
<a href="https://www.youtube.com/watch?v=_fyCZPb1ChQ">
<img src="https://img.youtube.com/vi/_fyCZPb1ChQ/hqdefault.jpg" alt="Video 2" width="300" />
<br>
EndToEnd and Cart empt. tests (Saucelab)
</a>
</td>
<td>
<a href="https://www.youtube.com/watch?v=HAl7d1OYIpE">
<img src="https://img.youtube.com/vi/HAl7d1OYIpE/hqdefault.jpg" alt="Video 2" width="300" />
<br>
Dropd. and Feedb.popup tests (Saucelab)
</a>
</td>
</tr>
</table>
<table>
<tr>
<td>
<a href="https://www.youtube.com/watch?v=5RCdNtd5-Nc">
<img src="https://img.youtube.com/vi/5RCdNtd5-Nc/hqdefault.jpg" alt="Video 2" width="300" />
<br>
Smoke test (all 3 app/run from a batch file)
</a>
</td>
<td>
<a href="https://www.youtube.com/watch?v=_lf7F6Mp2Do">
<img src="https://img.youtube.com/vi/_lf7F6Mp2Do/hqdefault.jpg" alt="Video 3" width="300" />
<br>
Languages and Alarm tests (Battery Alarm)
</a>
</td>
<td>
<a href="https://www.youtube.com/watch?v=QFx-9d3RgDk">
<img src="https://img.youtube.com/vi/QFx-9d3RgDk/hqdefault.jpg" alt="Video 1" width="300" />
<br>
Logintests with Data Provider (Cura)
</a>
</td>
</tr>
</table>

(note: my computer had a hard time with video recording, the processor was often at 100%, so the tests ran slower than usual. Therefore, I have to cut the given video in some places (typically, at the beginning of the test, opening the app took longer than average ).)

#
#
<br>

# Appium 2 Project
Ez egy Appium 2 project, melyet tanulási - fejlődési célból hoztam létre, mint junior tesztelő. A folyamat alatt rengeteg új tapasztalatot szereztem és jó néhány kihívással szembesültem, hiszen aki ismeri az Appiumot, tudja, hogy mennyi mindennek kell a helyére  kerülnie ahhoz, hogy minden jól működjön. A tesztelést egy valós mobiltelefonon végeztem, egy Xiaomi Redmi note 8t-n, melyet fentebb videókban be is mutatok. 

A tesztkeretrendszert a nulláról építettem, melynek magját a Java - Appium 2 - Selenium - testNg - log4J adja. Képes a server logot, a logolást, a failed tesztek screenshotjait, a reportokat (Extent reports, Emailable report) szerverre feltölteni és emailben elküldeni. Illetve, ha nem fut a háttérben az Appium server, akkor elindul automatikusan kódból. A tesztek a tesztadatokat fájl(ok)ból olvassák be. A teszteket groupokba is soroltam és elindíthatóak fájlból is (látható pl. a "Smoke" teszt példavideóban). Természetesen számtalan fejlesztési és finomítási lehetőség van még. A következő célom a CI/CD integráció (pl. Jenkins-vel).
<br>

## Tech Stack
- **Java 22.0**
- **Appium 2.12.0**
- **Appium Java Client 9.3.0**
- **TestNG 7.10.2**
- **Log4j 2.24.0**
- **Extent reports 5.1.2**
- **Netlify (fájlfeltöltés szerverre)**
- **Send Grid (email küldés)**
<br>

**Tesztelt alkalmazások (két natív és egy webapp):** <br>
- [Saucelab App (MyDemoAppRN.1.3.0.build-244)](https://github.com/saucelabs/my-demo-app-rn/releases/ "link title") <br>
- [CURA Healthcare Service (Katalon demo webpage)](https://katalon-demo-cura.herokuapp.com// "link title") <br>
- [Battery Alarm v73 app)](https://www.batteryalarm.app/ "link title")

A tesztadatokat tartalmazó fileokat direkt nem tettem a .gitignore-ba, mert fiktív és nem privát adatok. És az emailküldéshez szükséges adatokat tartalmazó file-t sem, mert amit feltöltöttem, csak egy sablon, a saját adataim nélkül. Ahhoz, hogy működjön az emailküldés, szükséges kitölteni a filet az adatokkal (ha ez nem teljesül, akkor ki kell kommentelni a tearDownSuite() utolsó metódusát).

(megjegyzés: a videófelvétellel már nehezen bírt a gépem, sokszor 100%-on volt a processzor, így lassabban futottak a tesztek a megszokottnál. Ezért helyenként meg kell vágnom az adott videót (jellemzően a teszt elején az app megnyitása vett hosszabb időt igénybe az átlagosnál).) 