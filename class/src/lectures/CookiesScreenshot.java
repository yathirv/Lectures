package lectures;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class CookiesScreenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "/Users//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().deleteCookieNamed("asdf");

		driver.get("http://youtube.com/");
		File snap = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(snap, new File("/Users/screenshots.png"));
	}

}
