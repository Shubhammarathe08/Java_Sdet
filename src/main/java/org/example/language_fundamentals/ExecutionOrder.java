package org.example.language_fundamentals;

public class ExecutionOrder {

    {
        System.out.println("instance block executed");
    }

    static{
        System.out.println("static block executed");
    }


    ExecutionOrder(){
        System.out.println("no arg constructor executed");
    }

    ExecutionOrder(int x){
        System.out.println("int arg constructor executed");
    }

    <T> ExecutionOrder(T... t){
        System.out.println("var arg constructor executed");
    }

    {
        System.out.println("instance block executed after constructor");
    }


    int i1 = 100;
    static int i2 = 200;

    void m1(){
        System.out.println("void instance m1 executed");
    }

    static void m2(){
        System.out.println("static m2 executed");
    }

    public static void main(String[] args) {

        boolean local_var = true;

        System.out.println("main method executed");

        // Creating an instance of ExecutionOrder
        ExecutionOrder eo1 = new ExecutionOrder();

        // Creating an instance with int argument
        ExecutionOrder eo2 = new ExecutionOrder(10);

        // Creating an instance with var args
        ExecutionOrder eo3 = new ExecutionOrder(1, 2, 3);

    }

    public static void main(Character... args) {
        System.out.println("var arg char main method executed");
    }


}
