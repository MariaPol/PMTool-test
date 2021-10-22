package utils.elements.primeng;

import utils.elements.common.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PDropdown extends Select {

    public PDropdown() {

    }

    //applicable for p-dropdown elements (PrimeNG Angular)
    public void singleSelect(WebElement element, String menuItem) {
        super.singleSelect(element, menuItem);
    }

    public void singleSelectReactive(WebElement element, String menuItem) {
        super.singleSelectReactive(element, menuItem);
    }
}
