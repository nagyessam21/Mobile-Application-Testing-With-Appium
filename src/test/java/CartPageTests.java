import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Set;

public class CartPageTests extends BaseTest{
    private By countriesDropDown=By.id("com.androidsample.generalstore:id/spinnerCountry");
    private By egyptSelections=By.xpath("//android.widget.TextView[@text=\"Egypt\"]");
    private By maleRadioButton=By.id("com.androidsample.generalstore:id/radioMale");
    private By letsGoButton=By.id("com.androidsample.generalstore:id/btnLetsShop");
    private By nameField=By.id("com.androidsample.generalstore:id/nameField");
    private By cartIcon=By.id("com.androidsample.generalstore:id/appbar_btn_cart");
    private By termsAndConditions=By.xpath("//android.widget.TextView[@text=\"Please read our terms of conditions\"]");
    private By termsAndConditionsTitle=By.xpath("//android.widget.TextView[@text=\"Terms Of Conditions\"]");
    private By emailCheckBox=By.className("android.widget.CheckBox");
    private By loginButton=AppiumBy.androidUIAutomator("new UiSelector().text(\"تسجيل الدخول\")");
    private By proceedButton=By.xpath("//android.widget.Button[@text=\"Visit to the website to complete purchase\"]");
    private By searchFieldForGoogle= By.name("q");
    private WebDriverWait wait;

   // Verify user can see the terms and conditions of the app
    @Test
    public void showTermsAndConditions()
    {
        ProductsPage productsPage = loginFormPage.loginSuccessfully("Albania", "Male", "Nagy Essam");
        productsPage.scrollToElement("Converse All Star");
        String jordanLiftOffFromPage = productsPage.addTheProductToCart("Converse All Star");
        CartPage cartPage = productsPage.clickOnCartIcon();
        cartPage.readTheTermsAndConditions();
        Assert.assertTrue(cartPage.checkTheValidityOfAppearingTermsAndConditions());
    }

    //verify user can select the checkbox successfully
    @Test
    public void selectTheCheckbox()
    {
        ProductsPage productsPage = loginFormPage.loginSuccessfully("Albania", "Male", "Nagy Essam");
        productsPage.scrollToElement("Converse All Star");
        String jordanLiftOffFromPage = productsPage.addTheProductToCart("Converse All Star");
        CartPage cartPage = productsPage.clickOnCartIcon();
        cartPage.checkTheCheckBox();
        Assert.assertEquals(cartPage.checkTheValidityOfChecking(),"true");
    }

//    verify user can navigate to the proceed page by clicking on the button
    @Test
    public void proceedToCheckOut() throws InterruptedException {
        ProductsPage productsPage = loginFormPage.loginSuccessfully("Albania", "Male", "Nagy Essam");
        productsPage.scrollToElement("Converse All Star");
        String converseAllStar = productsPage.addTheProductToCart("Converse All Star");
        CartPage cartPage = productsPage.clickOnCartIcon();
        BrowserPage browserPage = cartPage.clickOnProceedButton();
        browserPage.searchForSomething("Success");
    }
}