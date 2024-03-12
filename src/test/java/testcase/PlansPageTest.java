package testcase;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PlansPage;
import util.TestUtil;
import java.util.List;

public class PlansPageTest extends TestBase {
    HomePage homePage;
    TestUtil testUtil;
    PlansPage plansPage;

    public PlansPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();
        homePage = new HomePage();
        plansPage = new PlansPage();
        homePage = homePage.selectLanguage();
        homePage = homePage.selectCurrency();
        plansPage = plansPage.selectCountry();
    }

    @Test(priority=1)
    public void verifyTripPlanTest(){

        List<WebElement> countries = driver.findElements(By.xpath("//*[@class = 'flex flex-col gap-4 justify-between p-4 rounded-[16px] bg-white overflow-hidden border-[#DBF879] border-2'][2]/div/div/div/div[1]"));
        for (WebElement selectTripPlan : countries)
        {
            String Location = selectTripPlan.getText().split("\n")[0];
            String Value = selectTripPlan.getText().split("\n")[1];
            if(Location.equals("Countries") && Value.equals("Thailand"))
            {

                System.out.printf("Countries "+":"  + Value);
            }else {
                Assert.fail("Text Not Matching");
            }

        }

        List<WebElement> data = driver.findElements(By.xpath("//*[@class = 'flex flex-col gap-4 justify-between p-4 rounded-[16px] bg-white overflow-hidden border-[#DBF879] border-2'][2]/div/div/div/div[2]"));
        for (WebElement selectTripPlan : data)
        {
            String DataPlan = selectTripPlan.getText().split("\n")[0];
            String GB = selectTripPlan.getText().split("\n")[1];
            if(DataPlan.equals("Data") && GB.equals("5 GB"))
            {

                System.out.printf("\n Data "+":"  + GB );
            }else {
                Assert.fail("Text Not Matching");
            }

        }

        List<WebElement> valid = driver.findElements(By.xpath("//*[@class = 'flex flex-col gap-4 justify-between p-4 rounded-[16px] bg-white overflow-hidden border-[#DBF879] border-2'][2]/div/div/div/div[3]"));
        for (WebElement selectTripPlan : valid)
        {
            String Validity = selectTripPlan.getText().split("\n")[0];
            String Days = selectTripPlan.getText().split("\n")[1];
            if(Validity.equals("Valid") && Days.equals("30 DAYS"))
            {

                System.out.printf("\n Valid "+":" +Days);
            }else {
                Assert.fail("Text Not Matching");
            }

        }

        List<WebElement> planType = driver.findElements(By.xpath("//*[@class = 'flex flex-col gap-4 justify-between p-4 rounded-[16px] bg-white overflow-hidden border-[#DBF879] border-2'][2]/div/div/div/div[4]"));
        for (WebElement selectTripPlan : planType)
        {
            String TypePlan = selectTripPlan.getText().split("\n")[0];
            String DataOnly = selectTripPlan.getText().split("\n")[1];
            if(TypePlan.equals("Plan type") && DataOnly.equals("Data only"))
            {

                System.out.printf("\n Plan type "+":" +DataOnly);
            }else {
                Assert.fail("Text Not Matching");
            }

        }

        List<WebElement> price = driver.findElements(By.xpath("//*[@class = 'flex flex-col gap-4 justify-between p-4 rounded-[16px] bg-white overflow-hidden border-[#DBF879] border-2'][2]/div/div/div/p"));
        for (WebElement selectTripPlan : price)
        {
            String SecondPlanPrice = selectTripPlan.getText();
            if(SecondPlanPrice.equals("9,29 €"))
            {

                System.out.printf("\n Price "+":"  +SecondPlanPrice);
            }else {
                Assert.fail("Text Not Matching");
            }

        }

    }
    @Test(priority=2)
    public void verifySecondPlanPriceTest(){

        List<WebElement> price = driver.findElements(By.xpath("//*[@class = 'flex flex-col gap-4 justify-between p-4 rounded-[16px] bg-white overflow-hidden border-[#DBF879] border-2'][2]/div/div/div/p"));
        for (WebElement selectTripPlan : price)
        {
            String SecondPlanPrice = selectTripPlan.getText();
            if(SecondPlanPrice.equals("9,39 €"))
            {

                System.out.printf("Second Plan Details \n" + SecondPlanPrice);
            }else {
                Assert.fail("Price Not Matching Expected Price is 9,39 € "+"Actual Price is:"  +SecondPlanPrice);
            }

        }
    }

    @AfterMethod
    public void tearDown(){

       driver.quit();
}

}
