package playwrightproject.demos;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.MouseButton;

public class ShadowDomIframe {
	
	@Test
	public void testShadowDom() throws Exception 
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		.setChannel("msedge").setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://selectorshub.com/iframe-in-shadow-dom/");
		page.locator("div#userName input#kils").fill("Jai Hanuman");
		System.out.println("Iframes : "+page.frames());
		FrameLocator frame1 = page.frameLocator("div#userName iframe[id='pact1']");
		frame1.locator("//input[@id='glaf']").fill("Good Good");
		frame1.locator("button:has-text('Close it')").click(new ClickOptions().setButton(MouseButton.RIGHT));
		
		page.locator("div#userName div#app2 input#pizza").fill("I Want Pizza");
		page.mouse().wheel(300, 100);
		Thread.sleep(5000);
		playwright.close();
	}

}
