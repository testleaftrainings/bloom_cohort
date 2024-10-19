package shadowdom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ClosedShadow2 {

    @Test
    public void Test() throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://letcode.in/shadow");
        Thread.sleep(3000);


        //This Element is inside single shadow DOM.
        Thread.sleep(4000);
//using querySelector to identify host
//        String script = "document.querySelector('my-web-component').myRoot.querySelector('#lname').value='Sivashankar'";
//       Using xpath to identify host
        String script = " return document.evaluate('//my-web-component',document,null,XPathResult.FIRST_ORDERED_NODE_TYPE,null).singleNodeValue";
        WebElement host = (WebElement)driver.executeScript(script);
//        WebElement lname = (WebElement) driver.executeScript( "return arguments[0].myRoot.querySelector('#lname')",host);
       driver.executeScript( "arguments[0].myRoot.querySelector('#lname').value='Sivashankar'",host);
//       lname.sendKeys("Sivashankar");
//        org.openqa.selenium.ElementNotInteractableException: element not interactable

//If you try to use sendkeys in a closed shadow dom element, you get this exception

    }
}


