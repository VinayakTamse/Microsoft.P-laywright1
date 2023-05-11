package playwrightproject.demos;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.FilterOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SelectorsOtherElements {
	
	public static void main(String[] args) throws InterruptedException {
		try(Playwright playwright = Playwright.create()){
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			Page page = browser.newPage();
			page.navigate("https://www.amazon.in");
			//page.pause();
			page.locator("div.navFooterLinkCol.navAccessibility:has(:text('Careers')) li").filter(new FilterOptions()
					.setHasText("Press Releases")).click();
			System.out.println(page.title());
			page.goBack();
			System.out.println(page.title());
			page.locator("span#nav-link-accountList-nav-line-1:has-text('Hello, sign in'), span#nav-link-accountList-nav-line-1:has-text('Hello, Log in')").click();
			Thread.sleep(5000);
			System.out.println(page.title());
			playwright.close();
		}
	}

}
