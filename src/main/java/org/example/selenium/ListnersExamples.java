package org.example.selenium;

import org.testng.annotations.Test;

public class ListnersExamples {

//
//    onStart: ListnerTest
//    onTestStart: method
//            method
//    onTestSuccess: method
//    onTestStart: method4
//            method4
//    onTestSuccess: method4
//    onTestStart: method1
//            method1
//    onTestSuccess: method1
//    onTestStart: method2
//            method2
//    onTestSuccess: method2
//    onFinish: ListnerTest


    @Test
    public void method() {
        System.out.println("method");
    }

    @Test(priority = 1)
    public void method1() {
        System.out.println("method1");
    }

    @Test(priority = 2)
    public void method2() {
        System.out.println("method2");
    }

    @Test(enabled = false)
    public void method3() {
        System.out.println("method3");
    }

    @Test
    public void method4() {
        System.out.println("method4");
    }
}
