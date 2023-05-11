package playwrightproject.demos;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.TextContentOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class CheckVisibility {
	
	public static void main(String[] args) {
		try (
		Playwright playwright = Playwright.create()){
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.amazon.in");
		List<String> lists = page.locator("a:visible").allInnerTexts();
		System.out.println(lists.size());
		System.out.println("=====================================================");
		List<String> lists2 = page.locator("a:visible").allTextContents();
		System.out.println(lists2.size());
		playwright.close();
		
		
		}
		
	}

}
