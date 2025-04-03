package PageObjects;

import UtilsMethods.DriverManager;
import UtilsMethods.FileUtilities;
import UtilsMethods.SeleniumUtilities;
import UtilsMethods.WaitUtilities;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class IframePage extends DriverManager {
	WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@id='fullName']")
    private static WebElement inp_InputFullName;

    @FindBy(how = How.XPATH, using = "//input[@id='join']")
    private static WebElement inp_AppendText;

    @FindBy(how = How.XPATH, using = "//input[@id='getMe']")
    private static WebElement inp_InsideTextBox;

    @FindBy(how = How.XPATH, using = "//input[@id='clearMe']")
    private static WebElement inp_Clear;

    @FindBy(how = How.XPATH, using = "//input[@id='noEdit']")
    private static WebElement inp_Disabled;

    @FindBy(how = How.XPATH, using = "//input[@id='dontwrite']")
    private static WebElement inp_ReadOnly;

    SeleniumUtilities seleniumUtilities = new SeleniumUtilities();
    WaitUtilities waitUtilities = new WaitUtilities();
    FileUtilities fileUtilities = new FileUtilities();
    
    String url = FileUtilities.getProperty("src/main/resources/properties/config.properties","letcodeURL_Iframe");

    public void navigateToInputFieldPage() throws InterruptedException, IOException {
    	this.driver = getDriver();
	    PageFactory.initElements(driver, this);
    	seleniumUtilities.navigateTo(url);
    	waitUtilities.setWait(2);
    }
}