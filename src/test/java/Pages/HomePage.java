package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

    //Inspects elements

    WebDriver driver;

    //A constructor is to introduce this class for all the coding that will follow
    public HomePage(WebDriver driver) {this.driver = driver;}

    @FindBy(xpath = "//input[@id='search_query_top']")
    WebElement xpath_searchBox;

    @FindBy(xpath = "//button[contains(@name,'submit_search')]")
    WebElement xpath_SearchButton;

    @FindBy(xpath = "(//a[contains(.,'Blouse')])[4]")
    WebElement xpath_BlouseItem;

    public void enterSearchItem(String Item) {

        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(xpath_searchBox));
        xpath_searchBox.sendKeys(Item);
    }

    public void clicking_searchButton() {
        xpath_SearchButton.click();
    }

    public void verify_search_success() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(xpath_BlouseItem));
        Assert.assertTrue(xpath_BlouseItem.isDisplayed());
        System.out.println("Searched Item is available");

    }

}
