package testingApps;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import capabilities.Capabilities;
import io.appium.java_client.android.AndroidDriver;
import pages.DiallerPage;

public class CreateNewContactsTest {

	DiallerPage dialNum;
	AndroidDriver driver=null;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		
		driver = Capabilities.capabilities();
		dialNum = new DiallerPage();

	}

	@Test
	public void dialMobileNumberAndErrage() throws MalformedURLException, InterruptedException {

		dialNum.dialPersonNumber(driver);
		dialNum.clickOnTOCreateNewContact(driver);
		dialNum.clickOnDropdown(driver);
		dialNum.dropdownMenuSelectTypeAndSave2(driver);

	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

