import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkboxes {

    public static final String CHECKBOXES_URL = "http://the-internet.herokuapp.com/checkboxes";

    @Test
    public static void isCheckboxSelectedTest() {
        //first checkbox test
        WebDriver driver = UtilityWebDriver.open(CHECKBOXES_URL);
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
