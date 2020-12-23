package HnM.Elements;

import General.Elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ItemToShopElement extends Element
{
    public ItemToShopElement(WebElement webElement)
    {
        super(webElement);

        image          = webElement.findElement(By.xpath(".//div[@class='image-container']/.//img"));
        linkToItemPage = webElement.findElement(By.xpath(".//div[@class='item-details']/.//a[@class='link']"));
    }


    public WebElement getLinkToItemPage() { return linkToItemPage; }


    private WebElement image;

    private WebElement linkToItemPage;
}
