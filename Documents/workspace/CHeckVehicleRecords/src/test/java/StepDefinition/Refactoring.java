package StepDefinition;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
public class Refactoring {
	
	    public String baseUrl = "https://covercheck.vwfsinsuranceportal.co.uk/";
	   // String driverPath = "C:\\geckodriver.exe";
	    public WebDriver driver ; 
	     
	     @BeforeTest
	      public void launchBrowser() {
	          System.out.println("launching chrome browser"); 
	        //  System.setProperty("webdriver.firefox.marionette", driverPath);
	          driver = new ChromeDriver();
	          driver.get(baseUrl);
	      }
	      @Test(priority=1)
	      public void verifyHomepageTitle() {
	          String expectedTitle = "Dealer Portal";
	          String actualTitle = driver.getTitle();
	          Assert.assertEquals(actualTitle, expectedTitle);
	     }
	      @Test(priority=2)
	      public void user_enters_vehicle_number_and_clicks_find_vehicle_button() throws Throwable {
	      	System.out.println("User enters vehicle number and clicks find vehicle button");
	      	driver.findElement(By.id("vehicleReg")).sendKeys("OV12UYY");
	      	
	      	WebElement clickbutton=driver.findElement(By.id("search"));
	      
	      	clickbutton.click();
	      	Thread.sleep(5000);
	      	
	      	
	      }
	      @Test(priority=3)
	      public void vehicle_insurance_start_and_end_date_displayed() throws Throwable {
	      	System.out.println("Vehicle insurance Start and end date displayed");
	      	
	      String result=	driver.findElement(By.className("result")).getText();
	      System.out.println(result);
	      Assert.assertEquals("Result for : OV12UYY", result);
	      
	      Thread.sleep(5000);
	      
	      }
	      @AfterTest
	      public void terminateBrowser(){
	          driver.close();
	      }
	}


