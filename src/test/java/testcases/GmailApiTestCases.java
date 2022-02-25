package testcases;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflow.GmailApiWorkFlow;

import javax.mail.MessagingException;
import java.io.IOException;

public class GmailApiTestCases extends CommonOps {

    @Test(priority = 1, description = "Retrieve a specific inbox in your Gmail account")
    @Description("test 01 will Retrieve a specific inbox in your Gmail account with email and password")
    public void test01() throws MessagingException, IOException {
        GmailApiWorkFlow.checkInbox();
    }
}
