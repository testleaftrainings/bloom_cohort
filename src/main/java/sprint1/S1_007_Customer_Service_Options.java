package sprint1;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import io.github.sukgu.Shadow;

public class S1_007_Customer_Service_Options {
	
	//@Test
	//public void createSalesforceAccount() {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
				
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Step 1: Login to Salesforce Application
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();

		//Step 2: Click on Learn More link in Mobile Publisher
		
		// Click the link to navigate to the new URL
		
		WebElement MPLearnMore = driver.findElement(By.xpath("//span[@class='slds-assistive-text' and text()=': Mobile Publisher']"));
		driver.executeScript("arguments[0].click();",MPLearnMore);
		
				
        // new page opens in a new window/tab, switch to it
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
		
        //click on confirm navigate to new page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Now, wait for a specific element to be visible on the new page and interact with it
        WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Confirm']")));
        driver.executeScript("arguments[0].click();",confirm);
		
		
		//Step 3: Click on Products and MouseHover on Service 
        
        Shadow shadow = new Shadow(driver);
        WebElement Products = shadow.findElementByXPath("//span[text()='Products']");
        Products.click();
        
        // Find the Service element with the CSS selector
        Thread.sleep(3000);
        WebElement Service = shadow.findElementByXPath("//span[text()='Service']");
             
  
        Actions actions = new Actions(driver);
        actions.moveToElement(Service).perform();
        Thread.sleep(3000);



		//Step 4 : Verify the tabs displayed in the page""    
		
		//Expected Result:	Below tabs should be displayed		Products,Company,Support & Services,Resources,COVID-19    
		
  
        
        List<String> Expected_services = Arrays.asList(
        	    "Customer Service Management", 
        	    "Field Service", 
        	    "Self-Service Experience", 
        	    "Omnichannel Customer Engagement", 
        	    "Customer Service Automation & Process", 
        	    "Intelligent Service Operations", 
        	    "Data-Driven Service", 
        	    "Customer Service AI", 
        	    "Contact Center", 
        	    "Voice & Phone Support", 
        	    "Employee Service", 
        	    "Service Cloud Pricing", 
        	    "What is Customer Service Software?", 
        	    "What are AI Agents?"
        	);

       
       
       //List<WebElement> linkElements = shadow.findElementsByXPath(".//ul[@class='c360-panel-linkedlist__listitems']//li//a");
        List<WebElement> linkElements = shadow.findElementsByXPath("//a[text()='See all service solutions']/../following-sibling::ul/li/div/a");
      
       

       List<String> Actual_Services = new ArrayList<>();

       // Check if linkElements is not empty
       if (linkElements.isEmpty()) {
           System.out.println("No link elements found inside the shadow DOM.");
       } else {
           // Iterate through the link elements and add their text to the list
           for (WebElement link : linkElements) {
        	   Actual_Services.add(link.getText()); // Add the text to the list
           }

           // Print the list of texts
           System.out.println(Actual_Services);
       }
       
    // Assert to compare the two lists
       Assert.assertEquals(Actual_Services, Expected_services, "The lists do not match!");
	}}
        
        