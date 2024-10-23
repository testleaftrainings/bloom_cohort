package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RAJI_S1_013_CreateNewOrder_S6_59 extends BaseClass {
@Test
	public void createNewOrder() throws InterruptedException {

		/*ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		// Step 1: Login to Sales-force Application
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();*/

		// Step 2: Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		// Step 3: Click view All from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();

		// Step 4. Click on Service Console from App Launcher
		WebElement serviceconsole = driver.findElement(By.xpath("//p[text()='Service Console']"));
		driver.executeScript("arguments[0].scrollIntoView(true);", serviceconsole);
		driver.executeScript("arguments[0].click();", serviceconsole);

		// Step 5. Click on the drop down and select Orders
		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
		driver.findElement(By.xpath("//a[@data-itemid='Order']")).click();
		// Step 6. Click on New
		WebElement New = driver
				.findElement(By.xpath("//li[@data-target-selection-name='sfdc:StandardButton.Order.New']/a"));
		driver.executeScript("arguments[0].click();", New);
		
		// Step 8. Contract number as 00000133
		WebElement ContractNumber = driver.findElement(By.xpath("//input[@placeholder='Search Contracts...']"));
		ContractNumber.sendKeys("00000133"); // Input the contract number
		driver.executeScript("arguments[0].click();", ContractNumber);
		

		WebElement IntendedContract = driver
				.findElement(By.xpath("//span[text()='Show more results for \"00000133\"']"));
		driver.executeScript("arguments[0].click();", IntendedContract);

		WebElement contract129 = driver.findElement(By.xpath("//table//td/a[@title='00000133']"));
		driver.executeScript("arguments[0].click();", contract129);


		// Step 7. Select Account name as Testleaf Software
		WebElement AccountName = driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']"));
		//AccountName.sendKeys(Keys.ENTER);
		AccountName.sendKeys("Testleaf Software");
		// Initialize Actions class
		Actions actions = new Actions(driver);

		// Perform double-click action
		actions.click(AccountName).perform();
		
		//driver.executeScript("arguments[0].click();", AccountName);
		//AccountName.sendKeys(Keys.ENTER);
		
		// Wait for the dropdown to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Show more results for \"Testleaf Software\"']"))); // Adjust the XPath

		// Now simulate pressing down arrow to select the first option, then press ENTER
		//Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		
		WebElement IntendedAccountName = driver
				.findElement(By.xpath("//span[text()='Show more results for \"Testleaf Software\"']"));
		driver.executeScript("arguments[0].click();", IntendedAccountName);
		
		WebElement AccountTLS = driver.findElement(By.xpath("//table//td/a[@title='Testleaf Software']"));
		driver.executeScript("arguments[0].click();", AccountTLS);
				
		// Step 9. Status as Draft - Already Draft by default 
		
		// Step 10.Select Order Start Date as next month 10th date : 10/11/2024
		
		driver.findElement(By.xpath("//input[@name='EffectiveDate']")).click();
		driver.findElement(By.xpath("//button[@title='Next Month']")).click();
		driver.findElement(By.xpath("//span[text()='10']")).click();
		
				
		// Step 11. Click Save Expected Result: success - Order number was created.
		
		driver.findElement(By.xpath("//button[@name=\"SaveEdit\"]")).click();
		System.out.println(driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText());

	}
}
