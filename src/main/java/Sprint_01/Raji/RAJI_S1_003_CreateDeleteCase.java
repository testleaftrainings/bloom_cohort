package Sprint_01.Raji;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class RAJI_S1_003_CreateDeleteCase {
	
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
		        WebElement Cases = driver.findElement(By.xpath("//p[text()='Cases']"));
		      //driver.executeScript("arguments[0].scrollIntoView(true);", Cases);
		        driver.executeScript("arguments[0].click();", Cases);
		        
		// Step 5 : Add Case 
		        driver.findElement(By.xpath("//div[@title='New']")).click();
		        driver.findElement(By.xpath("//button[@aria-label=\"Case Origin\"]")).click();
		        driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value=\"Email\"]")).click();
				driver.findElement(By.xpath("//input[@name='Subject']")).sendKeys("CaseByRaji");
				driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
				
				String CreateSuccess = driver.findElement(By.xpath("//div[contains(@id,\"toastDescription\")]")).getText();
				
				System.out.println(CreateSuccess);
				
				Thread.sleep(5000);
				
		//Step 6 : Delete Case
				
				driver.findElement(By.xpath("//button[@name='Delete']")).click();
				driver.findElement(By.xpath("//span[text()='Delete']")).click();
				
            String DeleteSuccess = driver.findElement(By.xpath("//div[contains(@id,\"toastDescription\")]")).getText();
				
				System.out.println(DeleteSuccess);
				
        //Step 7: Alternative by searching from List
				driver.findElement(By.xpath("//input[@name=\"Case-search-input\"]")).sendKeys("CaseByRaji");
				driver.findElement(By.xpath("//input[@name=\"Case-search-input\"]")).sendKeys(Keys.ENTER);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@data-aura-class=\"forceVirtualAction\"]")).click();
				Thread.sleep(3000);
				WebElement Delete = driver.findElement(By.xpath("//a[@title='Delete']"));
				 driver.executeScript("arguments[0].click();", Delete);
				 driver.findElement(By.xpath("//button[@title=\"Delete\"]")).click();
				
				 String DeleteSuccess2 = driver.findElement(By.xpath("//div[contains(@id,\"toastDescription\")]")).getText();
					
					System.out.println(DeleteSuccess2);
				
				//driver.close();
		
	}

}