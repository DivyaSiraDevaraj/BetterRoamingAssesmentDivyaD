package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Currency;

public class HomePage extends TestBase {

    Actions action;
    Currency currency;
    @FindBy(xpath = "(//div[@class='cursor-pointer text-[14px] font-bold uppercase flex flex-row items-center'])[1]")
    @CacheLookup
    WebElement selectLanguage;
    @FindBy(xpath = "//button[contains(text(),'Currency')]")
    @CacheLookup
    WebElement currencyButton;
     @FindBy(xpath ="//div[@role=\"dialog\"]//div//div[2]")
     @CacheLookup
    WebElement selectCurrencies;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage selectLanguage()
    {
        selectLanguage.click();
        return new HomePage();
    }

    public HomePage selectCurrency()
    {
        currencyButton.click();

        selectCurrencies.click();


        return new HomePage();
    }

}
