package org.TW;

import org.TW.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DemoTest extends BaseTest {

    WebDriver driver;
    TravelHomePage travelHomePage;

    @BeforeTest
    public void setUp() {
        driver = initializeDriver();
        travelHomePage = new TravelHomePage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> reservationDetails) {
        //single responsibility principle pattern

        travelHomePage.goTo();
        System.out.println(travelHomePage.getFooterNav().getFlightAttribute());
        System.out.println(travelHomePage.getNavigationBar().getFlightAttribute());
        System.out.println(travelHomePage.getFooterNav().getLinkCount());
        System.out.println(travelHomePage.getNavigationBar().getLinkCount());

        //strategy design pattern
        //factory design pattern
        //Execute around pattern
        travelHomePage.setBookingStrategy("multiCityTrip");
        travelHomePage.checkAvail(reservationDetails);
    }

    @DataProvider
    public Object[][] getData() {
        HashMap<String, String> reservationDetails = new HashMap<String, String>();
        reservationDetails.put("origin", "MAA");
        reservationDetails.put("destination", "HYD");
        reservationDetails.put("destination2", "DEL");

        HashMap<String, String> reservationDetails1 = new HashMap<String, String>();
        reservationDetails1.put("origin", "DEL");
        reservationDetails1.put("destination", "HYD");
        reservationDetails1.put("destination2", "MAA");

        return new Object[][]{
                {reservationDetails}, {reservationDetails1}
        };
    }
}
