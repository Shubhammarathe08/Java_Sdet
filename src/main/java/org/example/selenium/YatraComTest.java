package org.example.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.*;

public class YatraComTest {
    static WebDriver driver;
    public static void main(String[] args){

        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");

             driver = new ChromeDriver(options);

            // JavascriptExecutor js = new JavascriptExecutor(); // its an interface , cant create obj
            // JavascriptExecutor js = new RemoteWebDriver(); // no XXX no-arg constructor
            // JavascriptExecutor js = new ChromeDriver(); // it will create new session
            // JavascriptExecutor js = driver // child ref cant hold parent object
            // WebDriver js = driver;

            JavascriptExecutor js = (JavascriptExecutor)driver; // make it on same level

            driver.get("https://www.yatra.com/"); //
            driver.manage().window().maximize();
            //driver.navigate().to();
            Thread.sleep(2000);
            try {
                WebElement ele0 = driver.findElement(By.xpath("// li[text()='SME Account']//ancestor::div[contains(@class,'style_popup')]//span//*[@alt=\"cross\"]"));
                ele0.click();
            }
            catch(Exception e){

            }
            Thread.sleep(2000);

            WebElement departure_date = driver.findElement(
                    By.xpath("//div[@aria-label=\"Departure Date inputbox\"]//div//*[text()='Departure Date']/parent::div/following-sibling::div"));
            Thread.sleep(2000);
            departure_date.click();
            Thread.sleep(2000);

            List<WebElement> dates = driver.findElements(By.xpath("//div[@class=\"react-datepicker__month-container\"][1]//div[contains(@class,'react-datepicker__day') and contains(@aria-disabled,\"false\") ]//span[@class='custom-day-content ']/parent::span"));
            List<WebElement> prices = driver.findElements(By.xpath("//div[@class=\"react-datepicker__month-container\"][1]//div[contains(@class,'react-datepicker__day') and contains(@aria-disabled,\"false\") ]//span[@class='custom-day-content ']"));
            List<String> sorted_list = new ArrayList<>();

            System.out.println(prices.get(0).getText()); //visible text

            System.out.println(prices.get(0).getAttribute("class")); //tag value
            System.out.println(prices.get(0).getAttribute("value")); //tag value
            System.out.println(prices.get(0).getAttribute("innerHTML")); // same as get text

            HashMap<String,String> map = new LinkedHashMap();
            for(int i=0; i<dates.size()-1; i++){
                map.put(dates.get(i).getText(),prices.get(i).getText().replace("₹",""));
                //
            }
            System.out.println(map);

//            for(WebElement w : prices){
//                String temp = w.getText();
//                String res = "";
//                    res = temp.replace("₹","");
//                    sorted_list.add(res);
//                  for(Character c: temp.toCharArray()){
//                      try {
//                          res = res + Integer.parseInt(c + "");
//                      }
//                      catch(Exception e){
//                          }
//                  }
//                System.out.println(res);
//            }
//            Collections.sort(sorted_list);
//            System.out.println(sorted_list);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            driver.quit();
        }


    }

    // https://www.yatra.com/
}
