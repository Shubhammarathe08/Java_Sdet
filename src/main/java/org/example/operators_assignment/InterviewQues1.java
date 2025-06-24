package org.example.operators_assignment;

public class InterviewQues1 {

    /*
         new (operator)  vs newInstance() (method in class Class)
         1. create object if we know the class at compile time
            can invoke based on our choice of constructor [*** only - no arg constructor]
         2. create object if we know the class at runtime
         Object o = class.forName(args[0]).newInstance();

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
         instanceof (operator)  vc isInstance() (method)

          Thread t = new Thread();
          System.out.println(t instanceof Thread); // true

          java test Runnable
          class.forName(args[0]).isInstance(t); // true

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
         classNotFoundException (unchecked) vc ClassNotFoundException (checked)

         Test t = new Test();
         Runtime Exception : NoClassDefFoundError : Test

          Object o = class.forName(args[0]).newInstance();
          java test Test123
          ** for dynamically provided class >> if at runtime the class is not found, it throws
          Runtime Exception : ClassNotFoundException : Test123


    */
}
