package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Base;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebActions extends Base {

    @Step("get an element text")
    public static String getText(WebElement element){
        return element.getText();
    }



}
