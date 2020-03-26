package project.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"src/test/java/Homework2/features"},
        glue = {"project.hooks",
                "Homework2.steps"},
        tags = {"~@ignore", "@SmokeTest"}
)
public class CucumberRunner extends AbstractTestNGCucumberTests {
}
