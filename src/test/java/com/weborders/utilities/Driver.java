package com.weborders.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    //same for everyone
    private static WebDriver driver;

    //no one can create object of Driver class
    //everyone should call static getter method instead
    private Driver(){

    }
    public static WebDriver getDriver(){
        //if webdriver object doesn't exist
        //create it
        if(driver==null){
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();
            switch(browser){
                case "chrome":
                    WebDriverManager.chromedriver().version("79").setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized"); // to maximize browser alternatif other method
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "chromeheadless":
                    //to run chrome without interface (headless mode)
                    WebDriverManager.chromedriver().version("79").setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driver = new ChromeDriver(options);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Wrong browser name!");
            }
        }
        return driver;
    }
    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null; // to make sure object detsroyed
        }
    }

}

