package playwrightproject.demos;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.ClickOptions;
import com.microsoft.playwright.Locator.FilterOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;

public class HRMTest1 {
	
	
	@Test
	void Test01() throws InterruptedException
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome")
				.setHeadless(false).setSlowMo(20));
		BrowserContext context = browser.newContext(new NewContextOptions().setViewportSize(1920, 1080));
		context.tracing().start(new Tracing.StartOptions().setScreenshots(true)
				.setSnapshots(true)
				.setSources(true));
		Page page = context.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		page.getByPlaceholder("Username").fill("Admin");
		page.getByPlaceholder("Password").fill("admin123");
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
		Thread.sleep(5000);
		Locator adminLink = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Admin"));
		Locator lists = page.locator("ul.oxd-main-menu");
		lists.locator(adminLink).click();
		Thread.sleep(3000);
		Locator rowLoc = page.locator("div.oxd-table-card");
		Locator loc = page.getByRole(AriaRole.TABLE).filter(new FilterOptions().setHas(rowLoc));
		//System.out.println(loc.allInnerTexts());
		loc.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));
		
		Thread.sleep(3000);
		page.close();
		context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("hrm.zip")));
		context.close();
		browser.close();
		playwright.close();
		
		
	}

}
