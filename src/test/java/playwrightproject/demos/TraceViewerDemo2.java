package playwrightproject.demos;

import java.nio.file.Paths;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing.StartOptions;
import com.microsoft.playwright.Tracing.StopOptions;

public class TraceViewerDemo2 {
	
	
	Playwright playwright;
	Browser browser;
	BrowserContext context;
	
	@BeforeTest
	public void setUp()
	{
		playwright = Playwright.create();
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(5));
		context = browser.newContext();
		context.tracing().start(new StartOptions()
				.setScreenshots(true)
				.setSnapshots(true)
				.setSources(true));
	}
	
	@Test
	public void TestTraceViewerFeature()
	{
		Page page = context.newPage();
		page.navigate("https://demoqa.com/books");
		page.locator("input#searchBox").fill("Programming JavaScript Applications");
		page.click("//a[text()='Programming JavaScript Applications']");
		

	}
	
	@AfterTest
	public void tearDown()
	{
		context.tracing().stop(new StopOptions().setPath(Paths.get("Test1.zip")));
		context.close();
		playwright.close();
	}
	

}
