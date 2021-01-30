import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Dropdown {
    private static final String URL = "http://the-internet.herokuapp.com/dropdown";

    @Test
    public static void dropdownTest() {
        WebDriver driver = UtilityWebDriver.open(URL);
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        Assert.assertEquals(dropdownOptions.size(), 3);
        dropdown.selectByVisibleText("Option 1");
        String currentValueOfDropdown = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(currentValueOfDropdown, "Option 1");
        dropdown.selectByVisibleText("Option 2");
        currentValueOfDropdown = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(currentValueOfDropdown, "Option 2");
        driver.quit();
    }
}
