import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TyposTest {

    public static final String URL = "http://the-internet.herokuapp.com/typos";

    @Test
    public static void isTyposPresent() {
        WebDriver driver = UtilityWebDriver.open(URL);
        List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
        String result = paragraphs.get(1).getText();
        Assert.assertEquals(result, "Sometimes you'll see a typo, other times you won't.", "Error: There is a typos");
        driver.quit();
    }
}
