import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataTables {

    public static final String URL = "http://the-internet.herokuapp.com/tables";

    @Test
    public static void firstTableCellsContent() {
        WebDriver driver = UtilityWebDriver.open(URL);
        //find the first table
        WebElement table1 = driver.findElement(By.id("table1"));
        //find the proper element in the selected table
        String firstName = getTextFromTableCellByXpath(table1, "//table[@id='table1']/tbody/tr[2]/td[1]");
        String lastName = getTextFromTableCellByXpath(table1, "//table[@id='table1']/tbody/tr[2]/td[2]");
        String email = getTextFromTableCellByXpath(table1, "//table[@id='table1']/tbody/tr[2]/td[3]");
        String due = getTextFromTableCellByXpath(table1, "//table[@id='table1']/tbody/tr[2]/td[4]");
        String webSite = getTextFromTableCellByXpath(table1, "//table[@id='table1']/tbody/tr[2]/td[5]");
        String action = getTextFromTableCellByXpath(table1, "//table[@id='table1']/tbody/tr[2]/td[6]");
        Assert.assertEquals(firstName, "Bach", "ERROR: FirstName is not equal to compared text");
        Assert.assertEquals(lastName, "Frank", "ERROR: LastName is not equal to compared text");
        Assert.assertEquals(email, "fbach@yahoo.com", "ERROR: Email is not equal to compared text");
        Assert.assertEquals(due, "$51.00", "ERROR: Due is not equals to compared text");
        Assert.assertEquals(webSite, "http://www.frank.com", "ERROR: WebSite is not equals to compared text");
        Assert.assertEquals(action, "edit delete", "ERROR: Actions is not equals to compared text");
        driver.quit();
    }

    @Test
    public static void secondTableCellsContent() {
        WebDriver driver = UtilityWebDriver.open(URL);
        WebElement table2 = driver.findElement(By.xpath("//table[@id='table2']"));
        String firstName = getTextFromTableCellByXpath(table2, "//table[@id='table2']/tbody/tr[4]/td[1]");
        String lastName = getTextFromTableCellByXpath(table2, "//table[@id='table2']/tbody/tr[4]/td[2]");
        String email = getTextFromTableCellByXpath(table2, "//table[@id='table2']/tbody/tr[4]/td[3]");
        String due = getTextFromTableCellByXpath(table2, "//table[@id='table2']/tbody/tr[4]/td[4]");
        String webSite = getTextFromTableCellByXpath(table2, "//table[@id='table1']/tbody/tr[4]/td[5]");
        String action = getTextFromTableCellByXpath(table2, "//table[@id='table1']/tbody/tr[4]/td[6]");
        Assert.assertEquals(firstName, "Conway");
        Assert.assertEquals(lastName, "Tim");
        Assert.assertEquals(email, "tconway@earthlink.net");
        Assert.assertEquals(due, "$50.00");
        Assert.assertEquals(webSite, "http://www.timconway.com");
        Assert.assertEquals(action, "edit delete");
        driver.quit();
    }

    private static String getTextFromTableCellByXpath(WebElement table1, String xPath) {
        return table1.findElement(By.xpath(xPath)).getText();
    }
}
