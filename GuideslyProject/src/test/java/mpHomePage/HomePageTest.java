package mpHomePage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.percy.selenium.Percy;

public class HomePageTest {
	public static WebDriver driver;
	private static Percy percy;
	
	@Test
	public static void  Homepage() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D://Guidesly_imp//Drivers//chromedriver.exe");
		driver  = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		percy = new Percy(driver);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://guidesly-staging.web.app/");
		percy.snapshot("Marketplace Homepage");
	}
		
		public static void main(String[] args) throws IOException, InterruptedException {
			Homepage();

		}

}
