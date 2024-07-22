import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BrowserBaseTest {
    protected AndroidDriver driver;
    protected BrowserPage browserPage;
    @BeforeMethod
    public void setUP() throws URISyntaxException, MalformedURLException {
        UiAutomator2Options options=new UiAutomator2Options();
        options.setDeviceName("EmulatorFinal");
        options.setCapability("browserName","Chrome");
        options.setApp("C:\\Users\\welcome\\IdeaProjects\\E-CommerceMobileApp\\src\\test\\resources\\General-Store.apk");
        driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browserPage=new BrowserPage(driver);
    }
}