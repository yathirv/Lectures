package lectures;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class webtable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/yathi/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr//th[1]")).click();

		List<WebElement> elementList = driver.findElements(By.xpath("//tbody//tr//td[1]"));
		List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));

		List<String> price;

		do {

			List<WebElement> pricelist = driver.findElements(By.xpath("//tbody//tr//td"));
			price = pricelist.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());

			price.forEach(s -> System.out.println(s));
			if (price.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		} while (price.size() < 1);

		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Apple");
		List<WebElement> veggies = driver.findElements(By.xpath("//tbody//tr//td[1]")); // 2 outout
		List<WebElement> filtered = veggies.stream().filter(veggie -> veggie.getText().contains("Apple"))
				.collect(Collectors.toList()); // exact match 1 so , error
		Assert.assertEquals(veggies.size(), filtered.size());

	}

	private static String getPriceVeggie(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
