package pages.b_curaHealthcareWithChrome;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AppointmentConfirmationPage {
    private static final Logger LOG = LogManager.getLogger(AppointmentConfirmationPage.class);

    public AppointmentConfirmationPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = "//*[text()='Appointment Confirmation']")
    private WebElement appointmentConfirmationPageTitleText;

    @FindBy(id = "facility")
    private WebElement facilityText;

    @FindBy(id = "hospital_readmission")
    private WebElement hospitalReadmissionChoice;

    @FindBy(id = "program")
    private WebElement healthcareProgram;

    @FindBy(id = "visit_date")
    private WebElement visitDate;

    @FindBy(id = "comment")
    private WebElement comment;

    public boolean isPageLoaded() {
        try {
            return appointmentConfirmationPageTitleText.isDisplayed() &&
                    appointmentConfirmationPageTitleText.isEnabled() &&
                    appointmentConfirmationPageTitleText.getText().equals("Appointment Confirmation");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public List<String> getAppointmentDataAsTheyAreOnTheAppointmentConfirmationPage() {
        List<String> appointmentDataAsTheyAreOnTheAppointmentConfirmationPage = new ArrayList<>();
        appointmentDataAsTheyAreOnTheAppointmentConfirmationPage.add(facilityText.getText());
        appointmentDataAsTheyAreOnTheAppointmentConfirmationPage.add(hospitalReadmissionChoice.getText());
        appointmentDataAsTheyAreOnTheAppointmentConfirmationPage.add(healthcareProgram.getText());
        appointmentDataAsTheyAreOnTheAppointmentConfirmationPage.add(visitDate.getText());
        appointmentDataAsTheyAreOnTheAppointmentConfirmationPage.add(comment.getText());
        return appointmentDataAsTheyAreOnTheAppointmentConfirmationPage;
    }
}
