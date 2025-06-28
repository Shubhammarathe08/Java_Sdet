package org.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownsPractise {
    static WebDriver driver;


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        try {
            driver = new ChromeDriver(); // local Execution

            /*

            driver.get("https://testautomationpractice.blogspot.com/");
            driver.manage().window().maximize();

            // Select class >> xpath of dropdown - where select tag is
            WebElement select_dropdown = driver.findElement(By.xpath("//div/select[@class=\"form-control\" and @id=\"country\"]"));
            Select s = new Select(select_dropdown);

            s.selectByIndex(2); // index

            Thread.sleep(3000);

            s.selectByValue("canada"); // value

            Thread.sleep(3000);

            s.selectByVisibleText("\n" +
                    "        France\n" +
                    "      ");  // visible text

            Thread.sleep(3000);

            WebElement f_ele = s.getFirstSelectedOption(); // get first selected option WebElement
            System.out.println(f_ele);

            List<WebElement> all_opt = s.getAllSelectedOptions(); // get List of WebElements present options
            System.out.println(all_opt);

            Thread.sleep(3000);

            List<WebElement> ele_list = s.getOptions(); // WebLElement
            for(WebElement w:ele_list){
                System.out.println(w.getText());
            }

            */


            driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            WebElement button = driver.findElement(By.xpath("//div/input[@id=\"justAnInputBox\"]"));
            button.click();

            Thread.sleep(3000);

            WebElement choice_1 = driver.findElement(
                    By.xpath("//div//*[text()='Multi Selection']/parent::div//div//li[@class='ComboTreeItemChlid']/span[@data-id='0'][contains(text(),'choice 1  ')]"));
            choice_1.click();
            Thread.sleep(3000);



        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
//-------------------------------------------------------------------------------------------------------------
    }
}
