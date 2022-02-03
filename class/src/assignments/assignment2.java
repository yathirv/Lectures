package assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class assignment2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/yathi/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr//th[1]")).click();

		List<WebElement> ElementList = driver.findElements(By.xpath("//tbody//tr//td[1]"));
		List<String> originalList = new ArrayList<>();

		for (WebElement item : ElementList)
		originalList.add(item.getText());
		originalList.stream().sorted().collect(Collectors.toList()).forEach(s -> System.out.println(s));

		List<String> list = Stream.of("Almond", "Apple", "Banana", "Beans", "Brinjal").collect(Collectors.toList());
		Assert.assertEquals(originalList, list);

		///////////////////////

		WebElement input = driver.findElement(By.xpath("//input[@id='search-field']"));
		input.sendKeys("Potato");
		String h = input.getAttribute("value");
		WebElement match = driver.findElement(By.xpath("//tbody//tr//td[1]"));
		String k = match.getText();

		Assert.assertEquals(h , k );
	}

}
