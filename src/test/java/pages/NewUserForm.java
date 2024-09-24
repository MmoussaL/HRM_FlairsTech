package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class NewUserForm {

    By NameField = By.xpath("//input[contains(@placeholder,'Type for hints...')]");
    By Role = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
    By status = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");
    By username = By.xpath("//html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    By password = By.xpath("(//input[@type='password'])[1]");
    By confirmPassword = By.xpath("(//input[@type='password'])[2]");
    By saveButton = By.xpath("//button[@type='submit'][contains(.,'Save')]");


    public void addDetails (String name, String role, String stat, String user, String pass, String confirm, WebDriver driver, WebDriverWait wait) throws InterruptedException {
        // Enter the name
        wait.until(ExpectedConditions.visibilityOfElementLocated(NameField));
        driver.findElement(NameField).sendKeys(name);
        // Wait for the auto-suggest options to appear and select the first match (if any)
        Thread.sleep(5000);
        WebElement autoSuggestOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option']")));
        autoSuggestOption.click();
        Thread.sleep(3000);
        // Select the role
        wait.until(ExpectedConditions.visibilityOfElementLocated(Role));
        driver.findElement(Role).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']")));
        WebElement adminOption = driver.findElement(By.xpath("(//div[@role='option'])[2]"));
        adminOption.click();
        Thread.sleep(3000);
        // Select the status
        wait.until(ExpectedConditions.visibilityOfElementLocated(status));
        driver.findElement(status).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='listbox']")));
        WebElement enabledOption = driver.findElement(By.xpath("//span[text()='Enabled']"));  // Replace with "Disabled" if needed
        enabledOption.click();
        // Enter the username
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        driver.findElement(username).sendKeys(user);
        // Enter the password
        wait.until(ExpectedConditions.visibilityOfElementLocated(password));
        driver.findElement(password).sendKeys(pass);
        // Confirm the password
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPassword));
        driver.findElement(confirmPassword).sendKeys(confirm);
    }

    public void clickSaveButton(WebDriver driver, WebDriverWait wait) {
        // Click on the save button
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        driver.findElement(saveButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[contains(.,'System Users')]")));
    }


}
