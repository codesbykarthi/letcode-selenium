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

public class InputPage extends DriverManager {
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
    
    String url = FileUtilities.getProperty("src/main/resources/properties/config.properties","letcodeURL_Input");

    public void navigateToInputFieldPage() throws InterruptedException, IOException {
    	this.driver = getDriver();
	    PageFactory.initElements(driver, this);
    	seleniumUtilities.navigateTo(url);
    	waitUtilities.setWait(2);
    }

    public void enterFullNameInTextBoxOne() throws InterruptedException {
        try {
            inp_InputFullName.sendKeys("FullName");
            waitUtilities.setWait(2);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to enter full name in text box one. " + e.getMessage());
        }
    }

    public void appendTextAndPressKeyboardTabInTextBoxTwo() throws InterruptedException {
        try {
            seleniumUtilities.enterText(inp_AppendText, "AppendText");
            inp_AppendText.sendKeys(Keys.TAB);
            waitUtilities.setWait(2);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to append Text and press Tab key in text box two. " + e.getMessage());
        }
    }

    public void retrievesTheTextInsideTextBoxInTextBoxThree() throws InterruptedException {
        try {
            System.out.println(seleniumUtilities.getAttribute(inp_InsideTextBox, "value"));
            waitUtilities.setWait(2);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to retrieve the text inside text box three. " + e.getMessage());
        }
    }

    public void clearTextInsideTextBoxInTextBoxFour() throws InterruptedException {
        try {
            seleniumUtilities.scrollToAnElement(inp_Clear);
            inp_Clear.clear();
            waitUtilities.setWait(2);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to clear the text inside text box four. " + e.getMessage());
        }
    }

    public void validateTextBoxIsDisabledInTextBoxFive() throws InterruptedException {
        try {
            Assert.assertFalse("Field is enabled", seleniumUtilities.isElementEnabled(inp_Disabled));
            waitUtilities.setWait(2);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to validate the text box is disabled in text box five. " + e.getMessage());
        }
    }

    public void validateTextBoxIsReadonlyInTextBoxSix() throws InterruptedException {
        try {
            Assert.assertEquals("It is not read only", "true", seleniumUtilities.getAttribute(inp_ReadOnly, "readonly"));
            waitUtilities.setWait(2);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to validate the text box is readonly in text box six. " + e.getMessage());
        }
    }

}