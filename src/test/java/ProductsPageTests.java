import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductsPageTests extends BaseTest{
    SoftAssert sftassrt=new SoftAssert();
    private By productsWord=By.xpath("//android.widget.TextView[@text=\"Products\"]");
    private By jordanLiftOff=By.xpath("//android.widget.TextView[@text=\"Jordan Lift Off\"]");
    private By addToCartButton=By.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]");
    private By productsToList=By.id("com.androidsample.generalstore:id/productName");
    private By cartIcon=By.id("com.androidsample.generalstore:id/appbar_btn_cart");
    private By totalAmountInCart=By.id("com.androidsample.generalstore:id/totalAmountLbl");
    private By productName=AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productName\")");
    private By productPrice=AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productPrice\")");


        //Verify user can add the element in the cart successfully
        @Test
        public void addElementToCart()
        {
            ProductsPage productsPage = loginFormPage.loginSuccessfully("Albania", "Male", "Nagy Essam");
            productsPage.scrollToElement("Jordan Lift Off");
            String productNameFromPage=productsPage.addTheProductToCart("Jordan Lift Off");
            CartPage cartPage = productsPage.clickOnCartIcon();
            String productNameFromCart=cartPage.getTheNameOfTheProductsFromCart(0);
            Assert.assertEquals(productNameFromCart,productNameFromPage);
        }

        //Verify user can add more than one element in the cart successfully
        @Test
        public void addMoreThanOneElementToCart()
        {
            ProductsPage productsPage = loginFormPage.loginSuccessfully("Albania", "Male", "Nagy Essam");
            productsPage.scrollToElement("Jordan Lift Off");
            String jordanLiftOffFromPage = productsPage.addTheProductToCart("Jordan Lift Off");
            productsPage.scrollToElement("PG 3");
            String pg3FromPage = productsPage.addTheProductToCart("PG 3");
            CartPage cartPage = productsPage.clickOnCartIcon();
            String jordanLiftOffFromCart = cartPage.getTheNameOfTheProductsFromCart(0);
            String pg3FromCart=cartPage.getTheNameOfTheProductsFromCart(1);
            sftassrt.assertEquals(jordanLiftOffFromPage,jordanLiftOffFromCart);
            sftassrt.assertEquals(pg3FromCart,pg3FromPage);
            sftassrt.assertAll();
        }

        //verify the total price is equal to the actual total price
        @Test
        public void checkTheTotalPrice()
        {
            ProductsPage productsPage = loginFormPage.loginSuccessfully("Albania", "male", "Nagy Essam");
            productsPage.scrollToElement("Jordan Lift Off");
            String jordanLiftOffFromPage = productsPage.addTheProductToCart("Jordan Lift Off");
            productsPage.scrollToElement("PG 3");
            String pg3FromPage = productsPage.addTheProductToCart("PG 3");
            CartPage cartPage = productsPage.clickOnCartIcon();
            double totalPriceFromPages = cartPage.getThePriceFromCart(0)+cartPage.getThePriceFromCart(1);
            double totalPriceFromCart=cartPage.totalAmountFromCart();
            Assert.assertEquals(totalPriceFromCart,totalPriceFromPages);
        }
    }

