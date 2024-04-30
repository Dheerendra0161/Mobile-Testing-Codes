package webAppTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class WebAppTesting {
	public static AndroidDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "14"); // Adjust version if necessary
		desiredCapabilities.setCapability("deviceName", "Pixel 8");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");

		desiredCapabilities.setCapability("browserName", "Chrome");

		// Path to your chromedriver executable
		desiredCapabilities.setCapability("chromedriverExecutable",
				"C:\\Users\\Dheerendra\\Desktop\\Appium APK file\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		// Appium server URL
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		// Initialize AndroidDriver instance
		driver = new AndroidDriver(url, desiredCapabilities);
	}

	@Test
	public void webAppBasicTesting() {
		driver.get("https://www.amazon.in/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute']"));
		searchBox.click();
		searchBox.sendKeys("Laptops");

		WebElement submitSearch = driver.findElement(By.xpath("//input[@type='submit' and @class='nav-input']"));
		submitSearch.click();

		List<WebElement> addToCartButton = driver.findElements(By.xpath("//button[contains(text(),'Add to cart')]"));
		addToCartButton.get(0).click();

		WebElement cartButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='nav-cart-count']")));
		cartButton.click();

		WebElement proceedsToBuyButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//input[@data-feature-id='proceed-to-checkout-action']")));
		proceedsToBuyButton.click();

	}

	@AfterClass
	public void tearDown() {
		// Close the app and quit the driver
		if (driver != null) {
			driver.quit();
		}
	}
}
