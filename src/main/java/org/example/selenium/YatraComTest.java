package org.example.selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YatraComTest {
    static WebDriver driver;
    public static void main(String[] args){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.get("https://www.yatra.com/");
        driver.manage().window().maximize();


    }

    // https://www.yatra.com/
}
