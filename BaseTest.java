package com.company.tests.base;

import com.company.pages.LoginPage;
import com.company.utils.ConfigReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader config;
    
    @BeforeEach
    public void setUp() {
        config = new ConfigReader();
        String browser = System.getProperty("browser", config.getProperty("browser"));
        
        switch (browser.toLowerCase()) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
        }
        
        driver.manage().window().maximize();
        login();
    }
    
    private void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(
            config.getProperty("username"),
            config.getProperty("password")
        );
    }
    
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
