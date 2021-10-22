package utils.elements.common;

import utils.common.Wait;
import org.openqa.selenium.WebElement;

public class RadioButton extends Button {


    public RadioButton() {
    }

    public RadioButton click(WebElement radioButton, String value) {
        if (value.equalsIgnoreCase("1")) {
            radioButton.click();
            Wait.forPageToLoad();
        }
        return this;
    }
}
