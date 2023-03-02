package tripBooking;

import java.util.Set;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import guideslyWebLogin.GuideslyWebLogin;

public class UsingSearch extends GuideslyWebLogin {


	public static void BookingUsingSearch() throws InterruptedException{

		GuideslyWebLogin.Login();

		Thread.sleep(3000);
		driver.findElement(By
				.xpath("//*[@id=\'homeView\']/div[1]/div/div/div/div[4]/button"))
		.click();
		Thread.sleep(5000);
		WebElement location = driver.findElement(By
				.xpath("//*[@id=\'search-module--Col1--Ocf5z\']/div/div/div/div/div[1]/div/div[1]/input"));
		Thread.sleep(2000);
		location.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

		location.sendKeys("Orlando,FL");
		Thread.sleep(3000);
		location.sendKeys(Keys.ENTER);
		Thread.sleep(5000);

		String oldwindow = driver.getWindowHandle();

		driver.findElement(By.id("1114")).click();
		Thread.sleep(9000);

		//windows tab switch needed
		Set<String> handles =driver.getWindowHandles();

		for (String newwindow : handles) {
			driver.switchTo().window(newwindow);

		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)", "");

		Thread.sleep(5000);
		WebElement date = driver.findElement(By.xpath("//*[@id=\'tripsummary\']/div/div/div/div[2]/div[1]/div[2]/div/div/span"));
		date.click();
		Thread.sleep(1000);



		WebElement calendarReset = driver.findElement(By.xpath("//*[@id=\'tripsummary\']/div/div/div/div[2]/div[1]/div[2]/div/div[1]/div/div[2]/div[2]/div/button[2]"));
		calendarReset.click();
		Thread.sleep(2000);
		System.out.println(calendarReset);
		
			//if (driver.findElement(By.cssSelector("div.Test)))






	}



	public static void main(String[] args) throws InterruptedException {

		BookingUsingSearch();

	}
}

