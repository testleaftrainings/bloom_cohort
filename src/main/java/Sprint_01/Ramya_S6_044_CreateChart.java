package Sprint_01;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Ramya_S6_044_CreateChart extends BaseClass{
	
	@Test
	public void createRefund() throws AWTException, InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Click on the toggle menu button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		//Click view All and click Sales from App Launcher
		Thread.sleep(1000);
				driver.findElement(By.xpath("//button[text()='View All']")).click();

		//Search
//		driver.findElement(By.xpath("//input[contains(@id,'input-')]")).sendKeys("Service Con",Keys.ENTER);
//		System.out.println("0");

//Click on Service console
		Thread.sleep(2000);
		WebElement serviceconsole = driver.findElement(By.xpath("//p[text()='Service Console']"));
		js.executeScript("arguments[0].click();", serviceconsole);
		System.out.println("1");
		// Click on dropdown
		WebElement showmore = driver.findElement(By.xpath("//span[contains(text(),'Show Navigation Menu')]"));
		js.executeScript("arguments[0].click();", showmore);
		System.out.println("2");
		//Click on Refund
		driver.findElement(By.xpath("//a[@href='/lightning/o/Refund/home']")).click();
		System.out.println("3");
		
		//Clcik on New
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
	//	Clcik on any account existing
		driver.findElement(By.xpath("//span[contains(text(),'Kir')]")).click();
		
	//Select Status 
		driver.findElement(By.xpath("(//a[text()='--None--'])[1]")).click();
		
		Thread.sleep(2000);
		//select Canceled
		driver.findElement(By.xpath("//a[@title='Canceled']")).click();
		System.out.println("Status");
		
		//enter amount
		driver.findElement(By.xpath("(//span[text()='Amount']/following::input[@type=\"text\"])[2]")).sendKeys("50000");
		
		//i)Clcik on Type
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[text()='--None--'])[1]")).click();
		
		//ii)Select Referenced
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='Referenced']")).click();
		System.out.println("Type");
		
		//i) Click on processed
		WebElement processed = driver.findElement(By.xpath("(//a[text()='--None--'])[1]"));
		processed.click();
		//js.executeScript("arguments[0].click();", processed);
		
		//ii) select external
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@title='External']")).click();
		
		//click on save
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		
		//toast msg
		String taost = driver.findElement(By.xpath("//div[contains(@id,'toastDescription')]/span")).getText();
		System.out.println(taost);
		System.out.println("Refund created");
	

}

}
