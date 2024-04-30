package capabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Capabilities {
	public static AndroidDriver driver;

	public static AndroidDriver capabilities() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("platformVersion", "13"); // Adjust version if necessary
		desiredCapabilities.setCapability("deviceName", "Vivo T2x");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");

		// TO get the appPackage and appActivity run certain command
		// adb devices , adb shell and dumpsys window displays | grep -E 'mCurrentFocus'
		desiredCapabilities.setCapability("appPackage", "com.google.android.dialer");
		desiredCapabilities.setCapability("appActivity",
				"com.google.android.dialer.extensions.GoogleDialtactsActivity");
		// String packageName = driver.getCurrentPackage();

		// Adjust the URL according to the Appium server's host and port
		URL url = URI.create("http://127.0.0.1:4723/wd/hub").toURL();

		driver = new AndroidDriver(url, desiredCapabilities);
		return driver;
	}
}
