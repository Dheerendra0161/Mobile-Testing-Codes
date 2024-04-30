package pages;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import utilities.FakerTestData;
import utilities.LongPress;

public class DiallerPage {
	public AndroidDriver driver;
	Random random = new Random();

	public void dialPersonNumber(AndroidDriver driver) throws MalformedURLException, InterruptedException {

		String contentDesc = "key pad";
		String xpath = String.format("//android.widget.ImageButton[@content-desc=\"%s\"]", contentDesc);
		driver.findElement(By.xpath(xpath)).click();

		int requiredDigit = random.nextInt(8, 10);
		int[] array = { requiredDigit, requiredDigit };
		for (int i = 0; i < array.length; i++) {
			int digit = array[i];

			String numbersXpath = "//android.widget.TextView[@resource-id='com.google.android.dialer:id/dialpad_key_number' and @text='"
					+ digit + "']";
			// Click on the digit corresponding to the initial value
			driver.findElement(By.xpath(numbersXpath)).click();
		}

		for (int i = 0; i < 8; i++) {
			int mobileNumDigit = random.nextInt(10); // Random digit between 0 and 9

			String numbersXpath = "//android.widget.TextView[@resource-id='com.google.android.dialer:id/dialpad_key_number' and @text='"
					+ mobileNumDigit + "']";
			// Click on the randomly selected digit
			driver.findElement(By.xpath(numbersXpath)).click();
		}

	}

	public void clickOnDialCall(AndroidDriver driver) {

		WebElement dialCallButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\'dial\']"));
		dialCallButton.click();
	}

	public void modifyNumber(AndroidDriver driver) {
		// Long press to errage the number
		WebElement ele = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\'backspace\']"));
		LongPress.longpress(driver, ele);
	}

	public void clickOnTOCreateNewContact(AndroidDriver driver) throws InterruptedException {

		try {
			driver.findElement(By.xpath(
					"//android.widget.TextView[@resource-id=\'com.google.android.dialer:id/search_action_text\' and @text=\'Create new contact\']"))
					.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread.sleep(2000);
		WebElement firstName = driver.findElement(By.xpath("//android.widget.EditText[@text=\'First name\']"));
		firstName.sendKeys(FakerTestData.generateFirstName());

		Thread.sleep(2000);
		WebElement lastName = driver.findElement(By.xpath("//android.widget.EditText[@text=\'Last name\']"));
		try {
			lastName.sendKeys(FakerTestData.generateLastName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void dropdownMenuSelectTypeAndSave(AndroidDriver driver) throws InterruptedException {
		Thread.sleep(2000);

		// Find the coordinate from the Appium Inspector Tap/Swipe by Coordinate option
		int x = 155;
		int[] array = { 278, 365, 464, 566, 661, 753, 851, 946, 1041, 1140, 1235 };

		// Generate a random index within the range of the array length
		Random random = new Random();
		int randomIndex = random.nextInt(array.length);

		// Get the value at the random index
		int y = array[randomIndex];

		// Create TouchAction instance , it got deprecated now use W3C
		TouchAction touchAction = new TouchAction(driver);

		// Move finger to the element
		touchAction.tap(PointOption.point(x, y)).perform();

		Thread.sleep(5000);
		WebElement saveButton = driver.findElement(
				By.xpath("//android.widget.Button[@resource-id=\'com.google.android.contacts:id/save_button\']"));
		saveButton.click();

	}

	public void dropdownMenuSelectTypeAndSave1(AndroidDriver driver) throws InterruptedException {
		Thread.sleep(2000);

		int x = 155;
		int[] array = { 278, 365, 464, 566, 661, 753, 851, 946, 1041, 1140, 1235 };

		// Generate a random index within the range of the array length
		Random random = new Random();
		int randomIndex = random.nextInt(array.length);

		// Get the value at the random index
		int y = array[randomIndex];

		// Create Actions instance
		Actions actions = new Actions(driver);

		// Create PointerInput instance
		PointerInput pointerInput = new PointerInput(Kind.TOUCH, "finger");

		// Create Sequence for tap action
		Sequence tapSequence = new Sequence(pointerInput, y);

		// Add tap action to the sequence
		tapSequence.addAction(pointerInput.createPointerMove(Duration.ZERO, Origin.viewport(), x, y));
		tapSequence.addAction(pointerInput.createPointerDown(MouseButton.LEFT.asArg()));
		tapSequence.addAction(pointerInput.createPointerUp(MouseButton.LEFT.asArg()));

		// Add sequence to the actions chain and perform
		actions.perform();

		Thread.sleep(5000);
		WebElement saveButton = driver.findElement(
				By.xpath("//android.widget.Button[@resource-id=\'com.google.android.contacts:id/save_button\']"));
		saveButton.click();

	}

	public void clickOnDropdown(AndroidDriver driver) throws InterruptedException {
		Thread.sleep(2000);

		WebElement dropDownMenu = driver
				.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Show dropdown menu']"));
		dropDownMenu.click();
	}

	public void dropdownMenuSelectTypeAndSave2(AndroidDriver driver) throws InterruptedException {

		WebElement typeOfNumberToSave = driver.findElement(By.xpath("//*[@*=\"Pager Phone\"]"));
		typeOfNumberToSave.click();

		Thread.sleep(5000);
		WebElement saveButton = driver.findElement(
				By.xpath("//android.widget.Button[@resource-id=\'com.google.android.contacts:id/save_button\']"));
		saveButton.click();

	}

}
