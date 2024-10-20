package Sprint_01;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.sukgu.Shadow;

public class Raji_Jenkins extends BaseClass {

@Test
public void npc() throws InterruptedException {

		

		// Step 3: Click on toggle menu button from the left corner

		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		// Step 4: Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		// Step 5: Click on Campaigns
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement campaignsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//one-app-nav-bar-item-root[@data-target-selection-name=\"sfdc:TabDefinition.standard-Campaign\"]")));
		campaignsLink.click();

		// driver.findElement(By.xpath("//a[@title='Campaigns']")).click();

		// Step 6: Click Bootcamp link
		driver.findElement(By.xpath("//input[@name='Campaign-search-input']")).sendKeys("Bootcamp", Keys.ENTER);
		driver.findElement(By.xpath("//div[@data-aura-class=\"uiScroller\"]")).click();
		driver.findElement(By.xpath("//a[@title=\"Bootcamp\"]")).click();

		// Step 7: Click Add Leads

		WebElement addLeads = driver.findElement(By.xpath("//div[@title='Add Leads']"));
		driver.executeScript("arguments[0].scrollIntoView(true);", addLeads);
		addLeads.click();

		// Step 8: Click on the Search filed and click New Lead and Pick Salutation as
		// 'Mr.'
		/*
		 * driver.findElement(By.xpath("//input[@title='Search Leads']")).click();
		 * //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * //WebElement secondSearchIcon =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//input[@title='Search Leads']"))); WebElement secondSearchIcon =
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//div[@class='searchContainer']")));
		 * 
		 * secondSearchIcon.sendKeys(Keys.TAB);
		 */

		WebElement element = driver.findElement(By.xpath("//input[@title='Search Leads']"));
		System.out.println("Displayed: " + element.isDisplayed());
		System.out.println("Enabled: " + element.isEnabled());

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// WebElement element2 =
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='searchContainer']")));
		element.click();
		element.sendKeys("New ");
		Thread.sleep(1000);
		element.click();

		driver.findElement(By.xpath("(//div[@data-aura-class='forceSearchInputLookupDesktopActionItem'])[2]")).click(); // Step
																														// 9:
																														// Pick
																														// Salutation
																														// as
																														// 'Mr.'
		driver.findElement(By.xpath("//div[contains(@class,'salutation')]")).click();
		driver.findElement(By.xpath("//a[@title='Mr.']")).click();

		// Step 10: Enter first name as <your First Name>

		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Rajalakshmi");

		// Step 11: Enter last name as <your last name>

		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Gurusamy Ramiah", Keys.TAB,
				Keys.TAB, "TestLeaf");

		// Step 12: Enter company as 'TestLeaf'

		// Step 13: Click Save

		driver.findElement(By.xpath("(//button[@title='Save'])[2]")).click();
		Thread.sleep(1000);

		// Step 14: Click Next

		driver.findElement(By.xpath("(//div[@class=\"modal-footer slds-modal__footer\"]/button)[2]")).click();
		Thread.sleep(2000);

		// Step 15: Click Submit on the Add to Campaign pop up

		driver.findElement(By.xpath("(//div[@class=\"modal-footer slds-modal__footer\"]/button)[2]")).click();

		// Step 16: Verify the created Lead under Campaign

		String SuccessMessage = driver.findElement(By.xpath("//div[@class=\"toastTitle slds-text-heading--small\"]"))
				.getText();
		System.out.println(SuccessMessage);
		Thread.sleep(1000);
		// Step 17: Navigate to Leads tab

		WebElement Leads = driver.findElement(By.xpath("//a[@title='Leads']"));
		driver.executeScript("arguments[0].click();", Leads);

		// Step 18: Search for Lead with your Name
		driver.findElement(By.xpath("//input[@name=\"Lead-search-input\"]")).sendKeys("Rajalakshmi Gurusamy Ramiah",
				Keys.ENTER);
		Thread.sleep(1000);
		// Step 19: Expected Result: Lead should be created in Leads tab and associated
		// to Campaign

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Nelement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@data-aura-class='forceInlineEditCell']/a")));
		String ActualName = Nelement.getText();
		System.out.println("Element text: " + ActualName);

		// String ActualName =
		// driver.findElement(By.xpath("//span[@data-aura-class=\"forceInlineEditCell\"]/a")).getText();
		String ExpectedName = "Rajalakshmi Gurusamy Ramiah";

		Assert.assertEquals(ActualName, ExpectedName);

	}
}
