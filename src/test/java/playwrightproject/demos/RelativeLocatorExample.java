package playwrightproject.demos;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Locator.LocatorOptions;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForLoadStateOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;

public class RelativeLocatorExample {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://selectorshub.com/xpath-practice-page/");
		
		page.waitForLoadState(LoadState.DOMCONTENTLOADED, new WaitForLoadStateOptions().setTimeout(10000));
		Thread.sleep(5000);
		
		page.locator("input[type='checkbox']:left-of(:text('John.Smith'))").first().waitFor(new WaitForOptions().setState(WaitForSelectorState.VISIBLE));
		page.locator("input[type='checkbox']:left-of(:text('John.Smith'))").first().waitFor();
		page.locator("input[type='checkbox']:left-of(:text('John.Smith'))").first().click();
		page.locator("input:left-of(:has-text('Inspect this element'))").first().click();
		page.locator("input:left-of(:has-text('Inspect this element'))").first().fill("First Name");
		Thread.sleep(3000);
		playwright.close();
	}

}
