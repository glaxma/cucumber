package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public LdLandingPage LdLandingPage;
    public WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver=driver;
    }


    public LdLandingPage getLandingPage(){
       LdLandingPage=new LdLandingPage(driver);
       return LdLandingPage;
    }
}
