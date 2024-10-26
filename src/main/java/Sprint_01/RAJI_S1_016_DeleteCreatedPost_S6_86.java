package Sprint_01;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RAJI_S1_016_DeleteCreatedPost_S6_86 {

	// @Test
	public static void main(String args[]) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		// Step 1: Login to Sales-force Application
		driver.manage().deleteAllCookies();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		// Step 2. Enter username as 'learners@testleaf.com' and password as 'Leaf@1234'
		// and click on the 'Login' button.
		driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();

		// Step 3. Navigate to Home - Click on the 'File'
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		WebElement fileElement = driver.findElement(By.id("publisherAttachContentPost"));
		// Assert.assertEquals(true, fileElement.isEnabled());
		Assert.assertTrue(fileElement.isEnabled());
		String File = fileElement.getText();
		System.out.println(File);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		fileElement = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[@class=' oRight']//a[@title='File']")));
		// fileElement.click();

		driver.executeScript("arguments[0].click();", fileElement);
		// Actions actions = new Actions(driver);
		// actions.moveToElement(fileElement).click().perform();

		// driver.executeScript("arguments[0].style.visibility='visible';",
		// fileElement);
		// actions.moveToElement(fileElement).click().perform();

		// Step 4. Click on 'Select a file from Sales-force'
		driver.findElement(By.xpath("//a[text()='Select a file from Salesforce']")).click();
		// Step 5. Click on 'Owned by Me'

		// Wait for the new window to open
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Switch to the new window
		
		  // Store the current window handle
        String originalWindow = driver.getWindowHandle();
        
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		// Perform actions in the new window (e.g., click a button)
		WebElement button = driver.findElement(By.xpath("//span[text()='Owned by Me']")); // Replace with the actual XPath
		button.click();

		// Step 6. Search for 'Maven'
		
		driver.findElement(By.xpath("//input[@title=\"Search Files I Own...\"]")).sendKeys("Maven",Keys.ENTER);
		// Step 7. Click on the 'Attach' for Maven file
		WebElement attachElement = driver.findElement(By.xpath("//span[text()='Attach']"));
		driver.executeScript("arguments[0].click();", attachElement);

		// Step 8. Click on the 'Share' Button
		driver.switchTo().window(originalWindow);
		WebElement Share = driver.findElement(By.xpath("//input[@id='publishersharebutton']"));
		driver.executeScript("arguments[0].click();", Share);
		
		// Step 9. Click on the 'More Actions'
		
		WebElement moreActions = driver.findElement(By.xpath("(//span[text()='More Actions'])[1]"));
		driver.executeScript("arguments[0].click();", moreActions);
		
		// Step 10. Click on the 'File Sharing Settings'
		
		WebElement FSS = driver.findElement(By.xpath("//span[text()='File Sharing Settings']"));
		driver.executeScript("arguments[0].click();", FSS);
				
		// Step 11. Change permissions as 'Collaborators'
		
		
		// Step 12. Enable the checkBox for 'Prevent others from sharing and unsharing'
		// Step 13. Verify the checkbox is Enabled
		// Step 14. Click on the 'Close' button.
		// Step 15. Click on 'Click to add topics' and enter topic as 'Maven Installtion
		// Guide' and Click on the 'Done' button.
		// Step 16. Verify the Topics as 'Maven Installtion Guide'
		// Step 17. Click on the widget dropdown for post and click 'Delete'
		// Step 18. Click on the 'Ok' Button.
		// Step 19. Verify the post is Deleted.

	}
}
