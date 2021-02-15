package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenuTest extends BaseTest{

    @Test
    public void alertShouldAppearAfterRightMouseClickOnBoxArea() {
        contextMenuPage.open();
        contextMenuPage.rightMouseClickOnBoxArea();
        String result = contextMenuPage.getAlertText();
        Assert.assertEquals(result, "You selected a context menu");
        contextMenuPage.dismissAlert();
    }

}
