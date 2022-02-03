package lectures;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scope {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/Users/yathi/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://www.qaclickacademy.com/practice.php");

		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		//System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG'] //a")).size());

		WebElement column = footer.findElement(By.xpath("//tbody/tr/td[1]/ul"));
		int LinksinColumn = column.findElements(By.tagName("a")).size();
		System.out.println(LinksinColumn);
		
		for(int i=1; i<LinksinColumn; i++)
		{
			String clickonLink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			column.findElements(By.tagName("a")).get(i).sendKeys(clickonLink);
		}
			Set<String> newwindow = driver.getWindowHandles();
			Iterator<String> url = newwindow.iterator();

			while(url.hasNext())
			{
				driver.switchTo().window(url.next());
				System.out.println(driver.getTitle());
			}


		}

	}
