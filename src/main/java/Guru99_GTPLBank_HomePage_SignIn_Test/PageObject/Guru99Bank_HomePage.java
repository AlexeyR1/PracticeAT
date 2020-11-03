package Guru99_GTPLBank_HomePage_SignIn_Test.PageObject;

import General.PageSettings.PageSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Guru99Bank_HomePage extends PageSettings
{
    public Guru99Bank_HomePage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//form[@name='frmLogin']/.//input[@name='emailid' and @type='text']")
    private WebElement email;

    @FindBy(xpath = "//form[@name='frmLogin']/.//input[@name='btnLogin' and @type='submit']")
    private WebElement submitButton;


    public Guru99Bank_HomePageWithSignInData getSignInAccess(String email)
    {
        wait.until(ExpectedConditions.visibilityOf(this.email));
        this.email.sendKeys(email);
        submitButton.submit();

        return new Guru99Bank_HomePageWithSignInData(driver, wait);
    }
}
