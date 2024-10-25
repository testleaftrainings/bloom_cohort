package Sprint_01;

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
import org.testng.annotations.Test;

public class RAJI_S1_014_EditOrder_S6_60 extends BaseClass {

	@Test
	public void editOrder() throws InterruptedException {

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
		// Step 6. Click drop down near Recently Viewed and Select All Orders
		driver.findElement(By.xpath("//button[@title='Select a List View: Orders']")).click();
		driver.findElement(By.xpath(
				"//div[@data-aura-class='uiAbstractList forceVirtualAutocompleteMenuList']//span[text()='All Draft Orders']"))
				.click();
		// Step 7. Select first result, click the dropdown of the result and click on
		// Edit
		driver.findElement(By.xpath("//table[@aria-label='All Draft Orders']/tbody/tr/th")).click();
		// driver.findElement(By.xpath("//table[@aria-label='All
		// Orders']//td//span[text()='Show Actions']")).click();
		WebElement element = driver
				.findElement(By.xpath("//table[@aria-label='All Draft Orders']//td//span[text()='Show Actions']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		// Step 8. Click on the close button form the Account Name Field and Select
		// Account name as Testing001

		WebElement clearAccountName = driver.findElement(By.xpath("(//button[@title='Clear Selection'])[2]"));
		driver.executeScript("arguments[0].click();", clearAccountName);

		WebElement AccountName = driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']"));

		AccountName.sendKeys("Testleaf Software");

		// Initialize Actions class
		Actions actions = new Actions(driver);

		// Perform double-click action
		actions.click(AccountName).perform();

		// Wait for the dropdown to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Show more results for \"Testleaf Software\"']"))); // Adjust
																														// the
																														// XPath

		// Now simulate pressing down arrow to select the first option, then press ENTER
		// Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

		WebElement IntendedAccountName = driver
				.findElement(By.xpath("//span[text()='Show more results for \"Testleaf Software\"']"));
		driver.executeScript("arguments[0].click();", IntendedAccountName);

		WebElement AccountTLS = driver.findElement(By.xpath("//table//td/a[@title='Testleaf Software']"));
		driver.executeScript("arguments[0].click();", AccountTLS);

		// Step 9. Click on the close button form theContract Number field and select
		
		WebElement clearContract = driver.findElement(By.xpath("(//button[@title='Clear Selection'])[1]"));
		driver.executeScript("arguments[0].click();", clearContract);

		WebElement ContractNumber = driver.findElement(By.xpath("//input[@placeholder='Search Contracts...']"));
		ContractNumber.sendKeys("00000133"); // Input the contract number

		// Perform double-click action
		actions.click(ContractNumber).perform();

		WebElement IntendedContract = driver
				.findElement(By.xpath("//span[text()='Show more results for \"00000133\"']"));
		driver.executeScript("arguments[0].click();", IntendedContract);

		WebElement contract129 = driver.findElement(By.xpath("//table//td/a[@title='00000133']"));
		driver.executeScript("arguments[0].click();", contract129);

		// Step 10. Click Save Expected Result: New account name and respective Contract
		driver.findElement(By.xpath("//button[@name=\"SaveEdit\"]")).click();
		System.out.println(driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText());
	}
}
