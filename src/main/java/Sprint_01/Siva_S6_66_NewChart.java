package Sprint_01;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;

public class Siva_S6_66_NewChart extends BaseClass {

//    ChromeDriver driver = null;

   /* @BeforeMethod
    public void Login() {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
        launchUrl_And_Login(driver);
    }*/

    public void launchUrl_And_Login(RemoteWebDriver driver) {
        driver.get("https://login.salesforce.com");
        driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf@123");
//        driver.findElement(By.id("password")).sendKeys("Leaf$321");
        driver.findElement(By.id("Login")).click();

    }

    @Test
    public void test() throws InterruptedException {
//        2. Click on toggle menu button from the left corner
        navigateBeforeChart();
        chart();

    }

    public void mouseHover_And_Get_Status() throws InterruptedException {

        Thread.sleep(10000);
//        WebElement settings = driver.findElement(By.xpath("//a[@title='Settings']//lightning-primitive-icon"));
//        int y = settings.getLocation().getY();
//        driver.executeScript("window.scrollTo(0,"+y+")");
        Thread.sleep(2000);
        WebElement canvasElement = driver.findElement(By.xpath("//div[contains(@class,'pie')]"));

        driver.executeScript("arguments[0].scrollIntoView(true);", canvasElement);
        driver.findElement(By.xpath("//h2[text()='Charts']")).click();
        Thread.sleep(2000);
        WebElement dd = driver.findElement(By.xpath("(//span[.='Select Chart'])[1]/following::a[1]"));
        new Actions(driver).moveToElement(dd,0,90).pause(Duration.ofSeconds(10)).perform();
        Thread.sleep(2000);
//            Get the Status & Priority
        try {
            String chart_Status = driver.findElement(By.xpath("//label[text()='Status']/following-sibling::label")).getText();
            String priority = driver.findElement(By.xpath("//label[text()='Priority']/following::label[1]")).getText();
            System.out.println("Status:: " + chart_Status);
            System.out.println("Priority:: " + priority);
        } catch (Exception e) {
            System.out.println("No tooltip at angle ");
        }

    }

    public void chart() throws InterruptedException {
        //        8. Click on Chart icon
        driver.findElement(By.xpath("//button[@title='Charts']")).click();
//        9. Click on setting icon and select New Chart
        Thread.sleep(1000);
        WebElement settings = driver.findElement(By.xpath("//a[@title='Settings']//lightning-primitive-icon"));
        try {
            settings.click();
        } catch (Exception e) {
            Thread.sleep(1000);
            driver.executeScript("arguments[0].click();", settings);
        }
        Thread.sleep(5000);
        click("//a[@title='New Chart']");
//        10. Give Chart Name as Opened Tasks
        Thread.sleep(3000);

        driver.findElement(By.xpath("//label[text()='Chart Name']/following::input")).sendKeys("Opened Tasks");
//        11. Select Chart type as Donut Chart
        Thread.sleep(1000);

        click("//button[@name='chartTypePicklist']");
        Thread.sleep(1000);
        click("//lightning-base-combobox-item[descendant::span[@title='Donut Chart']]");
//        12. Select Aggregate Field as Priority
        WebElement Aggregate = driver.findElement(By.xpath("//label[text()='Aggregate Field']//following::button[1]"));
        try {
            Aggregate.click();
        } catch (Exception e) {
            driver.executeScript("arguments[0].click();", Aggregate);
        }
        Thread.sleep(1000);
        click("(//lightning-base-combobox-item[descendant::span[text()='Priority']])[1]");
//        13. Select Grouping Field as Status and Click Save
        click("//label[text()='Grouping Field']//following::button[1]");
        Thread.sleep(1000);
        click("//label[text()='Grouping Field']/following::lightning-base-combobox-item[descendant::span[text()='Status']]");
        Thread.sleep(1000);
        click("//h1[contains(.,'New Chart')]/../following::button[span[.='Save']]");

//        14. Mouse over on the chart and print the status and Priority count
        mouseHover_And_Get_Status();
//        15. Mouse over on the status field of first result from task list
        WebElement FirstStatusField = driver.findElement(By.xpath("(//button[@title='Mark Complete']/following::div[1])[1]"));
        new Actions(driver).moveToElement(FirstStatusField).build().perform();
//        16. Click on edit icon and change it as complete
//        Edit icon click
        click("//button[contains(@title,'Edit Status')]");
        //click on Status (Inprogress)(displayed) after clicking Edit icon
        Thread.sleep(1500);
        click("(//button[@title='Mark Complete']/following::div[1])[1]/following::a[1]");
        Thread.sleep(1000);
        //click on option completed
        click("//a[@role='option'][text()='Completed']");
        Thread.sleep(3000);
        click("//button[.='Save']");
        Thread.sleep(2000);
//        17. Click refresh icon and verify the chart Status and priority count of chart Expected Result:
        click("//button[@name='refreshButton']");
//        mouseHover_And_Get_Status();
//    1. Chart should be created based on the selected values
//        2. Chart should be updated based on the changed values. Step Video:
//        https://drive.google.com/file/d/19yvSR8JK-zxxBUz7ySQjjCCPMttZpSRr/view?usp=sharing
    }

    public void navigateBeforeChart() throws InterruptedException {
        Thread.sleep(4000);
        WebElement appLauncher = driver.findElement(By.xpath("//button[@title='App Launcher']"));

        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(appLauncher)).click();


//        3. Click view All from App Launcher
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//button[@aria-label='View All Applications']"));
        //view all click
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait1.until(ExpectedConditions.visibilityOf(element)).click();
//        4. Click on Content tab
        WebElement contentLink = driver.findElement(By.xpath("//p[text()='Content']"));
        try {
            contentLink.click();
        } catch (StaleElementReferenceException e) {
            Thread.sleep(3000);
            click("//p[text()='Content']");
        }

//        5. Click View All from Today's Task
        WebElement ViewAlltasks = driver.findElement(By.xpath("//a[@aria-label='View All Tasks']"));
        try {
            ViewAlltasks.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Caught ElementClickInterceptedException");
            System.out.println("For ViewAlltasks");
            driver.executeScript("arguments[0].click();", ViewAlltasks);
        }
//        6. click on Recently view and select Open task from task Dropdown
        Thread.sleep(3000);
        click("//button[@title='Select a List View: Tasks']");
//        Select Open Task
        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(.,\"Open Tasks\")]"))).click();
//        7. Click On display as list icon and select Table view
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
    }

    public void click(String xpath) throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(xpath));
        driver.executeScript("arguments[0].click();", element);
    }


}
