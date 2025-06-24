package org.example.language_fundamentals;

public class MainMethod {

    /*
       The main method is the entry point of a Java application.
       w/o main method >> javac Test // valid
       w/o main method >> java Test // invalid, JVM looks for main method to start execution
       whether class contains main method + its upto requirement >> checked by JVM

       if JVM unable to find main method >> runtime exception :
Error: Main method not found in class org.example.Test, please define the main method as: public static void main(String[] args)
       or a JavaFX application class must extend javafx.application.Application

       public >> to be called by JVM from anywhere
       static >> without existing object , JVM has to call this method
       void >> main method won't return anything to caller , JVM
       main >> name configured inside JVM instructions
       string[] args >> command line arguments | String... args | String[] my_args
       only allowed modifier >> final synchronized strictfp public
       unique >> final synchronized strictfp static public void main(String... my_args)

       Over Loading of main method is allowed, but JVM will always look for the main method with the exact signature
       Other overloaded method, we have to call explicitly to execute, like normal methods.

       public class Test{
    public static void main(String[] args) {
        System.out.println("Hello World");
        main(1);
                                           }
    public static void main(int... args) {
        System.out.println("bye World");
                                         }
                            }

       Parent class main method available to child class >> inheritance
       *** if child doesn't contain main method then parent class main method will be executed
       javac p >> p.class , c.class
       java p - parent class main method
       java c - parent class main method

       class P {
          public static void main(String[] my_args)
            {
            System.out.println("parent class main method");
             }
       }
       class C extends P {
       }

       Over-riding of main method is not allowed, if child class contains main method then parent class main method will not be executed
       it will be Method Hiding, not Overriding

       public class Test{
          public static void main(String[] args) {
          System.out.println("Hello World");
                                                 }
                        }
      class Baccha extends Test{
         public static void main(String[] args) {
         System.out.println("bye World");
                                                }
                                }


    */

     static public void main(String[] my_args)
        {
            System.out.println("Hello, World!");
        }

     static public void main(int... my_int)
       {
        System.out.println("Hello, World!");
      }


}
