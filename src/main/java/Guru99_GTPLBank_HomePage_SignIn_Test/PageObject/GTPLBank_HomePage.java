package Guru99_GTPLBank_HomePage_SignIn_Test.PageObject;

import General.PageSettings.PageSettings;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GTPLBank_HomePage extends PageSettings
{
    public GTPLBank_HomePage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//form[@name='frmLogin']/.//input[@name='uid' and @type='text']")
    private WebElement userIDField;

    @FindBy(xpath = "//form[@name='frmLogin']/.//input[@name='password' and @type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//form[@name='frmLogin']/.//input[@name='btnLogin' and @type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='http://demo.guru99.com/']")
    private WebElement guru99BankHomePageLink;

    private String url = "http://demo.guru99.com/V1/index.php";
    private String expectedResult = "GTPL Bank Home Page";


    public void goToGPTLBank()
    {
        driver.navigate().to(url);
        Assert.assertEquals(expectedResult, driver.getTitle());
    }


    public Guru99Bank_HomePage visitGettingSignInAccessSite()
    {
        wait.until(ExpectedConditions.visibilityOf(guru99BankHomePageLink));
        guru99BankHomePageLink.click();

        return new Guru99Bank_HomePage(driver, wait);
    }


    public Guru99ManagerHomePage signIn(String userID, String password)
    {
        wait.until(ExpectedConditions.visibilityOf(userIDField));
        userIDField.sendKeys(userID);
        passwordField.sendKeys(password);
        loginButton.submit();

        return new Guru99ManagerHomePage(driver, wait);
    }
}
