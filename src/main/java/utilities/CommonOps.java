package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pageobjects.w3schooltablepages.W3schoolTablePage;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.util.Properties;


public class CommonOps extends Base{

    @Parameters({"platform"})
    @BeforeClass
    public void startSession(String value) throws Exception {
        switch (value) {
            case "webDriver":
                myWebStarter();
                break;
            case "gmailPop3":
                myGmailApiStarter();
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Step("init WEB")
    public void myWebStarter() throws Exception {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get(url);
        webDriver.manage().window().maximize();
        action = new Actions(webDriver);
        //WEB_PAGE_FACTORY
        w3schoolTablePage = PageFactory.initElements(webDriver, W3schoolTablePage.class);
    }

    @Step("init API")
    public void myGmailApiStarter() throws MessagingException {

        //create properties field
        properties = new Properties();
        properties.put("mail.pop3.host", host);
        properties.put("mail.pop3.port", "995");
        properties.put("mail.pop3.starttls.enable", "true");
        emailSession = Session.getDefaultInstance(properties);

        //create the POP3 store object and connect with the pop server
        store = emailSession.getStore("pop3s");
        store.connect(host, username, password);
    }

    @AfterClass
    public void endSession() {
        if (webDriver != null) webDriver.quit();
    }

    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public static byte[] saveScreenshot() {
        if (Base.webDriver != null)
            return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        return null;
    }
}
