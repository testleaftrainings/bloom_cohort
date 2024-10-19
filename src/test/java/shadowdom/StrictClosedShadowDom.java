package shadowdom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class StrictClosedShadowDom {
@Test
    public void test() throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");

        Thread.sleep(2000);
        driver.findElement(By.id("userPass")).click();

        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.TAB).build().perform();
        actions.sendKeys("pass123").build().perform();

    }

}
