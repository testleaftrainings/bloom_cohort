package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RAJI_S1_014_EditOrder_S6_60 {
	
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
				driver.findElement(By.xpath("//p[text()='Service Console']")).click();
	//Step 5. Click on the drop down and select Orders
				driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
				driver.findElement(By.xpath("//a[@data-itemid='Order']")).click();
	//Step 6. Click drop down near Recently Viewed and Select All Orders
				driver.findElement(By.xpath("//button[@title='Select a List View: Orders']")).click();
				driver.findElement(By.xpath("//div[@data-aura-class=\"uiAbstractList forceVirtualAutocompleteMenuList\"]//span[text()='All Orders']")).click();
	//Step 7. Select first result, click the dropdown of the result and click on Edit
				driver.findElement(By.xpath("(//table[@aria-label='All Orders']//td[2])[1]")).click();
				//driver.findElement(By.xpath("//table[@aria-label='All Orders']//td//span[text()='Show Actions']")).click();
				WebElement element = driver.findElement(By.xpath("//table[@aria-label='All Orders']//td//span[text()='Show Actions']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

				driver.findElement(By.xpath("//a[@title='Edit']")).click();
	//Step 8. Click on the close button form the Account Name Field and Select Account name as Testing001
				
	//Step 9. Click on the close button form theContract Number field and select Contract number as 00000104
	//Step 10.Select Order Start Date as next month 10th date
	//Step 11. Click Save Expected Result: New account name and respective Contract number should be saved

}}
