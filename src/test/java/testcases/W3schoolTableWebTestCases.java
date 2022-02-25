package testcases;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import utilities.Utilities;
import workflow.W3schoolTableWebWorkFlow;

public class W3schoolTableWebTestCases extends CommonOps {

    @Test(priority = 1, description = "Verifing the table cell text")
    @Description("will get a company name and return the country name")
    public void test01() throws Exception {

        Verifications.verifyTrue(
                W3schoolTableWebWorkFlow.verifyTableCellText(

                        w3schoolTablePage.getTable(),
                       1,
                        Utilities.getDataXML("searchText"),
                        3,
                        Utilities.getDataXML("expectedText")));

    }
}
