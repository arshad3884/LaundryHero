package laundryhero.resources;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPathUtils {
    public static int getXPathIndex(WebDriver driver, WebElement element) {
        if (driver instanceof JavascriptExecutor) {
            return (int) ((JavascriptExecutor) driver).executeScript(
                "function getElementXPath(element) {" +
                "   if (element && element.id) {" +
                "       return 'id(\"' + element.id + '\")';" +
                "   } else {" +
                "       return getElementTreeXPath(element);" +
                "   }" +
                "}" +
                "function getElementTreeXPath(element) {" +
                "   var paths = [];" +
                "   for (; element && element.nodeType == 1; element = element.parentNode) {" +
                "       var index = 0;" +
                "       for (var sibling = element.previousSibling; sibling; sibling = sibling.previousSibling) {" +
                "           if (sibling.nodeType == Node.DOCUMENT_TYPE_NODE) {" +
                "               continue;" +
                "           }" +
                "           if (sibling.nodeName == element.nodeName) {" +
                "               ++index;" +
                "           }" +
                "       }" +
                "       var tagName = element.nodeName.toLowerCase();" +
                "       var pathIndex = (index ? '[' + (index + 1) + ']' : '');" +
                "       paths.splice(0, 0, tagName + pathIndex);" +
                "   }" +
                "   return paths.length ? '/' + paths.join('/') : null;" +
                "}" +
                "return getElementXPath(arguments[0]);", element
            );
        } else {
            throw new IllegalStateException("This driver does not support JavaScript execution.");
        }
    }
}
