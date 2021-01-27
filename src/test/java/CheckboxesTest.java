import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckboxesTest {

    public static final String CHECKBOXES_URL = "http://the-internet.herokuapp.com/checkboxes";

    @Test
    public static void isCheckboxSelectedTest() {
        //first checkbox test
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(CHECKBOXES_URL);
        boolean isFirstCheckboxSelected = driver.findElement(By.cssSelector("[type=checkbox]")).isSelected();
        Assert.assertEquals(isFirstCheckboxSelected, false);
        driver.findElement(By.cssSelector("[type=checkbox]")).click();
        isFirstCheckboxSelected = driver.findElement(By.cssSelector("[type=checkbox]")).isSelected();
        Assert.assertEquals(isFirstCheckboxSelected, true);
        //second checkbox test
        boolean isSecondCheckboxSelected = driver.findElement(By.cssSelector("[type=checkbox]")).isSelected();
        Assert.assertEquals(isSecondCheckboxSelected, true);
        driver.findElement(By.cssSelector("[type=checkbox]")).click();
        isSecondCheckboxSelected = driver.findElement(By.cssSelector("[type=checkbox]")).isSelected();
        Assert.assertEquals(isSecondCheckboxSelected, false);
        driver.quit();
    }
}
