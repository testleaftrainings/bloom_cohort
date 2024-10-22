package Sprint_01;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	

		RemoteWebDriver driver;
	    WebDriverWait wait;


	    @BeforeMethod
	    public void preCondition() throws MalformedURLException{
	     /* DesiredCapabilities dc = new DesiredCapabilities();
	    	dc.setBrowserName("MicrosoftEdge");
	    	dc.setPlatform(Platform.LINUX);   	       			
	        driver = new RemoteWebDriver(new URL(" http://20.40.48.160:4444/wd/hub"), dc);
	    	//ChromeDriver driver = new ChromeDriver();*/
	    	
	    	// Set Remote WebDriver and Desired Capabilities for GRID Execution
	    	// UI Console - http://20.40.48.160:4444/ui/#/sessions - click on Video - secret is the password
	    	
	    	// Set ChromeOptions
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	         
	    	DesiredCapabilities dc = new DesiredCapabilities();
	    			dc.setBrowserName("chrome");
	    			dc.setPlatform(Platform.LINUX);
	    			dc.setCapability(ChromeOptions.CAPABILITY, options);
	    		  //dc.merge(options);
	    			driver = new RemoteWebDriver(new URL("http://20.40.48.160:4444/wd/hub"), dc);

	    	
	    	driver.get(" https://login.salesforce.com/");             
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//	      driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	        driver.get("https://login.salesforce.com/");
	        driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
	        driver.findElement(By.id("password")).sendKeys("Leaf@123");
	        driver.findElement(By.id("Login")).click();
	    }


	    @AfterMethod
	    public void postCondition(){
	        driver.close();
	    }


	}

