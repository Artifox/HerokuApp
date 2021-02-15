package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePage {

    public static final By IFRAME_LABEL = By.cssSelector("[href='/iframe']");
    public static final By TEXT_IN_IFRAME = By.tagName("p");

    public FramesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("http://the-internet.herokuapp.com/frames");
    }

    public void clickIFrame() {
        driver.findElement(IFRAME_LABEL).click();
    }

    public void switchToIFrame() {
        driver.switchTo().frame(0);
    }

    public void switchToMainPage() {
        driver.switchTo().defaultContent();
    }

    public String getTextFromIFrame() {
        return driver.findElement(TEXT_IN_IFRAME).getText();
    }

}
