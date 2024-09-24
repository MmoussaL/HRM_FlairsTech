package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Users {
    By adminDashboard = By.xpath("//a[@href='/web/index.php/admin/viewAdminModule']");
    By userCard = By.className("oxd-table-card");
    By usersPageTitle = By.xpath("//h5[contains(.,'System Users')]");
    By addUserButton = By.xpath("//button[@type='button'][contains(.,'Add')]");
    By addUserForm = By.xpath("//h6[contains(.,'Add User')]");
    By searchField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By searchButton = By.xpath("//button[contains(.,'Search')]");
    By deleteButton = By.xpath("(//button[contains(@class,'oxd-icon-button oxd-table-cell-action-space')])[1]");
    By confirmDeleteButton = By.xpath("//button[@type='button'][contains(.,'Yes, Delete')]");
    By confirmationMsg = By.xpath("//div[@class='oxd-toast oxd-toast--success oxd-toast-container--toast'][contains(.,'SuccessSuccessfully Deleted×')]");

     public boolean isLoginSuccessful(WebDriver driver, WebDriverWait wait) {
        // Check if the login was successful
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminDashboard));
        return driver.findElement(adminDashboard).isDisplayed();
    }

    public void clickAdminTab(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminDashboard));
        driver.findElement(adminDashboard).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(usersPageTitle));
    }

    public void getAllUsers(WebDriver driver, WebDriverWait wait, int initialRecordCount) {
        // Code to get all users'
        wait.until(ExpectedConditions.visibilityOfElementLocated(usersPageTitle));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userCard));

        List<WebElement> users = driver.findElements(userCard);
        System.out.println("Number of users: " + users.size());
        initialRecordCount = users.size();
        System.out.println("Current record count before deleting or adding: " + initialRecordCount);
    }

    public void getAllUsersCount (WebDriver driver, WebDriverWait wait, int initialRecordCount, int currentRecordCount) {
        // Code to get all users'
        wait.until(ExpectedConditions.visibilityOfElementLocated(usersPageTitle));
        wait.until(ExpectedConditions.visibilityOfElementLocated(userCard));
        List<WebElement> users = driver.findElements(userCard);
        for (WebElement user : users) {
            System.out.println("User Card Details: " + user.getText());
        }
        System.out.println("Number of users: " + users.size());
        currentRecordCount = users.size();
        System.out.println("Current record count after adding new record: " + currentRecordCount);
        Assert .assertTrue(currentRecordCount > initialRecordCount);
    }

    public void clickAddUserButton (WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addUserButton));
        driver.findElement(addUserButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addUserForm));
    }

    public void searchUser (WebDriver driver, WebDriverWait wait, String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        driver.findElement(searchField).sendKeys(username);
    }

    public void search (WebDriver driver, WebDriverWait wait) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton));
        driver.findElement(searchButton).click();
        Thread.sleep(3000);
    }

    public void validateUserDetails (WebDriver driver, WebDriverWait wait, String username) {
        // Code to validate user details
        wait.until(ExpectedConditions.visibilityOfElementLocated(userCard));
        List<WebElement> users = driver.findElements(userCard);
        for (WebElement user : users) {
            System.out.println("User Card Details: " + user.getText());
            boolean contains = user.getText().contains(username);
            Assert.assertTrue(contains);
        }
        System.out.println("Number of users: " + users.size());
    }

    public void deleteUser (WebDriver driver, WebDriverWait wait) throws InterruptedException {
        // Code to delete a user
        Thread.sleep(6000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
        driver.findElement(deleteButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteButton));
        driver.findElement(confirmDeleteButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMsg));
        Assert.assertTrue(driver.findElement(confirmationMsg).getText().contains("Deleted"));
    }

    public void validateUserDeleted (WebDriver driver, WebDriverWait wait, String username) {
        // Code to validate user details

    }

}
