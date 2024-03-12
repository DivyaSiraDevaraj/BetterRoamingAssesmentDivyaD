package testcase;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;

import util.TestUtil;

public class HomePageTest extends TestBase {

    HomePage homePage;
    TestUtil testUtil;



    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        testUtil = new TestUtil();

        homePage = new HomePage();
    }

    @Test(priority=1)
    public void verifySelectLanguageTest(){
        homePage = homePage.selectLanguage();
    }
    @Test(priority=2)
    public void verifySelectCurrencyTest(){

        homePage = homePage.selectLanguage();
        homePage = homePage.selectCurrency();

    }

}
