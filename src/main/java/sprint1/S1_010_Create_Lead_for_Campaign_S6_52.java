package sprint1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.sukgu.Shadow;

public class S1_010_Create_Lead_for_Campaign_S6_52 {

    public static void main(String[] args) throws InterruptedException {
        
        // Set ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        
        // Initialize ChromeDriver
        ChromeDriver driver = new ChromeDriver(options);
        
        try {
            // Step 1: Navigate to Salesforce login page
            driver.get("https://login.salesforce.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.manage().window().maximize();
            
            // Step 2: Login to Salesforce Application
            driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
            driver.findElement(By.id("password")).sendKeys("Leaf$321");
            driver.findElement(By.id("Login")).click();
    
            // Step 3: Wait for page to load and click on the sliding icon until 'See System Status' is displayed.
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement desiredscroller = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@data-aura-class=\"uiCarouselPageIndicator\"]/li[3]")));
            driver.executeScript("arguments[0].click();", desiredscroller);
            
            // Step 4: Click on Get Started link
            WebElement getStarted = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-labelledby=\"tab_setupHomeCarousel_page3\"]/article[3]//span[text()=': System Status']")));
            driver.executeScript("arguments[0].click();", getStarted);
            
            // Step 5: Switch to new window - Click confirm on the redirecting page and navigate to SalesForce Trust new Window.
            for (String windowHandle : driver.getWindowHandles()) {
                driver.switchTo().window(windowHandle);
            }
    
            // Step 6: Click on the 'Visit Site' for Trailhead under 'Resources'
            WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Confirm']")));
            driver.executeScript("arguments[0].click();", confirm);
            
            Shadow shadow = new Shadow(driver);
            shadow.findElementByXPath("//div[@class='HomeCard_resources__OGgnP'][2]//a").click();

            // Step 7: Click on the 'Industries'
            
            shadow.findElementByXPath("//span[text()='Industries']").click();
            
            // Step 8 : Click on the 'Nonprofit'
            shadow.findElementByXPath("//span[text()='Nonprofit']").click();
           
            
            // Step 9 : Click on the 'Start Learning' for 'Salesforce for Nonprofits Basics'
            
            shadow.findElementByXPath("//a[@aria-label='Start learning: Salesforce for Nonprofits Basics']").click();
            
          //span[text()='Start learning']
            
            
            // Step 10 : Verify the title as 'Salesforce for Nonprofits Basics' and Industries as 'Nonprofit'
  
            String Actual_Title = driver.findElement(By.xpath("//div[@class='th-content-card_content-header']/h1")).getText();
            String Expected_Title = "Salesforce for Nonprofits Basics";
            Assert.assertEquals(Expected_Title, Actual_Title);
            //System.out.println(Expected_Title +"----"+Actual_Title);
            
            String Actual_Industries =driver.findElement(By.xpath("//a[@aria-label='Nonprofit']/h5")).getText();
            String Expected_Industries = "Nonprofit";
            
            Assert.assertEquals(Expected_Industries, Actual_Industries);
            		
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Always close the driver at the end of execution
            //driver.quit();
        }
    }
}
