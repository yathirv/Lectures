package lectures;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class locators {

	public static void main(String[] args) throws InterruptedException
	
	{
		String name = "gowtham";
		System.setProperty("webdriver.chrome.driver", "/Users/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password = getpassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
/*		Example of locators :
		id ,name , class name , link text
		css selector , xpath */
		
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello98");
		driver.findElement(By.className("signInBtn")).click();
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		System.out.println(
		driver.findElement(By.cssSelector("p.error")).getText());
		//Tagname.classname 
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("john");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("johnrsv@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("arjuntas@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("+918099268523");
		
		System.out.println(driver.findElement(By.xpath("//form/h2")).getText());
		
		//driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		driver.findElement(By.cssSelector("button[class='reset-pwd-btn']")).click();
		System.out.println(driver.findElement(By.className("infoMsg")).getText());
		
		driver.findElement(By.className("go-to-login-btn")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='inputPassword']")).sendKeys(password);
		
		Thread.sleep(1000);
		
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.className("signInBtn")).click();
		
		Thread.sleep(1000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		System.out.println(driver.findElement(By.cssSelector("h2")).getText());
		System.out.println(driver.findElement(By.xpath("//div/h2")).getText());
		System.out.println(driver.findElement(By.xpath("//div[contains(@class,'login-container')]/h2")).getText());
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		System.out.println(driver.findElement(By.className("logout-btn")).getText());
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello " + name + ",");
		driver.findElement(By.className("logout-btn")).click();
		driver.quit();
	}
		public static String getpassword (WebDriver driver) throws InterruptedException
		
		{
			
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.cssSelector("button[class='reset-pwd-btn']")).click();
		String passwordtext = driver.findElement(By.className("infoMsg")).getText();
		String[] spilttedpart = passwordtext.split("'");
		String password =  spilttedpart[1].split("'")[0];
		
		System.out.println(password);
		return password;
		}
}