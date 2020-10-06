package appium1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
public class Appium2 {
	static {
		System.setProperty("com.ibm.jsse2.overrideDefaultTLS","true");
	}
	public Appium2(){
		
	}
	public static void main(String[] args) throws MalformedURLException, IOException{
		
		String contactname;
	//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		/*
		 "appPackage": "com.samsung.android.contacts",
  		"appActivity": "com.android.contacts.activities.PeopleActivity",
  		"deviceName": "ad08160310171762a6",
  		"platformName": "Android",
  		"platformVersion": "8.0.0",
  		"manufacturer": "Samsung"
		 */

		caps.setCapability("deviceName","ad08160310171762a6");
		//caps.setCapability("udid", "ENUL6303030010"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "8.0.0");
		caps.setCapability("appPackage", "com.samsung.android.contacts");
		caps.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
		caps.setCapability("noReset", "false");
		
		
		//Instantiate Appium Driver
		try {
				AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
				
				//Added 5 seconds wait so that the app loads completely before starting with element identification
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// Go to contacts
				MobileElement el1 = (MobileElement) driver.findElementById("android:id/search_src_text");
				el1.click();
				el1.sendKeys("David Smit");
				MobileElement el2 = (MobileElement) driver.findElementById("com.samsung.android.contacts:id/cliv_name_textview");
				String RecordedName = el2.getText();
				System.out.println("RecordedName :"+RecordedName);
				el2.click();
				MobileElement el3 = (MobileElement) driver.findElementById("com.samsung.android.contacts:id/expand_detail_icon");
				el3.click();
				//Added 5 seconds wait so that the app loads completely before starting with element identification
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//--------------------------
				MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Edit");
				el4.click();
				MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.EditText");
				el5.sendKeys("98765");
				MobileElement el6 = (MobileElement) driver.findElementById("com.samsung.android.contacts:id/menu_done");
				el6.click();
				
			

				
				//--------------------------------

				//Added 5 seconds wait so that the app loads completely before starting with element identification
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				driver.closeApp();
 
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}

	}
}

