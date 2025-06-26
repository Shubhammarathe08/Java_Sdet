package org.example.oops;

import java.io.IOException;

public class SuperThisChild1 extends SuperThisParent1{
    int b = 20;
    static String bb = "b";


    SuperThisChild1() throws IOException {
        System.out.println("no arg overloaded SuperThisChild1 constructor");
    }

    SuperThisChild1(int i) throws IOException {

        System.out.println("int i overloaded SuperThisChild1 constructor");
    }

    void m1(){
        System.out.println("instance child1 m1()");
    }

    static void m2(){
        System.out.println("static child1 m2()");
    }

    {
        System.out.println("instance child1 block");
    }

    static{
        System.out.println("static child1 block");
    }

    public static void main(String[] args){
        //  SuperThisChild2 c = new SuperThisChild2(); No no arg const available in child2
    }
}
