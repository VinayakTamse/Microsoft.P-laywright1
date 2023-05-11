package playwrightproject.demos;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class OpenCartDemoTest01 {
	
	
	@Test
	void Test01() throws Exception 
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));
		Page page = browser.newPage();
		page.navigate("https://demo.opencart.com/index.php?route=account/login");
		String value = page.locator("form#form-login strong:has-text('customer')").textContent();
		System.out.println(value);
		Locator loc = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
		System.out.println(loc.textContent());
		Thread.sleep(3000);
		playwright.close();
	}

}
