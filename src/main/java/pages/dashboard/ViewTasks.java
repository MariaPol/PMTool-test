package pages.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BaseTest;
import utils.common.Verifications;
import utils.common.Wait;
import utils.elements.common.Link;
import java.util.Properties;

public class ViewTasks extends BaseTest {

    private final static String SUMMARY = "Summary";
    private final static String FROM = "Status";
    private final static String TO = "Status";
    private Link link = new Link();

    public ViewTasks() {
        initPageFactory();
    }

    public ViewTasks log(String logText) {
        super.log(logText);
        return this;
    }

    public ViewTasks moveTask(Properties params2) {
        WebElement fromStatus = getDriver().findElement(By.xpath("//div[@draggable='true']"));
        WebElement toStatus = getDriver().findElement(By.xpath("//div[@status='" + params2.getProperty(TO) + "']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", fromStatus, toStatus);
        return this;
    }

    public ViewTasks verifyMoveTask(Properties params1, Properties params2) {
        Wait.forPageToLoad();
        Assert.assertFalse(Verifications.isElementPresent(By.xpath("//*[@status='" + params1.getProperty(FROM) + "']//child::*[contains(text(),'" + params1.getProperty(SUMMARY) + "')]")));
        Assert.assertTrue(Verifications.isElementPresent(By.xpath("//*[@status='" + params2.getProperty(TO) + "']//child::*[contains(text(),'" + params1.getProperty(SUMMARY) + "')]")));
        return this;
    }
}
