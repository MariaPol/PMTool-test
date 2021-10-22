package utils.elements.common;

import org.openqa.selenium.WebElement;

public class Link extends Button {


    public Link() {
    }

    // Global handling of CLICKING an element (including WAIT for its existence)
    public void click(WebElement element) {
        super.click(element);
    }

    public void clickAction(WebElement element) {
        super.click(element);
    }

    public void clickJS(WebElement element) {
        super.clickJS(element);
    }

}
