import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTest {

    @Test
    public static void dropdownTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dropdown");
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
