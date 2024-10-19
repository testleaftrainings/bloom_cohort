package Sprint_01.Raji;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RAJI_S1_004_CreateWorkTypeGroup {
	
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

		//Step 3: Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
				
		//Step 4 : Search WorkType Groups
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Work Type Groups");
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//mark[text()='Work Type Groups']")).click();
		
		Thread.sleep(1000);
		
		//Step 4 : Add New WorkType Groups
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Raji_WTG");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		
		Assert.assertEquals(true, driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).isDisplayed());
	    String ActualText2 = driver.findElement(By.xpath("//span[@data-aura-class=\"forceActionsText\"]")).getText();
	    System.out.println(ActualText2);
		Assert.assertEquals("Work Type Group \"Raji_WTG\" was created.", ActualText2);
	}

}