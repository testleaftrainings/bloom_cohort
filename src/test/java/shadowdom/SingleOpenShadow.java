package shadowdom;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SingleOpenShadow {

    @Test
    public void Test() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/shadow");
        Thread.sleep(3000);


        //This Element is inside single shadow DOM.
        Thread.sleep(4000);
        SearchContext shadow = driver.findElement(By.cssSelector("#open-shadow")).getShadowRoot();
//       SearchContext shadow = driver.findElement(By.xpath("//my-web-component")).getShadowRoot();
        //closed mode
        Thread.sleep(4000);
        WebElement element = shadow.findElement(By.id("fname"));
        element.sendKeys("SIVA");


    }
}


