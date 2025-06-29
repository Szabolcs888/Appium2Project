# Appium 2 Project

[![Java](https://img.shields.io/badge/Java-22-orange.svg)](https://www.java.com)
[![Maven](https://img.shields.io/badge/Maven-3.9-blue.svg)](https://maven.apache.org/)
[![Appium](https://img.shields.io/badge/Appium-2.19-red.svg)](https://appium.io/)
[![Selenium](https://img.shields.io/badge/Selenium-4.32-green.svg)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.10-yellow.svg)](https://testng.org/)
[![ExtentReports](https://img.shields.io/badge/Report-ExtentReports%205.1-blueviolet.svg)](https://www.extentreports.com/)

The **Appium 2 Project** is a Java-based test automation framework built with Appium 2, supporting the testing of native and web mobile applications in both local and cloud-based (BrowserStack) environments.

---

## Table of contents

- [About the project](#about-the-project)
- [Key features and technical solutions](#key-features-and-technical-solutions)
- [Tech stack](#tech-stack)
- [Tested applications](#tested-applications)
- [Setup and prerequisites](#setup-and-prerequisites)
  - [Prerequisites for execution](#prerequisites-for-execution)
- [Usage and running tests](#usage-and-running-tests)
  - [Configuration](#configuration)
  - [Execution strategies and TestNG configuration](#execution-strategies-and-testng-configuration)
  - [Running the tests](#running-the-tests)
- [Screenshots and videos of the tests](#screenshots-of-the-tests)

## About the project

This project was created for learning purposes, allowing me as a junior software tester to practice and deepen my knowledge in the field of **test automation**, particularly in testing **mobile and web-based systems**. I aimed to create a test framework that, in its structure and operation, resembles solutions used in professional work environments.

The framework was built entirely from scratch. The core technologies are **Java**, **Appium 2**, **Selenium**, **TestNG**, and **Log4j**. The system can automatically manage the Appium server, generate logs and reports (Extent Reports, as well as HTML-formatted email reports), and take screenshots in case of failure. It is also capable of uploading these artifacts to Netlify and sending them via email using the SendGrid API. Although these functions are often handled centrally in a real CI/CD environment, my goal was to understand their operation by implementing them manually, thereby learning new Java libraries and techniques.

The tests operate in a data-driven manner, with input data sourced from JSON files. During the design phase, key considerations were **modularity**, **reusability**, and **easy maintainability**. Code quality was also enhanced using tools like **PMD** and **SpotBugs**.

Of course, there are still countless opportunities for development and refinement. My next goals include implementing **parallel test execution** and **CI/CD integration**, for example, using **Jenkins**.

Testing was performed on a real Android device (Xiaomi Redmi Note 8T) and in the **BrowserStack** cloud service, which I demonstrate in the videos below.

## Key features and technical solutions

The project follows modern software development and test automation *best practices*:

- **Page Object Model (POM):** UI elements and their corresponding actions are separated from the test logic, resulting in clean and maintainable code.
- **Data-Driven configuration:** Driver capabilities, environment settings, and test data are stored in external `JSON` and `.properties` files. This allows for modifying the test environment without changing the Java code.
- **Factory and Builder design patterns:**
  * `DriverFactory`: A central "factory" for creating various `AndroidDriver` instances (native/web, local/cloud).
  * `OptionsBuilder` classes: Responsible for the dynamic and readable assembly of complex Appium capabilities objects.
- **POJO and enum classes for structured data representation:**
  * The system uses `POJO` classes (e.g., `AppiumOptionsData`) to read JSON configurations and test data with the help of Jackson. This provides type safety and better readability compared to raw `Map` objects.
  * `Enums` are used for the safe handling of fixed, predefined values (e.g., execution environments), preventing errors from typos.
- **Layered logic with steps, assertions, and providers:**
  * Tests are broken down into well-defined layers. Page Object classes contain reusable, business-level steps (e.g., `login()`), while test methods are responsible for calling these steps and performing assertions.
  * Data-driven testing is supported through DataProvider classes.
- **Environment-dependent execution:** A single configuration switch allows for toggling between local (on a real device or emulator) and cloud-based (BrowserStack) execution.
- **Programmatic server management:** The `AppiumServerManager` can automatically start/stop the Appium server, eliminating the need for manual intervention.
- **Detailed reporting:** The system offers two parallel reporting mechanisms:
  * **ExtentReports:** Generates interactive, visual HTML reports with screenshots on failure.
  * **Custom email reporting:** Uses the SendGrid API to send HTML-formatted notifications, providing a reporting mechanism independent of any CI/CD system.
- **Timestamped logging to file (`logback`):** The `Log4j` logging system creates a separate, timestamped log file for each test run and server start, preventing log overwrites and simplifying debugging. The logging level and target location are configurable in the `log4j.properties` file for test runs and in `config.properties` for the Appium server.
- **Exception handling with custom exception hierarchy:** The framework introduces dedicated custom exception classes (e.g., `ConfigurationException`, `JsonReadException`, `LogFileException`) all extending a base `AppiumProjectException`. This promotes clearer, contextualized error reporting and better maintainability.
- **Refactoring based on the DRY (Don't Repeat Yourself) principle:** The entire project is built following the DRY principle. Frequently repeated operations—such as driver management, configuration reading, or common UI interactions—are centralized in reusable components. This significantly reduces code duplication and increases long-term maintainability.

## Tech Stack

The project uses the latest or near-latest versions of the following main technologies and libraries:
- **Java 22.0**
- **Maven 3.9.9**
- **Appium 2.19.0**
- **Appium Java Client 9.4.0**
- **Selenium 4.32.0**
- **TestNG 7.10.2**
- **Log4j 2.24.0**
- **Jackson 2.19**
- **Extent reports 5.1.2**
- **Sendgrid 4.10.3 (for email sending)**
- **Netlify-CLI 18.0.4 (for uploading files to a server)**

## Tested applications

- **SauceLabs Swag Labs (native) app** [(MyDemoAppRN.1.3.0.build-244)](https://github.com/saucelabs/my-demo-app-rn/releases/ "link title") <br>
- **Battery Alarm (native) app (v76)** [(Battery Alarm webpage)](https://www.batteryalarm.app/ "link title") <br>
- **CURA Healthcare Service (web) app** [(Katalon demo webpage)](https://katalon-demo-cura.herokuapp.com// "link title")
- **Chrome version: 137.0.7151.89**

## Setup and prerequisites

### Prerequisites for execution

- **Java Development Kit (JDK) 22 or newer**
- **Apache Maven** – for building the project and running tests
- **Node.js and npm** – for installing and running Appium
- **Appium 2** – installed globally (`npm install -g appium@next`)
- **Android SDK** – *it is recommended to install it with Android Studio, which also provides the necessary tools and an AVD manager*
- **Registration and configuration of external services:**
    * **Sendgrid** – for sending email-based test reports. Configuration file: `src/main/resources/emailsendingdata/sendgrid_account.json`
    * **Netlify** – for public access to files in test reports (e.g., screenshots), a simple Netlify account and deploy are required
    * **BrowserStack** – for test execution in a cloud-based device farm. Configuration files: `src/test/resources/testdatafiles/options/browserstack/`

## Usage and running tests

### Configuration

- **Execution environment and browser:** The following settings can be configured in the `src/main/resources/config.properties` file:
    * `run.environment`: The test execution environment. Possible values: `local` or `cloud` (BrowserStack).
    * `browser.type`: The browser used for web tests. Possible values: `chrome` or `firefox`.
- **Driver capabilities:** Platform- and environment-specific Appium settings are located in separate JSON files under the following path: `src/test/resources/testdatafiles/options/appium/`.

### Execution strategies and TestNG configuration

The framework uses **TestNG** to configure and run tests, leveraging its advanced control features.
- **Test Suites:** Predefined execution packages for various testing purposes (e.g., quick checks, full regression) are located in the `src/test/resources/testng-configs/` folder. This allows running only relevant tests, optimizing time and resources.
    * `smoke-tests.xml`: Fast-running tests to check basic functionality.
    * `regression-tests.xml`: A test suite ensuring full functional coverage of the system.
- **TestNG groups:** Tests can be logically separated using the `@Test(groups = {"smoke"})` annotation.
- **Data-Driven testing (@DataProvider):** The framework supports a data-driven testing approach. The `DataProviderTests` class for the **CURA H.S.** application provides an example of how to read test data (username, password) from an external JSON file (from the `src/test/resources/testdatafiles/testinputs/` folder). The `CuraLoginTestDataProvider` class separates the data supply from the test logic, allowing the same test case to be executed with multiple input combinations.
- **Priority and dependencies:** The `@Test(priority = ...)` annotation allows specifying the execution order of tests, which is particularly useful for testing complex, interdependent user flows.

### Running the tests

Tests can be run in two ways – in both cases, the `testng.xml` suite files form the basis.

#### 1. Running with Maven

The `pom.xml` file is configured with the **Maven Surefire Plugin** to run tests. The following commands should be executed from the project's root directory:
- **Run the default suite** (based on `pom.xml`):
  ```sh
  mvn clean test
  ```

- **Run a specific suite** with the `-Dsurefire.suiteXmlFiles` parameter:
  ```sh
  mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng-configs/testng-smoke.xml
  ```

#### 2. Running from an IDE

Any modern Java IDE (e.g., IntelliJ IDEA or Eclipse) with TestNG support allows running tests via a graphical interface, either at the level of individual test suites or even single methods.

## Screenshots of the Tests

<table>
<tr>
<td>
<img src="https://github.com/user-attachments/assets/a24859f8-3442-492a-97e7-6c040f685314" alt="Image 1" width="300"/>
<br>
EndToEnd test (Sauce Labs)
</td>
<td>
<img src="https://github.com/user-attachments/assets/f0548673-d1b7-473e-9dda-03264b642f4b" alt="Image 2" width="300"/>
<br>
Appointment conf. test (Cura Healthcare)
</td>
<td>
<img src="https://github.com/user-attachments/assets/321bfb85-2c23-42b4-9a9c-765efc20f910" alt="Image 3" width="300"/>
<br>
Test on BrowserStack (Sauce Labs)
</td>
</tr>
</table>

## Videos of the Tests
<table>
<tr>
<td>
<a href="https://www.youtube.com/watch?v=YfV5z6kA3X0">
<img src="https://img.youtube.com/vi/YfV5z6kA3X0/hqdefault.jpg" alt="Video 1" width="300" />
<br>
EndToEnd and Appointment tests (Cura)
</a>
</td>
<td>
<a href="https://www.youtube.com/watch?v=AUADuV_k55I">
<img src="https://img.youtube.com/vi/AUADuV_k55I/hqdefault.jpg" alt="Video 2" width="300" />
<br>
EndToEnd and Cart tests (Sauce Labs)
</a>
</td>
<td>
<a href="https://www.youtube.com/watch?v=SFCqrhz8kVc">
<img src="https://img.youtube.com/vi/SFCqrhz8kVc/hqdefault.jpg" alt="Video 3" width="300" />
<br>
Dropdown and Feedback popup tests (Sauce Labs)
</a>
</td>
</tr>
<tr>
<td>
<a href="https://www.youtube.com/watch?v=UT8veQOcc8c">
<img src="https://img.youtube.com/vi/UT8veQOcc8c/hqdefault.jpg" alt="Video 4" width="300" />
<br>
Smoke test (all 3 apps/run from a batch file)
</a>
</td>
<td>
<a href="https://www.youtube.com/watch?v=VsuDjn6x5Co">
<img src="https://img.youtube.com/vi/VsuDjn6x5Co/hqdefault.jpg" alt="Video 5" width="300" />
<br>
Languages and Alarm tests (Battery Alarm)
</a>
</td>
<td>
<a href="https://www.youtube.com/watch?v=nkuSgzNxoJ4">
<img src="https://img.youtube.com/vi/nkuSgzNxoJ4/hqdefault.jpg" alt="Video 6" width="300" />
<br>
Login tests with Data Provider (Cura)
</a>
</td>
</tr>
</table>

---

>  License: this project is licensed under the **MIT License**.
Created by: [Szabolcs Szigli](https://www.linkedin.com/in/szabolcs-szigli-07617640)

#
#
<br>
<br>

*In Hungarian*

# Appium 2 Project 

[![Java](https://img.shields.io/badge/Java-22-orange.svg)](https://www.java.com)
[![Maven](https://img.shields.io/badge/Maven-3.9-blue.svg)](https://maven.apache.org/)
[![Appium](https://img.shields.io/badge/Appium-2.19-red.svg)](https://appium.io/)
[![Selenium](https://img.shields.io/badge/Selenium-4.32-green.svg)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-7.10-yellow.svg)](https://testng.org/)
[![ExtentReports](https://img.shields.io/badge/Riport-ExtentReports%205.1-blueviolet.svg)](https://www.extentreports.com/)

Az **Appium 2 Project** egy Java-alapú, Appium 2-vel készült tesztautomatizálási keretrendszer, amely natív és webes mobilalkalmazások tesztelését támogatja helyi és felhőalapú (BrowserStack) környezetben.

---

## Tartalomjegyzék

- [A projektről](#a-projektről)
- [Főbb jellemzők és technikai megoldások](#főbb-jellemzők-és-technikai-megoldások)
- [Felhasznált technológiák](#felhasznált-technológiák)
- [Tesztelt alkalmazások](#tesztelt-alkalmazások)
- [Telepítés és előkészületek](#telepítés-és-előkészületek)
  - [Előfeltételek a futtatáshoz](#Előfeltételek-a-futtatáshoz)
- [Használat és tesztek futtatása](#használat-és-tesztek-futtatása)
  - [Konfiguráció](#konfiguráció)
  - [Futtatási stratégiák és TestNG-konfiguráció](#futtatási-stratégiák-és-testng-konfiguráció)
  - [Tesztek indítása](#tesztek-indítása)
- [Screenshots and videos of the tests](#screenshots-of-the-tests)

## A projektről

A projekt tanulási célból készült, hogy junior szoftvertesztelőként gyakorolhassam és mélyítsem az ismereteimet a **tesztautomatizálás**, különösen a **mobil- és webalapú rendszerek** tesztelésének területén. Olyan tesztkeretrendszert szerettem volna létrehozni, amely felépítésében és működésében hasonlít a munkahelyi környezetekben használt megoldásokhoz.

A keretrendszert teljes egészében a nulláról építettem fel. A fő technológiák: **Java**, **Appium 2**, **Selenium**, **TestNG** és **Log4j**. A rendszer képes automatikusan kezelni az Appium szervert, naplókat és riportokat generálni (Extent Reports, valamint HTML formátumú email-riport), illetve hiba esetén képernyőmentéseket készíteni. Ezeket képes Netlify-ra feltölteni és SendGrid API segítségével emailben továbbítani. Bár ezen funkciók egy valós CI/CD környezetben sokszor központilag vannak kezelve, célom az volt, hogy kézzel implementálva is megismerjem működésüket és ezáltal újabb Java könyvtárakat, technikákat is elsajátítsak.

A tesztek adatvezérelt módon működnek, a bemeneti adatok JSON fájlokból érkeznek. A tervezés során kiemelt szempont volt a **modularitás**, az **újrafelhasználhatóság** és a **könnyű karbantarthatóság**. A kódminőség javításában a **PMD** és a **SpotBugs** eszközök is szerepet kaptak. 

Természetesen számtalan fejlesztési és finomítási lehetőség van még. A következő céljaim közé tartozik a **párhuzamos tesztfuttatás**, valamint a **CI/CD integráció**, például **Jenkins** segítségével.

A tesztelést valós Android eszközön (Xiaomi Redmi Note 8T), valamint **BrowserStack** felhőszolgáltatásban végeztem, melyet fentebb videókban be is mutatok.

## Főbb jellemzők és technikai megoldások

A projekt a modern szoftverfejlesztési és tesztautomatizálási _best practice_-eket követi:

- **Page Object Model (POM):** Az UI-elemek és a velük végzett műveletek elkülönülnek a tesztlogikától, így tiszta, jól karbantartható kód jön létre.
- **Adatvezérelt konfiguráció:** A driverképességek (capabilities), környezeti beállítások és tesztadatok külső `JSON` és `.properties` fájlokban találhatók. Ez lehetővé teszi a tesztkörnyezet módosítását a Java-kód megváltoztatása nélkül.
- **Factory és Builder tervezési minták:**
  * `DriverFactory`: Egy központi "gyár", amely különféle `AndroidDriver` példányokat hoz létre (natív/web, lokális/cloud).
  * `OptionsBuilder` osztályok: A komplex Appium capabilities objektumok dinamikus és olvasható összeállításáért felelősek.
- **POJO és enum osztályok a struktúrált adatreprezentációhoz:**
  * A rendszer `POJO` osztályokat (pl. `AppiumOptionsData`) használ a JSON konfigurációk és tesztadatok beolvasására, Jackson segítségével. Ez típuskontrollt és jobb olvashatóságot biztosít a nyers `Map`-ekkel szemben.
  * Az `enum`-ok a fix, előre definiált értékek (pl. futtatási környezetek) biztonságos kezelését segítik, megelőzve az elgépelésből eredő hibákat.
- **Lépésekre, asszerciókra és providerekre tagolt logika:**
  * A tesztek jól definiált rétegekre bonthatók. A Page Object osztályok tartalmazzák az újrafelhasználható, üzleti szintű lépéseket (pl. `login()`), míg a tesztmetódusok ezek meghívásáért és az asszertálásért felelősek.
  * A DataProvider osztályok segítségével támogatott az adatvezérelt (data-driven) tesztelés.
- **Környezetfüggő futtatás:** Egyetlen konfigurációs kapcsolóval válthatunk a lokális (valós eszköz vagy emulátor) és a felhőalapú (BrowserStack) futtatás között.
- **Programozott szerverkezelés:** Az `AppiumServerManager` automatikusan képes elindítani/leállítani az Appium szervert, így manuális beavatkozás nem szükséges.
- **Részletes riportálás:** A rendszer két párhuzamos riportálási mechanizmust kínál:
  * **ExtentReports:** Interaktív, vizuális HTML-riport, hibák esetén képernyőmentéssel.
  * **Saját e-mailes riportküldés:** A SendGrid API segítségével HTML-formátumú értesítés küldhető, amely független bármely CI/CD rendszertől.
- **Időbélyeges logolás fájlba (`logback`):** A `Log4j` logolórendszer minden tesztfutáshoz és szerverindításhoz külön, időbélyeges logfájlt hoz létre, így elkerülhető a logfelülírás, és egyszerűbb a hibakeresés.
A logolás szintje és célhelye a tesztfuttatáshoz a `log4j.properties`, az Appium serverhez a `config.properties` fájlban állítható.
- **Hibakezelés saját kivételosztályokkal:** A keretrendszer több egyedi `RuntimeException`-leszármazott osztályt definiál (pl. `ConfigurationException`, `JsonReadException`, `LogFileException`), amelyek a `AppiumProjectException` ősosztályból származnak. Ezek az osztályok segítenek kontextusfüggőbb, jól értelmezhető hibakezelés kialakításában, és megkönnyítik a hibák naplózását és nyomon követését.
- **DRY (Don't Repeat Yourself) alapú refaktorálás:** A projekt teljes egészében a DRY-elv mentén épül fel. A gyakran ismétlődő műveletek – mint például a driverkezelés, konfigurációolvasás vagy gyakori UI-interakciók – központosított, újrafelhasználható komponensekben vannak elhelyezve. Ez jelentősen csökkenti a kódismétlést és növeli a hosszú távú karbantarthatóságot.

## Felhasznált technológiák

A projekt a következő fő technológiák és könyvtárak legfrissebb vagy közeli verzióit használja:
- **Java 22.0**
- **Maven 3.9.9**
- **Appium 2.19.0**
- **Appium Java Client 9.4.0**
- **Selenium 4.32.0**
- **TestNG 7.10.2**
- **Log4j 2.24.0**
- **Jackson 2.19**
- **Extent reports 5.1.2**
- **Sendgrid 4.10.3 (email küldés)**
- **Netlify-CLI 18.0.4 (fájlfeltöltés szerverre)**

## Tesztelt alkalmazások

- **SauceLabs Swag Labs (natív) app** [(MyDemoAppRN.1.3.0.build-244)](https://github.com/saucelabs/my-demo-app-rn/releases/ "link title") <br>
- **Battery Alarm (natív) app (v76)** [(Battery Alarm webpage)](https://www.batteryalarm.app/ "link title") <br>
- **CURA Healthcare Service (web) app** [(Katalon demo webpage)](https://katalon-demo-cura.herokuapp.com// "link title") 
- **Chrome version: 137.0.7151.89**
  
## Telepítés és előkészületek

### Előfeltételek a futtatáshoz

-  **Java Development Kit (JDK) 22 vagy újabb**
-  **Apache Maven** – a projekt buildeléséhez és a tesztek futtatásához
-  **Node.js és npm** – az Appium telepítéséhez és futtatásához
-  **Appium 2** – globálisan telepítve (`npm install -g appium@next`)
-  **Android SDK** – _javasolt az Android Studio-val együtt telepíteni, amely biztosítja a szükséges eszközöket és AVD-kezelőt is_
-  **Külső szolgáltatások regisztrációja és konfigurálása:**
    *  **Sendgrid** – e-mail alapú tesztriportok küldéséhez. Konfigurációs fájl: `src/main/resources/emailsendingdata/sendgrid_account.json`
    *  **Netlify** – a teszt reportokban szereplő fájlok (pl. screenshotok) nyilvános eléréséhez egy egyszerű Netlify-fiók és deploy szükséges
    *  **BrowserStack** – felhőalapú eszközparkban való tesztfuttatáshoz. Beállítási fájlok: `src/test/resources/testdatafiles/options/browserstack/`

## Használat és tesztek futtatása

### Konfiguráció

-  **Futtatási környezet és böngésző:** Az `src/main/resources/config.properties` fájlban adhatók meg az alábbi beállítások:
    * `run.environment`: A tesztek futtatási környezete. Lehetséges értékek: `local` (helyi gépen) vagy `cloud` (BrowserStack).
    * `browser.type`: A webes tesztekhez használt böngésző. Lehetséges értékek: `chrome` vagy `firefox`.
-  **Driver képességek (capabilities):** A platform- és környezetspecifikus Appium-beállítások külön JSON-fájlokban találhatók a következő útvonalon: `src/test/resources/testdatafiles/options/appium/`.

### Futtatási stratégiák és TestNG-konfiguráció

A keretrendszer a **TestNG** tesztkeretrendszert használja a tesztek konfigurálásához és futtatásához, kihasználva annak fejlett vezérlési lehetőségeit.
-  **Test Suite-ok:** A különféle tesztelési célokra (pl. gyors ellenőrzés, teljes regresszió) előre definiált futtatási csomagok találhatók az `src/test/resources/testng-configs/` mappában. Ezek lehetővé teszik, hogy csak a releváns teszteket futtassuk, optimalizálva az időt és az erőforrásokat.
    * `smoke-tests.xml`: Alapfunkcionalitást ellenőrző, gyors futású tesztek.
    * `regression-tests.xml`: A rendszer teljes körű funkcionális lefedettségét biztosító tesztcsomag.
-  **TestNG-csoportok (groups):** A tesztek `@Test(groups = {"smoke"})` annotációval logikailag elkülöníthetők.
-  **Adatvezérelt tesztelés (@DataProvider):** A keretrendszer támogatja a data-driven testing megközelítést. A **CURA H.S.** alkalmazás `DataProviderTests` osztálya példát mutat arra, hogyan olvashatók be a tesztadatok (felhasználónév, jelszó) külső JSON fájlból (a `src/test/resources/testdatafiles/testinputs/` mappából). A `CuraLoginTestDataProvider` osztály különválasztja az adatszolgáltatást a tesztlogikától, így ugyanaz a teszteset több bemeneti kombinációval is végrehajtható.
-  **Prioritás és függőségek:** A `@Test(priority = ...)` annotáció lehetővé teszi a tesztek futtatási sorrendjének megadását, ami különösen hasznos összetett, egymásra épülő felhasználói folyamatok tesztelésekor.

### Tesztek indítása

A tesztek futtatása kétféleképpen történhet – mindkét esetben a `testng.xml` suite-fájlok képezik az alapot.

#### 1. Futtatás Maven segítségével

A `pom.xml` fájlban konfigurált **Maven Surefire Plugin** gondoskodik a tesztek futtatásáról. A következő parancsokat a projekt gyökérkönyvtárából kell kiadni:
-  **Alapértelmezett suite futtatása** (a `pom.xml` alapján):
   ```sh
    mvn clean test
   ```

-  **Konkrét suite futtatása** a `-Dsurefire.suiteXmlFiles` paraméterrel:
    ```sh
    mvn clean test -Dsurefire.suiteXmlFiles=src/test/resources/testng-configs/testng-smoke.xml
    ```

#### 2. Futtatás IDE-ből

Bármely modern Java IDE (pl. IntelliJ IDEA vagy Eclipse) támogatja a TestNG-t, így grafikus felületen keresztül is indíthatók a tesztek, egyéni test suite-ok vagy akár egyes metódusok szintjén.

---

>  Licenc: Ez a projekt az **MIT-licenc** alatt érhető el.
Készítette: [Szabolcs Szigli](https://www.linkedin.com/in/szabolcs-szigli-07617640)
