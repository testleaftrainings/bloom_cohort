import io.github.sukgu.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShadowDomInsideIFrame {

    @Test
    public void test() throws InterruptedException {
        RemoteWebDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/shadow-dom-in-iframe/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(15000);
        WebElement iframe = driver.findElement(By.id("pact"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
        Shadow shadow = new Shadow(driver);
        shadow.findElementByXPath("//*[@id='tea']").sendKeys("Yes I need it");
//        driver.switchTo().frame(iframe);

       /* WebElement host = driver.findElement(By.id("snacktime"));
        SearchContext shadowRoot = host.getShadowRoot();


        shadowRoot.findElement(By.cssSelector("#tea")).sendKeys("Yes I need it");*/


    }

}
