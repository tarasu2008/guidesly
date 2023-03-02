package bioPageCheck;

import java.awt.Window;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BioPageWebCheck {
	public static WebDriver driver;
	static ExtentReports extent = new ExtentReports();
	@Test
	public static void biopagewebchecking() throws IOException, InterruptedException {
		
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);
		ExtentTest testcase;
		
		System.setProperty("webdriver.chrome.driver", "D://Guidesly_imp//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://guidesly.com/?debug=true");

		String url="";
		List<WebElement> allURLs = driver
				.findElements(By.xpath("//a[contains(@href,'book-a-guide')]"));

		System.out.println("Total links on the Wb Page: " + allURLs.size());

		//We will iterate through the list and will check the elements in the list.
		Iterator<WebElement> iterator = allURLs.iterator();

		
		
		while (iterator.hasNext()) {
			String url1  = iterator.next().getAttribute("href");
			System.out.println(url1);
			if (url1!=null) {
				String oldwindow = driver.getWindowHandle();
				driver.switchTo().newWindow(WindowType.TAB);
				driver.navigate().to(url1);
				Thread.sleep(4000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)", "");
				Thread.sleep(1000);
				
				try {
				if(driver.findElement(By
						.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div[1]/div[2]/span"))!= null)  {

						if (driver.findElement(By.xpath("//*[@id=\'tripsummary\']/div/div/div/div[2]/div[1]/div[2]/div/div/span")).isDisplayed());
														
				{
					
					extent.createTest("Guide Bio URL Verification")
					  .log(Status.PASS, url1 + "Guide Bio Page is Working");
					
					System.out.println("Company Name is Present");

					} 
				}
					
					
					} catch (Exception e) {
						
							extent.createTest("Guide Bio URL Verification")
							  .log(Status.FAIL, url1 + "Guide Bio Page is NOT Working");

						System.out.println(url1 + " URL is InValid");
					}
					
				
				Set<String> newwindowhandles = driver.getWindowHandles();

				for (String allwindows : newwindowhandles) {

					if(!allwindows.equals(oldwindow)) {
						driver.switchTo().window(allwindows);
						// it will close the current window where there is the control 
						driver.close();
						driver.switchTo().window(oldwindow);

					}
				}
			}


			
		}
		extent.flush();
		
	}
	



	public static void main(String[] args) throws IOException, InterruptedException {
		biopagewebchecking();

	}

}
