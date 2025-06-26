package org.example.language_fundamentals;

public class InstanceExecutionOrder {

    // instance member will be identified / initialised / executed - if Object creation happens
    // step1 - main method checking
    // step 2 - identification of instance members | Top to Bottom
    // step 3 - execution of instance assignment + instance block
    // step 4 - constructors execution ** for every object

    int i = 10;

    {
        m1();
        System.out.println("First Instance Block");
    }

    InstanceExecutionOrder() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        InstanceExecutionOrder t = new InstanceExecutionOrder();
        System.out.println("main");
    }

    public void m1() {
        System.out.println(j);
    }

    {
        System.out.println("Second Instance Block");

    }
    int j = 20;
}
