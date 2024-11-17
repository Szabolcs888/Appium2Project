package pages.b_curaHealthcareWithChrome;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MakeAppointmentPage {
    private static final Logger LOG = LogManager.getLogger(MakeAppointmentPage.class);
    AndroidDriver driver;

    public MakeAppointmentPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//*[text()='Make Appointment']")
    private WebElement makeAppointmentPageTitleText;

    @FindBy(id = "combo_facility")
    private WebElement facilityDropDownMenuButton;

    @FindBy(name = "facility")
    private WebElement facilityChoice;

    @FindBy(name = "hospital_readmission")
    private WebElement applyForHospitalReadmissionCheckbox;

    @FindBy(xpath = "//input[@type='radio']")
    private List<WebElement> healthcareProgramOptions;

    @FindBy(id = "txt_visit_date")
    private WebElement dateOfVisit;

    @FindBy(id = "txt_comment")
    private WebElement formBox;

    @FindBy(xpath = "//*[@id=\"btn-book-appointment\"]")
    private WebElement bookAppointmentButton;

    public String getMakeAppointmentPageTitleText() {
        try {
            return makeAppointmentPageTitleText.getText();
        } catch (NoSuchElementException e) {
            return "The title text is not available";
        }
    }

    public boolean isPageLoaded() {
        try {
            return makeAppointmentPageTitleText.isDisplayed() &&
                    makeAppointmentPageTitleText.isEnabled() &&
                    makeAppointmentPageTitleText.getText().equals("Make Appointment") &&
                    driver.getCurrentUrl().equals("https://katalon-demo-cura.herokuapp.com/#appointment");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void pressFacilityDropDownMenuButton() {
        LOG.info("We press the 'Facility' dropdown menu button");
        facilityDropDownMenuButton.click();
    }

    public void choiceFacilityOption(String option) {
        LOG.info("We choice the '{}' option", option);
        Select select = new Select(facilityChoice);
        select.selectByVisibleText(option);
    }

    public void pressApplyForHospitalReadmissionCheckBoxOrDontPressIt(String option) {
        if (option.equals("Yes")) {
            LOG.info("We press the 'Apply for hospital readmission' checkbox");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", applyForHospitalReadmissionCheckbox);
        } else
            LOG.info("We do not press the 'Apply for hospital readmission' checkbox");
    }

    public void choiceHealthcareProgramOption(String option) {
        LOG.info("We choice the '{}' in the Healthcare Program radio box", option);
        for (WebElement element : healthcareProgramOptions) {
            String idValue = element.getAttribute("value");
            if (idValue.equals(option)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                break;
            }
        }
    }

    public void fillDateOfVisitInput(String date) {
        LOG.info("We fill the date of visit input field with: '{}'", date);
        dateOfVisit.sendKeys(date);
    }

    public void fillCommentInput(String comment) {
        LOG.info("We write a comment in a comment field: '{}'", comment);
        formBox.sendKeys(comment);
    }

    public void pressBookAppointmentButton() {
        LOG.info("We press the 'Book Appointment' button");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bookAppointmentButton);
    }
}

