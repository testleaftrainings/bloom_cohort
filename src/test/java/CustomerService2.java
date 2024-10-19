import io.github.sukgu.Shadow;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class CustomerService2 {


    ChromeDriver driver = null;

    @BeforeMethod
    public void login() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
//        Login to https://login.salesforce.com

//        driver.get("https://login.salesforce.com/");
//        driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
//        driver.findElement(By.id("password")).sendKeys("Leaf$321");


        driver.get("https://virtusa-2df-dev-ed.develop.my.salesforce.com/");
        driver.findElement(By.id("username")).sendKeys("shankar@sdet.com");
        driver.findElement(By.id("password")).sendKeys("Shkr@9497");
        driver.findElement(By.id("Login")).click();

    }

    @Test
    public void testShadowRoot() throws InterruptedException {
        WebElement learnMore = driver.findElement(By.xpath("//button[@title='Learn More']"));
        try {
            learnMore.click();
        } catch (Exception e) {
            driver.executeScript("arguments[0].click();", learnMore);
        }

        Set<String> windowHandles = driver.getWindowHandles();
        String mainwindow = driver.getWindowHandle();

        for (String window : windowHandles) {
            if (!window.equals(mainwindow)) {
                driver.switchTo().window(window);
            }
        }

        driver.findElement(By.xpath("//button[text()='Confirm']")).click();

        Shadow shadow = new Shadow(driver);

        WebElement Products = shadow.findElementByXPath("//span[text()='Products']/..");
        shadow.highlight(Products);
        System.out.println(Products.getText());
        Products.click();

        WebElement Service = shadow.findElementByXPath("//div/span[text()='Service']/../../..");

        Thread.sleep(3000);
        new Actions(driver).moveToElement(Service).build().perform();
        Thread.sleep(3000);
        String script = "return document.evaluate(`(//hgf-c360nav)[1]`,document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue.shadowRoot.querySelector(`#l1-0-l2-7 > div > hgf-c360panellinkedlist`).shadowRoot.querySelectorAll(`div>ul>li:nth-child(n)>div>a`)";
        List<WebElement> elements =(List<WebElement>) driver.executeScript(script);

        System.out.println(elements.size());
        elements.forEach(element -> System.out.println(element.getText().trim()));


    }
}
