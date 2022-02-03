package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class assignment8 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/yathi/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("united");
		Thread.sleep(3000);
		//List<WebElement> suggestions = driver.findElements(By.cssSelector(".ui-menu-item"));

		Actions mouse = new Actions(driver);
		//WebElement move = driver.findElement(By.cssSelector(".ui-menu-item-wrapper"));
		WebElement lookingFor = driver.findElement(By.xpath("//li/div[contains(text(),'United Kingdom (UK)')]"));
		mouse.moveToElement(lookingFor).click(lookingFor).build().perform();
		System.out.println(driver.findElement(By.cssSelector("#autocomplete")).getAttribute("value"));



		  /*for (WebElement lookingFor : suggestions)
		  {
			  if(lookingFor.getText().equalsIgnoreCase("United Kingdom (UK)"))
		  {
			  lookingFor.click();
			  break;
			  }
		  System.out.println(lookingFor);
		  }*/

	}
}