package lectures;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleException {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement NameBox = driver.findElement(By.name("name"));
		
		driver.findElement(By.linkText("Shop")).click();
		driver.findElement(By.linkText("Home")).click();
		NameBox.sendKeys("hello");
		
		driver.findElement(By.cssSelector("input[name='name']:nth-child(1)")).
		sendKeys("Abium Naanum");
	}

}
