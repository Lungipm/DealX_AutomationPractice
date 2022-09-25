package Tests;

import Configurations.TakeScreenshots;
import Configurations.browserSetup;
import Configurations.extentReport;
import Pages.HomePage;
import com.aventstack.extentreports.Status;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;


public class TC2_search_for_item_loop extends extentReport {

    public TC2_search_for_item_loop() throws IOException {}

    public static String dir = System.getProperty("user.dir");
    String dataSheet = dir + ("/TestData/searchItem.xlsx");
    FileInputStream fis = new FileInputStream(dataSheet);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);

    //Navigate to website
    WebDriver driver = browserSetup.startBrowser("Chrome", "http://automationpractice.com/index.php");
    HomePage home = PageFactory.initElements(driver, HomePage.class);
    TakeScreenshots takingScreenshot = PageFactory.initElements(driver, TakeScreenshots.class);

    @Test
    public void Searching_for_an_Item() throws InterruptedException {

        //reading Search Item from datasheet
        XSSFSheet sheet = workbook.getSheetAt(0);
        String searchItem = sheet.getRow(1).getCell(0).getStringCellValue();

        test = extent.createTest("Search", "Search for Item");
        test.log(Status.INFO, "****Home: Search for Item test has started****");
        takingScreenshot.takeSnapshot(driver, "Home Page"); //use wherever a screenshot is needed

        home.enterSearchItem(searchItem);
        Thread.sleep(2000);
        home.clicking_searchButton();
        home.verify_search_success();
        takingScreenshot.takeSnapshot(driver, "Captured Search Item");

        test.log(Status.INFO, "*****Search: Searched Item is successfully returned");

    }

    /**
    @AfterTest
    public void closeBrowsers() {
    driver.quit();
    }
    **/
}
