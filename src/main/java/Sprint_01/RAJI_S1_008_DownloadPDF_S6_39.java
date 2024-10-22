package Sprint_01;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class RAJI_S1_008_DownloadPDF_S6_39 {

	public static void main(String[] args) throws InterruptedException {
		
		// Set Chrome preferences for downloading PDF
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("plugins.always_open_pdf_externally", true); // Disable PDF viewer, always download
		
		// Set ChromeOptions
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("prefs", chromePrefs);
		
		// Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver(options);
		
		// Navigate to Salesforce login page
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		// Step 1: Login to Salesforce Application
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@123");
		driver.findElement(By.id("Login")).click();

		// Step 2: Click on the sliding icon until "View Release Notes" is displayed
		WebElement desiredscroller = driver.findElement(By.xpath("//ul[@data-aura-class=\"uiCarouselPageIndicator\"]/li[3]"));
		driver.executeScript("arguments[0].click();", desiredscroller);
		
		// Step 3: Click on Get Started link
		WebElement GetStarted = driver.findElement(By.xpath("//div[@aria-labelledby=\"tab_setupHomeCarousel_page3\"]/article[2]//span[text()=': Release Notes']"));
		driver.executeScript("arguments[0].click();", GetStarted);
		
		// Step 4: Confirm navigation to Release Notes new Window
		for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement confirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Confirm']")));
		driver.executeScript("arguments[0].click();", confirm);
		
		// Step 5: Select Summer '22 release notes from the dropdown
		WebElement RELDropDown = driver.findElement(By.xpath("//button[@name='releaseVersionPicker']"));
		driver.executeScript("arguments[0].click();", RELDropDown);
		
		WebElement Summer22 = driver.findElement(By.xpath("//lightning-combobox[contains(@class,'release-version-picker')]//lightning-base-combobox-item//span[@title=\"Summer '22\"]"));
		driver.executeScript("arguments[0].click();", Summer22);
		Thread.sleep(3000);
		
		// Step 6: Click on the Download Summer '22 release notes link and Download the Release Notes
		WebElement PDFDownload = driver.findElement(By.xpath("//button[@title='Open PDF']"));
		driver.executeScript("arguments[0].click();", PDFDownload);
		
		Thread.sleep(50000);
		
		        
		// Step 7: Verify the downloaded release notes PDF
        // Expected Result: Summer 22 release notes PDF should be downloaded in the default folder
		
		// Path to the Downloads folder (this works for most systems)
		String downloadPath = System.getProperty("user.home") + "/Downloads";
		String expectedFileName = "salesforce_summer22_release_notes.pdf";  // Update this to match the actual filename
		
		// Check if the file exists in the Downloads folder
		boolean isDownloaded = isFileDownloaded(downloadPath, expectedFileName);
		
		if (isDownloaded) {
		    System.out.println("File downloaded successfully!");
		} else {
		    System.out.println("File not downloaded.");
		}

		
	}
	
	// Helper method to check if the file exists in the specified folder
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		File dir = new File(downloadPath);
		File[] dirContents = dir.listFiles();
		
		if (dirContents != null) {
			for (File file : dirContents) {
				if (file.getName().equals(fileName)) {
					// File found
					return true;
				}
			}
		}
		// File not found
		return false;
	}
}
