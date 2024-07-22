import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFormTests extends BaseTest{
private By countriesDropDown=By.id("com.androidsample.generalstore:id/spinnerCountry");
private By selection=By.xpath("//android.widget.TextView[@text=\"Albania\"]");
private By maleRadioButton=By.id("com.androidsample.generalstore:id/radioMale");
private By femaleRadioButton=By.id("com.androidsample.generalstore:id/radioFemale");
private By letsGoButton=By.id("com.androidsample.generalstore:id/btnLetsShop");
private By nameField=By.id("com.androidsample.generalstore:id/nameField");
private By productsWord=By.xpath("//android.widget.TextView[@text=\"Products\"]");


    //Verify that user can navigate to the shop after filling the form
    @Test(priority = 0)
    public void verifyUserCanNavigateToShopAfterFillForm()
    {
        loginFormPage.fillDataOfTheForm("Albania","male","Nagy Essam");
        ProductsPage productsPage = loginFormPage.clickOnLetsGoButton();
        Assert.assertTrue(productsPage.checkValidityOfNavigateToProductsPage());
    }

    //verify user cannot go shopping, if he didn't login
    @Test
    public void verifyUserCannotShopIfHeDidnotEnterRequiredFields()
    {
        loginFormPage.clickOnLetsGoButton();
        Assert.assertEquals(loginFormPage.validationAlert(),"Please enter your name");
    }

    //verify user can select any of the radio buttons
    @Test
    public void verifySelectingRadioButtons()
    {
        loginFormPage.fillDataOfTheForm("Albania","Female","Nada Essam");
        ProductsPage productsPage = loginFormPage.clickOnLetsGoButton();
        Assert.assertTrue(productsPage.checkValidityOfNavigateToProductsPage());
    }

    //verify user can select country from the drop down list
    @Test
    public void selectCountryFromDropDown()
    {
        loginFormPage.selectFromCountries("Egypt");
        Assert.assertEquals(loginFormPage.getSelectedCountry(),"Egypt");
    }
}