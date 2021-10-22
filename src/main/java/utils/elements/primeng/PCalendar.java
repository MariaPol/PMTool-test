package utils.elements.primeng;

import utils.elements.common.Button;
import utils.elements.common.Input;
import org.openqa.selenium.WebElement;

public class PCalendar extends Button {

    Input input = new Input();

    public PCalendar() {
    }

    public Input getInput() {
        return input;
    }

    @Override
    public void click(WebElement element) {
        super.click(element);
    }

    @Override
    public void clickJS(WebElement element) {
        super.clickJS(element);
    }

}
