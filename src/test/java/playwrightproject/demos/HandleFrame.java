package playwrightproject.demos;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class HandleFrame {
	
	public static void main(String[] args) throws Exception {
		
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false).setChannel("chrome"));
		BrowserContext context = browser.newContext(new NewContextOptions().setViewportSize(1980, 720));
		context.tracing().start(new Tracing.StartOptions().setScreenshots(true)
				.setSnapshots(true)
				.setSources(true)
		);
		Page page = context.newPage();
		page.navigate("https://www.formsite.com/templates/human-resources/employment-application-form/");
		page.getByAltText("Employment Application Templates").click();
		FrameLocator iframe1 = page.frameLocator("//iframe[@id='frame-one1704441643']");
		iframe1.locator("input[id='RESULT_TextField-2']").fill("Krishna");
		iframe1.locator("//input[@name='RESULT_TextField-3']").fill("Rama");
		iframe1.locator("//input[@name='RESULT_TextField-4']").fill("Kundalahalli Colony");
		iframe1.locator("//input[@name='RESULT_TextField-6']").fill("Bangalore");
		iframe1.locator("//input[@name='RESULT_TextField-10']").fill("RamaKrishna@gmail.com");
		Thread.sleep(5000);
		context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("HandleFrame.zip")));
		context.close();
		playwright.close();
	}

}
