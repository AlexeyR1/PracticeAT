package HnMTest;

import HnM.PageObject.ItemToShopPage;
import HnM.PageObject.Men_NewProducts_ViewAll_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingBagTest extends HnMTestSettings
{
    @Test
    public void addItemToShoppingBag()
    {
        String expectedResult = "1";

        Men_NewProducts_ViewAll_Page menProductsPage = new Men_NewProducts_ViewAll_Page(driver, wait);
        menProductsPage.goToMenProductsPage();

        // Переходим на страницу указанного по номеру элемента
        ItemToShopPage itemPage = menProductsPage.goToItemToShopPage(1);
        itemPage.chooseItemSize();
        itemPage.addItemToBag();

        Assert.assertEquals(itemPage.getItemInShoppingBagCount(), expectedResult);
    }
}
