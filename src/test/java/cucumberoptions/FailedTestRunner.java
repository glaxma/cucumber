package cucumberoptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "@C:\\Users\\lginne\\IdeaProjects\\cucumber\\target\\failed_scenarios.txt"
        , glue = {"stepdefinition"}, monochrome = true,
        plugin = {"json:target/jsonReports/cucumber.json"},
        tags = "@LD_CC_Future_Enrollments")

public class FailedTestRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
