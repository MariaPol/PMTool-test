package utils.elements.common;

import utils.BaseTest;
import utils.common.Verifications;
import org.openqa.selenium.By;

public class Table extends BaseTest {

    protected String tableId;

    public String getTableId() {
        return tableId;
    }

    protected Table goToFirstPage(String tableID) {
        return null;
    }

    protected Table goToNextPage(String tableID) {
        return null;
    }

    protected Boolean isGoToFirstPageButtonEnabled(String tableID) {
        return false;
    }

    protected Boolean isGoToNextPageButtonEnabled(String tableID) {
        return false;
    }

    protected Boolean isGoToLastPageButtonEnabled(String tableID) {
        return false;
    }

    protected Boolean isGoToPreviousPageButtonEnabled(String tableID) {
        return false;
    }

    protected Boolean isNotLastRow(int id) {
        return Verifications.isElementPresent(By.xpath(".//tr[contains(@id,':" + id + "')]"));
    }

    protected Boolean isFieldPresentInTable(String pTableID, String text) {
        boolean found = false;
        while (!found) {
            if (Verifications.isElementPresent(By.xpath(".//td[contains(.,'" + text + "')]"))) {
                return true;
            }
            if (!isGoToNextPageButtonEnabled(pTableID)) {
                found = true;
            }
            goToNextPage(pTableID);
        }

        return false;
    }

    @Override
    public boolean exists(String pTableID) {
        return Verifications.isElementPresent(By.xpath("//p-table[@id='"+ pTableID +"']"));
    }

    @Override
    protected Table log(String logText) {
        super.log(logText);
        return this;
    }
}
