package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class CallingPage {

	public void clickOnEndCallButton(AndroidDriver driver) {

		WebElement callButton = driver
				.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\'End call\']"));
		callButton.click();
	}

}
