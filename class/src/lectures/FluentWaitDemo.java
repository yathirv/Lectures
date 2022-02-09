package lectures;
import java.time.Duration;
import java.util.NoSuchElementException;

//import java.util.function.Function;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWaitDemo {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		
/*		Fluent wait finds the web element and 
 *         repeately at regular interval of time until
 *           the timeout or till the object gets found 
		
		Web driver wait continuously listen to the Dom
		   without polling */ 
		
		Wait<WebDriver> FluentWait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);

		FluentWait.until(new Function <WebDriver, WebElement> ()
		
		{

			@Override
			public WebElement apply(WebDriver driver)
			
			{

				if (driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed())

				{

					return driver.findElement(By.cssSelector("[id='finish'] h4"));

				}

				else

				{

					return null;

				}

			}

		});

		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed());
		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());

	}

}