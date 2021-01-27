import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddRemoveElementsTest {

    @Test
    public void amountOfDeleteButtonsTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();
        addElementButton.click();
        driver.findElements(By.xpath("//button[text()='Delete']")).get(1).click();
        int numberOfButtons = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(numberOfButtons, 1, "There are less Delete buttons than expected ");
        driver.quit();
    }
}
