package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import util.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {
    //public static WebDriver driver = new ChromeDriver();
    public static Properties prop;
    public static WebDriver driver;

    public  static EventFiringWebDriver e_driver;
    //public static WebEventListener eventListener;

    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "//src//main//java"
                    + "//config//config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void initialization(){
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "E:\\Software_Installation\\Drivers\\chromedriver-win64\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }
        else if(browserName.equals("FF")){
            System.setProperty("webdriver.gecko.driver", "E:\\Software_Installation\\Drivers\\chromedriver-win64\\geckodriver");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

    }



}