package org.example.language_fundamentals;

public class ExecutionOrder {

    // if all things are static >> class, var , block , method
    /*
     step 1 - identification of - static members
            >> static block 1, i2 , m2 ,2 main methods , static block 2 (parent-child >> top-bottom)
     step 2 - execution of static var + static blocks (parent-child >> top-bottom)
              i2 = 200

     op:- first static block executed
          second static block executed

     step 3 - execution of main | p s v m(String[] args)
               local_var = true
               op:- first static block executed
               second static block executed
               main method executed

     >>>> Object Creation >>>>

     step 4 -  identification of - instance members (parent-child >> top-bottom)
               >> instance block 1 , 3 constructors , i1, m1, instance block 2
     step 5 - execution of instance var + instance blocks (parent >> top-bottom)
               i1 = 100
               op:- first static block executed
               second static block executed
               main method executed
               first instance block executed
               second instance block

     step 6 - instance constructor (parent >> top-bottom)

               op:- first static block executed
               second static block executed
               main method executed
               first instance block executed
               second instance block
               no arg constructor executed

               first instance block executed
               second instance block
               int arg constructor executed

               first instance block executed
               second instance block
               no arg constructor executed
               var arg constructor executed

     step 7 - execution of instance var + instance blocks (child >> top-bottom)
     step 8 - instance constructor (child >> top-bottom)

 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    private static String m1(String msg) {
        System.out.println(msg);
        return msg;
    }

    public Initialization() {   // constructor
        m = m1("1");
    }

    {
        m = m1("2");
    }

    String m = m1("3");

    public static void main(String[] args) {
        Object o = new Initialization();
    }

output :- null | 2 (m=) , 3 (m=3) , 1 (m=1)


    */

    {
        System.out.println("first instance block executed");
    }

    static{
        System.out.println("first static block executed");
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

    static{
        System.out.println("second static block executed");
    }


    {
        System.out.println("second instance block");
    }

    public static void main(Character... args) {
        System.out.println("var arg char main method executed");
    }


}
