package Sprint_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ramya_S6_013_CreateCase {

	public static void main(String[] args) throws InterruptedException {


		//Launching the Browser
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		JavascriptExecutor js = (JavascriptExecutor) driver;


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

		WebElement sales = driver.findElement(By.xpath("//p[text()='Sales']"));
		js.executeScript("arguments[0].click();", sales);

		//Click on Cases tab 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'More')]")).click();

		//Thread.sleep(2000);
		//driver.findElement(By.xpath("(//a[@href='/lightning/o/Case/home'])[2]")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement cases = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Cases'])[2]")));
		//cases.click();
		js.executeScript("arguments[0].click();", cases);

		//Clcik on New button
		driver.findElement(By.xpath("//a[@title='New']")).click();

		//Select status as None
		//1.Select

		driver.findElement(By.xpath("//label[text()='Status']/following::button[1]")).click();
		//2.None
		WebElement none = driver.findElement(By.xpath("//span[contains(@title,'None')]"));
		js.executeScript("arguments[0].click();", none);

		//Enter Subject as 'Testing'
		driver.findElement(By.xpath("//span[contains(text(),'Description Information')]/following::input[1]")).sendKeys("Testing");

		//Enter description as 'Automation testing'
		driver.findElement(By.xpath("//label[text()='Status']/following::textarea[1]")).sendKeys("Automation Testing");

		//Click on Save button
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();

		//Get the text from dialog box
		String error = driver.findElement(By.xpath("//div[@class='slds-media__body']/following::h2[13]")).getText();
		System.out.println(error);

	}
}

