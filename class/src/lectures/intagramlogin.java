package lectures;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class intagramlogin {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.instagram.com/");
		intagramlogin nexturl = new intagramlogin();
		nexturl.google(driver);
		driver.navigate().to("https://www.instagram.com/");
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("gowthamraj__");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("XXXXXXXXXXXX");
		
		
		//driver.findElement(By.cssSelector("button[type='submit']")).click();
		//driver.findElement(By.cssSelector("div#verificationCodeDescription.swB58")).getText();
		// driver.quit();
		
		intagramlogin h = new intagramlogin();
		h.google(driver);
	}

	public void google(WebDriver driver)
{
	driver.navigate().to("https://www.google.com");
}
}