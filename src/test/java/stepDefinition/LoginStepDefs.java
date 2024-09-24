package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginStepDefs {
    Base base = new Base();

    public LoginStepDefs() throws FileNotFoundException {
    }

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties");
            base.properties.load(fileInputStream);
            base.Setup(base.properties.getProperty("browser"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @When("User enters valid username")
    public void userEntersValidUsername() {
        base.login.enterUsername(base.properties.getProperty("username"), base.wait, base.driver);


    }

    @And("User enters valid password")
    public void userEntersValidPassword() {
        base.login.enterPassword(Base.properties.getProperty("password"), base.wait, base.driver);
    }

    @And("Clicks on the login button")
    public void clicksOnTheLoginButton() {
        base.login.clickLogin(Base.wait, base.driver);


    }

    @Then("User should be navigated to the home page")
    public void userShouldBeNavigatedToTheHomePage() {
        Assert.assertTrue(Base.users.isLoginSuccessful(base.driver, base.wait));
    }
}
