package utils.elements.common;

import org.openqa.selenium.interactions.Actions;
import utils.common.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Select extends Button {

    public Select() {

    }

    public void singleSelect(WebElement element, String menuItem) {
        if (menuItem != null && !menuItem.isEmpty()) {
            clickAction(element);
            Wait.forPageToLoad();
            WebElement itemToSelect = element.findElement(By.xpath("//li[@role='option' and @aria-label='"
                    + menuItem + "']"));
            Wait.forElement(itemToSelect);
            click(itemToSelect);
            Wait.forPageToLoad();
        }
    }

    protected void singleSelectReactive(WebElement element, String menuItem) {
        if (menuItem != null && !menuItem.isEmpty()) {
            clickAction(element);
            Wait.forPageToLoad();
            WebElement itemToSelect = element.findElement(By.xpath("(//p-dropdown//*[contains(text(),\""
                    + menuItem + "\")]//parent::li)"));
            Wait.forElement(itemToSelect);
            click(itemToSelect);
            Wait.forPageToLoad();
        }
    }

    public void simpleSelect(WebElement element, String menuItem) {
        if (menuItem != null && !menuItem.isEmpty()) {
            clickAction(element);
            Wait.forPageToLoad();
            WebElement itemToSelect = element.findElement(By.xpath("//*[@class='" + element.getAttribute("class") + "']//following::li[contains(.,'" + menuItem + "')]"));
            Wait.forElement(itemToSelect);
            clickAction(itemToSelect);
            Wait.forPageToLoad();
        }
    }
}