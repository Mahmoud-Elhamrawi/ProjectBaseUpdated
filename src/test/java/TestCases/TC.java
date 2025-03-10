package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.log.Log;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

import static Factory.DriverFactory.*;
import Listeners.IInvokedListeners ;
import Listeners.ITestListeners ;
import utilities.DataUtils;
import utilities.LogsUtils;


@Listeners({IInvokedListeners.class,ITestListeners.class})
public class TC {

    WebDriver driver ;
    @BeforeMethod
    public void setUp() throws IOException {


        setUpDriver(DataUtils.readPropertiesFile("ENV","BrowserName"))   ;
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get("https://www.google.com/ncr");

    }


    @Test
    public void testValid()
    {
        LogsUtils.info("welcome.........");
    }


    @AfterMethod
    public void tearDown()
    {
        tearDownDriver();
    }
}
