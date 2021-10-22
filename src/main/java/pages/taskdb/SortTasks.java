package pages.taskdb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.BaseTest;
import utils.common.Wait;
import utils.elements.common.Link;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTasks extends BaseTest {

    @FindBy(id = "sort_tasks")
    @CacheLookup
    WebElement sortTasksBtn;

    Link link = new Link();

    public SortTasks() {
        initPageFactory();
    }

    public SortTasks log(String logText) {
        super.log(logText);
        return this;
    }

    public SortTasks sortBySummary() {
        link.clickAction(sortTasksBtn);
        return this;
    }

    public SortTasks verifySortingTask(String sortingOrder) {
        Wait.forPageToLoad();
        ArrayList<String> obtainedList = new ArrayList<>();
        List<WebElement> elementList = driver.findElements(By.id("items"));
        for (WebElement we : elementList) {
            obtainedList.add(we.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>(obtainedList);
        if (sortingOrder.equals("Ascending")){
            Collections.sort(sortedList);
        } else if (sortingOrder.equals("Descending")) {
            Collections.reverse(sortedList);
        }

        Collections.sort(sortedList);
        Assert.assertEquals(obtainedList, sortedList);
        return this;
    }
}


