package shadowdom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClosedShadow {

    @Test
    public void Test() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/shadow");
        Thread.sleep(3000);


        //This Element is inside single shadow DOM.
        Thread.sleep(4000);

//        String script = "document.querySelector('my-web-component').myRoot.querySelector('#lname').value='Sivashankar'";
        String script = " return document.evaluate('//my-web-component',document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue";
        WebElement host = (WebElement)driver.executeScript(script);
       driver.executeScript( "arguments[0].myRoot.querySelector('#lname').value='Sivashankar'",host);



    }
}


