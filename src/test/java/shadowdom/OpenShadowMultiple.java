package shadowdom;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OpenShadowMultiple {

    @Test
    public void TestShadowWithinShadow() throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://books-pwakit.appspot.com");


        //This Element is inside single shadow DOM.
        String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
        Thread.sleep(1000);
        SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
        Thread.sleep(1000);
        shadow.findElement(By.cssSelector("#input")).sendKeys("Money");


    }

}
