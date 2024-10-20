package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ramya_S6_008_CreateWorkType {


	public static void main(String[] args) throws InterruptedException {

		//Launching the Browser
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);

		//launching the salesforce URL
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		//Login page
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();

		//Click on the toggle menu button
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//searchbar
		WebElement search = driver.findElement(By.xpath("//input[contains(@id,'input')]"));
		search.sendKeys("Type Gr");
		search.click();

		//Click on the Dropdown icon in the Work Type Groups tab
		driver.findElement(By.xpath("//p[contains(text(),'Work')]")).click();


		//Click on New Work Type Group
		driver.findElement(By.xpath("//a[@title='New']")).click();

		//Enter Description as 'Automation'.
		//Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//textarea[contains(@id,'input')]"));
		element.sendKeys("Automation");
		System.out.println(element.getAttribute("textContent"));
		
		//Select Group Type as 'Capacity'
				//1.Group Type
				Thread.sleep(3000);

				


				WebElement grouptype_search = driver.findElement(By.xpath("//span[text()='Default']"));
				try {
					grouptype_search.click();
				} catch (Exception e) {
					driver.executeScript("arguments[0].click();", grouptype_search);
					//grouptype_search.click();


				}
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@title='Capacity']")).click();
				
				//Click on save
				WebElement save = driver.findElement(By.xpath("//label[contains(text(),'W')]/following::button[7]"));
				save.click();
				//verify the alert message
				String errormsg = driver.findElement(By.xpath("//h2[@class='slds-truncate slds-text-heading_medium']")).getText();
	System.out.println(errormsg);
	
	//Closing the error message
	driver.findElement(By.xpath("//button[@title='Close error dialog']")).click();
	
	//Entering the mandatory values
	WebElement workername = driver.findElement(By.xpath("//label[contains(text(),'W')]/following::input[1]"));
	workername.sendKeys("ramya");
	Thread.sleep(3000);
	save.click();
	}
	

	}
