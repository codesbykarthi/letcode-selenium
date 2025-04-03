package UtilsMethods;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	private static WebDriver driver;

	/**
	 * This method is used to store current running browser driver and can share to all classes
	 *
	 * @return
	 */
	public static WebDriver getDriver() {
		try {
			if (driver == null) {
				String browser = FileUtilities.getProperty("src/main/resources/properties/config.properties", "browser");
				switch (browser) {
				case "chrome":
					System.setProperty("webdriver.chrome.driver", FileUtilities.getProperty("src/main/resources/properties/config.properties", "DriverPath"));
					driver = new ChromeDriver();
					break;
				default:
					System.out.println("Unsupported browser: " + browser);
					break;
				}
				if(FileUtilities.getProperty("src/main/resources/properties/config.properties", "ImplicitWaitStatus").equals("true")) {
					int implicitWait = Integer.parseInt(FileUtilities.getProperty("src/main/resources/properties/config.properties", "ImplicitWaitSeconds"));
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
				}
				driver.manage().window().maximize();
			}
			return driver;
		} catch (Exception e) {
			Assert.fail("TestFailed: Unable to initialize the driver instance" + e.getMessage());
		}
		return null;
	}

	/**
	 * This method is used to quit driver instance
	 */
	public static void quitDriver() {
		try {
			if (driver != null) {
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			Assert.fail("TestFailed: Unable to quit the driver instance" + e.getMessage());
		}
	}

}

