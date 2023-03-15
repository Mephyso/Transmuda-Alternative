package com.transmuda.utilities;

import com.transmuda.pages.DashboardPage;
import com.transmuda.pages.VehicleCostsPage;
import io.cucumber.messages.types.DataTable;

public class ButtonGenerator {

    DashboardPage dashboardPage= new DashboardPage();
    VehicleCostsPage vehicleCostsPage= new VehicleCostsPage();

    /**
     * The following method is used to click specific web element on specific page
     * @param element
     * @param page
     */
    public void clickTheElementOnThePage(String element, String page){
        switch (page){
            case "VehicleCostPage":
                dashboardPage.clickElementOnTheBasePage(element);
                break;
        }
    }

    public void checkTheWebElement(DataTable element, String page){
        switch (page) {
            case "VehicleCostPage":
                vehicleCostsPage.checkTheElementOnTheVehicleCostsPage(element);
                break;
        }
    }
}
