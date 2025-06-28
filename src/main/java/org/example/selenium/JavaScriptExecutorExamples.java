package org.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class JavaScriptExecutorExamples {
    static WebDriver driver;

    //  WebDriver driver4 = new RemoteWebDriver();
    //   reason: RemoteWebDriver() has protected access in org.openqa.selenium.remote.RemoteWebDriver
    // has NO default constructor

    public static void main(String[] args) throws IOException, InterruptedException {

        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(); // local Execution

            // Js Executor
            JavascriptExecutor js = (JavascriptExecutor) driver;
            //  Object executeScript(String script, Object... args); | min 1 >> script Rest Var Arg

            driver.get("https://demo.nopcommerce.com/");
            driver.manage().window().maximize();


            //draw border around element
            WebElement ele = driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));
            js.executeScript("arguments[0].style.border='5px solid red'", ele);

            // take screenshot
            TakesScreenshot t = (TakesScreenshot) driver;
            File source = t.getScreenshotAs(OutputType.FILE);
            File target = new File("C:\\Users\\shubh\\Desktop\\My_Folder\\logo.png");
            FileUtils.copyFile(source, target);

            Thread.sleep(5000);

            // Flash
            WebElement eee = driver.findElement(
                    By.xpath("//button[@class=\"button-1 search-box-button\"]"));
            String bg_color = ele.getCssValue("backgroundColor");
            for(int i=0; i<=10; i++){
                js.executeScript("arguments[0].style.backgroundColor='#ff0000'", eee);
                js.executeScript("arguments[0].style.backgroundColor='"+bg_color+"'", eee);
            }

            // doc title
            String s = js.executeScript("return document.title").toString();
            System.out.println(s);

            Thread.sleep(5000);

            // Scroll down
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

            Thread.sleep(5000);

            // Scroll up
            js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");

            Thread.sleep(5000);

            // Scroll into view
            WebElement eww = driver.findElement(By.xpath("//div//strong[text()='Featured products']"));
            js.executeScript("arguments[0].scrollIntoView(true);", eww);

            Thread.sleep(5000);

            //Zoom
            js.executeScript("document.body.style.zoom='200%'");

            Thread.sleep(5000);

            // Refresh
            js.executeScript("history.go(0)");


            Thread.sleep(5000);

            // Click action
            WebElement ele1 = driver.findElement(By.xpath("//a[@class=\"ico-register\"]"));
            js.executeScript("arguments[0].click()", ele1);

            Thread.sleep(5000);

            // Js alert
            String var_str = "kuch bhi ?";
            js.executeScript("alert('" + var_str + "')");

            Thread.sleep(5000);
        }
        finally {
            driver.quit();
        }


    }
}
