package Sprint_01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ramya_S6_025_CreateLegal extends BaseClass{
	@Test
	public void createlegal() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		

		//Click on the toggle menu button
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//searchbar
		WebElement search = driver.findElement(By.xpath("//input[contains(@id,'input')]"));
		search.sendKeys("Legal En");
		//search.click();
		//Clcik on Legal Entity
		Thread.sleep(2000);
		WebElement legalEn = driver.findElement(By.xpath("//a[@href='/lightning/o/LegalEntity/home']"));
		js.executeScript("arguments[0].click();", legalEn);
		//Click on New button
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		//Enter Testleaf as company name
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");
		
		//Enter Salesforce as Decription
		driver.findElement(By.xpath("//label[contains(text(),'Description')]/following::textarea")).sendKeys("Salesforce");
		
		//Clcik on Save button
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		 
		//close the dialog box
		
		WebElement dialog = driver.findElement(By.xpath("//a[@href='javascript:void(0)']"));
		dialog.click();
//		Thread.sleep(3000);
//		driver.switchTo().alert().dismiss();
		//driver.switchTo().dialo
		
		//get the text of name area
		WebElement text = driver.findElement(By.xpath("//div[contains(@id,\"help-message-\")]/following::div[text()='Complete this field.']"));
text.getText();
System.out.println(text);
System.out.println("Complete the field");
	}
}
