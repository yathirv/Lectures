package lectures;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class recaptcha {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://www.google.com/recaptcha/api2/demo");
		driver.switchTo().frame(0);
		driver.findElement(By.id("recaptcha-anchor")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		//driver.findElement(By.cssSelector("div[id='recaptcha-verify-button']")).click();
		}
	}