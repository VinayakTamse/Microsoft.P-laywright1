package playwrightproject.demos;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
public class LaunchChrome {
	
	
	
	public static void main(String[] args) {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.google.com");
		page.locator("//div[@jsname='vdLsw']/following::textarea[1]").type("Hello World");
		
		BrowserContext context2 = browser.newContext();
		Page page2 = context2.newPage();
		page2.navigate("https://www.amazon.in");
		System.out.println(page.title());
		System.out.println(page2.title());
		page.close();
		page2.close();
		context2.close();
		context.close();
		playwright.close();
		
		
	}
	

}
