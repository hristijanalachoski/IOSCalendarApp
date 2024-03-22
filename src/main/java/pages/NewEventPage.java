package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.GlobalVariables;

public class NewEventPage {

    protected IOSDriver driver;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeNavigationBar[`name == \"New Event\"`]")
    private RemoteWebElement newEventPageHeader;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[1]")
    private RemoteWebElement hourPicker;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypePickerWheel)[2]")
    private RemoteWebElement minutePicker;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell[contains(@name, 'Starts')]/XCUIElementTypeButton/XCUIElementTypeButton)[2]")
    private RemoteWebElement startsHourPickerButton;

    public NewEventPage(IOSDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("New event page is loaded")
    public boolean newEventPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(newEventPageHeader)).isDisplayed();
    }

    @Step("Choose start hour {0}, minute {1}")
    public void chooseStartHour(String hour, String minutes) {
        startsHourPickerButton.click();
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(hourPicker)).sendKeys(hour);
        minutePicker.sendKeys(minutes);
    }
}
