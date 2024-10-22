package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RAJI_S1_004_DeleteWorkTypeGroup {
	
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
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();

		//Step 2: Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		//Step 3: Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
				
		//Step 4 : Search WorkType Groups
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Work Type Groups");
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//mark[text()='Work Type Groups']")).click();
		
		//Step 5: Search for WTG to be deleted 
			driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']")).sendKeys("Raji_WTG");
			driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']")).sendKeys(Keys.ENTER);
			
			
			WebElement element = driver.findElement(By.xpath("//div[@data-aura-class='forceVirtualAction'][1]")); // Locate your element
			Actions actions = new Actions(driver);
			
		//Step 6: Delete WTG 
			
			// Scroll into view and attempt the click
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			actions.moveToElement(element).click().perform();
			
			Thread.sleep(1000);
			WebElement DD = driver.findElement(By.xpath("//a[@title='Raji_WTG']/ancestor::tr/td[5]"));
            DD.click();
			driver.findElement(By.xpath("//a[@title='Delete']")).click();
			driver.findElement(By.xpath("//button[@title='Delete']")).click();
			Assert.assertEquals(true, driver.findElement(By.xpath("//div[@data-key='success']")).isDisplayed());


			
	}	

}