package org.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class FramesExamples {
    static WebDriver driver;


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        try {
            driver = new ChromeDriver(); // local Execution
            driver.get("https://ui.vision/demo/webtest/frames/");
            driver.manage().window().maximize();

            // multiple frames/iframes = [0,1, 2] index / [one, two ,three] name
            // driver.switchTo().frame(Index); return type >> WebDriver
            // driver.switchTo().frame(Name); return type >> WebDriver
            // driver.switchTo().frame(WebElement); return type >> WebDriver

            WebElement ele_1 = driver.findElement(By.xpath("//*[@src=\"frame_1.html\"]"));
            driver.switchTo().frame(ele_1);
            driver.findElement(By.xpath("//input[@name=\"mytext1\"]")).sendKeys("ccccc");
            Thread.sleep(2000);

            driver.switchTo().defaultContent(); // if driver pointed to some other frame

            WebElement ele_2 = driver.findElement(By.xpath("//*[@src=\"frame_2.html\"]"));
            driver.switchTo().frame(ele_2);
            driver.findElement(By.xpath("//input[@name=\"mytext2\"]")).sendKeys("dddd");
            Thread.sleep(2000);

            driver.switchTo().defaultContent(); // if driver pointed to some other frame

            WebElement ele_3 = driver.findElement(By.xpath("//*[@src=\"frame_3.html\"]"));
            driver.switchTo().frame(ele_3);
            driver.findElement(By.xpath("//input[@name=\"mytext3\"]")).sendKeys("eeee");
            Thread.sleep(2000);
            //nested iframe


            WebElement inside_frame = driver.findElement(
                    By.xpath("//iframe[@src=\"https://docs.google.com/forms/d/1yfUq-GO9BEssafd6TvHhf0D6QLDVG3q5InwNE2FFFFQ/viewform?embedded=true\"]"));
            driver.switchTo().frame(inside_frame);


            WebElement round_1 = driver.findElement(
                    By.xpath("//div[@class=\"ulDsOb\"]//span[contains(text(),'Hi, I am the UI.Vision IDE')]"));
            round_1.click();
            Thread.sleep(2000);

            JavascriptExecutor js = (JavascriptExecutor)driver;
            WebElement to_scroll = driver.findElement(By.xpath("//span[text()=\"Web Testing\"]"));
            js.executeScript("arguments[0].scrollIntoView(true)",to_scroll);
            Thread.sleep(2000);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            driver.quit();
        }
    }


}
