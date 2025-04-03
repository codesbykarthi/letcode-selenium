package UtilsMethods;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SeleniumUtilities extends DriverManager {

    Actions actions = new Actions(getDriver());
    WaitUtilities waitUtilities = new WaitUtilities();

    /**************************************************************** INTERACTION METHODS - START *******************************************************************/

    /**
     * This method is for clicking an element
     *
     * @param element - Web element
     */
    public void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to click on the element. " + e.getMessage());
        }
    }

    /**
     * This method is for submitting a form
     *
     * @param element - Web element
     */
    public void submit(WebElement element) {
        try {
            element.submit();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to submit the form. " + e.getMessage());
        }
    }

    /**
     * This method is for entering a text in a text box
     *
     * @param element - Web element
     * @param text    - Text to be entered in a text box
     */
    public void enterText(WebElement element, String text) {
        try {
            element.sendKeys(text);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to clear and enter the text in text box. " + e.getMessage());
        }
    }

    /**
     * This method is for selecting the dropdown using visible text
     *
     * @param element     - Web element
     * @param visibleText - Visible text to be selected in dropdown
     */
    public void selectDropdownByVisibleText(WebElement element, String visibleText) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(visibleText);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to select the dropdown using visible text. " + e.getMessage());
        }
    }

    /**
     * This method is for selecting the dropdown using visible text
     *
     * @param element - Web element
     * @param value   - Value to be selected in dropdown
     */
    public void selectDropdownByValue(WebElement element, String value) {
        try {
            Select select = new Select(element);
            select.selectByValue(value);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to select the dropdown using value. " + e.getMessage());
        }
    }

    /**
     * This method is for selecting the dropdown using visible text
     *
     * @param element - Web element
     * @param index   - Index to be selected in dropdown
     */
    public void selectDropdownByIndex(WebElement element, int index) {
        try {
            Select select = new Select(element);
            select.selectByIndex(index);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to select the dropdown using index. " + e.getMessage());
        }
    }

    /**
     * This method is for SCROLLING to a specific pixel
     *
     * @param scrollSize - Number of pixel scrollbar should scroll
     */
    public void scrollToAnElement(long scrollSize) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window.scrollBy(0," + scrollSize + ")");
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to scroll to a specific element. " + e.getMessage());
        }
    }

    /**
     * This method is for SCROLLING to a specific element
     *
     * @param element - Web element
     */
    public void scrollToAnElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to scroll to a specific element. " + e.getMessage());
        }
    }

    /**
     * This method is for taking PAGE SCREENSHOT
     *
     * @throws IOException
     */
    public void takeScreenshot() throws IOException {
        try {
            File screenshotFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            String screenshotPath = "Screenshot/screenshot.png";
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to take the screenshot. " + e.getMessage());
        }
    }

    /**
     * This method is for taking full PAGE SCREENSHOT with ALERT POP UP also
     *
     * @throws IOException
     */
    public void robotScreenshot() throws IOException {
        try {
            Robot r = new Robot();
            Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle rec = new Rectangle(d);
            BufferedImage bi = r.createScreenCapture(rec);
            File f = new File("D:\\Automation Project\\Selenium_Gokul\\letcode_webautomation\\test-output\\robotScreenshot.jpg");
            ImageIO.write(bi, "jpg", f);
            byte[] fileBytes = new byte[(int) f.length()];
            try (FileInputStream fis = new FileInputStream(f)) {
                fis.read(fileBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to take the full screenshot. " + e.getMessage());
        }
    }


    /**
     * This method if for HIGHLIGHTING a specific element
     *
     * @param element
     */
    public void highlightElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to highlight a specific element. " + e.getMessage());
        }
    }

    /**************************************************************** INTERACTION METHODS - END *******************************************************************/
    
    /**************************************************************** EXTRACTION METHODS - START *******************************************************************/

    /**
     * This method is for getting text of an element
     *
     * @param element - Web element
     * @return
     */
    public String getText(WebElement element) {
        try {
            return element.getText().trim();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to get the text from webpage. " + e.getMessage());
            return null;
        }
    }

    /**
     * This method is for getting alert Text
     *
     * @return
     */
    public String getAlertText() {
        try {
            return getDriver().switchTo().alert().getText();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to get the alert text from webpage. " + e.getMessage());
            return null;
        }
    }

    /**
     * This method is for getting total size of the elements
     *
     * @param elements - Web elements
     * @return
     */
    public int getElementsSize(List<WebElement> elements) {
        try {
            return elements.size();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to get the size of elements. " + e.getMessage());
            return 0;
        }
    }

    /**
     * This method is for getting tag name of an element
     *
     * @param element - Web element
     * @return
     */
    public String getTagName(WebElement element) {
        try {
            return element.getTagName();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to get the tag name from webpage. " + e.getMessage());
            return null;
        }
    }

    /**
     * This method is for getting attribute of an element
     *
     * @param element   - Web element
     * @param attribute - Attribute key which we need to fetch the value
     * @return
     */
    public String getAttribute(WebElement element, String attribute) {
        try {
            return element.getDomAttribute(attribute);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to get the attribute from webpage. " + e.getMessage());
            return null;
        }
    }

    
    /**
     * This method is for getting CSS value of an element
     *
     * @param element   - Web element
     * @param property - CSS property which we need to fetch the value
     * @return
     */
    public String getCSSValue(WebElement element, String property) {
        try {
            return element.getCssValue(property);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to get the CSS VAlue of element from webpage. " + e.getMessage());
            return null;
        }
    }

    /**
     * This method is for getting the current selected dropdown value
     *
     * @param element - Web element
     * @return
     */
    public String getCurrentDropdownSelectedOption(WebElement element) {
        try {
            Select select = new Select(element);
            return select.getFirstSelectedOption().getText();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to get the current selected dropdown value. " + e.getMessage());
            return null;
        }
    }

    /**
     * This method is for getting all the options of a dropdown
     *
     * @param element - Web element
     * @return
     */
    public List<String> getAllDropdownOptions(WebElement element) {
        try {
            List<String> allDropdownValuesText = new ArrayList<>();
            Select select = new Select(element);
            List<WebElement> allDropdownValues = select.getOptions();
            for (WebElement eachDropdownValue : allDropdownValues) {
                allDropdownValuesText.add(eachDropdownValue.getText());
            }
            return allDropdownValuesText;
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to get all the options of a dropdown. " + e.getMessage());
            return null;
        }
    }

    /**
     * This method is for getting all the options of a dropdown
     *
     * @param element - Web element
     * @return
     */
    public List<String> getAllSelectedDropdownOptions(WebElement element) {
        try {
            List<String> allSelectedDropdownValuesText = new ArrayList<>();
            Select select = new Select(element);
            List<WebElement> allDropdownValues = select.getAllSelectedOptions();
            for (WebElement eachDropdownValue : allDropdownValues) {
                allSelectedDropdownValuesText.add(eachDropdownValue.getText());
            }
            return allSelectedDropdownValuesText;
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to get all the selected options of a dropdown. " + e.getMessage());
            return null;
        }
    }

    /**
     * This method is used to click the auto complete value once the expected string is matched with the any value of the autocomplete list
     *
     * @param textBoxElement                 - Web element of the exact auto complete text box
     * @param text                           - Exact text which we are entering
     * @param autocompleteValuesListElements - Web elements of the list of auto complete suggestion values
     * @param expectedValue                  - Expected string which we are looking for and need to select in the auto complete list
     */
    public void validateAndAutocompleteAValue(WebElement textBoxElement, String text, List<WebElement> autocompleteValuesListElements, String expectedValue) {
        try {
            boolean isValuePresent = false;
            enterText(textBoxElement, text);
            waitUtilities.wait(2);
            for (WebElement value : autocompleteValuesListElements) {
                if (value.getText().equalsIgnoreCase(expectedValue)) {
                    isValuePresent = true;
                    value.click();
                    break;
                }
            }
            Assert.assertTrue("Expected value to be selected is not present in the list of auto complete values. ", isValuePresent);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to validate and auto complete a value. " + e.getMessage());
        }
    }

    /**
     * This method is for getting title of a page
     *
     * @return
     */
    public String getPageTitle() {
        try {
            return getDriver().getTitle();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to get the page title. " + e.getMessage());
            return null;
        }
    }

    /**
     * This method is for getting current page URL
     *
     * @return
     */
    public String getCurrentPageURL() {
        try {
            return getDriver().getCurrentUrl();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to get the current page URL. " + e.getMessage());
            return null;
        }
    }

    /**
     * This method is for getting height of an element
     *
     * @return
     */
    public int getHeight(WebElement element) {
        try {
            return element.getSize().getHeight();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to get the height of an element. " + e.getMessage());
            return 0;
        }
    }

    /**
     * This method is for getting width of an element
     *
     * @return
     */
    public int getWidth(WebElement element) {
        try {
            return element.getSize().getWidth();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to get the width of an element. " + e.getMessage());
            return 0;
        }
    }

    /**
     * This method is for getting position of X of an element
     *
     * @return
     */
    public int getLocationX(WebElement element) {
        try {
            return element.getLocation().getX();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to get the position of X of an element. " + e.getMessage());
            return 0;
        }
    }

    /**
     * This method is for getting position of Y of an element
     *
     * @return
     */
    public int getLocationY(WebElement element) {
        try {
            return element.getLocation().getY();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to get the position of Y of an element. " + e.getMessage());
            return 0;
        }
    }

    /**************************************************************** EXTRACTION METHODS - END *******************************************************************/


    /**************************************************************** VALIDATION METHODS - START *******************************************************************/

    /**
     * This method is for validating that element is displayed
     *
     * @param element - Web element
     * @return
     */
    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to validate element is displayed. " + e.getMessage());
            return false;
        }
    }

    /**
     * This method is for validating that element is enabled or not
     *
     * @param element - Web element
     * @return
     */
    public boolean isElementEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to validate element is enabled or not. " + e.getMessage());
            return false;
        }
    }

    /**
     * This method is for validating that element is selected or not
     *
     * @param element - Web element
     * @return
     */
    public boolean isElementSelected(WebElement element) {
        try {
            return element.isSelected();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to validate element is selected or not. " + e.getMessage());
            return false;
        }
    }

    /**
     * This method is for validating that dropdown is multiple or not
     *
     * @param element - Web element
     * @return
     */
    public boolean isMultipleDropdown(WebElement element) {
        try {
            Select select = new Select(element);
            return select.isMultiple();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to validate dropdown is multiple dropdown or not. " + e.getMessage());
            return false;
        }
    }

    /**
     * This method is for validating text of an element and expected string is equal or not
     *
     * @param element      - Web element
     * @param expectedText - Expected string which user is passing
     * @return
     */
    public boolean isGetTextEqual(WebElement element, String expectedText) {
        try {
            return element.getText().equals(expectedText);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to validate text of an element is equal to expected string or not. " + e.getMessage());
            return false;
        }
    }

    /**
     * This method is for validating text of an element contains an expected string or not
     *
     * @param element      - Web element
     * @param expectedText - Expected string which user is passing
     * @return
     */
    public boolean isGetTextContains(WebElement element, String expectedText) {
        try {
            return element.getText().contains(expectedText);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to validate text of an element contains an expected string or not. " + e.getMessage());
            return false;
        }
    }

    /**
     * This method is for validating both actual and expected string are equal or not
     *
     * @param actualText   - Actual string
     * @param expectedText - Expected string
     * @return
     */
    public boolean areBothStringEqual(String actualText, String expectedText) {
        try {
            return actualText.equalsIgnoreCase(expectedText);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to validate both strings are equal. " + e.getMessage());
            return false;
        }
    }

    /**
     * This method is for validating actual string contains expected string or not
     *
     * @param actualText   - Actual string
     * @param expectedText - Expected string
     * @return
     */
    public boolean containsText(String actualText, String expectedText) {
        try {
            return actualText.contains(expectedText);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to validate one string contains another string. " + e.getMessage());
            return false;
        }
    }

    /**************************************************************** VALIDATION METHODS - END *******************************************************************/

    /**************************************************************** WINDOWS/TABS/FRAMES/ALERTS METHODS - START *******************************************************************/

    /**
     * This method is for switching to the child window
     */
    public void switchToSpecificWindow(int windowIndex) {
        try {
            Set<String> childWindows = getDriver().getWindowHandles();
            List<String> childWindowsSize = new ArrayList<>(childWindows);
            getDriver().switchTo().window(childWindowsSize.get(windowIndex));
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to switch to child window. " + e.getMessage());
        }
    }

    /**
     * This method is for switching to the child tab
     */
    public void createAndSwitchToChildTab() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("window-open()");
            ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
            getDriver().switchTo().window(tabs.get(1));
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to switch to child tab. " + e.getMessage());
        }
    }

    /**
     * This method is for switching to a specific frame
     *
     * @param index - Specific index of a frame
     */
    public void switchToFrame(int index) {
        try {
            getDriver().switchTo().frame(index);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to switch to specific frame by index. " + e.getMessage());
        }
    }

    /**
     * This method is for switching to a specific frame
     *
     * @param element - Web element
     */
    public void switchToFrame(WebElement element) {
        try {
            getDriver().switchTo().frame(element);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to switch to specific frame by xpath. " + e.getMessage());
        }
    }

    /**
     * This method is for switching out of all child windows and frames
     */
    public void switchOutOfAllFrames() {
        try {
            getDriver().switchTo().defaultContent();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to switch out of all child frames or windows. " + e.getMessage());
        }
    }

    /**
     * This method is for accepting the pop-up alert
     */
    public void acceptAlert() {
        try {
            getDriver().switchTo().alert().accept();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to accept the pop-up alert. " + e.getMessage());
        }
    }

    /**
     * This method is for dismissing the pop-up alert
     */
    public void dismissAlert() {
        try {
            getDriver().switchTo().alert().dismiss();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to dismiss the pop-up alert. " + e.getMessage());
        }
    }

    /**
     * This method is for sending text to the pop-up alert
     *
     * @param textToSendInAlert
     */
    public void sendTextToAlert(String textToSendInAlert) {
        try {
            getDriver().switchTo().alert().sendKeys(textToSendInAlert);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to send text to the pop-up alert. " + e.getMessage());
        }
    }

    /**************************************************************** WINDOWS/TABS/FRAMES/ALERTS METHODS - END *******************************************************************/

    /********************************************************************** NAVIGATION METHODS - START *******************************************************************/

    /**
     * This method is for navigating to specific URL
     *
     * @param url - Expected URL
     */
    public void navigateTo(String url) {
        try {
            getDriver().navigate().to(url);
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to navigate to specific URL. " + e.getMessage());
        }
    }

    /**
     * This method is for navigating back to the previous page
     */
    public void navigateBack() {
        try {
            getDriver().navigate().back();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to navigate back to the previous page. " + e.getMessage());
        }
    }

    /**
     * This method is for navigating forward to the next page
     */
    public void navigateForward() {
        try {
            getDriver().navigate().forward();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to navigate forward to the next page. " + e.getMessage());
        }
    }

    /**
     * This method is for refreshing the current page
     */
    public void refreshPage() {
        try {
            getDriver().navigate().refresh();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to refresh the current page. " + e.getMessage());
        }
    }

    /********************************************************************** NAVIGATION METHODS - END *******************************************************************/

    /********************************************************************** ACTIONS METHODS - START *******************************************************************/

    /**
     * This method is used for sending Keys
     *
     * @param keys - Keyboard Keys which we need to click //Keys.CONTROL //Keys.ENTER
     */
    public void actionsSendKeys(CharSequence... keys) {
        try {
            actions.sendKeys(keys).build().perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to send Keys using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for sending text
     *
     * @param element - Web element
     * @param text    - Text which we need to send
     */
    public void actionsSendKeys(WebElement element, String text) {
        try {
            actions.sendKeys(element, text).build().perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to send the text using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for clicking an element using actions class
     *
     * @param element - Web element
     */
    public void actionsClick(WebElement element) {
        try {
            actions.click(element).perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to click on an element using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for double-clicking an element using actions class
     *
     * @param element - Web element
     */
    public void actionsDoubleClick(WebElement element) {
        try {
            actions.doubleClick(element).perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to double click on an element using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for right-clicking an element using actions class
     *
     * @param element - Web element
     */
    public void actionsRightClick(WebElement element) {
        try {
            actions.contextClick(element).perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to right click on an element using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for clicking and holding an element using actions class
     *
     * @param element - Web element
     */
    public void actionsClickAndHold(WebElement element) {
        try {
            actions.clickAndHold(element).build().perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to click and hold on an element using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for clicking, holding and releasing an element using actions class
     *
     * @param element - Web element
     */
    public void actionsClickAndHoldAndRelease(WebElement element) {
        try {
            actions.clickAndHold(element).release().build().perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to click and hold and release an element using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for move an element by clicking, holding, moving by offset and releasing at target place using actions class
     *
     * @param element - From location of the web element
     * @param xOffset - Position of X axis of the To location
     * @param yOffset - Position of Y axis of the To location
     */
    public void actionsClickAndHoldAndMoveByOffset(WebElement element, int xOffset, int yOffset) {
        try {
            actions.clickAndHold(element).moveByOffset(xOffset, yOffset).release().perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to click and hold and move an element using offset using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for release using actions class
     */
    public void actionsRelease() {
        try {
            actions.release().build().perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to release using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for releasing an element using actions class
     *
     * @param element - Web element
     */
    public void actionsReleaseElement(WebElement element) {
        try {
            actions.release(element).build().perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to release an element using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for selecting multiple elements using clicking, holding and releasing using actions class
     *
     * @param elements   - List of Web element
     * @param startIndex - From index of list of values to be selected
     * @param endIndex   - To index of list of values to be selected
     */
    public void actionsMultipleClickAndHold(List<WebElement> elements, int startIndex, int endIndex) {
        try {
            for (int i = startIndex; i <= endIndex; i++) {
                actions.clickAndHold(elements.get(i)).perform();
            }
            actions.release(elements.get(endIndex)).build().perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to multiple select an element using click and hold and release using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for selecting multiple elements using keyDown, click and keyUp using actions class
     *
     * @param elements   - List of Web element
     * @param startIndex - From index of list of values to be selected
     * @param endIndex   - To index of list of values to be selected
     */
    public void actionsMultipleSelectUsingKeyDownAndKeyUp(List<WebElement> elements, int startIndex, int endIndex) {
        try {
            actions.keyDown(Keys.CONTROL).perform();
            for (int i = startIndex; i <= endIndex; i++)
                actions.click(elements.get(i)).perform();
            actions.keyUp(Keys.CONTROL).perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to multiple select an element using keyDown and keyUp using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for moving an element using drag and drop using actions class
     *
     * @param source - From location of an element where we need to drag
     * @param target - To location of an element where we need to drop
     */
    public void actionsDragAndDrop(WebElement source, WebElement target) {
        try {
            actions.dragAndDrop(source, target).build().perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to move an element using drag and drop by using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for moving an element using drag and drop by using actions class
     *
     * @param element - From location of an element where we need to drag
     * @param xOffset - Position of X axis of the To location
     * @param yOffset - Position of Y axis of the To location
     */
    public void actionsDragAndDropBy(WebElement element, int xOffset, int yOffset) {
        try {
            actions.dragAndDropBy(element, xOffset, yOffset).build().perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to move an element using drag and drop by using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for moving an element using clicking, holding, moving and releasing at the target location using actions class
     *
     * @param source - From location of a web element
     * @param target - To location of a web element
     */
    public void actionsClickAndHoldAndMoveToElement(WebElement source, WebElement target) {
        try {
            actions.clickAndHold(source)
                    .moveToElement(target)
                    .release(target)
                    .build().perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to move an element using click and hold and move to an element by using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for clicking keyboard keys using actions class
     *
     * @param keys - Exact Key board key which we need to click
     */
    public void actionsKeyDown(CharSequence keys) {
        try {
            actions.keyDown(keys).perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to click a key using keyDown by using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for releasing keyboard keys using actions class
     *
     * @param keys - Exact Key board key which we need to release
     */
    public void actionsKeyUp(CharSequence keys) {
        try {
            actions.keyUp(keys).perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to release a key using keyUp by using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for mouse hovering of an element using actions class
     *
     * @param element - Web element
     */
    public void actionsMoveToElement(WebElement element) {
        try {
            actions.moveToElement(element).build().perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to mouse hover an element by using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for moving to an element by offset using actions class
     *
     * @param element - Web element
     * @param xOffset - Position of X axis
     * @param yOffset - Position of Y axis
     */
    public void actionsMoveToElementByOffset(WebElement element, int xOffset, int yOffset) {
        try {
            actions.moveToElement(element, xOffset, yOffset).perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to move an element using move to element with offset by using actions class. " + e.getMessage());
        }
    }

    /**
     * This method is used for moving by offset using actions class
     *
     * @param xOffset - Position of X axis
     * @param yOffset - Position of Y axis
     */
    public void actionsMoveByOffset(int xOffset, int yOffset) {
        try {
            actions.moveByOffset(xOffset, yOffset).perform();
        } catch (Exception e) {
            Assert.fail("TestFailed: Unable to perform move by offset by using actions class. " + e.getMessage());
        }
    }

    //ClickAndHoldMoveByOffset == //dragAndDropBy = From,        == Resizable

    //ClickANdHoldMoveToElement == //DragAndDrop  == From, To  // (KeyDown and KeyUp)  == Droppable

    /********************************************************************** ACTIONS METHODS - END *******************************************************************/

}