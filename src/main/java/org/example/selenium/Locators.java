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


        /*
        driver.findElement(By.id("")); // id
        // amazon - cart | id="nav-cart-count"]
        // By.id("nav-cart-count")
//-------------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.name("")); // name
        // amazon - search box top | name="field-keywords"
        // By.name("field-keywords")
//-------------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.className("")); // class name
        // amazon - logo | class="nav-logo-link nav-progressive-attribute"
                    country flag element (top right)| class="icp-nav-link-inner"
        // By.className("nav-logo-link nav-progressive-attribute") X multiple classes
        // By.className("nav-logo-link") (single class) correct can use only single class here
        // By.className("icp-nav-link-inner")
//-------------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.tagName("")); // tag name
//-------------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.linkText("")); // link text ( test  behind which link is enabled )
        //amazon - sell section |  <a href="/b/?_encoding=UTF8&amp;ld=AZUSSOA-sell&amp;class="nav-a
                                    " tabindex="0" data-csa-c-type="link"  data-csa-c-content-id="nav_cs_sell" >
                                    Sell
                                    </a>
        //         By.linkText("Sell")
//-------------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.partialLinkText(""));// partial link text link text ( test  behind which link is enabled )
        // Amazon - returns and orders | Returns
                                            & Orders
        // By.partialLinkText("Returns")
//-------------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.xpath(""));// xpath
        // amazon - cart | id="nav-cart-count"
        //           By.xpath("//div/span[@id="nav-cart-count"")
        // amazon - return and orders| href="/gp/css/order-history?ref_=nav_orders_first"
        //           By.xpath("//div/a[@href="/gp/css/order-history?ref_=nav_orders_first"]")
//-------------------------------------------------------------------------------------------------------------------------------------
        driver.findElement(By.cssSelector(""));// css
        // amazon - search box zoom lens icon | div span input[id="nav-search-submit-button"]
        //          By.cssSelector("div span input[id=\"nav-search-submit-button\"]")
-------------------------------------------------------------------------------------------------------------------------------------
                       X apth and css
                       / - absolute xpath
                       // relative xpath |  ( / for immediate child )
                                             ( // for all children )
                       css       |  ( "" for immediate child )
                                  ( " " space for all children )
     ** absolute is faster
-------------------------------------------      C S S   L O C A T E R S      -----------------------------------------------------------

                                    General format >>  tag  , tag[attribute='value']

id : a[id='a-autoid']  -  a#a-autoid
class : a[class='a-button'] -  a.a-button
any random attribute :  div[aria-label='Your recently']

>>>>>> Partial matching  : attributes
Start: Tag[attribute ^= 'value']   Ex. div a img[ alt ^= 'OnePlus' ]
End: Tag[attribute $= 'value']  Ex. div a img[ alt $= 'OnePlus' ]
Tag[attribute *= 'value'] Ex. div a img[ alt *= 'OnePlus' ]

>>>> match text or partial text or contains
NO
SUCH
FUNCTIONALITY
>>>>>> Family Tree Navigation
Parent  - Can’t travel to parent node

first-child - li:first-child / li:first-of-type
target only the first child of the element's parent.

last-child - li:last-child
target only the last child of the element's parent.

only-child - span:only-child / li:only-of-type
target elements which are the only child of its parent.

nth-last-of-type - td:nth-last-of-type(2) / td:nth-last-child(2)
Select according to the type of element and nth last position of element.
>>>>>>>> more
Preceeding Sibling :- No such thing
Preceeding :- No such thing

following sibling / following ( + )
Ex : tr#extra_line+tr em

nth element - li:nth-of-type(2) / li:nth-child(2)
select according to the type of element and position of element.

Direct Child : ( > )
Descendents : ( space  )
>>>>>>>
    //dynamic elements
    //hidden elements
    //shadow dom elements
    // svg
    */


    }
}
