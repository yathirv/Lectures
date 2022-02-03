package lectures;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FileUpload {

	public static void main(String[] args) throws InterruptedException, IOException {

		String DownloadPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "/Users/yathi/Documents/chromedriver.exe");

		// chrome configuration
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", DownloadPath);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://altoconvertpdftojpg.com/");
		driver.findElement(By.cssSelector("[class*='btn--choose']")).click();

		Thread.sleep(3000);

		Runtime.getRuntime().exec("/Users/ASUS/Documents/file2Upload.exe");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class*='medium']")));
		
		WebElement popUp = driver.findElement(By.cssSelector("button[class='button']")); 
        int popSize = driver.findElements(By.cssSelector("[class*='popup--default']")).size();
         if(popSize > 0)
         {
          popUp.click();
         }
         
         Thread.sleep(5000);


		driver.findElement(By.cssSelector("button[class*='medium']")).click();
		Thread.sleep(30000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
		driver.findElement(By.linkText("Download")).click();

		Thread.sleep(5000);

		File f = new File(DownloadPath + "/Result.zip");
		Thread.sleep(5000);
		if (f.exists())
		{
			Assert.assertTrue(f.exists());
		if (f.delete())
			System.out.println("file deleted");

		}

	}

}
