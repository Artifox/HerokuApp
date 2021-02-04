import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HoversTest {

    public static final String URL = "http://the-internet.herokuapp.com/hovers";

    @Test
    public static void hoversEndToEnd() {
        WebDriver driver = UtilityWebDriver.open(URL);
        Actions hover = new Actions(driver);
        int avatarsCount = driver.findElements(By.className("figure")).size();
        for (int i = 0; i < avatarsCount; i++) {
            hoverAndCheck(driver, hover, i);
        }
        driver.quit();
    }

    private static void hoverAndCheck(WebDriver driver, Actions hover, int numberOfItem) {
        List<WebElement> userAvatars = driver.findElements(By.className("figure"));
        hover.moveToElement(userAvatars.get(numberOfItem).findElement(By.cssSelector("img[alt='User Avatar']"))).build().perform();
        String name = userAvatars.get(numberOfItem).findElement(By.className("figcaption")).findElement(By.tagName("h5")).getText();
        userAvatars.get(numberOfItem).findElement(By.className("figcaption")).findElement(By.tagName("a")).click();
        String notFoundError = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(name, "name: user" + (numberOfItem + 1), "ERROR: Username is wrong");
        Assert.assertEquals(notFoundError, "Not Found", "ERROR: Not Found message is not found");
        driver.get(URL);
    }

}
