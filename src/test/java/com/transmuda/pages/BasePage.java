package com.transmuda.pages;

import com.transmuda.utilities.BrowserUtils;
import com.transmuda.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    @FindBy(xpath = "//div[normalize-space()='You do not have permission to perform this action.']")
    public WebElement errorMessage;

    @FindBy(xpath = "//span[normalize-space()='Vehicles Model']")
    public WebElement vehiclesModel;

    @FindBy(css = "span.title-level-1")
    public List<WebElement> menuOptions;

    @FindBy(xpath = "(//div[@class='loader-frame'])[last()]")
    protected WebElement loaderMask;


    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;

    @FindBy(css = "#user-menu > a")
    public WebElement userName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderScreenDisappear();
//        BrowserUtils.waitForStaleElement(pageSubTitle);
        return pageSubTitle.getText();
    }


    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     */
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[4]/a" )
    public WebElement fleetModuleVehicleOdometer;

    /**
     * This method will navigate user to the specific module in vytrack application.
     * For example: if tab is equals to Activities, and module equals to Calls,
     * Then method will navigate user to this page: http://qa2.vytrack.com/call/
     *
     * @param tab
     * @param module
     */
    public void navigateToModule(String tab, String module) {
        String tabLocator = "//span[normalize-space()='" + tab + "' and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[normalize-space()='" + module + "' and contains(@class, 'title title-level-2')]";
        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.getDriver().findElement(By.xpath(tabLocator));
            new Actions(Driver.getDriver()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.getDriver().findElement(By.xpath(moduleLocator)));
            Driver.getDriver().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
//            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
            BrowserUtils.clickWithTimeOut(Driver.getDriver().findElement(By.xpath(moduleLocator)),  5);
        }
    }

    @FindBy(xpath = "//i[@title='Get help']")
    public WebElement questionIcon;

    @FindBy (xpath = "//span[@class='title title-level-1'][normalize-space()='Fleet']")
    public WebElement fleetModule;

    @FindBy (xpath ="//a[@href='/entity/Extend_Entity_VehicleCosts']/span")
    public WebElement fleetModuleVehicleCosts;

    @FindBy (xpath = "//span[@class='title title-level-1'][normalize-space()='Customers']")
    public WebElement customersModule;

    @FindBy (xpath = "//span[@class='title title-level-1'][normalize-space()='Sales']")
    public WebElement salesModule;

    @FindBy (xpath = "//span[@class='title title-level-1'][normalize-space()='Activities']")
    public WebElement activitiesModule;

    @FindBy (xpath = "//span[@class='title title-level-1'][normalize-space()='Marketing']")
    public WebElement marketingModule;

    @FindBy (xpath = "//span[@class='title title-level-1'][normalize-space()='Reports & Segments']")
    public WebElement reportAndSegmentsModule;

    @FindBy (xpath = "//span[@class='title title-level-1'][normalize-space()='System']")
    public WebElement systemModule;

    @FindBy(xpath = "//span[@class='title title-level-2'][contains(.,'Calendar Events')]")
    public WebElement calenderEvent;

    @FindBy (xpath="//a[.='Learn how to use this space']")
    public WebElement pinbarHelpButton;

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[4]/a/span")
    public WebElement VehicleOdometerSalesManager;

    public void clickElementOnTheBasePage (String element){
        switch (element){
            case "FleetModule":
                fleetModule.click(); break;
            case "Vehicle CostsModule":
                fleetModuleVehicleCosts.click(); break;
        }

    }


}