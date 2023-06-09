package playwrightproject.demos;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;

public class DemoTest01 {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.onDialog(dialog -> {
			String msg = dialog.message();
			System.out.println(msg);
			dialog.accept();
			
		});
		page.navigate("https://vinutamse.github.io/webpractice/");
		FrameLocator iframe = page.frameLocator("iframe#partform");
		iframe.locator("div#loginform input#name").first().fill("My Name is Vinayak Tamse");
		iframe.locator("div#loginform input[type=password]").fill("Abcd1234");
		iframe.locator("div#loginform button:has-text('Login')").click();
		Thread.sleep(5000);
		iframe.locator("text='Forms'").click();
		iframe.locator("input#fname").fill("Vinayak");
		iframe.locator("input#lname").fill("Tamse");
		iframe.locator("input[type='checkbox']:left-of(:text('Male'))").first().check();
		iframe.locator("button >> visible=true").click();
		iframe.locator("button:text('close')").click();
		
		
		Thread.sleep(3000);
		page.close();
		browser.close();
		playwright.close();
		
	}

}
