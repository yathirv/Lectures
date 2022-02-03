package lectures;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class SiblingsStaticDynamic
{
	public static void main(String[] args) throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefws = new HashMap<>();
		prefws.put("profile.default_content_setting_values.notifications", "Add extension");
		options.setExperimentalOption("prefs", prefws);
		System.setProperty("webdriver.chrome.driver", "/Users/yathi/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);

		// SIBLINGS
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// from Q&A

		/*
		int url = 2;
		String i = driver.getCurrentUrl();
		switch (url)
		{
		case 1:
		i.equals("https://beta.spicejet.com/");
		driver.get("https://book.spicejet.com/");
		break;
		case 2:
		i.equals("https://www.spicejet.com/");
		break;
		}
		*/

		driver.get("https://chrome.google.com/webstore/detail/selectorshub-xpath-plugin/ndgimibanhlabgdgjcpbbndiehljcpfh");
		driver.findElement(By.cssSelector("*[class='dd-Va g-c-wb g-eg-ua-Uc-c-za g-c-Oc-td-jb-oa g-c']")).click();
		Thread.sleep(5000);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> AllCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int size = AllCheckboxes.size();
		System.out.println(size);

		/*
		for (WebElement checkboxes : AllCheckboxes)
		 {
		 checkboxes.click();
		 }
		 */

		for (int i = 0; i < size; i++)
		{
			AllCheckboxes.get(i).click();
			}
		
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]/parent::div/parent::header/div/button[2]")).getText());
		Thread.sleep(2000);
		driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
		WebElement staticdropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		System.out.println(driver.findElement(By.cssSelector("*[value='INR']")).getText());

		// STATIC

		/*
		driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).click();
		driver.findElement(By.cssSelector("*[value='INR']")).click();
		driver.findElement(By.xpath("//*[@value='USD']")).click();
		System.out.println(driver.findElement(By.cssSelector("*[value='INR']")).
		getText());
		System.out.println(driver.findElement(By.xpath("//*[@value='USD']")).getText());
		*/

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		int i;
		for (i = 0; i < 5; i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "6 Adult");
		System.out.println(("adult members " + driver.findElement(By.id("spanAudlt")).getText()));
		driver.findElement(By.id("btnclosepaxoption")).click();

		// RadioButton

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		// Assert.assertTrue(driver.findElement(By.id("Div1")).getAttribute("style").contains("opacity:0.5"))

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println("calender is enabled");
			Assert.assertTrue(true);
			}
		else
		{
			Assert.assertTrue(false);
		}
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		// DYNAMIC

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		// driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

		/*
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR']//a[@value='MAA']")).click();
		*/

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("autosuggest")).sendKeys("in");
		Thread.sleep(3000);

		//driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='BLR']")).click();
		// driver.findElement(By.linkText("India")).click();
		List<WebElement> options2 = driver.findElements(By.className("ui-corner-all"));
		// List<WebElement> options
		// =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for (WebElement option : options2)
		{
			if (option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
				}
			}
		// driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		driver.findElement(By.cssSelector("*[id*='friendsandfamily']")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("*[id*='SeniorCitizenDiscount']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("*[id*='SeniorCitizenDiscount']")).isSelected());
		
		driver.findElement(By.xpath("//*[@id='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		Assert.assertEquals(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected(),true);

		/*
		System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click(); System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		*/

		System.out.println(driver.findElements(By.cssSelector("*[type='checkbox']")).size());
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		System.out.println("you ticket is BOOKED.");
		}
	}