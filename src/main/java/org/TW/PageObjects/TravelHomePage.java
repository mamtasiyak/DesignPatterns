package org.TW.PageObjects;

import org.TW.AbstractComponents.SearchFlightAvail;
import org.TW.AbstractComponents.StrategyFactor;
import org.TW.PageComponents.FooterNav;
import org.TW.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {
    //responsibility of this class is to redirect us to other classes. That's the only responsibility this class have.(single responsibility)

    By sectionElement = By.id("traveller-home");
    By footerNavSectionElement = By.id("buttons");
    SearchFlightAvail searchFlightAvail;
    WebDriver driver;

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar(driver, footerNavSectionElement);
    }

    public FooterNav getFooterNav() {
        return new FooterNav(driver, sectionElement);
    }

    public void setBookingStrategy(String strategyType) {
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        searchFlightAvail = strategyFactor.createStrategy(strategyType);
        this.searchFlightAvail = searchFlightAvail;
    }

    public void checkAvail(HashMap<String, String> reservationDetails) {
        searchFlightAvail.checkAvail(reservationDetails);
    }
}
