package playwrightproject.demos;

import org.testng.annotations.Test;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

import app.Chrome;

public class ShadowDom2 {

	@Test
	void TestShadowDOM() throws InterruptedException
	{
		Chrome chrome =new  Chrome();
		
		Page page = chrome.launchBrowser();
		page.navigate("https://selectorshub.com/shadow-dom-in-iframe/");
		FrameLocator iframe = page.frameLocator("//iframe[@id='pact']");
		iframe.locator("#snacktime #tea").fill("Coffee and Tea");
		iframe.locator("#app2 #pizza").fill("I want Pizza");
		FrameLocator iframe2 = page.frameLocator("#snacktime iframe[id='shadpact']");
		iframe2.locator("#opled input#college").fill("Good College");
		Thread.sleep(5000);
		page.close();
		chrome.close();
	}
	
}
