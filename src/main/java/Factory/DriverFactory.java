package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    WebDriver driver ;

   public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public static void setUpDriver(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.setCapability("webSocketUrl", true);
                threadLocal.set(new ChromeDriver(options));
            break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions() ;
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.setCapability("webSocketUrl",true);
                threadLocal.set(new EdgeDriver(edgeOptions));
                break;
            default:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized") ;
                firefoxOptions.setCapability("webSocketUrl", true);
                threadLocal.set(new FirefoxDriver(firefoxOptions));
        }
    }


    public static WebDriver getDriver()
    {
        return threadLocal.get();
    }

    public static void tearDownDriver()
    {
        getDriver().quit();
        threadLocal.remove();
    }






}
