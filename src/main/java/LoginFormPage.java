import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginFormPage extends AndroidActions{
    private AndroidDriver driver;
    private By countriesDropDown=By.id("com.androidsample.generalstore:id/spinnerCountry");
    private By maleRadioButton=By.id("com.androidsample.generalstore:id/radioMale");
    private By femaleRadioButton=By.id("com.androidsample.generalstore:id/radioFemale");
    private By letsGoButton=By.id("com.androidsample.generalstore:id/btnLetsShop");
    private By nameField=By.id("com.androidsample.generalstore:id/nameField");
    private By toastMessageAlert=By.xpath("//android.widget.Toast");
    private By selectedCountry=By.xpath("//android.widget.Spinner/android.widget.TextView");

    public LoginFormPage(AndroidDriver driver)
    {
        super(driver);
        this.driver=driver;
    }
    public ProductsPage clickOnLetsGoButton()
    {
        clickOnElement(letsGoButton);
        return new ProductsPage(driver);
    }
    public void selectFromCountries(String name)
    {
        clickOnElement(countriesDropDown);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+name+"\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text=\""+name+"\"]")).click();
    }
    public void fillDataOfTheForm(String countryName,String gender,String name) {
        selectFromCountries(countryName);
        sendKeysForElement(name,nameField);
        driver.hideKeyboard();
        if (gender.equalsIgnoreCase("male"))
        {
            clickOnElement(maleRadioButton);
        }
        else if (gender.equalsIgnoreCase("Female"))
        {
            clickOnElement(femaleRadioButton);
        }
    }
    public String validationAlert()
    {
        return driver.findElement(toastMessageAlert).getText();
    }
    public  String getSelectedCountry()
    {
        return driver.findElement(selectedCountry).getText();
    }
    public ProductsPage loginSuccessfully(String countryName,String gender,String name)
    {
        fillDataOfTheForm(countryName,gender,name);
        clickOnElement(letsGoButton);
        return new ProductsPage(driver);
    }
}