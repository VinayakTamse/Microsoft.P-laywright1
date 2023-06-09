package playwrightproject.demos;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileUpload {
	
	@Test
	public void Test01() throws InterruptedException
	{
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		page.setInputFiles("input[name='filesToUpload']", Paths.get("Anim.png"));
		Thread.sleep(3000);
		page.setInputFiles("input[name='filesToUpload']", new Path[0]);
		Thread.sleep(3000);
		page.setInputFiles("input[name='filesToUpload']", new Path[] {Paths.get("Anim.png"),
				Paths.get("Anim.gif"),
				Paths.get("Test.zip")});
		Thread.sleep(3000);
		playwright.close();
	}

}
