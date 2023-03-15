package com.transmuda.pages;

import com.transmuda.utilities.BrowserUtils;
import io.cucumber.messages.types.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VehicleCostsPage extends BasePage{
    @FindBy(xpath = "//span[@class='grid-header-cell__label']")
    public List<WebElement> allVehicleCostsTablesHeaders;

    @FindBy(xpath = "(//input[@type='checkbox'])[4]")
    public WebElement firstCheckBox;

    @FindBy(xpath = "//input[@tabindex='-1']")
    public List<WebElement> allCheckBoxes;

    public void checkTheElementOnTheVehicleCostsPage(DataTable element){
        switch (element.toString()){
            case "TYPE":
                BrowserUtils.verifyElementDisplayed(allVehicleCostsTablesHeaders.get(0));
                break;
        }
    }

}
