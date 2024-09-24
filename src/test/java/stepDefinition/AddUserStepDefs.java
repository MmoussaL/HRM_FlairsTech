package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Base;

public class AddUserStepDefs {

    Base base = new Base();

    @And("I click on Add User button")
    public void iClickOnAddUserButton() {
        base.users.clickAddUserButton(base.driver, base.wait);

    }

    @And("I enter user details")
    public void iEnterUserDetails() throws InterruptedException {
        base.newUserForm.addDetails (
                base.properties.getProperty("name"),
                base.properties.getProperty("role"),
                base.properties.getProperty("status"),
                base.properties.getProperty("HRMusername"),
                base.properties.getProperty("password"),
                base.properties.getProperty("password"),
                base.driver,base.wait);

    }

    @And("I click on Save button")
    public void iClickOnSaveButton() {
        base.newUserForm.clickSaveButton(base.driver, base.wait);
        base.users.isLoginSuccessful(base.driver, base.wait);
    }

    @Then("I should see the user added successfully")
    public void iShouldSeeTheUserAddedSuccessfully() {
        base.users.getAllUsers(base.driver, base.wait, base.initialRecordCount);
        base.users.getAllUsersCount(base.driver, base.wait, base.initialRecordCount, base.currentRecordCount);
    }
}
