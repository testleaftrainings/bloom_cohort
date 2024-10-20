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
import org.testng.Assert;
import org.testng.annotations.Test;

public class RAJI_S1_002_EditAccount2_V2 {
	
	//@Test
	//public void createSalesforceAccount() {
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		//Step 1: Login to Salesforce Application
		driver.navigate().to("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com",Keys.TAB,"Leaf$321",Keys.TAB,Keys.ENTER);
		
		//Step 2: Click on toggle menu button from the left corner
		WebElement launcher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(launcher));
		launcher.click();
		WebElement viewAll = driver.findElement(By.xpath("//button[normalize-space()='View All']"));
		viewAll.click();
		
		Thread.sleep(1000);
		
		//Step 3: Click view All and click Sales from App Launcher
		driver.findElement(By.xpath("//p[text()='Sales']")).click();

		//Step 4: Click on Accounts tab 
		// driver.findElement(By.xpath("//a[@title='Accounts']")).click();
		WebElement eleAccounts = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", eleAccounts);
		
		//Step 5: Search for the Account Using the unique account name created by you
				WebElement searchAccount = driver.findElement(By.xpath("//input[@name='Account-search-input']"));
				searchAccount.sendKeys("Rajalakshmi");
				searchAccount.sendKeys(Keys.ENTER);
				Thread.sleep(3000);
		
				
				
				driver.findElement(By.xpath("//div[@class='scroller actionBarPlugin']")).click();
				
				
		driver.findElement(By.xpath("//a[normalize-space()='Rajalakshmi']/ancestor::tr/td[6]")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		
		driver.findElement(By.xpath("//input[@name='Phone']")).clear();
		
		driver.findElement(By.xpath("//input[@name='Phone']")).sendKeys("9884342881");
		
		
		//Select Type = Technology Partner
		
		WebElement Type = driver.findElement(By.xpath("//label[text()='Type']/following-sibling::div"));
		Type.click();
		//dropdown.sendKeys("Technology Partner");
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[@title='Technology Partner']")).click();
		
		//Select Industry = Healthcare 
		
		WebElement Industry = driver.findElement(By.xpath("//label[text()='Industry']/following-sibling::div"));
		driver.executeScript("arguments[0].scrollIntoView(true);", Industry);
		Industry.click();
		
		driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Healthcare']")).click();
		
		// Bill Address and Shipping Address
		
		WebElement billAddress =driver.findElement(By.xpath("(//textarea[@name='street'])[1]"));
		billAddress.sendKeys("12, St Thomas Mount",Keys.TAB,"Chennai",
				Keys.TAB,"600001",Keys.TAB,"Tamil Nadu",Keys.TAB,"India","12,Bharathiyar Street",Keys.TAB,"Chennai",
				Keys.TAB,"600001",Keys.TAB,"Tamil Nadu",Keys.TAB,"India");
		
		// Select Customer Priority as Low
		
		WebElement Cuspriority = driver.findElement(By.xpath("//button[@aria-label='Customer Priority']"));
		driver.executeScript("arguments[0].click();", Cuspriority);
		driver.findElement(By.xpath("//div[@aria-label=\"Customer Priority\"]/lightning-base-combobox-item[3]")).click();
		
		// Select SLA as High
		WebElement SLA = driver.findElement(By.xpath("//button[@aria-label='SLA']"));
		driver.executeScript("arguments[0].click();", SLA);
		driver.findElement(By.xpath("//div[@aria-label='SLA']/lightning-base-combobox-item[3]")).click();
		
		//Select Active as NO 
		WebElement Active = driver.findElement(By.xpath("//button[@aria-label='Active']"));
		driver.executeScript("arguments[0].click();", Active);
		driver.findElement(By.xpath("//div[@aria-label='Active']/lightning-base-combobox-item[2]")).click();
				
		//16)Select Upsell Oppurtunity as No
		WebElement Upsell = driver.findElement(By.xpath("//button[@aria-label='Upsell Opportunity']"));
		driver.executeScript("arguments[0].click();", Upsell);
		driver.findElement(By.xpath("//div[@aria-label='Upsell Opportunity']/lightning-base-combobox-item[3]")).click();
		
		//17)Click on save and verfiy Phone number
		WebElement save = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		driver.executeScript("arguments[0].click();", save);
		
		String num =driver.findElement(By.xpath("//tbody//tr//td[4]/span/span")).getText();
		System.out.println(num);
		Assert.assertEquals("9884342881",num);
		
	}


}