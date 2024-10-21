package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RAJI_S1_012_CreateNewTask_S6_61 extends BaseClass {

 @Test
public  void createNewTask() throws InterruptedException {
		
		/*ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
				
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
	//Step 1: Login to Sales-force Application
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();*/
	
	
	//Step 2: Click on toggle menu button from the left corner
				driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

	//Step 3: Click view All from App Launcher
				driver.findElement(By.xpath("//button[text()='View All']")).click();
				
				
	//Step 4. Click on Content tab 				
				driver.findElement(By.xpath("//p[text()='Content']")).click();
				
				Thread.sleep(1000);
				
	//Step 5. Click View All from Today's Task
				driver.findElement(By.xpath("(//span[@class=\"viewAllLabel\"])[3]")).click();
				Thread.sleep(1000);
	//Step 6. Click on Show two more Action and click New Task
				driver.findElement(By.xpath("//div[@class='leftRegion']//a[@title='Show 2 more actions']")).click();
				driver.findElement(By.xpath("//a[@title='New Task']")).click();
	//Step 7. Select a Account Name in Assigned to field and set Status as In Progress
				driver.findElement(By.xpath("//input[@title='Search People']")).sendKeys(Keys.TAB,Keys.TAB,Keys.ENTER);
				driver.findElement(By.xpath("//div[@class='select-options']//a[@title='In Progress']")).click();
	//Step 8. Select a subject as Email
				driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Task.Subject']//input")).sendKeys("Email",Keys.TAB,Keys.ENTER);
	//Step 9. Click on the image of Name field, click on Contacts and select Contact
				driver.findElement(By.xpath("//a[@title='Contacts']")).click();
				driver.findElement(By.xpath("//input[@title='Search Contacts']")).click();
				driver.findElement(By.xpath("(//div[@class='listContent'])[2]//li")).click();
	//Step 10. Click on the image of Related To field, click on Product and Select Product
				driver.findElement(By.xpath("//img[@alt='Accounts']")).click();
				driver.findElement(By.xpath("//span[@title='Products']")).click();
				driver.findElement(By.xpath("//input[@title='Search Products']")).click();
				driver.findElement(By.xpath("(//div[@class=\"listContent\"])[3]//li")).click();
	//Step 11. Set Priority as High and Click on Save
				driver.findElement(By.xpath("//div[@data-target-selection-name='sfdc:RecordField.Task.Priority']//a")).click();
				driver.findElement(By.xpath("//a[@title='High']")).click();
				driver.findElement(By.xpath("//span[text()='Save']")).click();
				String ActualMsg = driver.findElement(By.xpath("//div[@role=\"alert\"]//span[@data-aura-class=\"forceActionsText\"]")).getText();
            System.out.println(ActualMsg);
            String ExpectedMsg ="Task \"Email\" was created.";
            Assert.assertEquals(ActualMsg, ExpectedMsg);
}}
