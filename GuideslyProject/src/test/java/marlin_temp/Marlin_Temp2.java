package marlin_temp;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Marlin_Temp2 {
	private static final int WebElement = 0;
	private static final int String = 0;
	public static WebDriver driver;
	static ExtentReports extent = new ExtentReports();
	@SuppressWarnings("unused")
	@Test
	public static void Marlin_temp_check() throws IOException, InterruptedException {

		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		ExtentTest testcase;

		System.setProperty("webdriver.chrome.driver", "D://Guidesly_imp//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.get("https://www.johnrogers-staging-nextjs.guidesly.com");
		driver.get("https://www.johnrogers-staging-nextjs.guidesly.com/");
		Thread.sleep(5000);

		//Rates
		WebElement rates = driver.findElement(By.xpath("//*[@id=\"desktop-header\"]/div/div[2]/nav/span[2]"));
		rates.click();
		Thread.sleep(8000);

		//Gallery
		WebElement gallery = driver.findElement(By.xpath("//*[@id=\'desktop-header\']/div/div[2]/nav/span[3]"));
		gallery.click();
		Thread.sleep(3500);

		//Reviews
		WebElement reviews = driver.findElement(By.xpath("//*[@id=\'desktop-header\']/div/div[2]/nav/span[4]"));
		reviews.click();
		Thread.sleep(6000);

		//FishingReports
		WebElement fishingReports = driver.findElement(By.xpath("//*[@id=\'desktop-header\']/div/div[2]/nav/span[5]"));
		fishingReports.click();
		Thread.sleep(5000);

		//TargetFish
		WebElement targetfish = driver.findElement(By.xpath("//*[@id=\'desktop-header\']/div/div[2]/nav/span[6]"));
		targetfish.click();
		Thread.sleep(5000);

		//MeetTheGuide
		WebElement meettheGuide = driver.findElement(By.xpath("//*[@id=\'desktop-header\']/div/div[2]/nav/span[7]"));
		meettheGuide.click();
		Thread.sleep(5000);

		//BookNow
		WebElement booknow = driver.findElement(By.xpath("//*[@id=\'desktop-header\']/div/div[2]/nav/button"));
		booknow.click();
		Thread.sleep(7000);

		//TripDateArrowClick
		WebElement TripDateArrowClick = driver.findElement(By.xpath("//*[@id=\"panel1bh-header\"]/div[1]/p[2]"));
		TripDateArrowClick.click();
		Thread.sleep(6000);

		//FindtheAvailableDate
		WebElement m;
		boolean y=false;
		do {
			try {
				m = driver.findElement(By.xpath("//*[contains(@class,'DayPicker-Day--availability')]"));
				m.click();
				y=true;
				break;
			} catch (Exception e) {
				System.out.println("No Available date on this month");
				y=false;
				Thread.sleep(1000);
				WebElement next = driver.findElement(By.xpath("//*[@id=\"panel1bh-content\"]/div/div[1]/div/div/div/div[1]/span[2]"));
				next.click();
			}			


		} while (y=true);

		//TripTypeArrowClick
		//WebElement TripTypeArrowClick = driver.findElement(By.xpath("//*[@id=\"panel1bh-header\"]/div[1]/p[2]"));
		//TripTypeArrowClick.click();
		//Thread.sleep(3000);

		//TripTypeclick
		WebElement TripTypeClick = driver.findElement(By.xpath("//*[@id=\"panel1bh-content\"]/div/div/label[1]/div/div/span/p"));
		TripTypeClick.click();
		Thread.sleep(4000);

		//TripTimeArrowClick
		//WebElement TripTimeArrowClick = driver.findElement(By.xpath("//*[@id=\"panel1bh-header\"]/div[1]/p[2]"));
		//TripTimeArrowClick.click();
		//Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);

		//TripTypeclick

		WebElement TripTimeClick = driver.findElement(By.xpath("//*[@id=\"panel1bh-content\"]/div/div/div/div[2]"));
		TripTimeClick.click();
		Thread.sleep(3000);

		// ContinueToBookClick
		WebElement ContinueToBookClick = driver.findElement(By.xpath("//*[@id=\"trip-summary-section\"]/div/div[5]/div[5]/button"));
		ContinueToBookClick.click();
		Thread.sleep(3000);






	}



	public static void main(String[] args) throws IOException, InterruptedException {
		Marlin_temp_check();

	}
}
