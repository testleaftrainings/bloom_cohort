package Sprint_01;

import com.github.javafaker.App;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Siva_S6_65_Filter_Task{

    ChromeDriver driver = null;
    @BeforeMethod
    public void Login() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        driver.get("https://login.salesforce.com");
        driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf$321");
        driver.findElement(By.id("Login")).click();
    }
    @Test
    public void testFilterTask()
    {
        WebElement appLauncher = driver.findElement(By.xpath("//button[@title='App Launcher']"));

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(appLauncher)).click();

        WebElement element = driver.findElement(By.xpath("//button[@aria-label='View All Applications']"));
        //view all click
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

}

//Test Steps:
//        1. Login to https://login.salesforce.com
//        2. Click on toggle menu button from the left corner
//3. Click view All from App Launcher
//4. Click on Content tab
//5. Click View All from Today's Task
//        6. Click on dropdown in Task and Select a task List view as Open Task
//7. Click on Filter icon
//8. Click on Filter by Owner, select All Tasks and click on Done
//9. Click on Add Filter and Select Field as Status
//10. Select Operator as equals and select Value as In Progress
//11. Click on Save
//12. Verify whether the status field contains only the valus as In Prograss Expected Result:
//success
//List view should be updated based on the filter input values. Step Video:
//https://drive.google.com/file/d/15bqg-cQHWvF9HmrwmKAcmcse_2P3_wMe/view?usp=sharing
