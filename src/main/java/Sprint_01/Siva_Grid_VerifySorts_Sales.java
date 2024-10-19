package Sprint_01;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Siva_Grid_VerifySorts_Sales {

    @Test
    public void test_VerifySorting() throws MalformedURLException {
        //Options
        EdgeOptions edgeOptions= new EdgeOptions();
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.setCapability("platformName", Platform.LINUX);
        edgeOptions.setCapability("browserVersion","129.0");

        //RemoteWebDriver
        RemoteWebDriver driver = new RemoteWebDriver(
                new URL("http://20.40.48.160:4444/wd/hub"),edgeOptions);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//        Login to https://login.salesforce.com

        driver.get("https://login.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("shankar@sdet.com");
        driver.findElement(By.id("password")).sendKeys("Shkr@9497");
        driver.findElement(By.id("Login")).click();
//          Click on toggle menu button from the left corner
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='App Launcher']"))).click();

//        WebElement element = driver.findElement(By.xpath("//button[@title='App Launcher']"));
//        element.click();
//        Click view All and click Sales from App Launcher
        driver.findElement(By.xpath("//button[@aria-label='View All Applications']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();

//        Click on Accounts tab
        try {
            driver.findElement(By.xpath("//a[@title='Accounts']")).click();
        } catch (JavascriptException e) {
            WebElement AccountsLink = driver.findElement(By.xpath("//a[@title='Accounts']"));
            driver.executeScript("arguments[0].click();",AccountsLink);
        }

//        Click sort arrow in the Account Name to sort in ascending order
        driver.findElement(By.xpath("//span[@title='Account Name']/..")).click();

//        Read all account names
        List<String> actualAccountNames = driver.findElements(By.xpath("//table[@aria-label='Recently Viewed']/tbody/tr/th/span/a")).stream().map(e -> e.getText().trim()).collect(Collectors.toList());
        //        "Expected Result:
//        All the accounts should be displayed ascending order by Account Name"
        List<String> sortedList = actualAccountNames;
        Collections.sort(sortedList);
        Assert.assertTrue(actualAccountNames.equals(sortedList));

    }
}
