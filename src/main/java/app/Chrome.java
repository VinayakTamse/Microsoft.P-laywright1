package app;

import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser;

public class Chrome implements Chromium {

	Playwright playwright;
	@Override
	public Page launchBrowser() {
		
		playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		return page;
		
	}
	
	public void close()
	{
		playwright.close();
		System.out.println("Closed Playwright Server");
	}

}
