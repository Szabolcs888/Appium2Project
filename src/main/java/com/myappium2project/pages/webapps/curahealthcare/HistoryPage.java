package com.myappium2project.pages.webapps.curahealthcare;

import com.myappium2project.pages.BasePageClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HistoryPage extends BasePageClass {
    @FindBy(xpath = "//h2[text()='History']")
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

    public HistoryPage(AndroidDriver driver) {
        super();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isPageLoaded() {
        try {
            return historyTitleText.isDisplayed() &&
                    historyTitleText.isEnabled() &&
                    "History".equals(historyTitleText.getText());
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public List<String> getAppointmentDataOnHistoryPage() {
        List<String> appointmentDataOnHistoryPage = new ArrayList<>();
        appointmentDataOnHistoryPage.add(visitDate.getText());
        appointmentDataOnHistoryPage.add(facilityText.getText());
        appointmentDataOnHistoryPage.add(hospitalReadmissionChoice.getText());
        appointmentDataOnHistoryPage.add(healthcareProgram.getText());
        appointmentDataOnHistoryPage.add(comment.getText());
        return appointmentDataOnHistoryPage;
    }
}