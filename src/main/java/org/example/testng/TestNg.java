package org.example.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.*;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class TestNg {

/*
    @BeforeTest
    public void m2(){
        System.out.println("@BeforeTest");
    }
    @AfterTest
    public void m3(){
        System.out.println("@AfterTest");
    }
    @BeforeMethod
    public void m4(){
        System.out.println("@BeforeMethod");
    }
    @AfterMethod
    public void m5(){
        System.out.println("@AfterMethod");
    }
    @BeforeClass
    public void m6(){
        System.out.println("@BeforeClass");
    }
    @AfterClass
    public void m7(){
        System.out.println("@AfterClass");
    }
    @BeforeSuite
    public void m8(){
        System.out.println("@BeforeSuite");
    }
    @AfterSuite
    public void m9(){
        System.out.println("@AfterSuite");
    }
    @Test
    public void m1(){
        System.out.println("@Test");
    }

    @BeforeGroups
    public void m10(){
        System.out.println("  @BeforeGroups");
    }

    @AfterGroups
    public void m11(){
        System.out.println("@AfterGroups");
    }
 //---------------------------- Assertions ------------------------------

    @Test
    public void assertion(){

        // Hard Assert
        // If a hard assert fails, the current test method execution stops immediately.
        // If a condition failure makes the rest of the test invalid or risky to proceed./
        Assert.assertEquals("actual","expected");
        Assert.assertNotEquals("actual","expected");
        Assert.assertTrue(1==1);
        Assert.assertFalse(2!=2);

        //soft asserts
        // Collects all assertions in a test method, and executes them all,
        // reporting failures only at the end when .assertAll() is called.
        // You want to see all failures in one test execution, not one by one.
        SoftAssert sa =new SoftAssert();
        sa.assertEquals("actual","expected");
        sa.assertNotEquals("actual","expected");
        sa.assertTrue(1==1);
        sa.assertFalse('a'==1);

        sa.assertAll();
    }

    //---------------------------- Priority ------------------------------

    @Test(priority = 1)
    public void B() {
          System.out.println("priority_demo B");
    }

    @Test(priority = 1)
    public void A() {
        System.out.println("priority_demo A");
    }

    @Test(priority = 2)
    public void priority_demo2() {
        System.out.println("priority_demo2");
    }
    @Test(priority = -1)
    public void priority_demo3() {
        System.out.println("priority_demo-1");
    }

    @Test
    public void zzz() {
        System.out.println("no_priority zzz");
    }

    @Test
    public void yyy() {
        System.out.println("no_priority yyy");
    }

//    priority_demo-1
//    no_priority yyy
//    no_priority zzz
//    priority_demo A
//    priority_demo B
//    priority_demo2

    // -ve > non priority (alphabetical) >  priority (smaller > greater) * same order (alphabetical)

        //---------------------------- Priority ------------------------------

    @Test(groups = "Smoke")
    public void method_1() {
        System.out.println("method_1");
    }

    @Test(groups = "Sanity")
    public void method_2() {
        System.out.println("method_2");
    }

    @Test(groups = "Regression")
    public void method_3() {
        System.out.println("method_3");
    }
    @Test(groups = {"Smoke","Sanity","Regression"})
    public void method_4() {
        System.out.println("method_4");
    }
    @Test(groups = {"Smoke","Sanity"})
    public void method_5() {
        System.out.println("method_5");
    }

//<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
//<suite name="MySuite">
//    <test name="TestNgClassTest">
//        <groups>
//            <run>
//                <include name="Smoke"/>
//                <include name="Regression"/>
//            </run>
//        </groups>
//        <classes>
//            <class name="org.example.testng.TestNg"/>
//        </classes>
//    </test>
//</suite>              >>>> runs 1,3,4,5

*/
    //------------------------------  Enable Disable DependsOn---------------------------

    @Test(enabled = true)
    public void enable_disable_1() {
        System.out.println("enable_disable_1");
    }

    @Test()
    public void enable_disable_2() {
        System.out.println("enable_disable_2");
    }


    // not executed -> if this test depends on any grp,that failed/passed it will run anyways
    @Test(enabled = false ,alwaysRun = true)
    public void enable_disable_3() {
        System.out.println("enable_disable_3");
    }

    // fails if dependent methods fails
    @Test(dependsOnMethods = "enable_disable_3",alwaysRun = true)
    public void enable_disable_4() {
        System.out.println("enable_disable_4");
    }

    // fails if dependent methods fails
    @Test(dependsOnMethods = "enable_disable_1",alwaysRun = true)
    public void enable_disable_5() {
        System.out.println("enable_disable_4");
    }

//<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd" >
//<suite name="MySuite">
//    <test name="TestNgClassTest">
//        <classes>
//            <class name="org.example.testng.TestNg">
//                <methods>
//                    <exclude name="enable_disable_3"/>
//                </methods>
//            </class>
//        </classes>
//    </test>
//</suite>
//--------------------------------------------------------------------------------------------
}
