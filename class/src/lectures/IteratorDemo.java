package lectures;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IteratorDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("http://rahulshettyacademy.com/loginpagePractise/#");
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();

		Set<String> newwindow = driver.getWindowHandles();
		Iterator<String> url = newwindow.iterator();
		String parentID = url.next();
		String childID = url.next();
		
		driver.switchTo().window(childID);
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		//String recoverMail = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at ")[1].trim().split(" ")[0];
		
		String[] mail = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at ");
		String[] email = mail[1].split(" with");
		String recoveryMail = email[0];
		
		driver.switchTo().window(parentID);
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys(recoveryMail);
		String password = driver.findElement(By.cssSelector("p[class='text-center text-white']")).getText().split(" Password is ")[1];
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='user']")).click();
		
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.cssSelector("div[class='modal-body'] p")).getText());
		
		driver.findElement(By.cssSelector("#okayBtn")).click();
		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.cssSelector("#signInBtn")).click();


	}

}
