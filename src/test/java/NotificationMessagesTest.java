import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NotificationMessagesTest {

    public static final String URL = "http://the-internet.herokuapp.com/notification_message_rendered";

    @Test
    public static void notificationAppear() {
        WebDriver driver = UtilityWebDriver.open(URL);
        WebElement parentElement = driver.findElement(By.className("example"));
        parentElement.findElement(By.tagName("a")).click();
        String rawResult = driver.findElement(By.cssSelector("div[class='flash notice']")).getAttribute("innerText");
        String finalResult = rawResult.substring(1, 18);
        Assert.assertEquals(finalResult, "Action successful", "ERROR: Action unsuccesful");
        driver.quit();
    }
}
