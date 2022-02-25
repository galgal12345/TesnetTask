package pageobjects.w3schooltablepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class W3schoolTablePage {


    @FindBy(how = How.XPATH,using = "//*[@id=\"customers\"]")
    private WebElement table;


    public WebElement getTable() {
        return table;
    }
}
