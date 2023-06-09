package playwrightproject.demos;

import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileDownload {
	
	//https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/#downloads
	
	
	@Test
	public void Test01()
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/#downloads");
		Download download = page.waitForDownload(() -> {
			page.locator("//a[text()='x64']").first().click();
		});
		System.out.println(download.url());
		download.saveAs(Paths.get("vinu.zip"));
		//download.delete();
		System.out.println(download.path());
		playwright.close();
	}

}
