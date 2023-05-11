package playwrightproject.demos;

import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.ViewportSize;

public class Demo2 {
	
	
	public static void main(String[] args) throws Exception {
		
	
		try (Playwright playwright = Playwright.create()){
		Browser browser = playwright.firefox().launch(new LaunchOptions().setHeadless(false));
		int height = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int width = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		System.out.println("Width is "+width+" and height is "+height);
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context.newPage();
		page.navigate("https://www.flipkart.com/");
		page.locator("//button[text()='✕']").click();
		
		Locator loc = page.locator("//a[text()='Login']");
		
		System.out.println(loc.innerText().concat("Hello"));
		
		Thread.sleep(5000);
		loc.click();
		
		playwright.close();
		}
		
	}

}
