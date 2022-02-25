package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageobjects.w3schooltablepages.W3schoolTablePage;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class Base {

    //WEB
    protected static WebDriver webDriver;

    //PAGES
    protected static W3schoolTablePage w3schoolTablePage;

    //ACTIONS
    protected static Actions action;

    //URL
    protected static String url = Utilities.getDataXML("Url");

    //API
    protected static String host = Utilities.getDataXML("host");
    protected static String mailStoreType = Utilities.getDataXML("mailStoreType");
    protected static String username = Utilities.getDataXML("username");
    protected static String password = Utilities.getDataXML("password");

    protected static Store store;
    protected static Properties properties;
    protected static Session emailSession;

    protected static Folder emailFolder;
    protected static Message[] messages;
}
