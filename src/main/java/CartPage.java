import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CartPage extends AndroidActions{
    private AndroidDriver driver;
    private By totalAmountInCart=By.id("com.androidsample.generalstore:id/totalAmountLbl");
    private By proceedButton=By.xpath("//android.widget.Button[@text=\"Visit to the website to complete purchase\"]");
    private By termsAndConditions=By.xpath("//android.widget.TextView[@text=\"Please read our terms of conditions\"]");
    private By termsAndConditionsTitle=By.xpath("//android.widget.TextView[@text=\"Terms Of Conditions\"]");
    private By emailCheckBox=By.className("android.widget.CheckBox");
    private By productNameFromCart= AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productName\")");
    private By productPriceFromCart=AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productPrice\")");


    public CartPage (AndroidDriver driver)
    {
        super(driver);
        this.driver=driver;
    }
    public String getTheNameOfTheProductsFromCart(int i)
    {
        return driver.findElements(productNameFromCart).get(i).getText();
    }
    public double getThePriceFromCart(int i)
    {
        return switchStringToDouble(driver.findElements(productPriceFromCart).get(i).getText());
    }
    public double totalAmountFromCart()
    {
        return switchStringToDouble(driver.findElement(totalAmountInCart).getText());
    }
    public void readTheTermsAndConditions()
    {
        longPressFunction(termsAndConditions);
    }
    public boolean checkTheValidityOfAppearingTermsAndConditions()
    {
        return driver.findElement(termsAndConditionsTitle).isDisplayed();
    }
    public void checkTheCheckBox()
    {
        driver.findElement(emailCheckBox).click();
    }
    public String checkTheValidityOfChecking()
    {
        return driver.findElement(emailCheckBox).getAttribute("checkable");
    }
    public BrowserPage clickOnProceedButton()
    {
        clickOnElement(proceedButton);
        return new BrowserPage(driver);
    }
}