package TestCase;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PageObjects.ButtonPage;
import PageObjects.DropdownPage;
import PageObjects.InputPage;
import UtilsMethods.DriverManager;

public class Letcode extends DriverManager {

	@BeforeMethod
	public void setUp() {
		try {
			getDriver(); 
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to initialize WebDriver");
		}
	}

	@Test
	public void letcodeInput() throws InterruptedException, IOException {

		InputPage inputPage = new InputPage();

		inputPage.navigateToInputFieldPage();
		inputPage.enterFullNameInTextBoxOne();
		inputPage.appendTextAndPressKeyboardTabInTextBoxTwo();
		inputPage.retrievesTheTextInsideTextBoxInTextBoxThree();
		inputPage.clearTextInsideTextBoxInTextBoxFour();
		inputPage.validateTextBoxIsDisabledInTextBoxFive();
		inputPage.validateTextBoxIsReadonlyInTextBoxSix();

	}

	@Test
	public void letcodeButton() throws InterruptedException, IOException {

		ButtonPage buttonPage = new ButtonPage();

		buttonPage.navigateToButtonFieldPage();
		buttonPage.clickGoToHomeButtonOne();
		buttonPage.getPositionButtonTwo();
		buttonPage.getBackgroundColorButtonThree();
		buttonPage.getButtonSizeButtonFour();
		buttonPage.validateIsDisabledButtonFive();
		buttonPage.clickAndHodButtonSix();
	}

	@Test
	public void letcodeDropdown() throws InterruptedException, IOException {

		DropdownPage dropdownPage = new DropdownPage();

		dropdownPage.navigateToDropdownFieldPage();
		dropdownPage.selectDropdownUsingVisibleTextDPDone();
		dropdownPage.selectDropdownUsingIndexAndValidateElementTextandColorDPDTwo();
		dropdownPage.getOptionsAndGetSelectedOptionsDPDThree();
		dropdownPage.selectOptionByValueAndPrintDPDFour();

	}

	@AfterMethod
	public void tearDown() {
		try {
			quitDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
