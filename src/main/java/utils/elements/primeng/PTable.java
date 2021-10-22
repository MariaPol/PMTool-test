package utils.elements.primeng;

import utils.common.Verifications;
import utils.common.Wait;
import utils.config.resources.TestDataConfig;
import utils.elements.common.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class PTable extends Table {


    private final static String TABLE_HEADING_TITLE = "Table_Heading_Title";

    public PTable() {
        initPageFactory();
    }

    public Boolean isGoToFirstPageButtonEnabled(String tableID) {
        return Verifications
                .isElementPresent(
                        By.xpath("//p-table[@id='" + tableID + "']/descendant::*[@class = 'ui-paginator-icon pi pi-step-backward']"));
    }

    public Boolean isGoToNextPageButtonEnabled(String tableID) {
        return Verifications
                .isElementPresent(
                        By.xpath("//p-table[@id='" + tableID + "']/descendant::*[@class = 'ui-paginator-next ui-paginator-element ui-state-default ui-corner-all']"));
    }

    public Boolean isGoToLastPageButtonEnabled(String tableID) {
        return Verifications
                .isElementPresent(
                        By.xpath("//p-table[@id='" + tableID + "']/descendant::*[@class = 'ui-paginator-last ui-paginator-element ui-state-default ui-corner-all']"));
    }

    public Boolean isGoToPreviousPageButtonEnabled(String tableID) {
        return Verifications
                .isElementPresent(
                        By.xpath("//p-table[@id='" + tableID + "']/descendant::*[@class = 'ui-paginator-prev ui-paginator-element ui-state-default ui-corner-all']"));
    }

    public PTable goToNextPage(String tableID) {
        if (isGoToNextPageButtonEnabled(tableID)) {
            getDriver().findElement(By.xpath("//p-table[@id='" + tableID + "']/descendant::*[@class = 'ui-paginator-next ui-paginator-element ui-state-default ui-corner-all']")).click();
        } else {
            System.out.println("ERROR Element is NOT clickable.");
        }
        Wait.forPageToLoad();
        return this;
    }

    public PTable goToFirstPage(String tableID) {
        if (isGoToFirstPageButtonEnabled(tableID)) {
            getDriver().findElement(By.xpath("//p-table[@id='" + tableID + "']/descendant::*[@class = 'ui-paginator-first ui-paginator-element ui-state-default ui-corner-all']")).click();
        } else {
            System.out.println("ERROR Element is NOT clickable.");
        }
        Wait.forPageToLoad();
        return this;
    }

    protected Boolean isNotLastRow(int id) {
        return super.isNotLastRow(id);
    }


    public Boolean isFieldPresentInTable(String pTableID, String text) {
        return super.isFieldPresentInTable(pTableID, text);
    }

    @Override
    public boolean exists(String pTableID) {
        return super.exists(pTableID);
    }

    @Override
    public PTable log(String logText) {
        super.log(logText);
        return this;
    }


    /**
     * Verify table headings names with specific order
     *
     * @param params
     */
    public void verifyHeadingColumnOrder(Properties params) {

        List<String> headings = new ArrayList();

        headings = TestDataConfig.multipleOrSingleTestData(params, TABLE_HEADING_TITLE);

        for (String heading : headings) {
            Verifications.verifyTHOrder(getTableId(), heading, headings.indexOf(heading) + 1);
        }
    }
}
