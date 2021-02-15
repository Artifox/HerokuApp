package tests;

import org.testng.annotations.Test;

public class FileUploaderTest extends BaseTest{

    @Test
    public void fileShouldBeUploaded(){
        fileUploaderPage.open();
        fileUploaderPage.setFilePath("src/test/resources/chromedriver.exe");
        fileUploaderPage.clickUploadButton();
        fileUploaderPage.isFileUploaded();
    }
}
