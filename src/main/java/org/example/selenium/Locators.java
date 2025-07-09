package org.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main(String[] args) throws InterruptedException {

        // amazon - https://www.amazon.com/
        // yatra - https://www.yatra.com/
        // google - https://www.google.com/

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        try{
            WebElement ele = driver.findElement(By.xpath("//span//button[text()='Continue shopping']"));
            ele.click();
            Thread.sleep(2000);
        }
        finally{
        }
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("div span input[id=\"nav-search-submit-button\"]")).click(); // class name

    }
}
