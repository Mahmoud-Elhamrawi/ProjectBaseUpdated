package utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class classesUtils {
    //TODO:: clicking on Ele
    public static void clickOnEle(WebDriver driver , By locator)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }


    //TODO :: send Text
    public static void sendText(WebDriver driver , By locator , String txt)
    {
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator)) ;
        driver.findElement(locator).sendKeys(txt);
    }


    //TODO:: Get Text
    public static String  getText(WebDriver driver , By locator)
    {
       return driver.findElement(locator).getText();
    }



    //TODO :: convert By to Web Element
    public static WebElement convertToWbEle(WebDriver driver , By locator)
    {
      return   driver.findElement(locator) ;
    }


    // TODO :: Scrolling
    public static void scrolling(WebDriver driver , By locator)
    {
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(locator)) ;
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",convertToWbEle(driver, locator)) ;
    }


    public static String screenShotsPath ="test-outputs/screenShots/";

    //TODO :: take screenshot
    public static void takeScreenShot(String  screenName, WebDriver driver) throws IOException {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE) ;
        File dis = new File(screenShotsPath+screenName+getTimeStamp()+".png");
        FileUtils.copyFile(src,dis);
        Allure.addAttachment(screenName , Files.newInputStream(Path.of(dis.getPath())));

    }

    //TODO ::  getLatestFiles
        public static File getLastFile(String pathFile) throws FileNotFoundException {
            File reader = new File(pathFile);
            File [] files = reader.listFiles();
            assert files != null;
                Arrays.sort(files, Comparator.comparing(File::lastModified).reversed());
            return files[0];
        }

    //TODO:: generate timestamp
      public static String getTimeStamp()
      {
          return new SimpleDateFormat("yyyy-MM-dd:h-m-ssa").format(new Date());
      }


}
