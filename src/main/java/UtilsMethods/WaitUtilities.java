package UtilsMethods;


	import org.openqa.selenium.*;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import java.time.Duration;


	public class WaitUtilities extends DriverManager {
	    private WebDriverWait wait;

	    /**
	     * Java Static Thread Wait
	     *
	     * @param seconds - Amount of seconds driver needs to freeze.
	     * @throws InterruptedException
	     */

	    public void setWait(int seconds) throws InterruptedException {
	        Thread.sleep(seconds * 1000L);
	    }

	    /**
	     * This method waits until page load is completed
	     * @return
	     */

	    public boolean waitUntilPageIsLoaded() {
	        boolean status;
	        do {
	            status = ((JavascriptExecutor) getDriver()).executeScript("return document.readyState").equals("complete");
	        } while (!status);
	        return true;
	    }


	    /**************************************************************** IMPLICIT WAITS - START *******************************************************************/

	    /**
	     * This method is waits before each and every element until driver quits or driver closes for our given implicit time
	     *
	     * @param time - Amount of wait time in seconds
	     */
	    public void implicitWait(int time) {
	    	int implicitWait = Integer.parseInt(FileUtilities.getProperty("src/main/resources/properties/config.properties", "ImplicitWaitSeconds"));
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		}

	    /**************************************************************** IMPLICIT WAITS - END *******************************************************************/


	    /**************************************************************** EXPLICIT WAITS - START *******************************************************************/

	    /**
	     * This method is waits until the presence of a specific element in the DOM for our given explicit time
	     *
	     * @param time    - Amount of wait time in seconds
	     * @param locator - Locator of an element
	     */
	    public boolean explicitWaitForElementPresent(By locator, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method is waits until the presence and visibility of a specific element in the DOM for our given explicit time
	     *
	     * @param time    - Amount of wait time in seconds
	     * @param locator - Locator of an element
	     */
	    public boolean explicitWaitForElementVisible(By locator, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method is waits until the presence and visibility of a specific element in the DOM for our given explicit time
	     *
	     * @param time    - Amount of wait time in seconds
	     * @param element - Web element
	     */
	    public boolean explicitWaitForElementToBeVisible(WebElement element, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.visibilityOf(element));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }

	    }

	    /**
	     * This method is waits until the specific element is present, visible and is in clickable status in the DOM for our given explicit time
	     *
	     * @param time    - Amount of wait time in seconds
	     * @param locator - Locator of an element
	     */
	    public boolean explicitWaitForElementClickable(By locator, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.elementToBeClickable(locator));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method is waits until the specific element is present, visible and is in clickable status in the DOM for our given explicit time
	     *
	     * @param time    - Amount of wait time in seconds
	     * @param element - Web element
	     */
	    public boolean explicitWaitForElementToBeClickable(WebElement element, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.elementToBeClickable(element));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method is waits until the given element is no longer attached to the DOM, indicating that it has become stale because of the page is refreshed or the DOM changes for the given explicit time
	     *
	     * @param time    - Amount of wait time in seconds
	     * @param element - Web element
	     */
	    public boolean explicitWaitForElementToBeStaled(WebElement element, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.stalenessOf(element));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until expected text is present in the element for our given explicit time
	     *
	     * @param locator      - Locator of an element
	     * @param expectedText - Expected text of an element
	     * @param time         - Amount of wait time in seconds
	     * @return
	     */
	    public boolean explicitWaitForTextPresent(By locator, String expectedText, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until expected text is present in the element for our given explicit time
	     *
	     * @param element      - Web element
	     * @param expectedText - Expected text of an element
	     * @param time         - Amount of wait time in seconds
	     * @return
	     */
	    public boolean explicitWaitForTextToBePresentInElement(WebElement element, String expectedText, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until PAGE TITLE CONTAINS expected string for our given explicit time
	     *
	     * @param title - Title of the page
	     * @param time  - Amount of wait time in seconds
	     * @return
	     */
	    public boolean explicitWaitForTitleContains(String title, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.titleContains(title));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until PAGE TITLE is EQUAL to the expected string for our given explicit time
	     *
	     * @param title - Title of the page
	     * @param time  - Amount of wait time in seconds
	     * @return
	     */
	    public boolean explicitWaitForTitleToBe(String title, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.titleIs(title));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until PAGE URL CONTAINS expected string for our given explicit time
	     *
	     * @param partialUrl - URL of the page
	     * @param time       - Amount of wait time in seconds
	     * @return
	     */
	    public boolean explicitWaitForUrlContains(String partialUrl, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.urlContains(partialUrl));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until PAGE URL is EQUAL to the expected string for our given explicit time
	     *
	     * @param url  - URL of the page
	     * @param time - Amount of wait time in seconds
	     * @return
	     */
	    public boolean explicitWaitForUrlToBe(String url, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.urlToBe(url));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until pop-up alert is present for the given explicit time
	     *
	     * @param time - Amount of wait time in seconds
	     * @return
	     */
	    public boolean explicitWaitForAlertPresent(int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.alertIsPresent());
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until frame to be available and switching inside to that frame for the given explicit time
	     *
	     * @param frameLocator - Locator of the frame
	     * @param time         - Amount of wait time in seconds
	     * @return
	     */
	    public boolean explicitWaitForFrameToBeAvailableAndSwitchToIt(By frameLocator, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until certain attribute to be present in an element in the dom for the given explicit time
	     *
	     * @param locator   - Locator of an element
	     * @param attribute - Attribute key of an element
	     * @param value     - Attribute value of an element
	     * @param time      - Amount of wait time in seconds
	     * @return
	     */
	    public boolean explicitWaitForAttributeToBe(By locator, String attribute, String value, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.attributeToBe(locator, attribute, value));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until certain attribute to be present in an element in the dom for the given explicit time
	     *
	     * @param element   - Web element
	     * @param attribute - Attribute key of an element
	     * @param value     - Attribute value of an element
	     * @param time      - Amount of wait time in seconds
	     * @return
	     */
	    public boolean explicitWaitForAttributeToBe(WebElement element, String attribute, String value, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until element to be selected for the given explicit time
	     *
	     * @param locator - Locator of an element
	     * @param time    - Amount of wait time in seconds
	     * @return
	     */
	    public boolean explicitWaitForElementToBeSelected(By locator, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.elementToBeSelected(locator));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until element to be selected for the given explicit time
	     *
	     * @param element - Web element
	     * @param time    - Amount of wait time in seconds
	     * @return
	     */
	    public boolean explicitWaitForElementToBeSelected(WebElement element, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.elementToBeSelected(element));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until the element is no longer visible on the web page for the given explicit time
	     *
	     * @param locator - Locator of an element
	     * @param time    - Amount of wait time in seconds
	     * @return
	     */
	    public boolean explicitWaitForElementToBeInvisible(By locator, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until the element is no longer visible on the web page for the given explicit time
	     *
	     * @param element - Web element
	     * @param time    - Amount of wait time in seconds
	     * @return
	     */
	    public boolean explicitWaitForElementToBeInvisible(WebElement element, int time) {
	        try {
	            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(time));
	            wait.until(ExpectedConditions.invisibilityOf(element));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }
	    /**************************************************************** EXPLICIT WAITS - END *******************************************************************/


	    /**************************************************************** FLUENT WAITS - START *******************************************************************/

	    /**
	     * This method waits until the presence and visibility of a specific element in the DOM for our given fluent time
	     *
	     * @param locator     - Locator of an element
	     * @param waitTime    - Amount of wait time in seconds
	     * @param pollingTime - The polling interval, which determines how often WebDriver should check for the visibility of the element.
	     * @return
	     */
	    public boolean fluentWaitForElementVisible(By locator, int waitTime, int pollingTime) {
	        try {
	            FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver())
	                    .withTimeout(Duration.ofSeconds(waitTime)) // Set maximum time to wait
	                    .pollingEvery(Duration.ofSeconds(pollingTime)) // Set polling interval
	                    .ignoring(NoSuchElementException.class) // Ignores NoSuchElementException while waiting for certain element
	                    .withMessage("Unable to wait until visibility of element " + locator); // Customer error message will only print if assertion or try catch is not used
	            fluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until the presence of a specific element in the DOM for our given fluent time
	     *
	     * @param locator     - Locator of an element
	     * @param waitTime    - Amount of wait time in seconds
	     * @param pollingTime - The polling interval, which determines how often WebDriver should check for the presence of the element.
	     * @return
	     */
	    public boolean fluentWaitForElementPresent(By locator, int waitTime, int pollingTime) {
	        try {
	            FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver())
	                    .withTimeout(Duration.ofSeconds(waitTime))
	                    .pollingEvery(Duration.ofSeconds(pollingTime))
	                    .ignoring(NoSuchElementException.class)
	                    .withMessage("Unable to wait until the presence of an element " + locator);
	            fluentWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method waits until the presence and visibility of a specific element in the DOM for our given fluent time
	     *
	     * @param element     - Web element
	     * @param waitTime    - Amount of wait time in seconds
	     * @param pollingTime - The polling interval, which determines how often WebDriver should check for the visibility of the element.
	     * @return
	     */
	    public boolean fluentWaitForElementVisible(WebElement element, int waitTime, int pollingTime) {
	        try {
	            FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver())
	                    .withTimeout(Duration.ofSeconds(waitTime))
	                    .pollingEvery(Duration.ofSeconds(pollingTime))
	                    .ignoring(NoSuchElementException.class)
	                    .withMessage("Unable to wait until the visibility of an element " + element);
	            fluentWait.until(ExpectedConditions.visibilityOf(element));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method is waits until the specific element is present, visible and is in clickable status in the DOM for our given fluent time
	     *
	     * @param locator     - Locator of an element
	     * @param waitTime    - Amount of wait time in seconds
	     * @param pollingTime - The polling interval, which determines how often WebDriver should check for the visibility of the element.
	     * @return
	     */
	    public boolean fluentWaitForElementClickable(By locator, int waitTime, int pollingTime) {
	        try {
	            FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver())
	                    .withTimeout(Duration.ofSeconds(waitTime))
	                    .pollingEvery(Duration.ofSeconds(pollingTime))
	                    .ignoring(NoSuchElementException.class)
	                    .withMessage("Unable to wait until the element is clickable " + locator);
	            fluentWait.until(ExpectedConditions.elementToBeClickable(locator));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**
	     * This method is waits until the specific element is present, visible and is in clickable status in the DOM for our given fluent time
	     *
	     * @param element     - Web element
	     * @param waitTime    - Amount of wait time in seconds
	     * @param pollingTime - The polling interval, which determines how often WebDriver should check for the visibility of the element.
	     * @return
	     */
	    public boolean fluentWaitForElementToBeClickable(WebElement element, int waitTime, int pollingTime) {
	        try {
	            FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver())
	                    .withTimeout(Duration.ofSeconds(waitTime))
	                    .pollingEvery(Duration.ofSeconds(pollingTime))
	                    .ignoring(NoSuchElementException.class)
	                    .withMessage("Unable to wait until the element is clickable " + element);
	            fluentWait.until(ExpectedConditions.elementToBeClickable(element));
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    /**************************************************************** FLUENT WAITS - END *******************************************************************/

	}
