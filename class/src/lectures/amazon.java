package lectures;
/*
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon {

 public static void main(String[] args) {

   // Init Driver
	 System.setProperty("webdriver.chrome.driver", "/Users/ASUS/Documents/chromedriver.exe");
	WebDriver driver = new ChromeDriver();

  // Goto URL
  driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

  // Define required products and XPaths strings
  String[] neededProducts = {"Brocolli", "Cucumber", "Beetroot"};
  String sXPButtonLeft = "//h4[contains(text(),'";
  String sXPButtonRight = "')]//following-sibling::div[2]";

  // Add products to cart
  //for(String neededProduct: neededProducts)
  // driver.findElement(By.xpath(sXPButtonLeft + neededProduct + sXPButtonRight)).click();
  for (String i : neededProducts) {

	  driver.findElement(By.xpath("//h4[contains(text(),'"+i+"')]/parent::div/div[3]/button")).click();

	  System.out.println("Added: "+i);
	  }
  }
 }
*/



/*
/// Trainer
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon {

		public static void main(String[] args)
		{
		String[] products = { "Cucumber", "Mushroom", "Beans", "Water Melon" };

		System.setProperty("webdriver.chrome.driver", "/Users/ASUS/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		amazon gk = new amazon();

		gk.addCart(driver, products);

		}

		public void addCart(WebDriver driver, String[] products)
		{

		int count = 0;

		List<WebElement> productNameList = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < productNameList.size(); i++) {
		for (int j = 0; j < products.length; j++)

		if (productNameList.get(i).getText().contains(products[j].toString())) {
		count++;

		driver.findElements(By.cssSelector("div.product-action")).get(i).click();

		if (count == products.length)
			break;
	}
}
		}
}
*/


import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class amazon {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "/Users/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String[] buy = {"Cucumber","Beetroot","Brocolli"};
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		addItems(driver,buy);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		//System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		driver.findElement(By.xpath("//select/option[contains(text(),'Select')]")).click();
	}

	public static void addItems(WebDriver driver,String[] buy)
{
	List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
	int times = 0;
	for (int i = 0; i < products.size(); i++)
	{
		String []name = products.get(i).getText().split("-");
		String fname=name[0].trim();
		List<String> veggies = Arrays.asList(buy);
		String veggie = Arrays.toString(buy);
			

	if (veggies.contains(fname))
	{
		driver.findElements(By.cssSelector("div.product-action button")).get(i).click();
		//NOT driver.findElements(By.cssSelector("button[text()='ADD TO CART']")).get(i).click();
		times++;
		if (times ==(buy.length))
		{
			break;
		}
	
	}System.out.println("as list " + veggies);
	System.out.println("as string " + veggie);
	}System.out.println(buy);
	
}
	}
