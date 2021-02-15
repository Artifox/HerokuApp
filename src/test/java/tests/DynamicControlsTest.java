package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void checkboxShouldBeRemoved() {
        dynamicControlsPage.open();
        dynamicControlsPage.isCheckboxVisible();
        dynamicControlsPage.pressRemoveButton();
        Assert.assertEquals(dynamicControlsPage.getItsGoneLabel(), "It's gone!", "'It's gone' label is not found");
        dynamicControlsPage.isCheckboxInvisible();
    }

    @Test
    public void inputShouldBeEnabled() {
        dynamicControlsPage.open();
        dynamicControlsPage.isInputVisible();
        Assert.assertFalse(dynamicControlsPage.isInputEnabled());
        dynamicControlsPage.pressEnableButton();
        dynamicControlsPage.isItsEnabledLabelDisplayed();
        Assert.assertTrue(dynamicControlsPage.isInputEnabled());
    }
}
