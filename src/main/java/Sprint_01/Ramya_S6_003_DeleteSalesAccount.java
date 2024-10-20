package Sprint_01;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Ramya_S6_003_DeleteSalesAccount extends BaseClass {

	@Test
	public void dsa() throws AWTException, InterruptedException {

		// Click on the toggle menu button
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		// Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		try {
			driver.findElement(By.xpath("//p[text()='Sales']")).click();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			Reporter.log("Network is Slow");
		}

		// Click on Accounts tab
		// driver.findElement(By.xpath("//a[@title='Accounts']")).click();

		WebElement accounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", accounts);

		// Search the account 'Your Name'
		try {
			WebElement accountname = driver.findElement(By.xpath("//input[@name='Account-search-input']"));
			accountname.sendKeys("Credits");
			Robot robo = new Robot();
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			// accountname.click();
		}

		catch (ElementNotInteractableException e) {
			System.out.println("Hi");
		}

		Thread.sleep(3000);
		// Click on the Dropdown icon and Select Delete
		WebElement dropdown = driver.findElement(By.xpath("//span[contains(text(),'Show Actions')]"));
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click();", dropdown);
		// System.out.println("Hello");

		// click on dropdown delete option
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		// System.out.println("2");

		// Click delete button on dialog box
		driver.findElement(By.xpath("//button[@title='Delete']")).click();

		// Getting the error message
		String errormsg = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]/span")).getText();
		System.out.println(errormsg);
	}

}
