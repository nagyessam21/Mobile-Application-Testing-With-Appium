import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;

public class ProductsPage extends AndroidActions{
    private AndroidDriver driver;
    private By productsWord=By.xpath("//android.widget.TextView[@text=\"Products\"]");
    private By jordanLiftOff=By.xpath("//android.widget.TextView[@text=\"Jordan Lift Off\"]");
    private By addToCartButton=By.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]");
    private By productsToList=By.id("com.androidsample.generalstore:id/productName");
    private By cartIcon=By.id("com.androidsample.generalstore:id/appbar_btn_cart");
    private By totalAmountInCart=By.id("com.androidsample.generalstore:id/totalAmountLbl");
    private By productName= AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productName\")");
    private By productPrice=AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productPrice\")");
    public ProductsPage(AndroidDriver driver)
    {
        super(driver);
        this.driver=driver;
    }
    public Boolean checkValidityOfNavigateToProductsPage()
    {
        return driver.findElement(productsWord).isDisplayed();
    }
    public String addTheProductToCart(String nameProduct)
    {
        String productNameFromPage=null;
        int j=0;
        int listSize = driver.findElements(productsToList).size();
        for (int i=0;i<listSize;i++)
        {
            productNameFromPage=driver.findElements(productsToList).get(i).getText();
            if (productNameFromPage.equalsIgnoreCase(nameProduct))
            {
                j=i;
                break;
            }
        }
        driver.findElements(addToCartButton).get(j).click();
        return productNameFromPage;
    }
    public CartPage clickOnCartIcon()
    {
        driver.findElement(cartIcon).click();
        return new CartPage(driver);
    }
}

