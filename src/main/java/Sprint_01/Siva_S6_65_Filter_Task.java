package Sprint_01;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Siva_S6_65_Filter_Task {

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
    public void testFilterTask() throws InterruptedException {
        Thread.sleep(3000);
        WebElement appLauncher = driver.findElement(By.xpath("//button[@title='App Launcher']"));

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(appLauncher)).click();

        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//button[@aria-label='View All Applications']"));
        //view all click
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait1.until(ExpectedConditions.visibilityOf(element)).click();
        //click on Context link
        WebElement contentLink = driver.findElement(By.xpath("//p[text()='Content']"));
        try {
            contentLink.click();
        } catch (StaleElementReferenceException e) {
            Thread.sleep(3000);
            driver.findElement(By.xpath("//p[text()='Content']")).click();
        }
        WebElement ViewAlltasks = driver.findElement(By.xpath("//a[@aria-label='View All Tasks']"));
        try {
            ViewAlltasks.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Caught ElementClickInterceptedException");
            System.out.println("For ViewAlltasks");
            driver.executeScript("arguments[0].click();", ViewAlltasks);
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@title='Select a List View: Tasks']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,\"Open Tasks\")]"))).click();
//check the view and change it to table view
        Thread.sleep(3000);
        //trying to click on below to ensure no overlay for clicking button ('select List Display')
        driver.findElement(By.xpath("//span[@aria-label='Open Tasks']")).click();
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

        //7.Click on Filter icon
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@title='Filters']")).click();
//8. Click on Filter by Owner, select All Tasks and click on Done
        Thread.sleep(3000);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(.,'Filter by Owner')]")
        )).click();

        //select all Tasks (radio button)
        Thread.sleep(1000);
        WebElement selectAllTasks_RadioButton = driver.findElement(By.xpath("//label[span[contains(text(),'All tasks')]]/preceding-sibling::input"));
        try {
            selectAllTasks_RadioButton.click();
        } catch (Exception e) {
            driver.executeScript("arguments[0].click();", selectAllTasks_RadioButton);
        }
        //click Done button
        driver.findElement(By.xpath("//button[span[text()='Done']]")).click();
        //click on Add Filter
        driver.findElement(By.xpath("//a[.='Add Filter']")).click();
        //Click on Field dd and select status
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@aria-label='Field']")).click();
        Thread.sleep(1000);
        WebElement StatusOption = driver.findElement(By.xpath("//lightning-base-combobox-item[descendant::span[.='Status']]"));
        try {
            StatusOption.click();
        } catch (Exception e) {
            driver.executeScript("arguments[0].click();", StatusOption);
        }
        //select Operator as equals

        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@aria-label='Operator']")).click();
        Thread.sleep(1000);
        WebElement equalsOption = driver.findElement(By.xpath("//lightning-base-combobox-item[descendant::span[.='equals']]"));
        try {
            equalsOption.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("caught ElementClickInterceptedException");
            System.out.println();
        }
        Thread.sleep(1000);
        //Click on Value dropdown
        driver.findElement(By.xpath("//div[text()='Value']/following::a[1]")).click();
        Thread.sleep(1000);
        //select by clicking In Progress list item
        driver.findElement(By.xpath("//a[@*='In Progress']/..")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[span[text()='Done']]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        Thread.sleep(2000);
        String actualText = driver.findElement(By.xpath("//div[starts-with(@id,'toast')]/span")).getText().trim();
        String expectedText = "List view updated.";
        Assert.assertEquals(actualText, expectedText);


    }

}

//Test Steps:
//        1. Login to https://login.salesforce.com
//        2. Click on toggle menu button from the left corner
//3. Click view All from App Launcher
//4. Click on Content tab
//5. Click View All from Today's Task
//6. Click on dropdown in Task and Select a task List view as Open Task
//7. Click on Filter icon
//8. Click on Filter by Owner, select All Tasks and click on Done
//9. Click on Add Filter and Select Field as Status
//10. Select Operator as equals and select Value as In Progress
//11. Click on Save
//12. Verify whether the status field contains only the valus as In Prograss Expected Result:
//success
//List view should be updated based on the filter input values. Step Video:
//https://drive.google.com/file/d/15bqg-cQHWvF9HmrwmKAcmcse_2P3_wMe/view?usp=sharing
