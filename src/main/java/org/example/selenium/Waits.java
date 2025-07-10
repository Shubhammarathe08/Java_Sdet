package org.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Waits {

    static WebDriver driver;


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        try {
            driver = new ChromeDriver(); // local Execution
            driver.get("https://seleniumbase.io/demo_page");
            driver.manage().window().maximize();

            // implicit wait >>>>>>>>>>
            // applied to whole page - all elements // Duration.ofSeconds(30)
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // Waits up to 10 seconds for any element to appear before throwing NoSuchElementException.


            // explicit wait >>>>>>>>>>
            // wait for specific conditions to be true
            // if an element found before that - moves forward
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")));
            loginButton.click();

            // wait for title
            wait.until(ExpectedConditions.titleContains("Dashboard"));
            // Waits for an iframe to be available and switches context for further operations within it.
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("myFrame")));
            // Before clicking any button, link, or input that may take time to become active after loading.
            WebElement loginButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")));
            loginButton.click();
            // Before sending keys or reading text from an element to ensure it’s visible on U
            WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            username.sendKeys("myUser");
            // Ensures the element exists in the DOM even if not visible yet. Useful for hidden elements that become visible later via JS.
            WebElement hiddenElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("hiddenField")));
            //Waits for JavaScript alerts to appear before switching to them.
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            // Waits for loaders/spinners or overlays to disappear before proceeding.
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loader")));


            // fluent wait >>>>>>>>>>
            // FluentWait is useful when polling for conditions that might not be element-based,
            // such as waiting for a file to appear in a download directory.
            // Ignores NoSuchElementException during polling
            //  Use Fluent Wait for highly dynamic applications needing flexible polling and exception handling.
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);

            WebElement dynamicElement = fluentWait.until(driver1 -> driver1.findElement(By.id("dynamicId")));
            dynamicElement.click();
//===============================================================================================
            String downloadPath = "C:\\Users\\YourUser\\Downloads";
            String expectedFileName = "example.pdf";

            // FluentWait to check if file exists
            FluentWait<String> wait1 = new FluentWait<>(downloadPath)
                    .withTimeout(Duration.ofSeconds(30))   // total timeout
                    .pollingEvery(Duration.ofSeconds(2))   // polling interval
                    .ignoring(Exception.class);            // ignore all exceptions during wait

            wait1.until(new Function<String, Boolean>() {
                public Boolean apply(String path) {
                    File file = new File(path + File.separator + expectedFileName);
                    boolean exists = file.exists();
                    System.out.println("Checking file exists: " + exists);
                    return exists;
                }
            });

            System.out.println("File has been downloaded successfully.");
        }
        finally{
            driver.quit();
        }
    }
}
