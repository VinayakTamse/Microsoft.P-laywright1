package playwrightproject.demos;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AutoLogin {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		page.locator("input[name=username]").fill("Admin");
		page.locator("input[name=password]").fill("admin123");
		page.locator("button:visible").click();
		page.locator(":text-is('Leave')").click();
		context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("auto_login.json")));
		Thread.sleep(3000);
		playwright.close();
		
	}

}
