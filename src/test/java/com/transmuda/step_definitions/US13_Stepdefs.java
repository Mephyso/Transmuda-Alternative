package com.transmuda.step_definitions;

import com.transmuda.pages.DashboardPage;
import com.transmuda.pages.VehicleCostsPage;
import com.transmuda.utilities.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

import com.transmuda.utilities.ButtonGenerator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.messages.types.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class US13_Stepdefs {
    private static Logger log = LoggerFactory.getLogger(US13_Stepdefs.class);
    DashboardPage dashboardPage = new DashboardPage();
    VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();
    ButtonGenerator buttonGenerator= new ButtonGenerator();



    @And("the user click on the Vehicle Costs under the Fleet")
    public void theUserClickOnTheVehicleCostsUnderTheFleet() {
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.clickWithJS(dashboardPage.fleetModule);
        BrowserUtils.clickWithJS(dashboardPage.fleetModuleVehicleCosts);
        BrowserUtils.sleep(5);
    }

    @Then("the user should see following titles in the table")
    public void theUserShouldSeeFollowingTitlesInTheTable(List<String> expectedTitles) {
        List<String> actualTitles = new ArrayList<>();
        for (WebElement element:vehicleCostsPage.allVehicleCostsTablesHeaders)
            if (element.getText().length()>0) actualTitles.add(element.getText());

        Assert.assertEquals(expectedTitles,actualTitles);
    }

    @And("the user click the first checkbox")
    public void theUserClickTheFirstCheckbox() {
        BrowserUtils.clickWithJS(vehicleCostsPage.firstCheckBox);
    }

    @Then("the user should see all the vehicle costs are checked")
    public void theUserShouldSeeAllTheVehicleCostsAreChecked() {
        boolean result=true;
        for (WebElement element:vehicleCostsPage.allCheckBoxes)
            if (!element.isSelected()) result=false;

        Assert.assertTrue(result);
    }

    @And("the user click on {string} in {string}")
    public void theUserClickOnIn(String element, String page) {
        buttonGenerator.clickTheElementOnThePage(element, page);
    }

    @Then("the user should see webelement {} on the {string}")
    public void theUserShouldSeeWebelementOnThe(DataTable element, String page) {
        log.info("Log of method");
        buttonGenerator.checkTheWebElement(element, page);
    }
}
