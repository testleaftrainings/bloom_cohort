package Sprint_01;

import com.github.javafaker.Faker;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Siva_S6_90_NewPostDeleted {

    private ChromeDriver driver;
    private Faker faker = new Faker();

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
        driver.findElement(By.id("username")).sendKeys("learners@testleaf.com");
        driver.findElement(By.id("password")).sendKeys("Leaf@1234");
        driver.findElement(By.id("Login")).click();
    }

    @Test
    public void test()
    {
//        Test step:
//        1. Navigate to Salesforce login page
//        2. Enter username as 'leaners@testleaf.com' and password as 'Leaf@1234' and click on the 'Login' button.
//        3. Click on the 'File'

        driver.findElement(By.xpath("//li[@id='home_Tab']/a")).click();
       /* WebElement fileTab = driver.findElement(By.xpath("//a[@title='File']/.."));
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(fileTab));

        driver.executeScript("arguments[0].click();",fileTab)*/;
        driver.findElement(By.id("section_header")).click();
        driver.findElement(By.xpath("//span[text()='Post']")).click();
//        WebElement fileTab = driver.findElement(By.xpath("//li/a[@title='File']/.."));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].focus(); arguments[0].click();", fileTab);


//        4. Click on 'Select a file from Salesforce'
    /*    WebElement selectAFile= driver.findElement(By.linkText("Select a file from Salesforce"));
        try {
            new WebDriverWait(driver,Duration.ofSeconds(10)).
                    until(ExpectedConditions.visibilityOf(selectAFile)).click();
        } catch (Exception e) {
driver.executeScript("arguments[0].click();",selectAFile);

            new WebDriverWait(driver,Duration.ofSeconds(10)).
                    until(ExpectedConditions.visibilityOf(selectAFile)).click();
        }*/
        String parent = driver.getWindowHandle();
        new WebDriverWait(driver,Duration.ofSeconds(10)).
                until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(parent)) {
                driver.switchTo().window(handle);
                break;
            }
        }



//        5. Click on 'Owned by Me'
        driver.findElement(By.xpath("//a[@title='Owned by Me']")).click();
//        6. Search for 'Maven'
        WebElement SearchBox = driver.findElement(By.xpath("//input[@title='Search Files I Own...']"));
        new WebDriverWait(driver,Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(SearchBox)).click();

        SearchBox.sendKeys("Maven");
        //click on search button
        driver.findElement(By.xpath("//a[@title='Search']")).click();
//        7. Click on the 'Attach' for Maven file
        WebElement eleAttachLink = driver.findElement(By.xpath("//span[text()='Attach']/.."));
        long startTime = System.currentTimeMillis();
        WebElement finalEleAttachLink = eleAttachLink;
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(driver->
                {
                    Boolean isStale = ExpectedConditions.stalenessOf(finalEleAttachLink).apply(driver);
                    long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
//                    System.out.println("Checking staleness of element ::"+isStale);
                    return isStale;
                }
        );
        long totalTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Total wait time for element to become stale: " + totalTime + " seconds");
        eleAttachLink = driver.findElement(By.xpath("//span[text()='Attach']/.."));
        eleAttachLink.click();

        driver.switchTo().window(parent);
//        8. Click on the 'Share' Button
        driver.findElement(By.xpath("//input[@value='Share']")).click();
//        9. Click on the 'More Actions'
        driver.findElement(By.xpath("(//a/span[text()='More Actions'])[1]")).click();
//        10. Click on the 'File Sharing Settings'
        driver.findElement(By.xpath("(//a/span[text()='File Sharing Settings'])[1]")).click();

//        11. Change permissions as 'Collaborators'

        String permission = driver.findElement(By.xpath("//table[@id='sharedWithList']//tr[1]/td[3]/a/span")).getText().trim();
        if(!permission.equals("Collaborators")) {
            WebElement ChangePermissionDropdownImg = driver.findElement(By.xpath("(//a/span[@class='permissionLabel'])[1]/following-sibling::img"));
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    ExpectedConditions.visibilityOf(ChangePermissionDropdownImg)
            ).click();

            WebElement eleOptionCollaborators = driver.findElement(By.xpath("(//span[contains(text(),'Collaborators')])[2]"));
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                    ExpectedConditions.visibilityOf(eleOptionCollaborators)
            ).click();
        }

//        12. Enable the checkBox for 'Prevent others from sharing and unsharing'
        WebElement elesharingOption = driver.findElement(By.id("sharingOption"));
        boolean sharingOption = elesharingOption.isSelected();
        if(!sharingOption)
        {
            try {
                elesharingOption.click();
            } catch (Exception e) {
                driver.executeScript("arguments[0].click();",elesharingOption);
            }
        }

//        13. Verify the checkbox is Enabled
        boolean selected = elesharingOption.isSelected();
        System.out.println("Verify if checkbox is enabled::"+selected);
        Assert.assertTrue(selected);
//        14. Click on the 'Close' button.
        WebElement eleCloseBtn = driver.findElement(By.xpath("//input[@value='Close']"));
        eleCloseBtn.click();
//        15. Click on 'Click to add topics' and enter topic as 'Maven Installtion Guide' and Click on the 'Done' button.
//        driver.findElement(By.linkText("Click to add topics:")).click();
        driver.findElement(By.xpath("//a[@title='More Actions']")).click();
        WebElement AddTopics = driver.findElement(By.xpath("(//a[text()='Add Topics'])[1]"));

        try {
            AddTopics.click();
        } catch (Exception e) {
            driver.executeScript("arguments[0].click();",AddTopics);
        }

        driver.findElement(By.xpath("//textarea[text()='Add your own topics or choose from our suggestions.']"))
                .sendKeys("Maven Installtion Guide");
//        16. Verify the Topics as 'Maven Installtion Guide'
        WebElement option = driver.findElement(By
                .xpath("(//li[a[span[strong[normalize-space(text())!='']]]])[1]"));
        String text = option.getText().trim();
        System.out.println("Option :: "+text);
        option.click();
        Assert.assertTrue(text.contains("Maven Installtion Guide"));
        WebElement eleDone = driver.findElement(By.xpath("//input[@title='Done']"));
        eleDone.click();

//        17. Click on the widget dropdown for post and click 'Delete'
        driver.findElement(By.xpath("//a[@title='More Actions']")).click();
        //        18. Click on the 'Ok' Button.
        driver.findElement(By.xpath("(//a[@title='Delete this post'])[1]")).click();

        new WebDriverWait(driver,Duration.ofSeconds(5)).until(
                ExpectedConditions.numberOfWindowsToBe(2));
        List<String> windowHandles1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles1.get(1));  // Switch to the second window
        driver.findElement(By.id("simpleDialog0button0")).click();
//        19. Verify the post is Deleted.
        String windowHandle = driver.getWindowHandle();
        driver.switchTo().window(windowHandle);
        WebElement eleFileNotAvailable = driver.findElement(By.xpath("//td[contains(text(),'The file is no longer available')]"));
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(driver->eleFileNotAvailable.isDisplayed());
        String actualtext_FileNotAvailable = eleFileNotAvailable.getText().trim();
        Assert.assertTrue(actualtext_FileNotAvailable.equals("The file is no longer available."));

    }

    public void verifyOverlap()
    {
        WebElement element = driver.findElement(By.id("publisherAttachContentPost"));
       driver.executeScript("arguments[0].style.border='3px solid red'", element);

        new Actions(driver).moveToLocation(element.getLocation().getX(),element.getLocation().getY()).doubleClick().perform();

    }

}
