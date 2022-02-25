package workflow;

import io.qameta.allure.Step;
import utilities.CommonOps;

import java.io.IOException;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;


public class GmailApiWorkFlow extends CommonOps {

    @Step("checks the Gmail Inbox")
    public static void checkInbox() throws MessagingException, IOException {

            //create the folder object and open it
            emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            messages = emailFolder.getMessages();
            System.out.println("you have: " + messages.length +" new massages");

            for (int i = 0; i < messages.length; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());

            }
            //close the store and folder objects
            emailFolder.close(false);
            store.close();

    }
}
