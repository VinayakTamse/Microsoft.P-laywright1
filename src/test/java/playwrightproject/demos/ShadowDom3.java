package playwrightproject.demos;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDom3 {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		.setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://books-pwakit.appspot.com/");
		ElementHandle shadowHost = page.querySelector("book-app[apptitle='BOOKS']");
		Frame frame = shadowHost.contentFrame();
		frame.querySelector("input#input").fill("Hello//////");
	}

}
