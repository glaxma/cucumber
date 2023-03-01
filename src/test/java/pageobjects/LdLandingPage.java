package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LdLandingPage {
    private final WebDriver driver;
//public WebDriver driver;


    @FindBy(xpath = "//input[@id='Login']")
    private WebElement userName;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement password;

    @FindBy(xpath = "//input[@value='LOG IN']")
    private WebElement Login;

    public LdLandingPage(WebDriver driver) {
        this.driver=driver;
    }

    public void enterUserNameAndPasswordAndLogin(String username, String Password ) {

        userName.sendKeys(username);
        password.sendKeys(Password);
        Login.click();
    }

}
