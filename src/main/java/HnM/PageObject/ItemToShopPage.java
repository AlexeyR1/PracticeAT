package HnM.PageObject;

import General.PageSettings.PageSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class ItemToShopPage extends PageSettings
{
    public ItemToShopPage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@id='picker-1']/button")
    private WebElement chooseSizeButton;

    @FindBy(xpath = "//div[@id='picker-1']/ul/li[@class='item  js-enable-nib' and @data-code!='']")
    private WebElement availableSizeOption;

    @FindBy(xpath = "//div[@id='picker-1']/following-sibling::button[@class='item button fluid button-big button-buy']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//span[@class='shoppingbag-item-count']")
    private WebElement itemInShoppingBagCount;

    @FindBy(xpath = "//div[@class='cookie-notification js-notification js-cookie-notification']/.//button")
    private WebElement closeCookieMessageButton;


    public String getItemInShoppingBagCount()
    {
        wait.until((driver) -> itemInShoppingBagCount.getText().equals("1"));

        return itemInShoppingBagCount.getText();
    }


    public void chooseItemSize()
    {
        // Сообщение мешает нажатию кнопки
        closeCookieMessage();

        if (chooseSizeButton.isEnabled())
        {
            chooseSizeButton.click();
            availableSizeOption.click();
        }
    }


    public void addItemToBag()
    {
        addToBagButton.click();
    }


    private void closeCookieMessage()
    {
        wait.until(ExpectedConditions.visibilityOf(closeCookieMessageButton));
        closeCookieMessageButton.click();
    }
}
