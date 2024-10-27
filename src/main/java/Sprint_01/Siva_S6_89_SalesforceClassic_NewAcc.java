package Sprint_01;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Siva_S6_89_SalesforceClassic_NewAcc {
//public class SIVA_S6_89_SalesforceClassic_NewAcc extends BaseClass {

    private ChromeDriver driver;
    private Faker faker = new Faker();
    private String acctName="";
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
    public void test() {
//        Test Steps:
//        1. Navigate to Salesforce login page
//        2. Enter username as 'leaners@testleaf.com' and password as 'Leaf@1234' and click on the 'Login' button.
//        3. Choose 'Account' from the dropdown

        WebElement Accountstab = driver.findElement(By.xpath("//li[@id='Account_Tab']/a"));
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(Accountstab));
        Accountstab.click();
        WebElement createNewSelect = driver.findElement(By.id("createNewSelect"));
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(createNewSelect));

        new Select(createNewSelect).selectByVisibleText("Account");

//        4. Click on the 'Go!' button.
        driver.findElement(By.id("createNewGo")).click();
//        5. Enter the Account Name as 'BootCamp Puppeteer_<Your Name>'
        WebElement AcctName = driver.findElement(By.xpath("//label[text()='Account Name']/following::input[1]"));
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(AcctName));
        acctName= faker.name().firstName();
        AcctName.sendKeys(acctName);


//        6. Enter the Billing Address


        //street
        WebElement eleBillingStreet = driver.findElement(By.xpath("(//textarea[contains(@id,'street')])[1]"));
        eleBillingStreet.sendKeys("124");
        //city
        WebElement eleBillingCity = driver.findElement(By.xpath("(//input[contains(@id,'city')])[1]"));
        eleBillingCity.sendKeys("Chennai");

        WebElement eleBillingZipCode = driver.findElement(By.xpath("(//input[contains(@id,'zip')])[1]"));
        eleBillingZipCode
                .sendKeys("600100");
        WebElement eleBillState = driver.findElement(By.xpath("(//input[contains(@id,'state')])[1]"));
        eleBillState.sendKeys("tamilnadu");
        WebElement eleCountry = driver.findElement(By.xpath("(//input[contains(@id,'country')])[1]"));
        eleCountry.sendKeys("India");
//        7. Click Copy Billing Address to Shipping Address link
        WebElement CopyBillingAddrLink = driver.findElement(By.linkText("Copy Billing Address to Shipping Address"));
        CopyBillingAddrLink.click();

//        8. Verify the Shipping Address reflects the Billing Address
        WebElement eleShipStreet = driver.findElement(By.xpath("(//textarea[contains(@id,'street')])[2]"));
        WebElement eleShipCity = driver.findElement(By.xpath("(//input[contains(@id,'city')])[2]"));
        WebElement eleShipZipCode = driver.findElement(By.xpath("(//input[contains(@id,'zip')])[2]"));
        WebElement eleShipState = driver.findElement(By.xpath("(//input[contains(@id,'state')])[2]"));
        WebElement eleShipCountry = driver.findElement(By.xpath("(//input[contains(@id,'country')])[2]"));

        Assert.assertEquals(eleBillingStreet.getAttribute("value"), eleShipStreet.getAttribute("value"));
        Assert.assertEquals(eleBillingCity.getAttribute("value"), eleShipCity.getAttribute("value"));
        Assert.assertEquals(eleBillingZipCode.getAttribute("value"), eleShipZipCode.getAttribute("value"));
        Assert.assertEquals(eleBillState.getAttribute("value"), eleShipState.getAttribute("value"));
        Assert.assertEquals(eleCountry.getAttribute("value"), eleShipCountry.getAttribute("value"));
//        9. Enter the SLA Expiration Date as Current Date + 20 days
        String desiredDate = LocalDate.now().plusDays(20).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        driver.findElement(By.xpath("//label[text()='SLA Expiration Date']/following::input[1]"))
                .sendKeys(desiredDate, Keys.TAB);

//        10. Click on Save button.
        driver.findElement(By.xpath("(//input[@title='Save'])[2]")).click();
//        11. Verify the newly creatd item under Recent Items and verify the new account form is dispalyed
        List<WebElement> elements = driver.findElements(By.xpath("(//div[.='Recent Items'])[1]/following::div/div[contains(@class,'mruItem')]//span"));
        List<String> actualAccountNames = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            actualAccountNames.add(elements.get(i).getText().trim());

        }
        Assert.assertTrue(actualAccountNames.contains(acctName));
        String actualAccName = driver.findElement(By.xpath("//td[text()='Account Name']/following::td[1]")).getText();
        Assert.assertTrue(actualAccName.contains(acctName));
//        12. Navigate to Accounts tab and Verify the newly Created account is displayed

//        13. Close the browser Expected Result:
//    Verify the newly Created account is displayed
        String displayedName = driver.findElement(By.xpath("(//td[@id='bodyCell']//h2)[1]")).getText().trim();
        Assert.assertEquals(displayedName, acctName);

        driver.quit();

    }

}
