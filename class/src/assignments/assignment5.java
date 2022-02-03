package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment5 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/yathi/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.qaclickacademy.com/practice.php");
		String i = "option2";
		driver.findElement(By.cssSelector("input[value=" + i + "]")).click();

		WebElement staticdropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByValue(i);

		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(i);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();

		/*Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		String[] spilttedText1 = alertText.split(" ");
		String spilttedText2 = spilttedText1[1];
		String text = spilttedText2.split(",")[0];*/

		System.out.println(driver.switchTo().alert().getText());
		String alert = driver.switchTo().alert().getText();
		if(alert.contains(i))
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("failure");
		}
	}

}
