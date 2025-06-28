package org.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BasicSelenium {
     /*
         WebDriver >> package org.openqa.selenium;
         RemoteWebDriver >> package org.openqa.selenium.remote;
         ChromeDriver >> package org.openqa.selenium.chrome;

         RemoteWebDriver (C)  Implements
         >> WebDriver, JavascriptExecutor, TakesScreenshot,
         >> FindsById,FindsByName,FindsByClassName,FindsByTagName,FindsByLinkText,FindsByXPath,FindsByCssSelector
         >> HasInputDevices, HasCapabilities, Interactive, HasVirtualAuthenticator
     * */
    WebDriver driver = new ChromeDriver(); // local Execution
    ChromeDriver driver1 = new ChromeDriver();
    ChromiumDriver driver2 = new ChromeDriver();
    RemoteWebDriver driver3 = new ChromeDriver();


   //  WebDriver driver4 = new RemoteWebDriver();
    //   reason: RemoteWebDriver() has protected access in org.openqa.selenium.remote.RemoteWebDriver
    // has NO default constructor

    public static void main(String[] args) throws MalformedURLException {

         WebDriverManager.chromedriver().setup();
//
//        // 1. Selenium Grid hub URL
//        URL url = new URL("http://localhost:4444/wd/hub");
//
//        // 2. Desired browser capabilities
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setBrowserName("chrome");
//
//        // 3. Create RemoteWebDriver instance
//        WebDriver driver0 = new RemoteWebDriver(url, caps);

        WebDriver driver = new ChromeDriver(); // local Execution

        // Js Executor

        JavascriptExecutor js = (JavascriptExecutor) driver;


    }

}
