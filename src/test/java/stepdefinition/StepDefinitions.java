package stepdefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.ContextSetUp;
import utils.PropertiesFile;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;


public class StepDefinitions {
    public ContextSetUp contextSetUp;
    public WebDriverWait wait;
    Faker fs = new Faker();
    String browser = "chrome";


    PropertiesFile PropertiesFile = new PropertiesFile();


    enum Browser {
        CHROME("chrome"),
        FIREFOX("firefox"),
        EDGE("edge");
        final private String browser;

        Browser(String browser) {
            this.browser = browser;
        }

        public String getBrowser() {
            return browser;
        }

    }

    public StepDefinitions(ContextSetUp contextSetUp) {
        this.contextSetUp = contextSetUp;
    }

    @Given("validate the browser")
    public void validateTheBrowser() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-position=0,0");
        chromeOptions.addArguments("--window-size=1840,1080");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-gpu");
//        chromeOptions.addArguments("--headless");
//        chromeOptions.setCapability("se:name", "Test UI");
        chromeOptions.setCapability("se:recordVideo", "true");
        chromeOptions.setCapability("se:timeZone", "IST");
        chromeOptions.setCapability("browserstack.debug", true);
        chromeOptions.setCapability("browserstack.video", true);
        chromeOptions.setCapability("browserstack.console", "enable");

//        chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value");

        contextSetUp.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
//        System.out.println("Tests Running browser is:" + browser);
//        if (browser.equalsIgnoreCase(Browser.CHROME.getBrowser())) {
//            System.setProperty("webdriver.chrome.driver", "..\\cucumber\\drivers\\chromedriver.exe");
//            contextSetUp.driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase(Browser.FIREFOX.getBrowser())) {
//            System.setProperty("webdriver.gecko.driver", "..\\cucumber\\drivers\\geckodriver.exe");
//            contextSetUp.driver = new FirefoxDriver();
//        } else if (browser.equalsIgnoreCase(Browser.EDGE.getBrowser())) {
//            System.setProperty("webdriver.edge.driver", "..\\cucumber\\drivers\\msedgedriver.exe");
//            contextSetUp.driver = new EdgeDriver();
//        } else {
//            System.out.println("No browser selected");
//        }

    }

    @When("Browser is Triggered")
    public void browserIsTriggered() {
        contextSetUp.driver.manage().window().maximize();
        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20));
    }


    @Then("Browser launched")
    public void browserLaunched() {
        contextSetUp.driver.get(PropertiesFile.PropertyFileReader("..\\cucumber\\src\\resources\\env\\qa.properties").getProperty("ldUrl"));
        System.out.println("Successfully Launched the url:" + contextSetUp.driver.getCurrentUrl());
    }

    @Given("Launch the url")
    public void launch_the_url() {
        // Write code here that turns the phrase above into concrete actions

//        String browser="chrome";
//        System.out.println("Tests Running browser is:" +browser);
//        if(browser.equalsIgnoreCase("chrome")) {
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\lginne\\IdeaProjects\\cucumber\\drivers\\chromedriver.exe");
//            contextSetUp.driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase("firefox")) {
//            System.setProperty("webdriver.gecko.driver", "C:\\Users\\lginne\\IdeaProjects\\cucumber\\drivers\\geckodriver.exe");
//            contextSetUp.driver = new FirefoxDriver();
//        } else if (browser.equalsIgnoreCase("edge")) {
//            System.setProperty("webdriver.edge.driver", "C:\\Users\\lginne\\IdeaProjects\\cucumber\\drivers\\msedgedriver.exe");
//            contextSetUp.driver = new EdgeDriver();
//        }else{
//            System.out.println("No browser selected");
//        }
//        contextSetUp.driver.manage().window().maximize();
//        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20));
//        contextSetUp.driver.get("https://ri-leasingdeskadmin-uat.realpage.com/");
//        contextSetUp.driver.get(PropertiesFile.PropertyFileReader("..\\cucumber\\src\\resources\\env\\qa.properties").getProperty("ldUrl"));
//        System.out.println("Successfully Launched the url:" + contextSetUp.driver.getCurrentUrl());
    }

    @When("I entered the valid {string} and {string}")
    public void i_entered_the_valid_and(String username, String Password) {
        WebElement userName = contextSetUp.driver.findElement(By.xpath("//input[@id='Login']"));
        userName.sendKeys(username);
        WebElement password = contextSetUp.driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys(Password);
    }

    @Then("Login is Successful")
    public void login_is_successful() {
        // Write code here that turns the phrase above into concrete actions
        WebElement login = contextSetUp.driver.findElement(By.xpath("//input[@value='LOG IN']"));
        login.click();

    }

    @Then("I click on Add Erp Policy")
    public void i_click_on_add_erp_policy() {
        // Write code here that turns the phrase above into concrete actions
        WebElement AddErpPolicy = contextSetUp.driver.findElement(By.linkText("Add ERP Policy"));
        WebDriverWait wait = new WebDriverWait(contextSetUp.driver, Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOf(AddErpPolicy));
        AddErpPolicy.click();

    }

    @Then("I Entered {string},{string}")
    public void i_entered(String Email, String DateOfBirth) {
        // Write code here that turns the phrase above into concrete actions
        WebElement FN = contextSetUp.driver.findElement(By.xpath("//input[@id='inputFname1']"));
        wait = new WebDriverWait(contextSetUp.driver, Duration.ofMillis(100));
        wait.until(ExpectedConditions.visibilityOf(FN));
        FN.sendKeys(fs.name().firstName());
        WebElement LN = contextSetUp.driver.findElement(By.xpath("//input[@id='inputLname1']"));
        wait = new WebDriverWait(contextSetUp.driver, Duration.ofMillis(100));
        wait.until(ExpectedConditions.visibilityOf(LN));
        LN.sendKeys(fs.name().lastName());
        WebElement email = contextSetUp.driver.findElement(By.xpath("//input[@id='inputEmail1']"));
        wait = new WebDriverWait(contextSetUp.driver, Duration.ofMillis(100));
        wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(Email);
        WebElement pn = contextSetUp.driver.findElement(By.xpath("//input[@id='inputPhone1']"));
        wait = new WebDriverWait(contextSetUp.driver, Duration.ofMinutes(1));
        wait.until(ExpectedConditions.visibilityOf(pn));
        pn.click();
        pn.sendKeys(fs.phoneNumber().phoneNumber());
        WebElement dob = contextSetUp.driver.findElement(By.xpath("//input[@id='txtBirthDate1']"));
        wait = new WebDriverWait(contextSetUp.driver, Duration.ofMillis(100));
        wait.until(ExpectedConditions.visibilityOf(dob));
        dob.click();
        dob.sendKeys(DateOfBirth);

    }

    @Then("I select State")
    public void i_select_state() {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("I Entered {string}")
    public void i_entered(String ZipCode) {
        // Write code here that turns the phrase above into concrete actions
        WebElement ZipCodes = contextSetUp.driver.findElement(By.xpath("//input[@id='txtZipcodes']"));
        ZipCodes.sendKeys(ZipCode);

    }

    @Then("I click on Search")
    public void i_click_on_search() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebElement searchProperty = contextSetUp.driver.findElement(By.xpath("//input[@id='btnSearchProperty']"));
        searchProperty.click();
        Thread.sleep(20000);
        WebElement webTable = contextSetUp.driver.findElement(By.xpath("//table[@id='MainTablePropListing']//tbody"));
        List<WebElement> rows = webTable.findElements(By.tagName("tr"));
        int totalRows = rows.size();
        System.out.println("Total rows are:" + totalRows);
        Thread.sleep(20000);
        outerLoop:
        for (WebElement webElement : rows) {
            List<WebElement> col = webElement.findElements(By.tagName("td"));
            int columns_count = col.size();
            System.out.println("total columns are:  " + columns_count);
            for (int column = 0; column < columns_count; column++) {
                String cellText = rows.get(column).getText();
                System.out.println(cellText);
                String[] splitText = cellText.split("\\s");
                for (String rowTextSeparator : splitText) {
                    if (rowTextSeparator.contains("AMIG") || rowTextSeparator.contains("American") || rowTextSeparator.contains("MAIC")) {
                        List<WebElement> propertyRadioButtons = rows.get(column).findElements(By.tagName("input"));
                        propertyRadioButtons.stream().findFirst().ifPresent(WebElement::click);
                        break outerLoop;
                    }
                }
            }

        }
        Thread.sleep(20000);
        List<WebElement> Columns_rowUnit = contextSetUp.driver.findElements(By.xpath("//tbody[@id='Locationslisting']  //input[@type='radio']"));
        int totalUnits = Columns_rowUnit.size();
        System.out.println("total units are:" + totalUnits);
        Columns_rowUnit.stream().findAny().ifPresent(WebElement::click);
        Thread.sleep(5000);
    }


    @Then("I Click on Save")
    public void i_click_on_save() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebElement Save = contextSetUp.driver.findElement(By.xpath("//input[@id='btnSave']"));
        Save.click();
        Thread.sleep(10000);
    }

    @Then("I Click on Insurance Questions")
    public void i_click_on_insurance_questions() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebElement NoOne = contextSetUp.driver.findElement(By.xpath("//input[@id='rdoAnswer2']"));
        NoOne.click();
        WebElement Continue = contextSetUp.driver.findElement(By.xpath("//button[@id='btnUnderwritingLDContinue']"));
        Continue.click();
        Thread.sleep(3000);
        WebElement NoTwo = contextSetUp.driver.findElement(By.xpath("//input[@id='rdoAnswer6']"));
        NoTwo.click();
        Continue.click();
        Thread.sleep(1000);

    }

    @Then("I click on btn Save")
    public void i_click_on_btn_save() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        contextSetUp.driver.switchTo().activeElement();
        WebElement ResidentSave = contextSetUp.driver.findElement(By.xpath("(//button[text()='OK'])[2]"));
