package playwrightproject.demos;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing.StartOptions;
import com.microsoft.playwright.Tracing.StopOptions;

public class TraceViewer1 {
	
	@Test
	void Test01() throws Exception
	{
		
	try(Playwright playwright = Playwright.create()){
		Browser browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext context = browser.newContext();
		context.tracing().start(new StartOptions().setScreenshots(true)
				.setSnapshots(true)
				.setSources(true));
		Page page = context.newPage();
		page.navigate("https://www.saucedemo.com/");
		page.getByPlaceholder("Username").fill("standard_user");
		page.locator("input#password").fill("secret_sauce");
		page.locator("input[id*='login-button']").click();
		page.locator("//div[text()='Sauce Labs Fleece Jacket']").click();
		page.locator("//*[text()='Add to cart']").click();
		page.locator("//button[@name='back-to-products']").click();
		page.locator("//a[@class='shopping_cart_link']").click();
		page.locator("//button[text()='Remove']").click();
		page.locator("button#react-burger-menu-btn").click();
		page.locator("//a[text()='Logout']").click();
		Thread.sleep(3000);
		context.tracing().stop(new StopOptions().setPath(Paths.get("file.zip")));
		playwright.close();
	}
	}
}
