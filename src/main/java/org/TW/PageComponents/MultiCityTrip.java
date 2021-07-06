package org.TW.PageComponents;

import org.TW.AbstractComponents.AbstractComponent;
import org.TW.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiCityTrip extends AbstractComponent implements SearchFlightAvail {

    private By modelPopUp = By.id("MultiCityModelAlert");
    private By multicityRadio = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By checkBox = By.id("ctl00_mainContent_chk_IndArm");
    private By search = By.id("ctl00_mainContent_btn_FindFlights");
    private By city2_from = By.id("ctl00_mainContent_ddl_originStation2_CTXT");

    public MultiCityTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) {
        makeStateReady(s -> selectOriginCity(reservationDetails.get("origin")));
        selectDestinationCity(reservationDetails.get("destination"));
        selectDestinationCity2(reservationDetails.get("destination2"));
    }

    public void selectOriginCity(String origin) {
        findElement(from).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    public void selectDestinationCity(String destination) {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();
    }

    public void selectDestinationCity2(String destination2) {
        findElement(city2_from).click();
        findElement(By.xpath("(//a[@value='" + destination2 + "'])[3]")).click();
    }

    public void makeStateReady(Consumer<MultiCityTrip> consumer) {
        //common prerequisite code
        System.out.println("I'm inside multiCity trip ");
        findElement(multicityRadio).click();
        findElement(modelPopUp).click();
        waitForElementToDisappear(modelPopUp);

        //execute actual function
        consumer.accept(this); //it accepts any method of this current class
        System.out.println("I'm done");


        //tear down method
    }

}
