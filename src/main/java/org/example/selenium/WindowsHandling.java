package org.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Set;

public class WindowsHandling {
    static WebDriver driver;


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        try {
            driver = new ChromeDriver(); // local Execution
            driver.get("https://demo.automationtesting.in/Windows.html");
            driver.manage().window().maximize();

            WebElement click = driver.findElement(By.xpath("//button[text()=\"    click   \"]"));

            String parent_window = driver.getWindowHandle();
            System.out.println(parent_window);

            click.click();

            Set<String> window_set = driver.getWindowHandles();
            System.out.println(window_set);
            ArrayList<String> li = new ArrayList<>(window_set);

            driver.switchTo().window(li.get(1));
            Thread.sleep(3000);
            WebElement other = driver.findElement(By.xpath("//li/a[@class=\"nav-link dropdown-toggle\"]"));
            other.click();
            Thread.sleep(3000);

            driver.findElement(By.xpath("//li/a[@href=\"#Seperate\"]")).click();

         /*

            >> To handle parent window
            String MainWindow = driver.getWindowHandle();
            System.out.println("Main window handle is " + MainWindow);


          Set<String> s1 = driver.getWindowHandles(); //s1,s2,s3 ...
            System.out.println("Child window handle is" + s1);

            Iterator<String> i1 = s1.iterator();

            while (i1.hasNext()) {
                String ChildWindow = i1.next();
                if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
                    driver.switchTo().window(ChildWindow);
                    String pageTitle=driver.getTitle();
                    System.out.println("The web page title of child window is:"+pageTitle);
                    driver.close();
                    System.out.println("Child window closed");
                }
            }

         */


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally{
            driver.quit();
        }
//-------------------------------------------------------------------------------------
    }
}
