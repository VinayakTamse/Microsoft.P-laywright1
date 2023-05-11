package playwrightproject.demos;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demo1 {
	
	
	public static void main(String[] args) {
		try {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setSlowMo(50));
		Page page = browser.newPage();
		page.navigate("https://www.amazon.in/");
		System.out.print(page.title());
		playwright.close();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		
		
	}

}
