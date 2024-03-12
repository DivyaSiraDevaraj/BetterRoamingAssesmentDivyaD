package pages;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class PlansPage extends TestBase {
    @FindBy(xpath= "//div/a/div/div/div/p[contains(text(),'Thailand')]")
    @CacheLookup
    WebElement selectTripCountry;

    public PlansPage() {
        PageFactory.initElements(driver, this);
    }
    public PlansPage selectCountry()  {

       JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");

        Actions action = new Actions(driver);
        action.moveToElement(selectTripCountry).perform();

        selectTripCountry.click();
        return new PlansPage();


    }


}
