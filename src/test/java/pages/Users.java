package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepDefinition.TestBase;

import java.util.List;

public class AdminPage extends TestBase {
    By adminDashboard = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    By userCard = By.className("oxd-table-card");
    By usersPageTitle = By.xpath("//h5[contains(.,'System Users')]");

    public AdminPage(WebDriver driver) {
        TestBase.driver = driver;
    }

     public boolean isLoginSuccessful() {
        // Check if the login was successful
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminDashboard));
        return driver.findElement(adminDashboard).isDisplayed();
    }

    public void clickAdminTab() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminDashboard));
        driver.findElement(adminDashboard).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(usersPageTitle));
    }

    public void getAllUsers() {
        // Code to get all users'
        wait.until(ExpectedConditions.visibilityOfElementLocated(usersPageTitle));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userCard));

        List<WebElement> users = driver.findElements(userCard);
        System.out.println("Number of users: " + users.size());
        for (WebElement user : users) {
            System.out.println(user.getText());
        }
        initialRecordCount = users.size();
        System.out.println("Current record count: " + currentRecordCount);
    }
}
