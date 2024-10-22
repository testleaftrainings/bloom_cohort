package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RAJI_S1_013_CreateNewOrder_S6_59 {
	
public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
				
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
	//Step 1: Login to Sales-force Application
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();
	
	
	//Step 2: Click on toggle menu button from the left corner
				driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

	//Step 3: Click view All from App Launcher
				driver.findElement(By.xpath("//button[text()='View All']")).click();
				
				
	//Step 4. Click on Service Console from App Launcher
	//Step 5. Click on the drop down and select Orders
	//Step 6. Click on New
	//Step 7. Select Account name as Testleaf Software 
	//Step 8. Contract number as 00000103
	//Step 9. Status as Draft
	//Step 10.Select Order Start Date as next month 10th date
	//Step 11. Click Save Expected Result: success - Order number was created.

}}
