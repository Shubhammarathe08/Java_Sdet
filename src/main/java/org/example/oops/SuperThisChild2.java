package org.example.oops;

import java.io.IOException;

public class SuperThisChild2 extends SuperThisChild1 {
    int c = 30;
    static String cc = "c";



    SuperThisChild2() throws IOException {
        System.out.println("no arg i overloaded SuperThisChild2 constructor");
    }

    SuperThisChild2(int i) throws IOException {
        System.out.println("int i overloaded SuperThisChild2 constructor");
    }


    SuperThisChild2(double d) throws IOException {
        System.out.println("double i overloaded SuperThisChild2 constructor");
    }

    void m1() {
        System.out.println("instance child2 m1()");
    }

    static void m2() {
        System.out.println("static child2 m2()");
    }

    {
        System.out.println("instance child2 block");
    }

    static {
        System.out.println("static child2 block");
    }

    public static void main(String[] args) {
        try {
            SuperThisChild2 c = new SuperThisChild2();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
