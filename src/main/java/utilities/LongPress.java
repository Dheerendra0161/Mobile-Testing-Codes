package utilities;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.android.AndroidDriver;

public class LongPress {

	public static void longpress(AndroidDriver driver, WebElement ele) {

		org.openqa.selenium.Point location = ele.getLocation();
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		Sequence longPress = new Sequence(finger, 1);
		// Add actions to the sequence: press down, move, and release
		longPress.addAction(
				finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), location.x, location.y));
		longPress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		longPress.addAction(finger.createPointerMove(Duration.ofMillis(2000), PointerInput.Origin.viewport(),
				location.x, location.y));
		longPress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// Perform the sequence
		driver.perform(Collections.singleton(longPress));
		
	}

}

