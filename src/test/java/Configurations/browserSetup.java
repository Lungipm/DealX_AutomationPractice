package Configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class browserSetup {


    //Configuration of browsers
    public static String dir = System.getProperty("user.dir"); //getting current project directory
    public static String myChromedriver = dir + "/Drivers/chromedriver.exe";
    public static String mygeckodriver = dir + "/Drivers/geckodriver.exe";
    public static String myEdgedriver = dir + "Drivers/edgedriver.exe";
    static WebDriver driver;

    public static WebDriver startBrowser(String browserchoice, String url) {

        if ("fiRefox".equalsIgnoreCase(browserchoice)) {
            System.setProperty("webdriver.gecko.driver", mygeckodriver);
            driver = new FirefoxDriver();

        } else if ("chRome".equalsIgnoreCase(browserchoice)) {
            System.setProperty("webdriver.chrome.driver", myChromedriver);
            driver = new ChromeDriver();

        } else {
            System.setProperty("webdriver.edge.driver", myEdgedriver);
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }



}
