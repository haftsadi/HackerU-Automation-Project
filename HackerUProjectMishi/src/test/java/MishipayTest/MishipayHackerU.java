package MishipayTest;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mifmif.common.regex.Generex;

import freemarker.core.StopException;
import resources.ExtentReporterNG;

public class MishipayHackerU {
 
	/*@BeforeSuite
	public void BeforeSuite() {
	ExtentReporterNG.iniReports();
		
	}
	
	@AfterSuite
	public void AfterSuite() throws IOException {
		ExtentReporterNG.endReports();
	}*/
	
	
	
	@Test
  public void Storeverification() throws InterruptedException {
	 // ExtentReporterNG.createTest("Login");
	  
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PEREZHAFTSADI\\Desktop\\SELENIUM\\WEB DRIVER\\chromedriver94.exe");
		WebDriver driver = new ChromeDriver();
		
		String mishipay = "https://test-webapp.mishipay.com/locate?r_lat=51.517278&r_long=0.13125";
		String itemId = "&item_id=4549738749493";
		driver.get(mishipay);
		
		Thread.sleep(2000);
		
		/*Maximize the screen*/
		driver.manage().window().maximize(); 
		/*Zoom Out the screen*/
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.body.style.zoom = '0.75'");


		Thread.sleep(4000);
		
		
		WebElement cachebutton= driver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/snack-bar-container/app-cookie-info/div/button"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click()", cachebutton);
		Thread.sleep(1000);
				
		String storeVerification = driver.findElement(By.xpath("/html/body/app-root/app-base/div/div[1]/app-scan/div/div[1]/store-banner/div/p")).getText();
		System.out.println(storeVerification);
		
		String mujiWelcome = "Welcome to MUJI Tottenham Court Road!";
		if (mujiWelcome.equals(storeVerification)){
			System.out.println("Store Verification Tests: Landing Store is correct!");
		}else {
			System.out.println("Store Verification Tests: Incorrect Store");
		}
		
		driver.quit();

  }
	
	
	@Test
	public void registrationTest() throws InterruptedException {
		
		//String for LoginName
		String Loginname = "HelloWorld";
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PEREZHAFTSADI\\Desktop\\SELENIUM\\WEB DRIVER\\chromedriver94.exe");
		WebDriver driver = new ChromeDriver();
		
		String mishipay = "https://test-webapp.mishipay.com/locate?r_lat=51.517278&r_long=0.13125";
		String itemId = "&item_id=4549738749493";
		driver.get(mishipay);
		
		Thread.sleep(2000);
		
		/*Maximize the screen*/
		driver.manage().window().maximize(); 
		/*Zoom Out the screen*/
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.body.style.zoom = '0.75'");


		Thread.sleep(4000);
		
		//Clicking on Cache button
		WebElement cachebutton= driver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/snack-bar-container/app-cookie-info/div/button"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click()", cachebutton);
		Thread.sleep(1000);
		
		//Clicking on Account Button
		
		WebElement accountbutton= driver.findElement(By.xpath("//*[@id=\"nav-bar\"]/div/mat-toolbar/button[2]"));
		JavascriptExecutor executor2 = (JavascriptExecutor)driver;
		executor2.executeScript("arguments[0].click()", accountbutton);
		Thread.sleep(1000);
		
		//Clicking on Signup
		WebElement signup= driver.findElement(By.xpath("/html/body/app-root/app-base/div/div[1]/app-profile/div/div[2]/div[2]/div[2]/button"));
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;
		executor3.executeScript("arguments[0].click()", signup);
		Thread.sleep(3000);
		
		//Filling FullName
		
		driver.findElement(By.id("mat-input-0")).sendKeys(Loginname);
		Thread.sleep(1000);
		
		//Generating Email
		String regex = "\\w{10}\\@gmail\\.com";
		driver.findElement(By.id("mat-input-1")).sendKeys(new Generex(regex).random());
		
		//Filling Password
		driver.findElement(By.id("mat-input-2")).sendKeys("Qwerty123.");
		
		//Clicking on Sign up button
		WebElement signupbutton= driver.findElement(By.xpath("/html/body/app-root/app-base/div/div[1]/app-signup/div/div[2]/form/button/div[1]"));
		JavascriptExecutor executor4 = (JavascriptExecutor)driver;
		executor4.executeScript("arguments[0].click()", signupbutton);
		Thread.sleep(3000);
		
		//Clicking Agree button
		
		WebElement agreebutton= driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-confirm-terms/mat-dialog-actions/button[2]/div[1]"));
		JavascriptExecutor executor5 = (JavascriptExecutor)driver;
		executor5.executeScript("arguments[0].click()", agreebutton);
		Thread.sleep(3000);
		
		//Clicking on Account Button
		
		WebElement accountbutton1= driver.findElement(By.xpath("//*[@id=\"nav-bar\"]/div/mat-toolbar/button[2]"));
		JavascriptExecutor executor6 = (JavascriptExecutor)driver;
		executor6.executeScript("arguments[0].click()", accountbutton1);
		Thread.sleep(1000);
		
		//Validating Login Name
		String validatename = driver.findElement(By.xpath("/html/body/app-root/app-base/div/div[1]/app-profile/div/div[2]/div[2]/h5")).getText();
		if (Loginname.equals(validatename)) {
			System.out.println("Registration Test: Login was successfully made");
		}else {
			System.out.println("Registration Test: Cannot Validate Login");
		}
		
		driver.quit();
	}
	
	@Test
	public void addingItemToBasket() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PEREZHAFTSADI\\Desktop\\SELENIUM\\WEB DRIVER\\chromedriver94.exe");
		WebDriver driver = new ChromeDriver();
		
		String mishipay = "https://test-webapp.mishipay.com/locate?r_lat=51.517278&r_long=0.13125";
		String itemId = "&item_id=4549738749493";
		driver.get(mishipay);
		
		Thread.sleep(2000);
		
		/*Maximize the screen*/
		driver.manage().window().maximize(); 
		/*Zoom Out the screen*/
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("document.body.style.zoom = '0.75'");


		Thread.sleep(4000);
		
		//Clicking on Cache button
		WebElement cachebutton= driver.findElement(By.xpath("//*[@id=\"cdk-overlay-0\"]/snack-bar-container/app-cookie-info/div/button"));
		JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		executor1.executeScript("arguments[0].click()", cachebutton);
		Thread.sleep(3000);
		
		Thread.sleep(5000);		
		
	}
	
	
	
}
