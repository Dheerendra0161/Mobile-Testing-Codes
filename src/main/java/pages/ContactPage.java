package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class ContactPage {
	public void contactButton(AndroidDriver driver) {
		//Click on contact number to show the saved the number
		WebElement contactElement = driver.findElement(By.xpath(
				"//android.widget.TextView[@resource-id=\'com.google.android.dialer:id/navigation_bar_item_small_label_view\' and @text=\'Contacts\']"));

		contactElement.click();

	}
}
