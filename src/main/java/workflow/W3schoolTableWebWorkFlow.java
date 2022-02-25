package workflow;

import extensions.WebActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.CommonOps;



public class W3schoolTableWebWorkFlow extends CommonOps {


    @Step("retrieve the value by using getTableCellTextByXpath")
    public static String getTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText) throws Exception {
        return  getTableCellTextByXpath(table, searchColumn, searchText, returnColumnText);
    }
    @Step("using getTableCellText and returns true or false")
    public static boolean verifyTableCellText(WebElement table, int searchColumn, String searchText, int returnColumnText, String expectedText) throws Exception {
        return getTableCellText(table, searchColumn, searchText, returnColumnText).equals(expectedText);
    }
    @Step("retrieve the value by using xpath")
    public static String getTableCellTextByXpath(WebElement table, int searchColumn, String searchText, int returnColumnText) throws Exception {
        return WebActions.getText(table.findElement(By.xpath("//td["+searchColumn+"][contains(text(),'"+searchText+"')]/../td["+returnColumnText+"]")));
    }

}
