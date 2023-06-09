package playwrightproject.demos;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class JSPopupDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		try (Playwright playwright = Playwright.create()){
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();
			page.navigate("https://vinutamse.github.io/webpractice/");
			page.onDialog((dialog) -> {
				 System.out.println(dialog.message());
				 dialog.accept();
			});
			FrameLocator iframe = page.frameLocator("iframe#partform");
			iframe.locator("div#loginform input[placeholder='Enter Name']").fill("Vinu Tamse");
			System.out.println("Entered User Name");
			iframe.locator("div#loginform button:text-is('Login')").click();
			Thread.sleep(3000);
			iframe.locator("text='Cards'").click();
			iframe.locator("button:text-is('Create Card')").click();
			iframe.locator("input[name='cardtitle']").fill("Automation");
			iframe.locator("textarea#carddesc").fill("Selenium helps to automates browsers");
			iframe.locator("select#cardImg").selectOption("Selenium");
			iframe.locator("'Save changes'").click();
			iframe.locator("button#msgclose").click();
			Thread.sleep(5000);
			iframe.locator("button:text-is('Delete')").click();
			
			Thread.sleep(5000);
			playwright.close();
		}
		
	}

}
