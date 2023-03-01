package utils;

import org.openqa.selenium.WebDriver;
import pageobjects.PageObjectManager;


public class ContextSetUp {
    public WebDriver driver;
    public PageObjectManager PageObjectManager;

    public ContextSetUp()  {
        PageObjectManager  = new PageObjectManager(driver);
    }
}
