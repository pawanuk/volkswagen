package StepDefinition;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
public class StepDefinition {
	WebDriver driver;
    @Given("^User is on Volkswagen vehicle checking  page$")
    public void user_is_on_volkswagen_vehicle_checking_page() throws Throwable {
    	System.out.println("User is on Volkswagen vehicle checking  page");
    	driver=new ChromeDriver();
    	driver.get("https://covercheck.vwfsinsuranceportal.co.uk/");
   
    }

    @When("^User enters vehicle number and clicks find vehicle button$")
    public void user_enters_vehicle_number_and_clicks_find_vehicle_button() throws Throwable {
    	System.out.println("User enters vehicle number and clicks find vehicle button");
    	driver.findElement(By.id("vehicleReg")).sendKeys("OV12UYY");
    	
    	WebElement clickbutton=driver.findElement(By.id("search"));
    	//WebElement clickbutton=driver.findElement(By.xpath("//a/span[contains(text(),'Find vehicle')]"));
    	clickbutton.click();
    	Thread.sleep(1000);
    	
    }

    @Then("^Vehicle insurance Start and end date displayed$")
    public void vehicle_insurance_start_and_end_date_displayed() throws Throwable {
    	System.out.println("Vehicle insurance Start and end date displayed");
    	
    String result=	driver.findElement(By.className("result")).getText();
    System.out.println(result);
    Assert.assertEquals("Result for : OV12UYY", result);
    

    driver.close();
    }

}

