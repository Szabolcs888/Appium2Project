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

public class HistoryPage {
    private static final Logger LOG = LogManager.getLogger(HistoryPage.class);

    public HistoryPage(AndroidDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @FindBy(xpath = ("//h2[text()='History']"))
    private WebElement historyTitleText;

    @FindBy(className = "panel-heading")
    private WebElement visitDate;

    @FindBy(id = "facility")
    private WebElement facilityText;

    @FindBy(id = "hospital_readmission")
    private WebElement hospitalReadmissionChoice;

    @FindBy(id = "program")
    private WebElement healthcareProgram;

    @FindBy(id = "comment")
    private WebElement comment;

    public boolean isPageLoaded() {
        try {
            return historyTitleText.isDisplayed() &&
                    historyTitleText.isEnabled() &&
                    historyTitleText.getText().equals("History");
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public List<String> getAppointmentDataAsTheyAreOnTheHistoryPage() {
        List<String> appointmentDataAsTheyAreOnTheHistoryPage = new ArrayList<>();
        appointmentDataAsTheyAreOnTheHistoryPage.add(visitDate.getText());
        appointmentDataAsTheyAreOnTheHistoryPage.add(facilityText.getText());
        appointmentDataAsTheyAreOnTheHistoryPage.add(hospitalReadmissionChoice.getText());
        appointmentDataAsTheyAreOnTheHistoryPage.add(healthcareProgram.getText());
        appointmentDataAsTheyAreOnTheHistoryPage.add(comment.getText());
        return appointmentDataAsTheyAreOnTheHistoryPage;
    }
}

