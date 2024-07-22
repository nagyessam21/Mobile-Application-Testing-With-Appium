import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BrowserPage extends AndroidActions {
    private AndroidDriver driver;
    private WebDriverWait wait;
    private By searchFieldForGoogle = By.name("q");
    private By searchResults = By.className("android.view.View");
    private By products = By.xpath("//a[text()=\"Browse Products\"]");

    public BrowserPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void searchForSomething(String contentToSearch) throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(20));
        driver.context("WEBVIEW_com.androidsample.generalstore");
        sendKeysForElement(contentToSearch, searchFieldForGoogle);
        driver.findElement(searchFieldForGoogle).sendKeys(Keys.ENTER);
    }

    public void searchByMobileBrowser(String content) {
        sendKeysForElement(content, searchFieldForGoogle);
        driver.findElement(searchFieldForGoogle).sendKeys(Keys.ENTER);
    }

    public void navigateToURL(String url) {
        driver.get(url);
    }

    public List<WebElement> getSearchResults()
    {
        return driver.findElements(searchResults);
    }
    public void scrollInBrowserPage()
    {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)","");
    }
    public BrowserProductsPage clickOnProducts()
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(products));
        clickOnElement(products);
        return new BrowserProductsPage(driver);
    }
    
}