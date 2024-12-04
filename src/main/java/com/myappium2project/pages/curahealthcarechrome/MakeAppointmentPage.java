package com.myappium2project.pages.curahealthcarechrome;

import com.myappium2project.logging.pagelogmessages.CommonPageLogMessages;
import com.myappium2project.pages.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MakeAppointmentPage extends BasePage {
    private static final String CHECKBOX_PRESS_ACTION_LOG = "We {}press the 'Apply for hospital readmission' checkbox";
    private final AndroidDriver driver;

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

    public MakeAppointmentPage(AndroidDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public String getMakeAppointmentPageTitleText() {
        try {
            return makeAppointmentPageTitleText.getText();
        } catch (NoSuchElementException e) {
            return CommonPageLogMessages.getTextIsNotAvailableLog("title");
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
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Facility' 'dropdown menu");
        facilityDropDownMenuButton.click();
    }

    public void choiceFacilityOption(String option) {
        LOG.info("We choice the '{}' option", option);
        Select select = new Select(facilityChoice);
        select.selectByVisibleText(option);
    }

    public void pressApplyForHospitalReadmissionCheckBoxOrDontPressIt(String option) {
        if (option.equals("Yes")) {
            LOG.info(CHECKBOX_PRESS_ACTION_LOG, "");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", applyForHospitalReadmissionCheckbox);
        } else {
            LOG.info(CHECKBOX_PRESS_ACTION_LOG, "do not ");
        }
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
        LOG.info(CommonPageLogMessages.FILL_INPUT_LOG, "Visit Date", date);
        dateOfVisit.sendKeys(date);
    }

    public void fillCommentInput(String comment) {
        LOG.info("We write a comment in a comment field: '{}'", comment);
        formBox.sendKeys(comment);
    }

    public void pressBookAppointmentButton() {
        LOG.info(CommonPageLogMessages.PRESS_BUTTON_LOG, "Book Appointment");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", bookAppointmentButton);
    }
}