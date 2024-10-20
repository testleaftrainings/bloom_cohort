package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Ramya_S6_001_CreateAccount {

	public static void main(String[] args) {

		//Launching the Browser
		ChromeDriver driver = new ChromeDriver();

		//launching the salesforce URL
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		//Login page
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();

		//Click on the toggle menu button
		driver.findElement(By.xpath("//button[@title='App Launcher']")).click();

		//Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		try {
			driver.findElement(By.xpath("//p[text()='Sales']")).click();}
		catch(org.openqa.selenium.NoSuchElementException e) {
			Reporter.log("Network is Slow");
		}

		//Click on Accounts tab 
		//driver.findElement(By.xpath("//a[@title='Accounts']")).click();

		WebElement element = driver.findElement(By.xpath("//a[@title='Accounts']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

		//Click on New button
		driver.findElement(By.xpath("//a[@title='New']")).click();





	}

}


