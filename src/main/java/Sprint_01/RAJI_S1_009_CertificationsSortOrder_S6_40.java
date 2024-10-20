package Sprint_01;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RAJI_S1_009_CertificationsSortOrder_S6_40 {

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
            
            // Step 5: Switch to new window
            for (String windowHandle : driver.getWindowHandles()) {
                driver.switchTo().window(windowHandle);
            }
    
            // Step 6: Confirm navigation to Release Notes new Window
            WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Confirm']")));
            driver.executeScript("arguments[0].click();", confirm);
            
            // Step 7: Click on the Compliance
            WebElement compliance = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Compliance']")));
            driver.executeScript("arguments[0].click();", compliance);
            
            // Step 8: Click on the Documents
            WebElement documents = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Documents']")));
            driver.executeScript("arguments[0].click();", documents);
            
            // Step 9: Click on the 'Name' to sort name in Ascending order
            WebElement nameHeader = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Name']")));
            driver.executeScript("arguments[0].click();", nameHeader);
            
            // Step 10: Verify the Documents are displayed in alphabetical order
            List<WebElement> nameElements = driver.findElements(By.xpath("//tr/td[1]/a"));
            List<String> actualNames = new ArrayList<>();
    
            // Capture the names in a list
            for (WebElement element : nameElements) {
                actualNames.add(element.getText());
            }
            
            // Remove Elements starting with Bracket
            List<String> filteredList = new ArrayList<>();
            for (String name : actualNames) {
                if (!name.startsWith("[")) {
                    filteredList.add(name);
                }
            }
            
            // Print filtered list for debugging purposes
            System.out.println("Filtered List: " + filteredList);
    
         // Check if the filtered list is in alphabetical order
            boolean isAlphabetical = true;
            for (int i = 0; i < filteredList.size() - 1; i++) {
                // Debugging output
                System.out.println("Comparing: " + filteredList.get(i) + " with " + filteredList.get(i + 1));
                
                // Compare only the first character
                if (filteredList.get(i).charAt(0) > filteredList.get(i + 1).charAt(0)) {
                    System.out.println("Mismatch found at index " + i + ": " + filteredList.get(i) + " should come after " + filteredList.get(i + 1));
                    isAlphabetical = false;
                    break;  // Exit the loop on first mismatch
                }
            }
    
            // Result
            if (isAlphabetical) {
                System.out.println("The extracted list is in alphabetical order.");
            } else {
                System.out.println("The extracted list is NOT in alphabetical order.");
            }
            
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Always close the driver at the end of execution
            driver.quit();
        }
    }
}
