package stepdefinition;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ContextSetUp;

import java.io.File;
import java.io.IOException;

public class Hooks {

    ContextSetUp contextSetUp;

    public Hooks(ContextSetUp contextSetUp) {
        this.contextSetUp = contextSetUp;
    }
//    WebDriver driver;
//    @Before()
//    public void setUp(){
//      System.setProperty("Webdriver.chrome.driver","C:\\Users\\lginne\\IdeaProjects\\cucumber\\chromedriver.exe");
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(driver, Duration.ofMillis(50))
//        driver.get("https://ri-leasingdeskadmin-uat.realpage.com/");
//
//
//    }
//    @After("@RegressionTest")
//    public void afterValidation(){
//      driver.close();
//      driver.quit();
//
//    }

    @AfterStep
    public void addScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) contextSetUp.driver).getScreenshotAs(OutputType.FILE);

            //Copy the file to a location and use try catch block to handle exception
            try {
                //  FileUtils.copyFile(screenshot, new File("C:\\projectScreenshots\\homePageScreenshot.png"));
                byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
                scenario.attach(fileContent, "image/png", "image");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
