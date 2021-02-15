package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DynamicControlsPage extends BasePage {

    public static final By CHECKBOX = By.id("checkbox");
    public static final By REMOVE_BUTTON = By.xpath("//button[text()='Remove']");
    public static final By ADD_BUTTON = By.xpath("//button[text()='Add']");
    public static final By ENABLE_BUTTON = By.xpath("//button[text()='Enable']");
    public static final By DISABLE_BUTTON = By.xpath("//button[text()='Disable']");
    public static final By TEXTBOX_INPUT = By.cssSelector("[type='text']");
    public static final By ITSGONE_LABEL = By.xpath("//*[@id='checkbox-example']/p");
    public static final By ITSENABLED_LABEL = By.xpath("//*[@id='input-example']/p");


    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    public void clickCheckbox() {
        driver.findElement(CHECKBOX).click();
    }


    public void isCheckboxVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKBOX));
        } catch (TimeoutException exception) {
            Assert.fail("Checkbox is not visible");
        }
    }

    public void isCheckboxInvisible() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(CHECKBOX));
        } catch (TimeoutException exception) {
            Assert.fail("Checkbox is visible");
        }
    }

    public void pressRemoveButton() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    public String getItsGoneLabel() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ITSGONE_LABEL));
        return driver.findElement(ITSGONE_LABEL).getText();
    }

    public void isInputVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(TEXTBOX_INPUT));
        } catch (TimeoutException exception) {
            Assert.fail("Input is invisible");
        }
    }

    public void pressEnableButton() {
        driver.findElement(ENABLE_BUTTON).click();
    }


    public void isItsEnabledLabelDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ITSENABLED_LABEL));
        } catch (TimeoutException exception){
            Assert.fail("'It's enabled' label is not found");
        }
    }

    public boolean isInputEnabled() {
        return driver.findElement(TEXTBOX_INPUT).isEnabled();
    }
}
