package General.PageSettings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageSettings
{
    public PageSettings(WebDriver driver, WebDriverWait wait)
    {
        this.driver = driver;
        this.wait   = wait;
    }


    protected WebDriver     driver;
    protected WebDriverWait wait;
}
