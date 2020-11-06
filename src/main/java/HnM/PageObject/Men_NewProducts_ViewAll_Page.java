package HnM.PageObject;

import General.PageSettings.PageSettings;
import HnM.Elements.ItemToShopElement;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Men_NewProducts_ViewAll_Page extends PageSettings
{
    public Men_NewProducts_ViewAll_Page(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@id='page-content']/.//ul[@class='products-listing small']/li")
    private List<WebElement> elementList;

    private       List<ItemToShopElement> itemToShopList    = new ArrayList<>();
    private final String                  expectedPageTitle = "Просмотреть все | H&M RU";


    public void goToMenProductsPage()
    {
        driver.navigate().to("https://www2.hm.com/ru_ru/muzhchiny/novye-postupleniya/view-all.html");
        Assert.assertEquals(expectedPageTitle, driver.getTitle());

        InitializeItemList();
    }


    public ItemToShopPage goToItemToShopPage(int index)
    {
        try
        {
            itemToShopList.get(index).getLinkToItemPage().click();
        }
        catch (IndexOutOfBoundsException exception)
        {
            System.out.println(exception.getMessage());
        }

        return new ItemToShopPage(driver, wait);
    }


    // Чтобы не заниматься такими приколами нужно иметь возможность применять FindBy к элементу-контейнеру
    private void InitializeItemList()
    {
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));

        elementList.forEach(item -> itemToShopList.add(new ItemToShopElement(item)));

        // Можно использовать методы от WebElement
        Assert.assertEquals("li", itemToShopList.get(0).getTagName());
    }
}
