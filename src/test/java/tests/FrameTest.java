package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test
    public void textInIFrameShouldByDisplayed() {
        framesPage.open();
        framesPage.clickIFrame();
        framesPage.switchToIFrame();
        Assert.assertEquals(framesPage.getTextFromIFrame(), "Your content goes here.", "Text in iFrame is wrong");
        framesPage.switchToMainPage();
    }
}
