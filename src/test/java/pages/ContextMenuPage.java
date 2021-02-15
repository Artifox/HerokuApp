package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage extends BasePage {

    public static final By BOX_AREA = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
    }

    public void rightMouseClickOnBoxArea() {
        Actions actions = new Actions(driver);
        WebElement boxArea = driver.findElement(BOX_AREA);
        actions.contextClick(boxArea).perform();
    }

    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

}
