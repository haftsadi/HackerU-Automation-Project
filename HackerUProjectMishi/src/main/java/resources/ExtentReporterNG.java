package resources;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public final class ExtentReporterNG{
	private ExtentReporterNG() {}
	
	private static ExtentReporterNG extent;
	
	public static void iniReports() {
		if(Objects.isNull(extent)) {
			
			ExtentReports extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("index.html"); //html file will be generated
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Automation Project Report");
			spark.config().setReportName("Hacker U Automation Report");
		}
			
			
		/*	ExtentTest test =extent.createTest("Registration Test").assignAuthor("Eduardo").assignCategory("Regression").assignDevice("Chrome 94"); //create a test node in the report
			test.pass("Registration Test was successfully"); //create a test step node in the report
			test.pass("Random Email generatet successfully");
			test.info("All Running");
			
			
			ExtentTest test1 =extent.createTest("Increasing Qty of Basket"); //create a test node in the report
			test1.pass("Item was added to basket"); //create a test step node in the report
			test1.pass("Basket Screen loaded propperly");
			test1.info("All Running");
			test1.fail("Gpay button is not in the Basket");*/
			
	}
		public static void endReports() throws IOException{
			if(Objects.nonNull(extent)) {
			extent.flush(); //Unless you call this method yout report will not be written with logs
			}
			Desktop.getDesktop().browse(new File("index.html").toURI());	
			
		}
		

		private void flush() {
			// TODO Auto-generated method stub
			
		}
		public static void createTest(String testcasename) {
			ExtentReporterNG.createTest(testcasename);
			
		}
		
		
		
	
}	