//        WebElement ResidentSave = contextSetUp.driver.findElement(By.xpath(" //div [@class='modal-footer'] //button[text()='OK']"));
        ResidentSave.click();
        Thread.sleep(10000);


    }

    @Then("I Click on Current Date")
    public void i_click_on_current_date() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebElement AllDatePicker = contextSetUp.driver.findElement(By.xpath("//input[@id='Alldatepicker']"));
        AllDatePicker.click();
        //current date
        WebElement currentDate = contextSetUp.driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-highlight ui-state-hover']"));
        currentDate.click();
        Thread.sleep(2000);
        contextSetUp.driver.switchTo().activeElement();
        WebElement DisclaimerPopUp = contextSetUp.driver.findElement(By.xpath("//input[@id='chkConfirmation']"));
        DisclaimerPopUp.click();
        WebElement DisclaimerPopUpOK = contextSetUp.driver.findElement(By.xpath("//button[@id='btnLDOk']"));
        DisclaimerPopUpOK.click();

        // Next
        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        contextSetUp.driver.switchTo().frame("rp-insurance-widget");
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement customRadioButton = contextSetUp.driver.findElement(By.xpath("//label[@for='custom']"));
        js.executeScript("arguments[0].click();", customRadioButton);
    }


    // eRP enrollments Page
    @And("I Entered {string} {string}")
    public void iEntered(String NameOnCard, String CardNumber) {
        WebElement Name_On_Card = contextSetUp.driver.findElement(By.xpath("//input[@id='cardName']"));
        Name_On_Card.sendKeys(NameOnCard);
        WebElement Card_Number = contextSetUp.driver.findElement(By.xpath("//input[@id='cardNumber']"));
        Card_Number.sendKeys(CardNumber);
        List<WebElement> Month = contextSetUp.driver.findElements(By.xpath("//select[@id='expMonth']//option"));
        for (WebElement ele : Month) {
            String Card_Month = ele.getText();
            System.out.println("Total months are:" + Card_Month);
            if (Card_Month.equalsIgnoreCase(" April ")) {
                ele.click();
                break;

            }
        }

        List<WebElement> Year = contextSetUp.driver.findElements(By.xpath("//select[@id='expYear']//option"));
        for (WebElement ele : Year) {
            String CardYear = ele.getText();
            System.out.println("Total Years are:" + CardYear);
            if (CardYear.equalsIgnoreCase(" 2030 ")) {
                ele.click();
                break;

            }
        }
    }

    @And("I Click on T&C OK button")
    public void iClickOnTCOKButton() throws InterruptedException {
        Thread.sleep(1000);
        contextSetUp.driver.switchTo().activeElement();
        WebElement TC_OK = contextSetUp.driver.findElement(By.xpath("//div[@class='col-sm-3 p-0'] //button[text()=' OK ']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", TC_OK);
//        TC_OK.click();
    }

    @Then("Monthly Policy Enrolled from LD Successfully")
    public void monthlyPolicyEnrolledFromLDSuccessfully() throws InterruptedException {
        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
        contextSetUp.driver.switchTo().defaultContent();
        Thread.sleep(20000);
        WebElement PolicyNumber = contextSetUp.driver.findElement(By.xpath("(//div[@class='span6']/p[2]/strong)[1]"));
        String Policy = PolicyNumber.getText();
        System.out.println("New Business Policy Number is:" + Policy);
    }

    @And("I click on Invoice")
    public void iClickOnInvoice() {
        WebElement Invoice = contextSetUp.driver.findElement(By.xpath("//strong[contains(text(),'Invoice')]"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", Invoice);
    }

    @And("I click on CC with Two Initial Installments CheckBox")
    public void iClickOnCCWithTwoInitialInstallmentsCheckBox() throws InterruptedException {
        Thread.sleep(10000);
        WebElement CC_WithTwoInstallments = contextSetUp.driver.findElement(By.xpath("//input[@id='ccInstallmentCheck']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", CC_WithTwoInstallments);
    }

    @Given("Launched the eRP url")
    public void launched_the_e_rp_url() throws InterruptedException, MalformedURLException {
        // Write code here that turns the phrase above into concrete actions
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lginne\\IdeaProjects\\cucumber\\drivers\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        contextSetUp.driver = new ChromeDriver(options);

//        contextSetUp.driver = new ChromeDriver();

        String browser = "chrome";
        System.out.println("Tests Running browser is:" + browser);
//        if (browser.equalsIgnoreCase(Browser.CHROME.getBrowser())) {
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\lginne\\IdeaProjects\\cucumber\\drivers\\chromedriver.exe");
//            contextSetUp.driver = new ChromeDriver();
//        } else if (browser.equalsIgnoreCase(Browser.FIREFOX.getBrowser())) {
//            System.setProperty("webdriver.gecko.driver", "C:\\Users\\lginne\\IdeaProjects\\cucumber\\drivers\\geckodriver.exe");
//            contextSetUp.driver = new FirefoxDriver();
//        } else if (browser.equalsIgnoreCase(Browser.EDGE.getBrowser())) {
//            System.setProperty("webdriver.edge.driver", "C:\\Users\\lginne\\IdeaProjects\\cucumber\\drivers\\msedgedriver.exe");
//            contextSetUp.driver = new EdgeDriver();
//        } else {
//            System.out.println("No browser selected");
//        }
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--window-position=0,0");
        chromeOptions.addArguments("--window-size=1840,1080");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("start-maximized");
//        chromeOptions.addArguments("--headless");
//        chromeOptions.setCapability("se:name", "Test UI");
        chromeOptions.setCapability("se:recordVideo", "true");
        chromeOptions.setCapability("se:timeZone", "IST");
        chromeOptions.setCapability("browserstack.debug", true);
        chromeOptions.setCapability("browserstack.video", true);
        chromeOptions.setCapability("browserstack.console", "enable");

//        chromeOptions.setCapability("se:sampleMetadata", "Sample metadata value");

        contextSetUp.driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
//        contextSetUp.driver.manage().window().maximize();
        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        contextSetUp.driver.get("https://ri-erenterplan-uat.realpage.com/");
        System.out.println("Successfully Launched the url:" + contextSetUp.driver.getCurrentUrl());
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement eRPSignIn = contextSetUp.driver.findElement(By.xpath("//a[@id='desktopLogin']"));
        js.executeScript("arguments[0].click();", eRPSignIn);
        WebElement eRPSignInUserName = contextSetUp.driver.findElement(By.xpath("//input[@id='username']"));
        new WebDriverWait(contextSetUp.driver, Duration.ofSeconds(2)).until(ExpectedConditions.visibilityOf(eRPSignInUserName));
//        Thread.sleep(3000);
        eRPSignInUserName.sendKeys("whatwhat");
        WebElement eRPSignInPassword = contextSetUp.driver.findElement(By.xpath("//input[@id='password']"));
        Thread.sleep(3000);
        eRPSignInPassword.sendKeys("what@23$");
        WebElement eRPSignInBtn = contextSetUp.driver.findElement(By.xpath("//button[@id='signIn']"));
        js.executeScript("arguments[0].click();", eRPSignInBtn);

        Thread.sleep(10000);
        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        WebElement eRPHomePage = contextSetUp.driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        Thread.sleep(30000);
        js.executeScript("arguments[0].click();", eRPHomePage);
    }

    @When("I entered the {string}")
    public void i_entered_the(String ZipCode) {
        // Write code here that turns the phrase above into concrete actions
        WebElement PostalCode = contextSetUp.driver.findElement(By.xpath("//input[@id='postalCode']"));
        PostalCode.sendKeys(ZipCode);
    }

    @When("I clicked on Get a Free Quote")
    public void i_clicked_on_get_a_free_quote() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebElement freeQuote = contextSetUp.driver.findElement(By.xpath("//input[@id='Go']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", freeQuote);
//        freeQuote.click();
        contextSetUp.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
//        Thread.sleep(20000);
//        JavascriptExecutor j = (JavascriptExecutor) contextSetUp.driver;
        if (js.executeScript("return document.readyState").toString().equals("complete")) {
            System.out.println("Page has loaded");
        }
        //iterate 50 times after every one second to verify if in ready state
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Page has not loaded yet ");
            }
            //again check page state
            if (js.executeScript("return document.readyState").toString().equals("complete")) {
                break;
            }
        }
    }

    @When("I clicked on first property")
    public void i_clicked_on_first_property() {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> searchFirstProperty = contextSetUp.driver.findElements(By.xpath("//div [@id='propertyResults'] //div[@class='row']"));
        System.out.println("the list of property:" + searchFirstProperty.size());
        for (WebElement ele : searchFirstProperty) {
            String values = ele.getText();
            System.out.println(values);
            JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
            js.executeScript("arguments[0].click();", ele);
        }
    }

    @When("I entered resident  {string}")
    public void i_entered_resident(String Email) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        contextSetUp.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        Thread.sleep(20000);
        WebElement FN = contextSetUp.driver.findElement(By.xpath("//input[@id='firstName']"));
        //   FN.click();
        String fn = fs.name().firstName();
        FN.sendKeys(fn);
        // FN.sendKeys(FirstName);
        WebElement LN = contextSetUp.driver.findElement(By.xpath("//input[@id='lastName']"));
        wait.until(ExpectedConditions.visibilityOf(LN));
        //     LN.click();
        String ln = fs.name().lastName();
        LN.sendKeys(ln);
        //LN.sendKeys(LastName);
        WebElement em = contextSetUp.driver.findElement(By.xpath("//input[@id='email']"));
        //    em.click();
        em.sendKeys(Email);
//        Thread.sleep(100);
//        em.sendKeys(Keys.TAB);
    }

    @When("I clicked on Continue button")
    public void i_clicked_on_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement continue_btn = contextSetUp.driver.findElement(By.xpath("//input[@id='Continue']"));
//        continue_btn.click();
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", continue_btn);

    }

    @When("switched to frames and I clicked on Enter your unit serach box")
    public void switched_to_frames_and_i_clicked_on_enter_your_unit_serach_box() throws InterruptedException {
        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        contextSetUp.driver.switchTo().frame("rp-insurance-widget");
        System.out.println("successfully switched");
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        WebElement unitSelection = contextSetUp.driver.findElement(By.xpath("//input[@id='typeahead-template']"));
        js.executeScript("arguments[0].click();", unitSelection);
        unitSelection.sendKeys("1");

//        Thread.sleep(1000);

        List<WebElement> unitAddress = contextSetUp.driver.findElements(By.xpath("//button[@type='button']"));
        int sz = unitAddress.size();
        System.out.println(sz);
        //instance of random class
        Random rand = new Random();
        int upperbound = 30;
        //generate random values from 0-220
        int int_random = rand.nextInt(upperbound);
//    unitAddress.stream().findAny().ifPresent(e-> js.executeScript("arguments[0].click();", e));
        for (int i = int_random; i < sz; i++) {
            WebElement unit = unitAddress.get(i);
            js.executeScript("arguments[0].click();", unit);
            break;
        }
    }

    @When("Selected {string} and {string}")
    public void selected_and(String Package, String Deductible) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> packages = contextSetUp.driver.findElements(By.xpath("//select[@id='propertyCoverage']/option"));
        packages.stream().filter(e -> e.getText().equalsIgnoreCase(Package)).forEach(v -> {
            System.out.println(v.getText());
            v.click();
        });
        List<WebElement> Deductibles = contextSetUp.driver.findElements(By.xpath("//select[@id='deductible']/option"));
        Deductibles.stream().filter(e -> e.getText().equalsIgnoreCase(Deductible)).forEach(v -> {
            System.out.println(v.getText());
            v.click();
        });
