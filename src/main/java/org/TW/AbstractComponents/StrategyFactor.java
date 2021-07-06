package org.TW.AbstractComponents;

import org.TW.PageComponents.MultiCityTrip;
import org.TW.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactor {
    WebDriver driver;
    By sectionElement = By.id("flightSearchContainer");

    public StrategyFactor(WebDriver driver) {
        this.driver = driver;
    }

    public SearchFlightAvail createStrategy(String strategyType) {
        if (strategyType.equalsIgnoreCase("multiCityTrip")) {
            return new MultiCityTrip(driver, sectionElement);
        }
        if (strategyType.equalsIgnoreCase("roundTrip")) {
            return new RoundTrip(driver, sectionElement);
        }
        return null;
    }
}
