package playwrightproject.demos;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class Ex01 {
	
	public static void main(String[] args) throws InterruptedException {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	      page.navigate("https://www.amazon.in/");
	     
	      page.getByPlaceholder("Search Amazon.in").click();
	      page.getByPlaceholder("Search Amazon.in").fill("Macbook pro");
	      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Go").setExact(true)).click();
	      Page page1 = page.waitForPopup(() -> {
	        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Apple 2022 MacBook Air Laptop with M2 chip: 34.46 cm (13.6-inch) Liquid Retina Display, 8GB RAM, 256GB SSD Storage, Backlit Keyboard, 1080p FaceTime HD Camera. Works with iPhone/iPad; Space Grey")).click();
	      });
	      page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Buy Now")).click();
	      Thread.sleep(5000);
	    }
	  }

}
