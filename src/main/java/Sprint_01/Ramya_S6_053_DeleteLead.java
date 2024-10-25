package Sprint_01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ramya_S6_053_DeleteLead extends BaseClass{

	@Test
	public  void deletelead() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		//Click on the toggle menu button
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		Thread.sleep(2000);
		//try {
			WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
			js.executeScript("arguments[0].click();", sales);
			//}
	//	catch(Exception e) {
			//Reporter.log("Network is Slow");
		//}
		Thread.sleep(3000);
		WebElement lead = driver.findElement(By.xpath("//a[@title='Leads']"));

		js.executeScript("arguments[0].click();", lead);

		//Search for the name 
		Thread.sleep(2000);
		WebElement search = driver.findElement(By.xpath("(//input[contains(@id,'input')])[1]"));
		search.sendKeys("test",Keys.ENTER);
		//search.sendKeys(Keys.ENTER);zzsssw``

		Thread.sleep(3000);
		//Click on the Dropdown icon and Select Delete 
		WebElement dropdown = driver.findElement(By.xpath("//span[contains(text(),'Show Actions')]"));
		js.executeScript("arguments[0].click();", dropdown);
		//System.out.println("Hello");

		//click on dropdown delete option
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		//System.out.println("2");

		//Click delete button on dialog box
		driver.findElement(By.xpath("//button[@title='Delete']")).click();

		//Getting the error message
		String errormsg = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]/span")).getText();
		System.out.println(errormsg);

		//Click the Campaign
		Thread.sleep(3000);
		WebElement campaingn = driver.findElement(By.xpath("//span[contains(text(),'Campaigns')]"));
		js.executeScript("arguments[0].click();", campaingn);
		
		//Click on bootcamp link
		WebElement bootcamp = driver.findElement(By.xpath("//a[@title='Bootcamp']"));
		js.executeScript("arguments[0].click();", bootcamp);
		System.out.println("Successfully verified the Associate Lead");



	}
}
