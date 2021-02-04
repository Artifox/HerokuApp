import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddRemoveElements {

    public static final String URL = "http://the-internet.herokuapp.com/add_remove_elements/";

    @Test
    public void amountOfDeleteButtonsTest() {
        WebDriver driver = UtilityWebDriver.open(URL);
        WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();
        addElementButton.click();
        driver.findElements(By.xpath("//button[text()='Delete']")).get(1).click();
        int numberOfButtons = driver.findElements(By.xpath("//button[text()='Delete']")).size();
        Assert.assertEquals(numberOfButtons, 1, "There are less Delete buttons than expected ");
        driver.quit();
    }
}
