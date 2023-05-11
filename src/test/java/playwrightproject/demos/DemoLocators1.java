package playwrightproject.demos;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.FilterOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.BrowserChannel;
import com.microsoft.playwright.options.ScreenshotAnimations;

public class DemoLocators1 {
	
	public static void main(String[] args) throws Exception {
		
		try (Playwright playwright = Playwright.create()){
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome").setSlowMo(10));
		Page page = browser.newPage();
		page.navigate("https://phptravels.net/");
		Locator lanDropDown = page.locator("div[class$='multi_language'] ul.dropdown-menu>li");
		System.out.println(lanDropDown.count());
		System.out.println(lanDropDown.allTextContents());
		page.locator("button#languages").click();
		lanDropDown.filter(new Locator.FilterOptions().setHasText("English")).click();
		Thread.sleep(3000);
		page.locator("button#currency").click();
		page.locator("div[class$='multi_currency'] ul>li")
		.filter(new Locator.FilterOptions().setHasText("INR")).click();
		page.waitForSelector("button#languages", new WaitForSelectorOptions().setTimeout(20000));
		page.locator("button#flights-tab span:last-of-type:has-text('flights')").last().click();
		page.getByRole(AriaRole.SEARCHBOX, new Page.GetByRoleOptions().setName("Flying From")).fill("Goa");
		Thread.sleep(5000);
		page.locator("#onereturn #departure").click();
		LocalDate date = LocalDate.now();
		int Date = date.getDayOfMonth();
		System.out.println("Todays Date "+Date);
	//	page.locator("(//div[contains(@class,'datepicker-days')])[3]/descendant::tr/td[text()='"+Date+"' and @class='day ']").click();
		//(//div[contains(@class,'datepicker-days')])[1]/descendant::tr/td[text()=9 and @class='day ']
		page.click("//button[@id='ACCOUNT']");
		page.locator("//ul[@class='dropdown-menu show']/li/a")
		.filter(new Locator.FilterOptions().setHas(page.locator("'Customer Login'"))).click();
		page.screenshot(new ScreenshotOptions().setAnimations(ScreenshotAnimations.ALLOW).setPath(Paths.get("Anim.gif")));
		assert page.getByPlaceholder("Email").isVisible();
		Thread.sleep(5000);
		playwright.close();
		
		
		
		
		
		}
		
	}

}
