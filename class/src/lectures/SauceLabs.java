package lectures;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabs {

	public static final String USERNAME = "oauth-yathirv4-7bf29";
	public static final String ACCESS_KEY = "fbe0b88b-1f8b-491f-982e-faa8e4e6ff53";
	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY
			+ "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

	public static void main(String[] args) throws MalformedURLException {

		System.setProperty("webdriver.chrome.driver", "/Users/chromedriver.exe");

		ChromeOptions browserOptions = new ChromeOptions();
		browserOptions.setPlatformName("Windows 7");
		browserOptions.setBrowserVersion("75");
		Map<String, Object> sauceOptions = new HashMap<>();
		browserOptions.setCapability("sauce:options", sauceOptions);

		WebDriver driver = new RemoteWebDriver(new URL(URL), browserOptions);
		driver.get("https://google.com");
		System.out.println(driver.getTitle());

	}

}
