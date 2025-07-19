package org.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;import org.openqa.selenium.By;

import java.awt.*;
import java.awt.event.KeyEvent;


public class ActionsClassExamples {
    static WebDriver driver;


    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        try {
            driver = new ChromeDriver(); // local Execution

            // Actions class (Supply driver)
            Actions actor = new Actions(driver);

            // Mouse hover / Click and hold /Drag and drop
            // Right-click (context click) /Double-click/Keyboard events (SHIFT, CTRL, etc.)

            WebElement ele = null;

            actor.moveToElement(ele).perform(); // mouser hover

            actor.click(ele); // click
/*
| **Method**             | **How**                                          | **Use Case**                                                               | **Limitation**                                  |
| ---------------------- | ------------------------------------------------ | -------------------------------------------------------------------------- | ----------------------------------------------- |
| **driver.click()**     | WebDriver native click                           | Default click when element is visible and enabled                          | Fails if blocked, hidden, or intercepted        |
| **Actions.click()**    | Moves mouse + click (realistic user interaction) | Hover menus, dynamic elements needing focus                                | Fails if element is not interactable            |
| **JSExecutor.click()** | JS direct DOM click                              | Last resort for stubborn elements, off-screen, hidden but clickable in DOM | Skips WebDriver event flow, not real user click |


driver.findElement(By.xpath("")).click()

Actions actions = new Actions(driver);
actions.moveToElement(element).click().build().perform();

 JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].click();", element);

            // Locate the element to hover over
            WebElement accountLists = driver.findElement(By.id("nav-link-accountList"));

            // Create Actions object
            Actions actions = new Actions(driver);

            // Move to the element (mouse hover)
            actions.moveToElement(accountLists).build().perform();

            // Optionally, click on sub-menu item after hover
            WebElement yourOrders = driver.findElement(By.linkText("Your Orders"));
            actions.moveToElement(yourOrders).click().build().perform();


*/


            Actions actions = new Actions(driver);
//------------------------------------------------------------------------------------------------------------
            ele.click(); //normal driver.click()
            actions.doubleClick(ele).build().perform(); // left click double
            actions.contextClick(ele).build().perform(); // right click

//            .build() - compiles multiple actions into a single executable action sequence (ActionChain).
//            .perform() - then executes that built sequence.

            // normal click()
            // actions click()
            // javascript click()
//-----------------------------------------------------------------------------------------------------------
             // drag and drop
            driver.findElement(By.id("aaa")).sendKeys("abbbbc");

            WebElement source = driver.findElement(By.id("draggable"));
            WebElement target = driver.findElement(By.id("droppable"));

            // Method 1: Using dragAndDrop directly
            actions.dragAndDrop(source, target).build().perform();

            // Method 2: Using clickAndHold + moveToElement + release + build().perform()
            // This is useful when dragAndDrop doesn't work due to JS issues
            actions.clickAndHold(source)
                    .moveToElement(target)
                    .release()
                    .build()
                    .perform();
//--------------------------------------------------------------------------------------------
              // key strokes

//
//            >> Basic Principle (Actions Class Keyboard Events)
//           ✅ keyDown(Keys.KEY) → press and hold key (without releasing)
//           ✅ sendKeys("char") → type character(s) while previously held keys remain pressed
//           ✅ keyUp(Keys.KEY) → release previously held key


//            ⚠️ Why it matters?
//                    If you just use sendKeys(Keys.CONTROL, "c"):
//        CONTROL is pressed and released, then “c” is pressed – not combined.

            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver");

            // up and down arrow
            actions.sendKeys(Keys.ARROW_DOWN).perform(); // Press DOWN arrow
            actions.sendKeys(Keys.ARROW_RIGHT).perform(); // Press RIGHT arrow

            // Press Enter key using Keys class
            searchBox.sendKeys(Keys.ENTER);  // keys enum

            //escape
            actions.sendKeys(Keys.ESCAPE).perform();

            //switch to tab
            actions.sendKeys(Keys.TAB).perform();
//----------------------------  Keys Combo ---------------------------------------
            //ctrl+c

//Why do we write CONTROL two times?
//✔ First keyDown(Keys.CONTROL)
//This presses and holds the CTRL key.
//Internally, it sends a keydown event for CTRL to the browser.
//✔ Then .sendKeys("c")
//This presses and releases "c" key while CTRL is still held down, resulting in CTRL + C combined shortcut.
//✔ Finally .keyUp(Keys.CONTROL)


            // why cant use with ? sendKeys()
            actions.keyDown(Keys.CONTROL) // press CTRL
                    .sendKeys("c")         // press c while CTRL held
                    .keyUp(Keys.CONTROL)   // release CTRL
                    .perform();

            //ctrl+v
            actions.keyDown(Keys.CONTROL)
                    .sendKeys("v")
                    .keyUp(Keys.CONTROL)
                    .perform();


//-------------------------------------------------------------------------------------------------
//            1. What is Robot class?
//✅ Robot class is part of java.awt package.
//✅ It is used to simulate native system input events like keyboard presses, mouse movements, clicks, etc.
//🔧 Why was it created?
//       To automate native system-level tasks.
//       It interacts outside browser context unlike Selenium WebDriver which is limited to browser DOM.

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_ALT);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        } finally{
            driver.quit();
        }
    }
}
