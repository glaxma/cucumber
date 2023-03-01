package cucumberoptions;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "C:\\Users\\lginne\\IdeaProjects\\cucumber\\src\\test\\java\\features"
        , glue = {"stepdefinition"}, monochrome = true,
//        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        plugin = {"json:target/jsonReports/cucumber.json","rerun:target/failed_scenarios.txt"},
        tags = "@LD_ACH_Enrollments")

public class TestNGTestRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
