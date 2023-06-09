package playwrightproject.demos;

import java.util.List;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.FrameLocator.LocatorOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestRelativeLoc {
	
	@Test
	public void test_selectors() throws InterruptedException
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext context = browser.newContext();
		Page page = context.newPage();
		page.navigate("https://vinutamse.github.io/webpractice/");
		FrameLocator frame = page.frameLocator("iframe#partform");
		frame.locator(":text-is('Checkboxes')").click();
		frame.locator("input[type=checkbox]:left-of(:text('Eldridge Kuhn'))").first().check();
		Locator row = frame.locator("table[id=demotable] tr");
		row.locator(":scope", new Locator.LocatorOptions().setHasText("Dedrick Morissette"))
		.locator("input[type=checkbox]").check();
		List<String> data = row.locator(":scope").allTextContents();
		System.out.println(data);
		row.locator(":scope").allInnerTexts().forEach(e -> System.out.println(e));
		
		Thread.sleep(3000);
		page.close();
		context.close();
		playwright.close();
	}

}
