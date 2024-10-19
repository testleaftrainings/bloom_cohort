import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class JQueryWithXPathExample {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();

        driver.get("https://example.com"); // Replace with your target URL

        // Inject jQuery into the page (if not already present)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("if (typeof jQuery == 'undefined') {"
                + "var script = document.createElement('script');"
                + "script.src = 'https://code.jquery.com/jquery-3.6.0.min.js';"
                + "document.head.appendChild(script);"
                + "}");

        // Wait for jQuery to load (you can use WebDriverWait for better synchronization)
        Thread.sleep(3000);

        // Now use XPath to find an element and manipulate it using jQuery
        String xpathExpression = "//div[@class='example-class']"; // Replace with your XPath
        WebElement element = (WebElement) js.executeScript(
                "return document.evaluate(arguments[0], document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;",
                xpathExpression);

        // You can now manipulate the element with jQuery (e.g., change text or CSS)
        js.executeScript("$(arguments[0]).css('background-color', 'yellow');", element);
        js.executeScript("$(arguments[0]).text('Text changed using jQuery');", element);

        // Optionally, print the element's new text or check other properties
        String newText = element.getText();
        System.out.println("New text: " + newText);

        // Close the browser
        driver.quit();


    }
}
