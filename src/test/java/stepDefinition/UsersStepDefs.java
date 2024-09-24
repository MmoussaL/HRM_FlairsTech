package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Base;

import java.io.FileInputStream;
import java.io.IOException;

public class UsersStepDefs {
    Base base = new Base();

    @Given("I am on the home page")
    public void userIsOnTheLoginPage() {
        Assert.assertTrue(Base.users.isLoginSuccessful(base.driver, base.wait));
    }

    @When("I Navigate to Admin tab")
    public void iNavigateToAdminTab() {
        base.users.clickAdminTab(base.driver, base.wait);

    }

    @Then("I should see the current records")
    public void iShouldSeeTheCurrentRecords() {
        base.users.getAllUsers(base.driver ,base.wait,base.initialRecordCount);
    }

    @And("I add username to search with")
    public void iAddUsernameToSearchWith() {
        base.users.searchUser(base.driver, base.wait, base.properties.getProperty("HRMusername"));
    }

    @And("I click on Search button")
    public void iClickOnSearchButton() throws InterruptedException {
        base.users.search(base.driver, base.wait);
    }

    @Then("I should see the user details")
    public void iShouldSeeTheUserDetails() {
        base.users.validateUserDetails(base.driver, base.wait, base.properties.getProperty("HRMusername"));
    }

    @And("I click on Delete User button")
    public void iClickOnDeleteUserButton() throws InterruptedException {
        base.users.deleteUser(base.driver, base.wait);
    }

    @Then("I should see the user deleted successfully")
    public void iShouldSeeTheUserDeletedSuccessfully() throws InterruptedException {
        base.users.searchUser(base.driver, base.wait, base.properties.getProperty("HRMusername"));
        base.users.search(base.driver, base.wait);
        base.users.validateUserDeleted(base.driver, base.wait, base.properties.getProperty("HRMusername"));
    }

    @Then("close the browser")
    public void closeTheBrowser() {
        base.teardown();
    }
}
