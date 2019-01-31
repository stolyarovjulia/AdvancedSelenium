package tests;

import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	RemoteWebDriver driver;

	@Parameters("browser")
	@BeforeClass
	protected void setup(ITestContext testContext, String browser) throws MalformedURLException {
		if ("true".equals(System.getProperty("debug"))) {
			ChromeOptions cOptions = new ChromeOptions();
			cOptions.addArguments("disable-infobars");
			driver = new ChromeDriver(cOptions);
		} else if (browser.equalsIgnoreCase("firefox")) {
			// create firefox RemoteWebDriver instance
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setBrowserName("firefox");
			capabilities.setVersion("63.0");
			capabilities.setCapability("enableVNC", true);
			capabilities.setCapability("enableVideo", true);
			capabilities.setCapability("screenResolution", "1280x1024x24");
			driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(), capabilities);
		}
		testContext.setAttribute("WebDriver", this.driver);
		driver.get("https://www.saucedemo.com/");
		System.out.println("was 1 now is 2");
	}

	@AfterClass
	protected void tearDown() {
		driver.quit();
	}
}