//        for (WebElement ele : packages) {
//            String values = ele.getText();
//            System.out.println("Package value is:" + values);
//            if (values.equalsIgnoreCase(Package)) {
//                ele.click();
//                break;
//            }
//        }
//        List<WebElement> Deductibles = contextSetUp.driver.findElements(By.xpath("//select[@id='deductible']/option"));
//        Deductibles.stream().filter(e->e.getText().equalsIgnoreCase(Deductible)).forEach(v->{System.out.println(v.getText());v.click();});
//        for (WebElement ele : Deductibles) {
//            String deductible = ele.getText();
//            System.out.println("deductible value is:" + deductible);
//            if (deductible.equalsIgnoreCase(Deductible)) {
//                ele.click();
//                break;
//            }
//        }
        Thread.sleep(10000);
        WebElement customRadioButton = contextSetUp.driver.findElement(By.xpath("//label[@for='custom']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", customRadioButton);
    }

    @And("I click on Next")
    public void iClickOnNext() throws InterruptedException {
        Thread.sleep(1000);
        WebElement goodPackage = contextSetUp.driver.findElement(By.xpath("//button[@id='nextButton']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", goodPackage);

    }

    @When("I click on Additional Coverages Next")
    public void i_click_on_additional_coverages_next() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(2000);
        WebElement AdditionalCoverage = contextSetUp.driver.findElement(By.xpath("//button[@id='nextButton']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", AdditionalCoverage);
    }

    @When("I Click on Question one")
    public void i_click_on_question_one() {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> questionOne = contextSetUp.driver.findElements(By.xpath("(//select[@name='questionAnswer']//option)"));
        questionOne.stream().filter(e -> e.getText().equalsIgnoreCase(" No ")).forEach(WebElement::click);
//        for (WebElement ele : questionOne) {
//            String questionResponse = ele.getText();
//            System.out.println("Clicked Successfully");
//            if (questionResponse.equalsIgnoreCase(" No ")) {
//                ele.click();
//                break;
//
//            }
//        }
    }

    @When("I Click on Question two")
    public void i_click_on_question_two() {

        List<WebElement> questionTwo = contextSetUp.driver.findElements(By.xpath("//div[contains(text(),'Do you or other applicants own or care for an anim')] /following::select/option"));
        questionTwo.stream().filter(e -> e.getText().equalsIgnoreCase(" No ")).forEach(WebElement::click);
//        for (WebElement ele : questionTwo) {
//            String questionResponse = ele.getText();
//            System.out.println("Clicked Successfully");
//            if (questionResponse.equalsIgnoreCase(" No ")) {
//                ele.click();
//                break;
//            }
//        }
    }

    @When("I click on questions Next")
    public void i_click_on_questions_next() {
        // Write code here that turns the phrase above into concrete actions
        WebElement QuestionNext = contextSetUp.driver.findElement(By.xpath("//button[@id='nextButton']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", QuestionNext);

    }

    @When("I entered the {string} {string}")
    public void i_entered_the(String PrimaryDOB, String PrimaryPhone) {
        // Write code here that turns the phrase above into concrete actions
        WebElement DOB = contextSetUp.driver.findElement(By.xpath("//input[@id='primaryResidentDOB']"));
        DOB.sendKeys(PrimaryDOB);
        WebElement phone = contextSetUp.driver.findElement(By.xpath("//input[@id='primaryResidentPhone']"));
        phone.sendKeys(PrimaryPhone);
    }

    @When("I Selected Text Updates Checkbox")
    public void i_selected_text_updates_checkbox() {
        // Write code here that turns the phrase above into concrete actions
        WebElement SmsOptIn = contextSetUp.driver.findElement(By.xpath("//input[@id='smsOptIn']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", SmsOptIn);
    }

    @When("I Selected Paperless Billing Checkbox")
    public void i_selected_paperless_billing_checkbox() {
        // Write code here that turns the phrase above into concrete actions
        WebElement SmsOptIn = contextSetUp.driver.findElement(By.xpath("//input[@id='paperless']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", SmsOptIn);

    }

    @When("I clicked on Primary Resident Details button Next")
    public void i_clicked_on_primary_resident_details_button_next() {
        // Write code here that turns the phrase above into concrete actions
        WebElement PrimaryholderNext = contextSetUp.driver.findElement(By.xpath("//button[@id='nextButton']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", PrimaryholderNext);
    }

    @When("I click on Monthly Payment Frequency {string}")
    public void i_click_on_monthly_payment_frequency(String term) {
        // Write code here that turns the phrase above into concrete actions
        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        WebElement MonthlyText = contextSetUp.driver.findElement(By.xpath("//strong[text()='Monthly']"));
        String mon = MonthlyText.getText();
        System.out.println(mon);
        WebElement QuarterlyText = contextSetUp.driver.findElement(By.xpath("//strong[text()='Quarterly']"));
        String Quat = QuarterlyText.getText();
        System.out.println(Quat);
        WebElement SemiAnnuallyText = contextSetUp.driver.findElement(By.xpath("//strong[text()='SemiAnnually']"));
        String Semi = SemiAnnuallyText.getText();
        System.out.println(Semi);
        WebElement AnnuallyText = contextSetUp.driver.findElement(By.xpath("//strong[text()='Annually']"));
        String Ann = AnnuallyText.getText();
        System.out.println(Ann);
        if (term.equalsIgnoreCase(mon)) {
            WebElement Monthly = contextSetUp.driver.findElement(By.xpath("//input[@id='Monthly']"));
            JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
            js.executeScript("arguments[0].click();", Monthly);
            // Monthly.click();
        } else if (term.equalsIgnoreCase(Quat)) {
            WebElement Quarterly = contextSetUp.driver.findElement(By.xpath("//input[@id='Quarterly']"));
            JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
            js.executeScript("arguments[0].click();", Quarterly);
            //  Quarterly.click();

        } else if (term.equalsIgnoreCase(Semi)) {
            WebElement SemiAnnually = contextSetUp.driver.findElement(By.xpath("//input[@id='SemiAnnually']"));
            JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
            js.executeScript("arguments[0].click();", SemiAnnually);
            //   SemiAnnually.click();
        } else if (term.equalsIgnoreCase(Ann)) {
            WebElement Annually = contextSetUp.driver.findElement(By.xpath("//input[@id='Annually']"));
            JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
            js.executeScript("arguments[0].click();", Annually);
            //   Annually.click();
        } else {
            System.out.println("No payment Frequency is selected");
        }

    }


    @When("I Entered {string} {string} {string}")
    public void i_entered(String NameOnCard, String CardNumber, String CVV) {
        // Write code here that turns the phrase above into concrete actions
        WebElement Name_On_Card = contextSetUp.driver.findElement(By.xpath("//input[@id='cardName']"));
        Name_On_Card.sendKeys(NameOnCard);
        WebElement Card_Number = contextSetUp.driver.findElement(By.xpath("//input[@id='cardNumber']"));
        Card_Number.sendKeys(CardNumber);
        List<WebElement> Month = contextSetUp.driver.findElements(By.xpath("//select[@id='expMonth']//option"));
        Month.stream().filter(e -> e.getText().equalsIgnoreCase(" April ")).forEach(WebElement::click);
//        for (WebElement ele : Month) {
//            String Card_Month = ele.getText();
//            System.out.println("Total months are:" + Card_Month);
//            if (Card_Month.equalsIgnoreCase(" April ")) {
//                ele.click();
//                break;
//
//            }
//        }

        List<WebElement> Year = contextSetUp.driver.findElements(By.xpath("//select[@id='expYear']//option"));
        Year.stream().filter(e -> e.getText().equalsIgnoreCase(" 2030 ")).forEach(WebElement::click);
//        for (WebElement ele : Year) {
//            String CardYear = ele.getText();
//            System.out.println("Total Years are:" + CardYear);
//            if (CardYear.equalsIgnoreCase(" 2030 ")) {
//                ele.click();
//                break;
//
//            }
//        }

        WebElement SecurityCode = contextSetUp.driver.findElement(By.xpath("//input[@id='securityCode']"));
        SecurityCode.sendKeys(CVV);

    }

    @When("I Entered {string} {string} {string}  {string}")
    public void i_entered(String Address, String Address2, String City, String PostalCode) {
        // Write code here that turns the phrase above into concrete actions
        WebElement BillingAddress = contextSetUp.driver.findElement(By.xpath("//input[@id='paymentBillingAddress']"));
        BillingAddress.sendKeys(Address);
        WebElement BillingAddress2 = contextSetUp.driver.findElement(By.xpath("//input[@id='paymentBillingAddress2']"));
        BillingAddress2.sendKeys(Address2);
        WebElement BillingPaymentCity = contextSetUp.driver.findElement(By.xpath("//input[@id='paymentBillingCity']"));
        BillingPaymentCity.sendKeys(City);
        List<WebElement> state = contextSetUp.driver.findElements(By.xpath("//select[@id='paymentBillingState']//option"));
        state.stream().filter(e -> e.getText().equalsIgnoreCase(" Maine ")).forEach(WebElement::click);
        for (WebElement ele : state) {
            String BillingState = ele.getText();
            System.out.println("Total States are:" + BillingState);
            if (BillingState.equalsIgnoreCase(" Maine ")) {
                ele.click();
                break;

            }
        }
        WebElement PostalZipCode = contextSetUp.driver.findElement(By.xpath("//input[@id='paymentBillingPostalCode']"));
        PostalZipCode.sendKeys(PostalCode);
    }

    @When("I click on I certify checkbox")
    public void i_click_on_i_certify_checkbox() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(3000);
        WebElement CertifyCheckbox = contextSetUp.driver.findElement(By.xpath("//input[@id='24hourCheck']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", CertifyCheckbox);
        //     CertifyCheckbox.click();

    }

    @When("I click on Terms of service checkbox")
    public void i_click_on_terms_of_service_checkbox() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        WebElement TermsOfService = contextSetUp.driver.findElement(By.xpath("//input[@id='termsCheck']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", TermsOfService);
        Thread.sleep(15000);

    }

    @When("I click on Pay")
    public void i_click_on_pay() {
        // Write code here that turns the phrase above into concrete actions
        WebElement Pay = contextSetUp.driver.findElement(By.xpath("//button[@id='payButton']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", Pay);

    }

    @Then("Monthly Policy Enrolled Successfully")
    public void monthly_policy_enrolled_successfully() {
        // Write code here that turns the phrase above into concrete actions
        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
        WebElement PolicyNumber = contextSetUp.driver.findElement(By.xpath("//div[contains(text(),'Policy Number')]/following::div[1]"));
        String Policy = PolicyNumber.getText();
        System.out.println("New Business Policy Number is:" + Policy);

    }

    @And("I click on BankAccount")
    public void iClickOnBankAccount() {
        WebElement BankAccount = contextSetUp.driver.findElement(By.xpath("//strong[contains(text(),'Bank Account')]"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", BankAccount);

    }

    @And("I Entered NameOnAccount {string} {string}")
    public void iEnteredNameOnAccount(String RoutingNumber, String AccountNumber) {

        String BankName = fs.name().name();
        WebElement BankAccName = contextSetUp.driver.findElement(By.xpath("//input[@id='bankName']"));
        BankAccName.sendKeys(BankName);
        WebElement RoutingNumb = contextSetUp.driver.findElement(By.xpath("//input[@id='bankRoutingNumber']"));
        // BankAccName.click();
        RoutingNumb.sendKeys(RoutingNumber);
        WebElement AccountNumb = contextSetUp.driver.findElement(By.xpath("//input[@id='bankAccount']"));
        //    AccountNumb.click();
        AccountNumb.sendKeys(AccountNumber);
    }

    @And("I Click on Coverage Start Date")
    public void iClickOnCoverageStartDate() {
        WebElement policyCoverageDate = contextSetUp.driver.findElement(By.xpath("//input[@id='coverageStartDate']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", policyCoverageDate);
        policyCoverageDate.clear();
        policyCoverageDate.sendKeys("06102021");
        js.executeScript("arguments[0].click();", policyCoverageDate);
    }

    @Given("Selected the Future date")
    public void selected_the_future_date() throws InterruptedException {
        WebElement futureDate = contextSetUp.driver.findElement(By.xpath("//input[@id='coverageStartDate']"));
        //  futureDate.clear();
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", futureDate);
        Thread.sleep(1000);
        List<WebElement> datePicker = contextSetUp.driver.findElements(By.xpath("//div[@class='btn-light ng-star-inserted']"));
        int siz = datePicker.size();
        System.out.println("the size of dates is:" + siz);
        int min_val = 1;
        int max_val = 34;
        Random rand = new Random();
        int randomNum = min_val + rand.nextInt((max_val - min_val) + 1);
        System.out.println("Random Number: " + randomNum);
        for (int i = randomNum; i < datePicker.size(); i++) {
            WebElement val = datePicker.get(i);
            System.out.println("the value of dates is:" + val.getText());
            Thread.sleep(8000);
            js.executeScript("arguments[0].click();", val);
            break;

        }
    }

    @And("I click on Invoice wit CC")
    public void iClickOnInvoiceWitCC() throws InterruptedException {
        WebElement InvoiceWithCC = contextSetUp.driver.findElement(By.xpath("//label[contains(text(),'Invoice with a credit card down payment.')]"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", InvoiceWithCC);
        Thread.sleep(15000);
    }

    @And("I click on Decline Personal Property Coverage OK button")
    public void iClickOnDeclinePersonalPropertyCoverageOKButton() throws InterruptedException {
        Thread.sleep(20000);
        WebElement DeclinePropertyCoverageBtn = contextSetUp.driver.findElement(By.xpath("//button[contains(text(),'OK')]"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", DeclinePropertyCoverageBtn);

    }

    @And("Selected {string}")
    public void selected(String Package) {
        List<WebElement> packages = contextSetUp.driver.findElements(By.xpath("//select[@id='propertyCoverage']/option"));
        for (WebElement ele : packages) {
            String values = ele.getText();
            System.out.println("Package value is:" + values);
            if (values.equalsIgnoreCase(Package)) {
                ele.click();
                break;
            }
        }
    }

    @And("I click on SemiAnnually and Annually Payment Frequency {string} for Zero Liability")
    public void iClickOnSemiAnnuallyAndAnnuallyPaymentFrequencyForZeroLiability(String term) {
        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        WebElement SemiAnnuallyText = contextSetUp.driver.findElement(By.xpath("//strong[text()='SemiAnnually']"));
        String Semi = SemiAnnuallyText.getText();
        System.out.println(Semi);
        WebElement AnnuallyText = contextSetUp.driver.findElement(By.xpath("//strong[text()='Annually']"));
        String Ann = AnnuallyText.getText();
        System.out.println(Ann);
        List<String> frequency = new ArrayList<>();
        frequency.add(Semi);
        frequency.add(Ann);
        WebElement SemiAnnually = contextSetUp.driver.findElement(By.xpath("//input[@id='SemiAnnually']"));
        WebElement Annually = contextSetUp.driver.findElement(By.xpath("//input[@id='Annually']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        frequency.stream().filter(e -> {
            if (term.equalsIgnoreCase(Semi)) {
                js.executeScript("arguments[0].click();", SemiAnnually);
            } else if (term.equalsIgnoreCase(Ann)) {
                js.executeScript("arguments[0].click();", Annually);
            }
            return false;
        });

//        if (term.equalsIgnoreCase(Semi)) {
//          //  WebElement SemiAnnually = contextSetUp.driver.findElement(By.xpath("//input[@id='SemiAnnually']"));
//            JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
//            js.executeScript("arguments[0].click();", SemiAnnually);
//        } else if (term.equalsIgnoreCase(Ann)) {
//            WebElement Annually = contextSetUp.driver.findElement(By.xpath("//input[@id='Annually']"));
//            JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
//            js.executeScript("arguments[0].click();", Annually);
//        } else {
//            System.out.println("No payment Frequency is selected");
//        }

    }

    @Then("I Entered ANICO {string}")
    public void iEnteredANICO(String PropertyName) {
        WebElement propertyName = contextSetUp.driver.findElement(By.xpath("//input[@id='txtPropertyNameAddress']"));
        propertyName.sendKeys(PropertyName);

    }

    @And("I Click on Property Radio button")
    public void iClickOnPropertyRadioButton() throws InterruptedException {
        WebElement searchProperty = contextSetUp.driver.findElement(By.xpath("//input[@id='btnSearchProperty']"));
        searchProperty.click();
        Thread.sleep(10000);
        WebElement Columns_Property = contextSetUp.driver.findElement(By.xpath("//tbody[@id='proplisting'] //input[@type='radio']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", Columns_Property);
        Thread.sleep(20000);
        List<WebElement> Columns_rowUnit = contextSetUp.driver.findElements(By.xpath("//tbody[@id='Locationslisting']  //input[@type='radio']"));
        int totalUnits = Columns_rowUnit.size();
        System.out.println("total units are:" + totalUnits);
        for (WebElement webElement : Columns_rowUnit) {
            webElement.click();
            break;
        }
        Thread.sleep(1000);
    }

    @And("I Click on ANICO T&C OK button")
    public void iClickOnANICOTCOKButton() throws InterruptedException {
        Thread.sleep(1000);
        contextSetUp.driver.switchTo().activeElement();
        WebElement TC_OK = contextSetUp.driver.findElement(By.xpath("//div[@class='col-sm-6'] //button[text()=' OK ']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", TC_OK);
    }

    @And("I Selected the {string} and {string}")
    public void iSelectedTheAnd(String Endorsement, String JW2500_5000) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        WebElement pet = contextSetUp.driver.findElement(By.xpath("//strong[contains(text(),'Pet Damage')]"));
        String PetDamage = pet.getText();
        WebElement water = contextSetUp.driver.findElement(By.xpath("//strong[contains(text(),'Water Backup')]"));
        String WaterBackUp = water.getText();
        WebElement jewelry = contextSetUp.driver.findElement(By.xpath("//strong[contains(text(),'Jewelry Theft')]"));
        String JewelryTheft = jewelry.getText();
        WebElement identity = contextSetUp.driver.findElement(By.xpath("//strong[contains(text(),'Identity Recovery')]"));
        String identityRecovery = identity.getText();
//        WebElement HurricaneDeductible = contextSetUp.driver.findElement(By.xpath("//strong[contains(text(),'Hurricane Deductible Reduction')]"));
//        String HurricaneDeductibleReduction = HurricaneDeductible.getText();
//        WebElement Bed_BugRemediation = contextSetUp.driver.findElement(By.xpath("//strong[contains(text(),'Bed Bug Remediation')]"));
//        String BedBugRemediation = Bed_BugRemediation.getText();

        List<String> endorsements = new ArrayList<>();
        endorsements.add(PetDamage);
        endorsements.add(WaterBackUp);
        endorsements.add(JewelryTheft);
        endorsements.add(identityRecovery);
//        endorsements.add(HurricaneDeductibleReduction);
//        endorsements.add(BedBugRemediation);
        endorsements.forEach(System.out::println);

        Thread.sleep(20000);
        if (Endorsement.equalsIgnoreCase(PetDamage)) {
            WebElement PetDamageEndorsement = contextSetUp.driver.findElement(By.xpath("//input[@id='Pet Damage']"));
            js.executeScript("arguments[0].click();", PetDamageEndorsement);
        } else if (Endorsement.equalsIgnoreCase(WaterBackUp)) {
            WebElement WaterBackUpEndorsement = contextSetUp.driver.findElement(By.xpath("//input[@id='Water Backup']"));
            js.executeScript("arguments[0].click();", WaterBackUpEndorsement);
            WebElement WaterBackUpRemoveConfirmButton = contextSetUp.driver.findElement(By.xpath("//button[text()='Confirm']"));
            contextSetUp.driver.switchTo().activeElement();
            js.executeScript("arguments[0].click();", WaterBackUpRemoveConfirmButton);
            js.executeScript("arguments[0].click();", WaterBackUpEndorsement);
        } else if (Endorsement.equalsIgnoreCase(JewelryTheft)) {
            WebElement JewelryTheft_2500 = contextSetUp.driver.findElement(By.xpath("//option[contains(text(),'Increased Jewelry Sublimits-$2,500')]"));
            String JewelryTheft_2500_Option = JewelryTheft_2500.getText();
            WebElement JewelryTheft_5000 = contextSetUp.driver.findElement(By.xpath("//option[contains(text(),'Increased Jewelry Sublimits-$5,000')]"));
            String JewelryTheft_5000_Option = JewelryTheft_5000.getText();
            if (JewelryTheft_2500_Option.equalsIgnoreCase(JW2500_5000)) {
                WebElement JewelryTheftBox = contextSetUp.driver.findElement(By.xpath("//select[@aria-label='Jewelry Theft']"));
                JewelryTheftBox.click();
                JewelryTheft_2500.click();
                WebElement JewelryRadioButton = contextSetUp.driver.findElement(By.xpath("//input[@id='Jewelry Theft']"));
                js.executeScript("arguments[0].click();", JewelryRadioButton);
            } else if (JewelryTheft_5000_Option.equalsIgnoreCase(JW2500_5000)) {
                WebElement JewelryTheftBox = contextSetUp.driver.findElement(By.xpath("//*[@id='coverageComponent']/div[3]/p[2]/select"));
                JewelryTheftBox.click();
                Thread.sleep(1000);
                JewelryTheft_5000.click();
                WebElement JewelryRadioButton = contextSetUp.driver.findElement(By.xpath("//input[@id='Jewelry Theft']"));
                js.executeScript("arguments[0].click();", JewelryRadioButton);
            } else if (Endorsement.equalsIgnoreCase(identityRecovery)) {
                WebElement identityRecoveryEndorsement = contextSetUp.driver.findElement(By.xpath("//input[@id='Identity Recovery']"));
                js.executeScript("arguments[0].click();", identityRecoveryEndorsement);
            }
//            } else if (Endorsement.equalsIgnoreCase(HurricaneDeductibleReduction)) {
//                WebElement HurricaneDeductible_Reduction = contextSetUp.driver.findElement(By.xpath("//input[@id='Hurricane Deductible Reduction']"));
//                js.executeScript("arguments[0].click();", HurricaneDeductible_Reduction);
//            } else if (Endorsement.equalsIgnoreCase(BedBugRemediation)) {
//                WebElement BedBug = contextSetUp.driver.findElement(By.xpath("//input[@id='Bed Bug Remediation']"));
//                js.executeScript("arguments[0].click();", BedBug);
//            }
        }

    }

    @And("I entered on Back Date {string}")
    public void iEnteredOnBackDate(String BackDate) throws InterruptedException {
        WebElement AllDatePicker = contextSetUp.driver.findElement(By.xpath("//input[@id='Alldatepicker']"));
        AllDatePicker.click();
        //  List<WebElement> EffDates = contextSetUp.driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
        //current date
        AllDatePicker.sendKeys(BackDate);
        System.out.println("the date is:" + BackDate);
        Thread.sleep(3000);
        AllDatePicker.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        contextSetUp.driver.switchTo().activeElement();
        WebElement DisclaimerPopUp = contextSetUp.driver.findElement(By.xpath("//input[@id='chkConfirmation']"));
        DisclaimerPopUp.click();
        WebElement DisclaimerPopUpOK = contextSetUp.driver.findElement(By.xpath("//button[@id='btnLDOk']"));
        DisclaimerPopUpOK.click();

        // Next
        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        contextSetUp.driver.switchTo().frame("rp-insurance-widget");
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        Actions at = new Actions(contextSetUp.driver);
        at.sendKeys(Keys.PAGE_DOWN).build().perform();
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement customRadioButton = contextSetUp.driver.findElement(By.xpath("//label[@for='custom']"));
        js.executeScript("arguments[0].click();", customRadioButton);
    }

    @And("I selected on ANICO Property {string}")
    public void iSelectedOnANICOProperty(String PropertyName) {
        List<WebElement> searchFirstProperty = contextSetUp.driver.findElements(By.xpath("//div [@id='propertyResults'] //div[@class='row']"));
        System.out.println("the list of property:" + searchFirstProperty.size());
        for (WebElement ele : searchFirstProperty) {
            String values = ele.getText();
            System.out.println(values);
            if (values.contains(PropertyName)) {
                JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
                js.executeScript("arguments[0].click();", ele);
                break;
            }
        }
    }

    @And("I Clicked on Custom Radio Button")
    public void iClickedOnCustomRadioButton() {
        WebElement customRadioButton = contextSetUp.driver.findElement(By.xpath("//label[@for='custom']"));
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("arguments[0].click();", customRadioButton);
    }

    @And("I select the future date")
    public void iSelectTheFutureDate() {
        WebElement AllDatePicker = contextSetUp.driver.findElement(By.xpath("//input[@id='Alldatepicker']"));
        AllDatePicker.click();
        Calendar cal = Calendar.getInstance();
        int date = cal.get(Calendar.DATE);
        System.out.println(date);
        WebElement webTable = contextSetUp.driver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/table/tbody"));
        List<WebElement> rows_table = webTable.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        loop:
        for (int row = 0; row < rows_count; row++) {
            List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
            for (WebElement ele : Columns_row) {
                int columns_count = Columns_row.size();
                System.out.println("Number of cells In Row " + row + " are " + columns_count);
                List<WebElement> values = ele.findElements(By.tagName("a"));
                for (WebElement ele1 : values) {
                    String cellText = ele1.getText();
                    if (Integer.parseInt(cellText) > date) {
                        ele1.click();
                        break loop;
                    }
                }
//                break;
            }

        }
        System.out.println("-------------------------------------------------- ");
        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        contextSetUp.driver.switchTo().frame("rp-insurance-widget");
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement customRadioButton = contextSetUp.driver.findElement(By.xpath("//label[@for='custom']"));
        js.executeScript("arguments[0].click();", customRadioButton);
    }

    @And("I select the Back date")
    public void iSelectTheBackDate() throws InterruptedException {
        WebElement AllDatePicker = contextSetUp.driver.findElement(By.xpath("//input[@id='Alldatepicker']"));
        AllDatePicker.click();
        Calendar cal = Calendar.getInstance();
        int date = cal.get(Calendar.DATE);
        System.out.println(date);
        WebElement webTable = contextSetUp.driver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/table/tbody"));
        List<WebElement> rows_table = webTable.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        System.out.println("rows count is:" + rows_count);
        loop:
        for (int row = 0; row < rows_count; row++) {
            List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));
            for (WebElement ele : Columns_row) {
                int columns_count = Columns_row.size();
                System.out.println("Number of cells In Row " + row + " are " + columns_count);
                List<WebElement> values = ele.findElements(By.tagName("a"));
                //               values.stream().filter(e -> Integer.parseInt(e.getText()) < date).forEach(e -> e.click());

                for (WebElement ele1 : values) {
                    String cellText = ele1.getText();
                    System.out.println("dates are:" + cellText);
                    if (Integer.parseInt(cellText) < date) {
                        ele1.click();
                        // break;
                        Thread.sleep(2000);
                        contextSetUp.driver.switchTo().activeElement();
                        WebElement DisclaimerPopUp = contextSetUp.driver.findElement(By.xpath("//input[@id='chkConfirmation']"));
                        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
                        js.executeScript("arguments[0].click();", DisclaimerPopUp);
                        WebElement DisclaimerPopUpOK = contextSetUp.driver.findElement(By.xpath("//button[@id='btnLDOk']"));
                        js.executeScript("arguments[0].click();", DisclaimerPopUpOK);
                        break loop;
                    }

                }
            }
        }

        System.out.println("-------------------------------------------------- ");
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        contextSetUp.driver.switchTo().frame("rp-insurance-widget");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement customRadioButton = contextSetUp.driver.findElement(By.xpath("//label[@for='custom']"));
        js.executeScript("arguments[0].click();", customRadioButton);


    }

    @And("I Click on Future Date")
    public void iClickOnFutureDate() {
        WebElement AllDatePicker = contextSetUp.driver.findElement(By.xpath("//input[@id='Alldatepicker']"));
        AllDatePicker.click();
        AllDatePicker.sendKeys("04/12/2023");
        JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        AllDatePicker.sendKeys(Keys.ENTER);

        // Next
        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        contextSetUp.driver.switchTo().frame("rp-insurance-widget");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement customRadioButton = contextSetUp.driver.findElement(By.xpath("//label[@for='custom']"));
        js.executeScript("arguments[0].click();", customRadioButton);
    }

    @And("I click on MAIC Monthly Payment Frequency {string}")
    public void iClickOnMAICMonthlyPaymentFrequency(String term) {
        contextSetUp.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        WebElement MonthlyText = contextSetUp.driver.findElement(By.xpath("//strong[text()='Monthly']"));
        String mon = MonthlyText.getText();
        System.out.println(mon);
        if (term.equalsIgnoreCase(mon)) {
            WebElement Monthly = contextSetUp.driver.findElement(By.xpath("//input[@id='Monthly']"));
            JavascriptExecutor js = (JavascriptExecutor) contextSetUp.driver;
            js.executeScript("arguments[0].click();", Monthly);
        }
    }
}

