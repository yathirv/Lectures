package assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class assignment7 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/yathi/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		List<WebElement> rows = driver.findElements(By.cssSelector(".table-display td:nth-child(1)"));
		int totalRows = rows.size();
		System.out.println("No.of.rows :" + totalRows);

		List<WebElement> column = driver.findElements(By.cssSelector(".table-display tr:nth-child(1) th"));
		int totalColumn = column.size();
		System.out.println("No.of.column :" + totalColumn);

		List<WebElement> second = driver.findElements(By.cssSelector(".table-display tr:nth-child(3) td"));
		System.out.println("second column :");

		for (WebElement element : second) {
			 String content = element.getText();
			 System.out.println(content);
		}


	}

}
