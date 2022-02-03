package assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assignment1 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver","/Users/yathi/Documents/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.cleartrip.com/");

//calendar

		driver.findElement(By.id("DepartDate")).click();

		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active ")).click();

//DD1

		WebElement adult = driver.findElement(By.id("Adults"));

		Select s = new Select(adult);

		s.selectByIndex(2);

//DD2

		WebElement ch = driver.findElement(By.id("Childrens"));

		Select s1 = new Select(ch);

		s1.selectByIndex(2);

		driver.findElement(By.xpath("//a[@title='More search options']")).click();

		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("indigo");

		driver.findElement(By.id("SearchBtn")).click();

//validate error message

		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());

	}

}

//MYSELF

/*import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class assingment {

	public static void main(String[] args)

	{
		System.setProperty("webdriver.chrome.driver", "/Users/ASUS/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.cleartrip.com/");

		WebElement option1= driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[1]"));
		Select adults = new Select(option1);
		adults.selectByIndex(6);

		WebElement option2 =driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[2]"));
		Select children = new Select(option2);
		children.selectByValue("2");

		WebElement option3 =driver.findElement(By.xpath("(//select[@class='bc-neutral-100 bg-transparent'])[2]"));
		Select Infants = new Select(option3);
		Infants.selectByIndex(2);

		driver.findElement(By.cssSelector("button[class='flex flex-middle flex-between t-all fs-2 focus:bc-secondary-500 bg-transparent bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 c-neutral-900']")).click();
		driver.findElement(By.cssSelector("div[aria-label='Fri Nov 12 2021']")).click();

		driver.findElement(By.cssSelector("a[class='td-none hover:td-underline px-4 mt-1 weak']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Airline name']")).sendKeys("indigo");
		driver.findElement(By.cssSelector("button[class='px-7 bg-primary-500 hover:bg-primary-600 c-white bc-transparent c-pointer w-100p py-2 px-5 h-10 fs-4 fw-600 t-all button bs-solid tp-color td-500 bw-1 br-4 lh-solid box-border']")).click();
		System.out.println(driver.findElement(By.xpath("//span[@class='to-ellipsis o-hidden ws-nowrap fs-3 c-white']")).getText());

	}

}*/


//////       ST1      ///////////

/*
Driver.get("https://www.cleartrip.com/");

Thread.sleep(5000);

//Selecting current date from calendar

Driver.findElement(By.xpath("//div[contains(@class,'homeCalender')]")).click();

Thread.sleep(3000);

Driver.findElement(By.xpath("//div[contains(@class,'Day--selected')][@aria-selected='true']")).click();

//Selecting Drop down values

WebElement StaticDropdown1 = Driver.findElement(By.xpath("//h4[text()='Adults']//following-sibling::select"));

WebElement StaticDropdown2 = Driver.findElement(By.xpath("//h4[text()='Children']//following-sibling::select"));

WebElement StaticDropdown3 = Driver.findElement(By.xpath("//h4[text()='Infants']//following-sibling::select"));

Select Dropdown1 = new Select(StaticDropdown1);

Select Dropdown2 = new Select(StaticDropdown2);

Select Dropdown3 = new Select(StaticDropdown3);

Dropdown1.selectByValue("5");

Dropdown2.selectByValue("2");

Dropdown3.selectByValue("0");

//Clicking on link

Driver.findElement(By.xpath("//a[contains(text(),'Class of travel, Airline preference')]")).click();

Thread.sleep(3000);

Driver.findElement(By.xpath("//input[@placeholder='Airline name']")).sendKeys("Indigo");

Thread.sleep(5000);

//Clicking on Search button

Driver.findElement(By.xpath("//button[text()='Search flights']")).click();

//Expected Error message

String ErrorMessage = Driver.findElement(By.xpath("(//div[contains(@class,'error')])[3]")).getText();

System.out.println(ErrorMessage);
*/

//////    ST2     ///////////

/*
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

public class Assigment2 {

	public static void main(String[] args) throws InterruptedException {

// Create Web Driver and Maximize screen

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ALIENWARE\\Documents\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

// Select URL

		driver.get("https://www.cleartrip.com/");

// Select Round trip

		driver.findElement(By.xpath("//label[2]/div[1]/span")).click();

// select depart Date

		driver.findElement(By.xpath("//div[@class='flex flex-middle p-relative homeCalender']/button")).click();

		driver.findElement(

				By.cssSelector(".DayPicker-Day.DayPicker-Day--start.DayPicker-Day--selected.DayPicker-Day--today"))

				.click();

		driver.findElement(

				By.cssSelector(".DayPicker-Day.DayPicker-Day--start.DayPicker-Day--selected.DayPicker-Day--today"))

				.click();

// Select return date

		driver.findElement(By.xpath("//div[@class='flex flex-middle p-relative homeCalender']/button[2]")).click();

		driver.findElement(By.xpath("//div[text()='25']")).click();

// Select tickets

		driver.findElement(By.xpath("//h4[text()='Adults']/following-sibling::select")).click();

		driver.findElement(By.xpath("//h4[text()='Adults']/following-sibling::select/option[5]")).click();

		driver.findElement(By.xpath("//h4[text()='Children']/following-sibling::select")).click();

		driver.findElement(By.xpath("//h4[text()='Children']/following-sibling::select/option[3]")).click();

// More options

		driver.findElement(By.xpath("//a[@class='td-none hover:td-underline px-4 mt-1 weak']")).click();

		driver.findElement(By.xpath("//div[@class='row p-relative px-4 mb-4']/div/div/div/div/div/input")).click();

		driver.findElement(By.xpath("//div[@class='row p-relative px-4 mb-4']/div/div/div/div/div/input"))

				.sendKeys("Indig");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='bg-white br-4 elevation-5 p-1 p-absolute mt-1 z-50 l-0']")).click();

		Thread.sleep(1000);

// Search flight

		driver.findElement(By.xpath("//div[@class='col flex flex-middle']/button")).click();

//get text from error

		System.out.println(driver
				.findElement(By.xpath("//div/span[text()='Select Departure and Arrival airports/cities.']")).getText());

//close tab

		driver.close();

	}

}

*/