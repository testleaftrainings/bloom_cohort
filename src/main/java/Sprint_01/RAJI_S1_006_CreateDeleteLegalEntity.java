package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RAJI_S1_006_CreateDeleteLegalEntity {
	
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

		//Step 2: Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		//Step 3: Click view All 
		   driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		//Step 4 : Search Cases
				//driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Cases");
				//driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(Keys.ENTER);
		        WebElement Cases = driver.findElement(By.xpath("//a[@data-label='Legal Entities']"));
		      //driver.executeScript("arguments[0].scrollIntoView(true);", Cases);
		        driver.executeScript("arguments[0].click();", Cases);
		      
		// Step 5 : Add Legal Entity 
		        driver.findElement(By.xpath("//div[@title='New']")).click();
		       	driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by RAJIGR");
				driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
				
				String CreateSuccess = driver.findElement(By.xpath("//div[contains(@id,\"toastDescription\")]")).getText();
				
				System.out.println(CreateSuccess);
				
				Thread.sleep(5000);
				
		//Step 6 : Delete Case
				
				driver.findElement(By.xpath("//ul[@class=\"slds-button-group-list\"]/li[4]")).click();
				driver.findElement(By.xpath("//span[text()='Delete']")).click();
				driver.findElement(By.xpath("//button[@title=\"Delete\"]")).click();
				
				
            String DeleteSuccess = driver.findElement(By.xpath("//div[contains(@id,\"toastDescription\")]")).getText();
				
				System.out.println(DeleteSuccess);
				
        //Step 7: Alternative by searching from List
				driver.findElement(By.xpath("//input[@name=\"LegalEntity-search-input\"]")).sendKeys("Salesforce Automation by RAJIGR");
				driver.findElement(By.xpath("//input[@name=\"LegalEntity-search-input\"]")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				WebElement actionsDD = driver.findElement(By.xpath("//a[contains(text(),\"RAJIGR\")]/ancestor::tr/td[5]"));
				driver.executeScript("arguments[0].click();", actionsDD);
				
								
				Actions actions = new Actions(driver);

		        // Use the Actions class to send the Enter key
		        actions.sendKeys(Keys.ENTER).perform();
				
				
				WebElement Delete = driver.findElement(By.xpath("//a[@title='Delete']"));
				 driver.executeScript("arguments[0].click();", Delete);
				 Thread.sleep(3000);
				 driver.findElement(By.xpath("//button[@title=\"Delete\"]")).click();
				
				 String DeleteSuccess2 = driver.findElement(By.xpath("//div[contains(@id,\"toastDescription\")]")).getText();
					
					System.out.println(DeleteSuccess2);
				
				//driver.close();*/
		
	}

}