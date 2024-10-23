package Sprint_01;

import com.github.javafaker.App;
import com.google.common.base.Verify;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Siva_S6_67_CloneTask {


    //    Test Steps:
//            1. Login to https://login.salesforce.com
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
        launchUrl_And_Login(driver);
    }

    public void launchUrl_And_Login(RemoteWebDriver driver) {
        driver.get("https://login.salesforce.com");
        driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf@123");
//        driver.findElement(By.id("password")).sendKeys("Leaf$321");
        driver.findElement(By.id("Login")).click();

    }

    @Test
    public void test() throws InterruptedException {
//            2. Click on toggle menu button from the left corner
        click("//button//span[text()='App Launcher']");
        //3. Click view All from App Launcher
        Thread.sleep(5000);
        click("//button[@aria-label='View All Applications']");
//4. Click on Content tab
        click("//p[text()='Content']");
//5. Click View All from Today's Task
        WebElement ViewAlltasks = driver.findElement(By.xpath("//a[@aria-label='View All Tasks']"));
        try {
            ViewAlltasks.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Caught ElementClickInterceptedException");
            System.out.println("For ViewAlltasks");
            driver.executeScript("arguments[0].click();", ViewAlltasks);
        }
//            6. Click on dropdown in Task and Select a task List view as Open Task
        click("//button[@title='Select a List View: Tasks']");
        click("(//a[span[text()='Open Tasks']])[1]");
//7. Click On display as list icon and select Table view
        Thread.sleep(3000);

        WebElement btn_SelectListDisplay = driver.findElement(By.xpath("//div[@title='Select list display']/button"));
        driver.executeScript("arguments[0].click();", btn_SelectListDisplay);
        Thread.sleep(4000);


        String checked = driver.findElement(By.xpath("//a[contains(.,'Table')]/..")).getAttribute("aria-checked");
        if (!Boolean.parseBoolean(checked)) {
            WebElement tableOption = driver.findElement(By.xpath("//a[contains(.,'Table')]"));
            try {
                tableOption.click();
            } catch (ElementClickInterceptedException e) {
                System.out.println("caught ElementClickInterceptedException");
                System.out.println("for table option");
                driver.executeScript("arguments[0].click();", tableOption);

            }
        }
//8. Click on settings icon and click clone
        click("//button[@title='List View Controls']");
        click("//a[.='Clone']");
//9. Give the list name as New open tasks and List API Name as New_open_tasks
        WebElement ListName = driver.findElement(By.xpath("//label[.='*List Name']/following::input[1]"));
        driver.executeScript("arguments[0].value='New open tasks'",ListName);

        WebElement ListAPIName = driver.findElement(By.xpath("//label[.='*List API Name']/following::input[1]"));
        driver.executeScript("arguments[0].value='New_open_tasks'",ListAPIName);

//10. Select All users can see this list view and click Save

        click("//input[@value='GLOBAL']");
        click("//*[text()='Clone List View']/following::button[span[.='Save']]");
//11. Save the open task subject field as map
        WebElement firstSubjectSpan = driver.findElement(By.xpath("//tbody/tr[1]/th[1]/span"));

        new Actions(driver).moveToElement(firstSubjectSpan).pause(2000).perform();
        //click on Edit icon
        click("//tbody/tr[1]/th[1]/span//button");
        WebElement subjectTxtBox = driver.findElement(By.xpath("//label[text()='Subject']/following::input[1]"));
        driver.executeScript("arguments[0].value='map'", subjectTxtBox);
        click("//button[span[.='Save']]");
        Thread.sleep(10000);
//12. Click on dropdown in Task and Select a task List view as New Open Tasks
        click("//button[@title='Select a List View: Tasks']");
        click("(//a[span[text()='Open Tasks']])[1]");
//13.Compare with Open Task field map values.
        String text = driver.findElement(By.xpath("//tbody/tr[1]/th[1]//a")).getText().trim();
        Assert.assertEquals(text, "map");
//14.
//    Verify both are same Expected result:
//    Clone the open Tasks in to New Open Tasks
//    The New Open Taskes fields should be match with Open Tasks Step Video:
//    https://drive.google.com/file/d/1uUDAehHGeqLMl139ygZ38XHughuDQa6e/view?usp=sharing

    }

    public void click(String xpath) throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(xpath));
        driver.executeScript("arguments[0].click();", element);
    }

}
