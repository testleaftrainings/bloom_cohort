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

public class RAJI_S1_015_CreateAccount_S6_85 {

	// @Test
	public static void main(String args[]) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		// Step 1: Login to Sales-force Application
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		// Step 2. Enter username as 'learners@testleaf.com' and password as 'Leaf@1234'
		// and click on the 'Login' button.
		driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();

		// Step 3. Click on the Accounts button , Choose 'Account' from the dropdown
		driver.findElement(By.xpath("//li[@id='Account_Tab']")).click();
		// Locate the <select> drop-down element
		WebElement dropdown = driver.findElement(By.id("createNewSelect"));

		// Use the Select class to choose the option
		Select select = new Select(dropdown);
		select.selectByVisibleText("Account");

		// Step 4. Click on the 'Go!' button.
		driver.findElement(By.xpath("//input[@id='createNewGo']")).click();
		// Step 5. Enter the Account Name as 'BootCamp Puppeteer_<Raji>'
		String AccountName="BootCamp Puppeteer_<Raji>";
		driver.findElement(By.xpath("//input[@id='acc2']")).sendKeys(AccountName);

		// Step 6. Enter the Billing Address
		driver.findElement(By.xpath("//textarea[@id='acc17street']")).sendKeys("2nd Street");
		driver.findElement(By.xpath("//input[@id='acc17city']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//input[@id='acc17zip']")).sendKeys("600089");
		driver.findElement(By.xpath("//input[@id='acc17state']")).sendKeys("TamilNadu");
		driver.findElement(By.xpath("//input[@id='acc17country']")).sendKeys("INDIA");

		// Step 7. Click Copy Billing Address to Shipping Address link
		driver.findElement(By.xpath("//a[text()='Copy Billing Address to Shipping Address']")).click();

		// Step 8. Verify the Shipping Address reflects the Billing Address
		// Step 9. Enter the SLA Expiration Date as Current Date + 20 days

		// Calculate the current date + 20 days
		LocalDate slaExpirationDate = LocalDate.now().plusDays(20);

		// Format the date as dd/MM/yyyy
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String formattedDate = slaExpirationDate.format(formatter);

		// Locate the input field and send the formatted date
		driver.findElement(By.xpath("//input[@id='00N5i00000LydkL']")).sendKeys(formattedDate);

		// Step 10. Click on Save button.
		driver.findElement(By.xpath("(//input[@title='Save'])[2]")).click();
		//driver.findElement(By.xpath("(//input[@value=\"Save & New (Ignore Alert)\"])[1]")).click();

		// Step 11. Verify the newly created item under Recent Items and verify the new account form is displayed
		String RecentAccount= driver.findElement(By.xpath("(//div[@class=\"mruItem\"])[1]/a")).getText();
		Assert.assertEquals(RecentAccount, AccountName);
		

	}
}
