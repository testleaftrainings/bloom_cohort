package sprint1_Raji;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class S1_012_CreateNewTask_S6_61 {
	
	
public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
				
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
	//Step 1: Login to Sales-force Application
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();
	
	
	//Step 2: Click on toggle menu button from the left corner
				driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

	//Step 3: Click view All from App Launcher
				driver.findElement(By.xpath("//button[text()='View All']")).click();
				
				
	//Step 4. Click on Content tab 
	//Step 5. Click View All from Today's Task
	//Step 6. Click on Show one more Action and click New Task
	//Step 7. Select a Account Name in Assigned to field 
	//Step 8. Select a subject as Email
	//Step 9. Set Priority as High and Status as In Progress
	//Step 10. Click on the image of Name field, click on Contacts and select Contact
	//Step 11. Click on the image of Related To field, click on Product and Select Product

}}
