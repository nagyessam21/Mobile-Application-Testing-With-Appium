import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest {
    protected AndroidDriver driver;
    protected LoginFormPage loginFormPage;

    @BeforeMethod
    public void setUP() throws URISyntaxException, MalformedURLException {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("EmulatorFinal");
        options.setApp("C:\\Users\\welcome\\IdeaProjects\\E-CommerceMobileApp\\src\\test\\resources\\General-Store.apk");
        driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginFormPage=new LoginFormPage(driver);

    }

    @AfterMethod
    public void quitDriver()
    {
    driver.quit();
    }


}

