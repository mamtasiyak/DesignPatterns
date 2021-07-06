package org.TW.PageComponents;

import org.TW.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNav extends AbstractComponent {

    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver, sectionElement); //when you inherit parent class you should invoke parent class constructor
        //in your own child constructor
    }


    //method to handle flights
    //when selenium executes any method in this class- scope of selenium
    //should be in footer only


    public String getFlightAttribute() {
        //custom find element
        return findElement(flights).getAttribute("class");
        //driver.findElement(flights).click();
    }

    public int getLinkCount() {
        return findElements(links).size();
    }

}
