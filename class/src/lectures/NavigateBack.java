package lectures;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateBack {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","/Users/yathi/Documents/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
		driver.navigate().to("http://youtube.com");
		driver.navigate().back();

}
}
