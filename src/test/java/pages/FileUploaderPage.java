package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;

public class FileUploaderPage extends BasePage {

    public static final By FILE_UPLOAD_FIELD = By.id("file-upload");
    public static final By UPLOAD_BUTTON = By.id("file-submit");
    public static final By UPLOADED_FILENAME = By.id("uploaded-files");

    public FileUploaderPage(WebDriver driver) {
        super(driver);
    }

    public void setFilePath(String path){
        driver.findElement(FILE_UPLOAD_FIELD).sendKeys(new File(path).getAbsolutePath());
    }

    public void open() {
        driver.get("http://the-internet.herokuapp.com/upload");
    }

    public void clickUploadButton() {
        driver.findElement(UPLOAD_BUTTON).click();
    }

    public void isFileUploaded() {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(UPLOADED_FILENAME));
        } catch (TimeoutException exception){
            Assert.fail("Uploaded file is not found on the page");
        }

    }
}
