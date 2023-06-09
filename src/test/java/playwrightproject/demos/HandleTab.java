package playwrightproject.demos;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleTab {
	
	
	@Test
	void handleTabTest() throws InterruptedException
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge")
				.setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://www.amazon.in/");
		page.fill("input#twotabsearchtextbox", "Mac Book");
		page.keyboard().press("Enter");
		
		Thread.sleep(3000);
		Page popUp = page.waitForPopup(() -> {
			
			page.getByAltText("Apple 2022 MacBook Air Laptop with M2 chip: 34.46 cm (13.6-inch) Liquid Retina Display, 8GB RAM, 256GB SSD Storage, Backli...")
			.first()
			.click();
			
		});
		popUp.waitForLoadState();
		popUp.locator("input#add-to-cart-button").click();
		Thread.sleep(3000);
		popUp.locator("div#nav-cart-count-container").click();
		Thread.sleep(3000);
		popUp.close();
		Thread.sleep(3000);
		playwright.close();
		
		
	}

}
