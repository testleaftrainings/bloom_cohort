package sprint1_Raji;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class S1_001_CreateAccount {
	
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
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		//Step 4: Click on Accounts tab 
		// driver.findElement(By.xpath("//a[@title='Accounts']")).click();
		WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", eleAccounts);

		//Step 5: Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();


		//Step 6: Enter 'your name' as account name
		driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]")).sendKeys("Rajalakshmi Gurusamy Ramiah");


		//Step 7: Select Ownership as Public                                       
		driver.findElement(By.xpath("//label[text()='Ownership']/following::button[1]")).click();
		
		//Step 8: Click save and verify Account name 
		driver.findElement(By.xpath("//label[text()='Description']/following::button[text()='Save']")).click();
		Thread.sleep(1000);
		String text = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]")).getText();
		System.out.println(text);
		
		//Step 9: Close the browser
		//driver.close();
		
	}

}