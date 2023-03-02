package guideslyWebLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GuideslyWebLogin {

	public static WebDriver driver;
	public static void Login() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D://Guidesly_imp//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://guidesly-staging.web.app/");


		WebElement Loginicon =  driver.findElement(By.id("desktopHam"));
		Loginicon.click();
		Thread.sleep(3000);

		WebElement LoginButton =  driver.findElement(By.xpath("//*[@id=\"gatsby-focus-wrapper\"]/div/div[1]/div/div/div[2]/div/div[5]/p[2]"));
		LoginButton.click();


		WebElement Username = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/form/div[1]/input"));
		Username.click();

		Username.sendKeys("thennarasu.dinamani@guidesly.com");

		WebElement Password = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/form/div[2]/input"));
		Password.sendKeys("Guidesly@1234");


		WebElement Submit = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/form/button"));
		Submit.click();



	}

	public static void main(String[] args) throws InterruptedException {
		Login();

	}

}
