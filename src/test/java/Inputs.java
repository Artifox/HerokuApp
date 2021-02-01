import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Inputs {

    public static final String INPUTS_URL = "http://the-internet.herokuapp.com/inputs";

    @Test
    public void enterNumbersTest() {
        WebDriver driver = UtilityWebDriver.open(INPUTS_URL);
        driver.findElement(By.tagName("input")).sendKeys("1234567890");
        String numbersResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(numbersResult, "1234567890", "ERROR: It's impossible to enter numeric values");
        driver.quit();
    }

    @Test
    public void enterSymbolsTest() {
        WebDriver driver = UtilityWebDriver.open(INPUTS_URL);
        driver.findElement(By.tagName("input")).sendKeys("abcdefg");
        String numbersResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(numbersResult, "", "ERROR: It's possible to enter symbols");
        driver.quit();
    }

    @Test
    public void enterSpecialCharactersTest() {
        WebDriver driver = UtilityWebDriver.open(INPUTS_URL);
        driver.findElement(By.tagName("input")).sendKeys("!@#$%^&*()_+");
        String numbersResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(numbersResult, "", "ERROR: It's possible to enter special characters");
        driver.quit();
    }

    @Test
    public void increaseValueByArrowUpTest() {
        WebDriver driver = UtilityWebDriver.open(INPUTS_URL);
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys(Keys.ARROW_UP);
        input.sendKeys(Keys.ARROW_UP);
        String numbersResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(numbersResult, "2", "ERROR: Value wasn't increased");
        driver.quit();
    }

    @Test
    public void decreaseValueByArrowDownTest() {
        WebDriver driver = UtilityWebDriver.open(INPUTS_URL);
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys(Keys.ARROW_DOWN);
        input.sendKeys(Keys.ARROW_DOWN);
        String numbersResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(numbersResult, "-2", "ERROR: Value wasn't decreased");
        driver.quit();
    }

}
