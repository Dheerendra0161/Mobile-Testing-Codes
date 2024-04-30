package testingApps;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import capabilities.Capabilities;
import io.appium.java_client.android.AndroidDriver;
import pages.CallingPage;
import pages.DiallerPage;

public class CallingByNumber {

	DiallerPage dialNum;
	AndroidDriver driver;
	CallingPage callPerson;

	@BeforeMethod
	public void setup() throws MalformedURLException {

		driver = Capabilities.capabilities();
		dialNum = new DiallerPage();
		callPerson = new CallingPage();

	}

	@Test
	public void dialAndEndTheCall() throws MalformedURLException, InterruptedException {

		dialNum.dialPersonNumber(driver);
		dialNum.clickOnDialCall(driver);
		Thread.sleep(4000);
		callPerson.clickOnEndCallButton(driver);

	}

}
