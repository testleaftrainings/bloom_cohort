package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CrossOrigin {
    @Test
    public void test() throws InterruptedException {

        ChromeDriver driver=new ChromeDriver();
        driver.get("https://selectorshub.com/xpath-practice-page/");

        Thread.sleep(2000);

        WebElement comingGoogle = driver.findElement(By.id("coming google"));
        driver.executeScript("arguments[0].scrollIntoView(true);",comingGoogle);
        Thread.sleep(2000);

        driver.switchTo().frame(comingGoogle);
        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("//div[contains(text(),'Cross Origin iframe Scenario')]")).getText();
        System.out.println(text);
    }
}
