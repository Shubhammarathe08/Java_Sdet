package org.example.oops;

import java.io.IOException;

public class SuperThisParent1 {
    /*


    super - refer super class >> var, methods , blocks | immediate super class
    this - current class >> var, methods , blocks | current class object | based on args

    *** cant use in static area | may it be Block , Method , Variable , Class

    >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>..
    super () - super class constructor
    this () - current class constructor
    only in constructor
    only in first line
    only one | not both simultaneously
    only once

    */
    int a = 10;
    static String aa = "a";

    SuperThisParent1() throws ArithmeticException, IOException {
        super();
       //  this(); recursive constructor call
        System.out.println(this.a);
        System.out.println(aa);
        System.out.println("SuperThisParent1 constructor");
    }

    void m1(){
        System.out.println(this.a);
        System.out.println(aa);
        System.out.println("instance parent m1()");
    }

    void m2(int... x){
        this.m1();
        System.out.println(aa);
        System.out.println("instance parent m1()");
    }

    static void m3(){
//        System.out.println(this.a);  cant use this/super static area
//        this.m1();
//        this.m2(1,2,3);
        System.out.println("static parent m2()");
    }

    {
        System.out.println("instance parent block");
        System.out.println(this.a);
        this.m1();
        this.m2(1,2,3);
    }

    static{
        System.out.println("static parent block");
    }

    public static void main(String[] args){
        // System.out.println(this.a); cant use in static area
        System.out.println(aa);
    }

}
