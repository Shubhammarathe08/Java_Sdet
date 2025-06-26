package org.example.language_fundamentals;

public class StaticChild extends StaticParent {

    // step 1- identify static member >> parent to child >> top to bottom
    // execution - static var - assignment >>  Then >> static blocks >>  parent to child >>  Top-Bottom
    // execution of main method >> child ONLY***
    // whenever we are loading child class >> auto parent class will be loaded VICE VERSA doesn't happen
    // inheritance

    static int x = 100;

    static {
        m2();
        System.out.println("Derived First Static Block");
    }

    public static void main(String[] args) {
        m2();
        System.out.println("Derived main");
    }

    public static void m2() {
        System.out.println(y);
    }

    static {
        System.out.println("Derived Second Static Block");
    }

    static int y = 200;

}
