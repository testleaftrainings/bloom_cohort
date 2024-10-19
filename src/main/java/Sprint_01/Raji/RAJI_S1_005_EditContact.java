package Sprint_01.Raji;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class RAJI_S1_005_EditContact {
	
public static void main(String[] args) throws InterruptedException {
	    String UniqueName = null;
	    String PhoneNumber = "9884342881";
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
				
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		//Step 1: Login to Salesforce Application
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$321");
		driver.findElement(By.id("Login")).click();

		//Step 2: Click on toggle menu button from the left corner
		driver.findElement(By.xpath("//button[@title='App Launcher']/div[1]")).click();

		//Step 3: Click view All 
		   driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		   Thread.sleep(3000);
		//Step 4 : Click on contacts under 'All Items'
		   
		   WebElement Contacts = driver.findElement(By.xpath("//p[text()='Contacts']"));
		      //driver.executeScript("arguments[0].scrollIntoView(true);", Cases);
		        driver.executeScript("arguments[0].click();", Contacts);
		//Step 5 : Get the size of contacts available and print the list
		        List<WebElement> ContactList = driver.findElements(By.xpath("//th[@data-aura-class=\"forceInlineEditCell\"]"));
		        System.out.println("The number of Contacts listed are :" + ContactList.size());
		        
		       
		        
		        for (Iterator iterator = ContactList.iterator(); iterator.hasNext();) {
					WebElement webElement = (WebElement) iterator.next();
					System.out.println(webElement.getText());
					 UniqueName=webElement.getText();
				}
		//Step 5 : Search for the Unique Name and Click on Edit 
		        
		        driver.findElement(By.xpath("//input[@name=\"Contact-search-input\"]")).sendKeys(UniqueName);
		        driver.findElement(By.xpath("//input[@name=\"Contact-search-input\"]")).sendKeys(Keys.ENTER);
		        
		        Thread.sleep(3000);
		        driver.findElement(By.xpath("//div[@data-aura-class='forceVirtualAction']")).click();
		        driver.findElement(By.xpath("//a[@title='Edit']")).click();
		      
		//Step 6:Edit Phone number with personal number
		        
		     WebElement phone = driver.findElement(By.xpath("//input[@name='Phone']"));
		     phone.clear();
		     phone.sendKeys(PhoneNumber);

		//Step 7:  Edit Title as Test 
		     
		     WebElement Title = driver.findElement(By.xpath("//input[@name='Title']"));
		     Title.clear();
		     Title.sendKeys("New Title");
		     
		 //Step 8: select your birthday in the birthday field 
		     
		     WebElement DOB = driver.findElement(By.xpath("//input[@name='Birthdate']"));
		     DOB.clear();
		     DOB.sendKeys("16/05/1990");
		     
		 //Step 9: edit Lead Source as Purchased list
		     driver.findElement(By.xpath("//button[@aria-label='Lead Source']")).click();
		     driver.findElement(By.xpath("//span[text()='Purchased List']")).click();
		     
		 //Step 10: Click Save and Verify and Print Phone number
		     driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		     String SuccessEdit = driver.findElement(By.xpath("//div[contains(@id,\"toastDescription\")]")).getText();
		   System.out.println(SuccessEdit);
		   String PhoneNumberEdited = driver.findElement(By.xpath("//span[contains(@class,'forceOutputPhone')]")).getText();
		   System.out.println(PhoneNumberEdited);
		   Assert.assertEquals(PhoneNumberEdited,PhoneNumber);
		     
}

}
