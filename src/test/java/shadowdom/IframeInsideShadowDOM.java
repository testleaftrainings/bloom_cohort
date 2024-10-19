package shadowdom;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeInsideShadowDOM {

    @Test

    public void test() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://selectorshub.com/iframe-in-shadow-dom/");

        Thread.sleep(2000);

//        switch to shadow dom,then switch to ifram.interact with taget element

        WebElement host = driver.findElement(By.cssSelector("#userName"));
        Thread.sleep(3000);
        SearchContext shadowRoot = host.getShadowRoot();
        Thread.sleep(2000);

        WebElement iframe1 = shadowRoot.findElement(By.cssSelector("#pact1"));
        Thread.sleep(2000);
        driver.switchTo().frame(iframe1);
        Thread.sleep(2000);

        //Below textbox is inside iframe#pact1 , iframe is inside shadowroot
        driver.findElement(By.cssSelector("#glaf")).sendKeys("Microsoft");


    }
}
