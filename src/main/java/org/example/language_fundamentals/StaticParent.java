package org.example.language_fundamentals;

public class StaticParent {

    static int i = 10;

    static {
        m1();
        System.out.println("Base Static Block");
    }

    public static void main(String[] args) {
        m1();
        System.out.println("Base main");
    }

    public static void m1() {
        System.out.println(j);
    }

    static int j = 20;
}
