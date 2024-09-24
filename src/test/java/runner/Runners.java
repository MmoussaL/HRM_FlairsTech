package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "stepDefinition",
        plugin = {"pretty", "html:target/cucumber-reports", "json: target/cucumber-reports/cucumber.json"},
        dryRun = false,
        monochrome = true,
        tags = "@task"
)
public class Runners {



}