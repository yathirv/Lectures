package lectures;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DateSelection {

	public static void main(String[] args)

	{
		System.setProperty("webdriver.chrome.driver", "/Users/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();

		WebElement month = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']"));

		while(!month.getText().contains("April")) //Does not contains April 
		{
			driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")). //Click on next 
			click();
		}


		List<WebElement> dates = driver.findElements(By.className("day"));  //Calendar is on April and check the date 
		int count = dates.size();
		System.out.println(count);

		for (int i= 0 ; i <count ; i++)
		{
			String text = dates.get(i).getText();
			
			if (text.equalsIgnoreCase("23"))
			{
				dates.get(i).click();
				break;
			}
		}
	} 
}           
