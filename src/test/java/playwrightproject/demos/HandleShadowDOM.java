package playwrightproject.demos;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class HandleShadowDOM {
	
	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		.setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://books-pwakit.appspot.com/");
		//page.locator("book-app[apptitle='BOOKS'] #input").fill("Hello Java");
		//page.locator("input[id='input']").fill("Hello Java");
		page.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Search Books")).fill("Java App Book");
		Thread.sleep(5000);
		playwright.close();
		
		
	}

}
