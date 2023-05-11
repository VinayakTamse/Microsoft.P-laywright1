package playwrightproject.demos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AmazonTestWithMultiBrowsers {
	
	static Playwright playwright;
	static Browser browser;
	
	
	public static void main(String[] args) throws Exception {
		
		playwright = Playwright.create();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Browser Name");
		String value = reader.readLine();
		System.out.println("Enter Browser Type");
		String browserType = reader.readLine();
		browser = getBrowser(value, browserType);
		Page page = browser.newPage();
		page.navigate("https://www.amazon.in");
		page.click("//span[text()='Hello, sign in']");
		Thread.sleep(3000);
		playwright.close();
		
	}
	
	private static Browser getBrowser(String browsername, String browserType) throws Exception
	{
		switch (browsername)
		{
		case "chromium":
			if (browserType.equalsIgnoreCase(browserType)) {
				browser = playwright.chromium().launch(new LaunchOptions().setChannel(browserType).setHeadless(false));
			}
			else {
				throw new Exception("No Such Browser");
			}
			break;
		case "firefox":
			browser = playwright.firefox().launch(new LaunchOptions().setHeadless(false));
			break;
		case "webkit":
			browser = playwright.webkit().launch(new LaunchOptions().setHeadless(false));
			break;
			default:
				System.out.println("No Such Browser");
				playwright.close();
				break;
		}
		return browser;
	}

}
