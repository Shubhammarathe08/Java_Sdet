package org.example.selenium;

public class KeysActions {

    /*
Actions actions = new Actions(driver);

Basic Key Presses in Selenium
// Press ENTER
element.sendKeys(Keys.ENTER);
// Press SPACE
element.sendKeys(Keys.SPACE);
// Press TAB
element.sendKeys(Keys.TAB);
// Press SHIFT (usually combined with other keys)
element.sendKeys(Keys.SHIFT, "a"); // Types 'A' instead of 'a'
Key Combinations
For modifier keys (Shift/Ctrl/Alt) combined with other keys:
// SHIFT + Key (Types uppercase)
element.sendKeys(Keys.SHIFT, "hello"); // Outputs "HELLO"
// CTRL + A (Select all)
element.sendKeys(Keys.CONTROL + "a");
// ALT + TAB (Switch windows - may not work in all browsers)
element.sendKeys(Keys.ALT + Keys.TAB);
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Right Click (Context Click)
Selenium 3 & 4:
Actions actions = new Actions(driver);
WebElement element = driver.findElement(By.id("element"));
actions.contextClick(element).perform();
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Double CLick
WebElement input = driver.findElement(By.id("field"));
actions.doubleClick(input).perform();
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Drag and Drop | Selenium 3 & 4:

Drag and Drop
WebElement source = driver.findElement(By.id("source"));
WebElement target = driver.findElement(By.id("target"));
// Method 1: Standard drag-and-drop
actions.dragAndDrop(source, target).perform();
// Method 2: Precise control
actions.clickAndHold(source)
       .moveToElement(target)
       .release()
       .perform();
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
copy paste | ctrl+c ctrl+v
   way 1 :-
// Select text
WebElement input = driver.findElement(By.id("field"));
actions.doubleClick(input).perform();
// Ctrl+C
actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
// Ctrl+V to another field
WebElement target = driver.findElement(By.id("target"));
target.click();
actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

   way 2 :-
WebElement inputField = driver.findElement(By.id("textInput"));
// Ctrl+A (Select All)
inputField.sendKeys(Keys.CONTROL + "a");
// Ctrl+C (Copy)
inputField.sendKeys(Keys.CONTROL + "c");
// Ctrl+V (Paste into another field)
WebElement targetField = driver.findElement(By.id("targetField"));
targetField.sendKeys(Keys.CONTROL + "v");
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

*/
}
