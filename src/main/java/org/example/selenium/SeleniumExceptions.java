package org.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumExceptions {

    static WebDriver driver;


    public static void main(String[] args) {

        driver = new ChromeDriver(); // local Execution

        /*

        0. WebDriverException ( parent class ) // unchecked exceptions
           throw new WebDriverException();
            WebDriverException extends RuntimeException

        1. when: session not created
           throw new SessionNotCreatedException();
           Browser-driver version incompatibility.

        2.  when: Forgot to set system property
            throw new IllegalStateException()
             The path to the driver executable must be set by the webdriver.chrome.driver system property

        3.  when: Somehow trying to access driver which is null
             throw new NullPointerException();

         4.  when :Shadow DOM detached after locating.
           throw new DetachedShadowRootException();

           Handle by: Re-locating shadow root before action.
           // Suppose element is in shadow DOM

           WebElement shadowRoot = driver.findElement(By.cssSelector("my-element")).getShadowRoot();
          // If page reloads or element re-renders
           shadowRoot.findElement(By.cssSelector("button")).click(); // DetachedShadowRootException

         5. when:- The website has an invalid, expired, self-signed, or untrusted SSL/TLS certificate.
          throw new InsecureCertificateException()
         Handle :- Accept Insecure Certificates (Recommended for automation only)
         ChromeOptions options = new ChromeOptions();
         options.setAcceptInsecureCerts(true);  // Accept insecure certificates

         6. when: Thrown when a command does not complete in enough time.
           throw new TimeoutException()
           handle :- use explicit wait, analyze application   then assign wait
           ** only explicit wait/fluent wait throws exception

        7. when taking a screenshot fails due to:
          throw new ScreenshotException()
           Driver does not support screenshots
          e.g. RemoteWebDriver without screenshot capability.
           Session is invalid or closed
           Element is outside viewport or stale (if taking element screenshot).
           Browser compatibility issue
         (Old browser version + new driver or vice versa).

         handle : use try catch\

         8. when :This exception is thrown when trying to move the mouse to a location
                   outside the viewport or browser window.
                throw new MoveTargetOutOfBoundsException()
          handle :- Check your browser window dimensions and use within bounds.
                   Ensure element has width/height > 0


         */


    /*  NotFoundException
       | **Exception**                 | **Parent Class**                       | **When it occurs**                           | **Resolution**                                                      |
| ----------------------------- | -------------------------------------- | -------------------------------------------- | ------------------------------------------------------------------- |
| **NoSuchElementException**    | NotFoundException → WebDriverException | Element not found in DOM.                    | ✔ Check locator.✔ Use explicit wait.✔ Check frame.                  |
| **NoSuchFrameException**      | NotFoundException                      | Frame index/name invalid or not present.     | ✔ Validate frame exists.✔ Use correct index/name.               |
| **NoSuchWindowException**     | NotFoundException                      | Switching to closed/non-existing window.     | ✔ Loop `getWindowHandles()` before switch.                          |
| **NoSuchAttributeException**  | NotFoundException                      | Attribute not present in element.            | ✔ Check attribute existence before getAttribute().                  |
| **NoSuchShadowRootException** | NotFoundException                      | Accessing shadow root on non-shadow element. | ✔ Ensure element supports shadow DOM.                               |
| **NoSuchCookieException**     | NotFoundException                      | Cookie not found for domain/session.         | ✔ Validate cookie existence before retrieval.                       |
| **NoSuchDriverException**     | WebDriverException                     | Driver not initialized or closed.            | ✔ Initialize driver before use. ✔ Avoid use after driver.quit(). |

//-------------------------------------------------------------------------------------

| **Exception**                        | **Cause**                                                          | **When it Occurs**                                      | **Example**                                         | **Handling (code snippet)**
| ------------------------------------ | ------------------------------------------------------------------ | ------------------------------------------------------- | --------------------------------------------------- | ----------------------------------------------------------------------------------------------
| **ElementNotInteractableException**  | Element present in DOM/not visible/enabled for interaction. | Trying to click or sendKeys on a hidden/disabled input. | `<input type="text" style="display:none">`                  |explicit value / make ele visible/clickable (js) + click / enable (js) + javascript executor
| **ElementClickInterceptedException** | Element is covered by another element.                             | Click is blocked by loader or popup.                    | `<div class="overlay"></div><button>Click</button>` | explicit wait / javascript executor
| **ElementNotSelectableException**    | Trying to select unselectable option.                              | Selecting a disabled option in dropdown.                | `<option disabled>Option</option>`                  | explicit wait / javascript executor
| **ElementNotVisibleException**       | Element is in DOM but hidden.                                      | Interaction with invisible elements.                    | `<div style="display:none"></div>`                  | explicit value / make ele visible/clickable (js) + click / enable (js) + javascript executor

//-----------------------------------------------------------------------------------------------

| **Check**    | **Method**                | **Returns** |
| ------------ | ------------------------- | ----------- |
| **Enabled**  | `isEnabled()`             | true/false  | // element, button, dropdown, checkbox, radio button, textarea, etc.
| **Selected** | `isSelected()`            | true/false  | // checkboxes, radio buttons
| **Visible**  | `isDisplayed()`           | true/false  | // all elements
| **Present**  | `findElements().size()>0` | true/false  |

//------------------ stale element ---------------
StaleElementReferenceException in Selenium
✅ What is it?
➡️ StaleElementReferenceException occurs when:
You refer to an element that is no longer attached to the current DOM.
✔️ Common reasons:
Page reloads or navigates after finding the element.
DOM is updated dynamically (AJAX calls, JS frameworks) causing elements to refresh or re-render.
Element is removed and re-added, making the old reference invalid (stale).

Solution 1: Re-locate element before use
WebElement el = driver.findElement(By.id("myButton"));
driver.navigate().refresh();
el = driver.findElement(By.id("myButton")); // re-locate
el.click();

//--------------------------------- invalid* exceptions  ------------------


| **Exception**                      | **Cause**                                    | **When it Occurs**                               | **Handling (Example)**                                                                                                                              |
| ---------------------------------- | -------------------------------------------- | ------------------------------------------------ | --------------------------------------------------------------------------------------------------------------------------------------------------- |
| **InvalidSelectorException**       | Invalid XPath or CSS selector syntax.        | Wrong syntax or unsupported locator strategy.    | ✅ Check syntax:<br>`driver.findElement(By.xpath("//input[@id='username']"))`<br>❌ Avoid:<br>`driver.findElement(By.xpath("//input[@id='username']"` |
| **InvalidArgumentException**       | Passing invalid or malformed arguments.      | Sending wrong type values to WebDriver commands. | ✅ Validate arguments before sending. Example:<br>Ensure file paths or element references are correct.                                               |
| **InvalidElementStateException**   | Element in invalid state for operation.      | Sending keys to readonly fields.                 | ✅ Check element state:<br>`if(el.isEnabled()){ el.sendKeys("abc"); }`                                                                               |
| **InvalidCookieDomainException**   | Adding cookie to different domain.           | URL domain mismatch.                             | ✅ Switch to the same domain before adding cookies.                                                                                                  |
| **InvalidSessionIdException**      | Session ID invalid or closed.                | Driver.quit() called before command.             | ✅ Ensure driver is active before performing actions.                                                                                                |
| **InvalidSwitchToTargetException** | Switching to invalid frame/window handle.    | Frame/window not present or closed.              | ✅ Use available handles:<br>`driver.switchTo().window(handle)` after verifying with `getWindowHandles()`.                                           |
| **InvalidCoordinatesException**    | Invalid coordinates provided to Actions API. | Moving to off-screen or negative coordinates.    | ✅ Calculate valid coordinates within viewport.                                                                                                      |


         */
//-------------------------------------------------------------------------------------
    }
}
