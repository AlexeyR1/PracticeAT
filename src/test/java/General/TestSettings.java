package General;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestSettings
{
    protected WebDriver     driver;
    protected WebDriverWait wait;

    private final int howLongToWait = 4;


    @BeforeTest
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait   = new WebDriverWait(driver, howLongToWait);

        driver.manage().window().maximize();
    }


    @AfterTest
    public void cleanUp() { driver.quit(); }
}
