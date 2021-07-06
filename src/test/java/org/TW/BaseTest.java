package org.TW;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/mamta.siyak/Downloads/SetUp/chromedriver");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
