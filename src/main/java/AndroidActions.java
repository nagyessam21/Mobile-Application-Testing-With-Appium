import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions {
    protected AndroidDriver driver;
    public AndroidActions(AndroidDriver driver)
    {
        this.driver=driver;
    }
    public void clickOnElement(By tab)
    {
        driver.findElement(tab).click();
    }
    public void sendKeysForElement(String content,By locator)
    {
        driver.findElement(locator).sendKeys(content);
    }
    public void scrollToElement(String name)
    {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+name+"\"));"));
    }
    public double switchStringToDouble(String text)
    {
        String cleanStr1 = text.replaceAll("[^\\d.]", "");
        double number1 = Double.parseDouble(cleanStr1);
        return number1;
    }
    public void longPressFunction(By locator)
    {
        WebElement element=driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("mobile:longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement) element).getId(),"duration","2000"));
    }
}
