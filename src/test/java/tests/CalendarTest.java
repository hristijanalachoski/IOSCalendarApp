package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import util.DriverSetup;

@Epic("Regression Tests")
@Feature("Calendar Tests")
public class CalendarTest extends DriverSetup {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify calendar button actions and validations")
    @Test(testName = "Calendar test")
    public void calendarTest() {

        Assert.assertTrue(calendarHomePage.calendarHomePageLoaded(), "Calendar home page is not loaded");

        calendarHomePage.chooseTimeslot("02:00");
        Assert.assertTrue(newEventPage.newEventPageLoaded(), "New event page is not loaded");

        newEventPage.chooseStartHour("20", "05");
    }
}
