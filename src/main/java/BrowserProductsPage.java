import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserProductsPage extends AndroidActions{
    private AndroidDriver driver;
    private WebDriverWait wait;
    private By devopsTrack=By.xpath("//a[text()=\"Devops\"]");


    public BrowserProductsPage(AndroidDriver driver)
    {
        super(driver);
        this.driver=driver;
    }
    public String checkTheValidityOfTheScroll()
    {
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(devopsTrack));
        return driver.findElement(devopsTrack).getText();
    }
}
