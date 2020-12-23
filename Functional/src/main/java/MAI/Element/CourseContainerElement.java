package MAI.Element;

import General.Elements.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CourseContainerElement extends Element
{
    public CourseContainerElement(WebElement webElement)
    {
        super(webElement);
        courseNumber = webElement.findElement(By.xpath("h5[@class='sc-container-header sc-gray']"));
        departments  = webElement.findElements(By.xpath(".//a[@class='sc-table-col']"));
    }


    public WebElement courseNumber;

    public List<WebElement> departments;
}
