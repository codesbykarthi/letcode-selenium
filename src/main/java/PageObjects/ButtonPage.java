package PageObjects;

import UtilsMethods.DriverManager;
import UtilsMethods.FileUtilities;
import UtilsMethods.SeleniumUtilities;
import UtilsMethods.WaitUtilities;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ButtonPage extends DriverManager {
    WebDriver driver;

    @FindBy(how = How.XPATH, using = "//button[@id='home']")
    private static WebElement btn_goToHomePage;

    @FindBy(how = How.XPATH, using = "//button[@id='position']")
    private static WebElement btn_findPositionOfButton;

    @FindBy(how = How.XPATH, using = "//button[@id='color']")
    private static WebElement btn_findButtonBackgroundColor;

    @FindBy(how = How.XPATH, using = "//button[@id='property']")
    private static WebElement btn_findSizeOfButton;

    @FindBy(how = How.XPATH, using = "//button[text()='Disabled']")
    private static WebElement btn_isDisabledButton;

    @FindBy(how = How.XPATH, using = "//button[@id='isDisabled' and @class='button is-primary']")
    private static WebElement btn_clickAndHoldButton;

    SeleniumUtilities seleniumUtilities = new SeleniumUtilities();
    WaitUtilities waitUtilities = new WaitUtilities();
    FileUtilities fileUtilities = new FileUtilities();

    String url = FileUtilities.getProperty("src/main/resources/properties/config.properties", "letcodeURL_Button");
    String HomePageUrl = FileUtilities.getProperty("src/main/resources/properties/config.properties", "letcodeURL_Home");

    public void navigateToButtonFieldPage() throws InterruptedException, IOException {
    	this.driver = getDriver();
	    PageFactory.initElements(driver, this);
    	seleniumUtilities.navigateTo(url);
    	waitUtilities.setWait(2);
    }

    public void clickGoToHomeButtonOne() throws InterruptedException, IOException {
        try {
            seleniumUtilities.click(btn_goToHomePage);
            waitUtilities.setWait(3);
            driver.navigate().back();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to navigate to home page by using Button one. " + e.getMessage());
        }
    }

    public void getPositionButtonTwo() throws InterruptedException, IOException {
        try {
            Point coords = btn_findPositionOfButton.getLocation();
            System.out.println("X : " + coords.getX() + ", Y : " + coords.getY());
            waitUtilities.setWait(2);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to retrieve position of button two. " + e.getMessage());
        }
    }

    public void getBackgroundColorButtonThree() throws InterruptedException, IOException {
        try {
            System.out.println(seleniumUtilities.getCSSValue(btn_findButtonBackgroundColor, "background-color"));
            waitUtilities.setWait(2);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to retrieve background color of button three. " + e.getMessage());
        }
    }

    public void getButtonSizeButtonFour() throws InterruptedException, IOException {
        try {
            Dimension size = btn_findPositionOfButton.getSize();
            System.out.println("Height : " + size.getHeight() + ", Width : " + size.getWidth());
            waitUtilities.setWait(2);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to retrieve size of button four. " + e.getMessage());
        }
    }

    public void validateIsDisabledButtonFive() throws InterruptedException, IOException {
        try {
            Assert.assertFalse("Field is enabled", seleniumUtilities.isElementEnabled(btn_isDisabledButton));
            waitUtilities.setWait(2);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to retrieve ekement's disabled state in button five. " + e.getMessage());
        }
    }

    public void clickAndHodButtonSix() throws InterruptedException, IOException {
        try {
            Assert.assertEquals(btn_clickAndHoldButton.getAccessibleName(), "Button Hold!");
            seleniumUtilities.actionsClickAndHold(btn_clickAndHoldButton);
            waitUtilities.setWait(3);
            seleniumUtilities.actionsReleaseElement(btn_clickAndHoldButton);
            Assert.assertEquals(btn_clickAndHoldButton.getAccessibleName(), "Button has been long pressed");
            waitUtilities.setWait(2);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to click and Hold in button Six. " + e.getMessage());
        }
    }

}