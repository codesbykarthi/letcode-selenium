package PageObjects;

import UtilsMethods.DriverManager;
import UtilsMethods.FileUtilities;
import UtilsMethods.SeleniumUtilities;
import UtilsMethods.WaitUtilities;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class DropdownPage extends DriverManager {
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//select[@id='fruits']")
	private static WebElement dpd_sel_fruits;

	@FindBy(how = How.XPATH, using = "//select[@id='superheros']")
	private static WebElement dpd_sel_superheroes;

	@FindBy(how = How.XPATH, using = "(//p[@class='subtitle' and contains(text(),'You have selected')]/ancestor::div[@class='content'])[0]")
	private static WebElement dpd_textContentOne;

	@FindBy(how = How.XPATH, using = "(//p[@class='subtitle' and contains(text(),'You have selected')]/ancestor::div[@class='content'])[1]")
	private static WebElement dpd_textContentTwo;

	@FindBy(how = How.XPATH, using = "//select[@id='lang']")
	private static WebElement dps_sel_language;

	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	private static WebElement dpd_sel_country;

	SeleniumUtilities seleniumUtilities = new SeleniumUtilities();
	WaitUtilities waitUtilities = new WaitUtilities();
	FileUtilities fileUtilities = new FileUtilities();

	String url = FileUtilities.getProperty("src/main/resources/properties/config.properties","letcodeURL_Dropdown");

	public void navigateToDropdownFieldPage() throws InterruptedException, IOException {
		this.driver = getDriver();
	    PageFactory.initElements(driver, this);
    	seleniumUtilities.navigateTo(url);
    	waitUtilities.setWait(2);
	}

	public void selectDropdownUsingVisibleTextDPDone() throws InterruptedException, IOException {
		try {
			seleniumUtilities.selectDropdownByVisibleText(dpd_sel_fruits, "Pine Apple");
			Assert.assertEquals(seleniumUtilities.getText(dpd_textContentOne), "You have selected Pine Apple");   	
			Assert.assertFalse(seleniumUtilities.isMultipleDropdown(dpd_sel_fruits));
			waitUtilities.setWait(2);
		} catch (Exception e) {
			Assert.fail("TestFailed: Unable to validate dropdown one. " + e.getMessage());
		}
	}

	public void selectDropdownUsingIndexAndValidateElementTextandColorDPDTwo() throws InterruptedException, IOException {
		try {
			seleniumUtilities.selectDropdownByIndex(dpd_sel_superheroes, 3);
			Assert.assertEquals(seleniumUtilities.getText(dpd_textContentTwo), "You have selected Batman");   	
			seleniumUtilities.selectDropdownByIndex(dpd_sel_superheroes, 5);
			Assert.assertEquals(seleniumUtilities.getText(dpd_textContentTwo), "You have selected Black Panther");   
			waitUtilities.setWait(2);
		} catch (Exception e) {
			Assert.fail("TestFailed: Unable to validate dropdown two. " + e.getMessage());
		}
	}

	public void getOptionsAndGetSelectedOptionsDPDThree() throws InterruptedException, IOException {
		try { 
			System.out.println(seleniumUtilities.getAllDropdownOptions(dps_sel_language));
			seleniumUtilities.selectDropdownByIndex(dps_sel_language, seleniumUtilities.getAllDropdownOptions(dps_sel_language).size()-1);
			Assert.assertEquals(seleniumUtilities.getText(dpd_textContentTwo), "You have selected C#"); 
			waitUtilities.setWait(2);
		} catch (Exception e) {
			Assert.fail("TestFailed: Unable to validate dropdown three. " + e.getMessage());
		}
	}
	
	public void selectOptionByValueAndPrintDPDFour() throws InterruptedException, IOException {
		try { 
			seleniumUtilities.selectDropdownByValue(dpd_sel_country, "India");
			seleniumUtilities.getCurrentDropdownSelectedOption(dpd_sel_country);
			waitUtilities.setWait(2);
		} catch (Exception e) {
			Assert.fail("TestFailed: Unable to validate dropdown four. " + e.getMessage());
		}
	}
}
