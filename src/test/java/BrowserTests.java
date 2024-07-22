import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class BrowserTests extends BrowserBaseTest{
    private By products=By.xpath("//a[text()=\"Browse Products\"]");
    private By devopsTrack=By.xpath("//a[text()=\"Devops\"]");
    private WebDriverWait wait;

    //Verify user can search by browser of the mobile
    @Test
    public void testSearchByGoogle() throws InterruptedException {
        browserPage.navigateToURL("http://google.com");
        browserPage.searchByMobileBrowser("Panda Giant");
        List<WebElement> searchResults = browserPage.getSearchResults();
        for (WebElement ele:searchResults)
        {
            Assert.assertTrue(ele.getText().contains("Panda"));
        }
    }

    //Verify scrolling in the browser of the mobile
    @Test
    public void testScrollByInBrowser()
    {
        browserPage.navigateToURL("https://rahulshettyacademy.com/angularAppdemo/");
        browserPage.scrollInBrowserPage();
        browserPage.clickOnProducts();
        browserPage.scrollInBrowserPage();
        Assert.assertEquals(browserPage.checkTheValidityOfTheScroll(),"Devops");
    }
}