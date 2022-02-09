package lectures;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frametest { // Drag and drop 

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://jqueryui.com/");
		driver.findElement(By.linkText("Droppable")).click();
		System.out.println(driver.findElements(By.tagName("iframe")).size());
	
		driver.switchTo().frame(0);
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		driver.findElement(By.cssSelector("div[id='draggable']")).click();
		
		
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.cssSelector("div[id='draggable']"));
		WebElement target = driver.findElement(By.cssSelector("div[id='droppable']"));
		a.dragAndDrop(source,target).build().perform();
		driver.switchTo().defaultContent();

	}

}
