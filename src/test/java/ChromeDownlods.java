import io.github.sukgu.Shadow;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDownlods {


    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        ChromeDriver driver = new ChromeDriver(options);

        driver.get("chrome://downloads");
        WebElement SearchDownloads = new Shadow(driver).findElementByXPath("//input[@id='searchInput']");
        SearchDownloads.sendKeys("Hi There");

    }
}



/*Exception in thread "main" org.openqa.selenium.JavascriptException: javascript error: Failed to set the 'src' property on 'HTMLScriptElement': This document requires 'TrustedScriptURL' assignment.
        (Session info: chrome=129.0.6668.100)
        at org.openqa.selenium.remote.RemoteWebDriver.executeScript(RemoteWebDriver.java:476)
	at ChromeDownlods.main(ChromeDownlods.java:14)
        */
