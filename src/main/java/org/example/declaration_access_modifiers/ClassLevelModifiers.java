package org.example.declaration_access_modifiers;

import javax.swing.*;
import java.util.AbstractList;

class ClassLevelModifiers {

    /*
    <default> , public , private , protected
    final , abstract , static
    synchronized ,  strictfp , native , transient , volatile

    user create class level modifiers >> need to provide info to JVM
                         for TOP level class
    default >>
              accessible within the same package only | from outside package we cant access | package level access
    public >>
              accessible from anywhere in the application
    final >>
              cannot be extended , cant be inherited
    abstract >>
                cannot be instantiated, must be extended
                can have abstract methods
    strictfp >>
                applicable on class + methods + interfaces | ***  not applicable to variables or fields

                strictfp class A {
                strictfp public void calculate() {}
                        // floating-point calculations
                    }
                used to restrict floating-point calculations to ensure portability across different platforms
                follows IEEE 754 standard for floating-point arithmetic
                ensures consistent results across different JVM implementations
                all concrete methods in a strictfp class must also be declared as strictfp
                abstract + strictfp >> illegal [ method ] BUT legal [ class ]

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

                         for INNER level class
    TOP level +
    private >>
                accessible only within the enclosing class
    protected >>
                accessible within the same package and subclasses
    static >>
                belongs to the class itself rather than an instance of the class
                can be accessed without creating an instance of the class

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

   final >>
         class - cant be extended/inherited | every method  in final class >> always final | *** Not variable
         method - cant be over-ridden
         variable - cant be reassigned after initialization
         abstract - cannot be used with final + applicable for classes, methods | **not for variables
         >> final class >> cant have Abstract methods  | need to extend and implement abstract method, final restrict it, so not allowed

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

                                                           abstract
         // method

         class Vehicle(){
         abstract public getNoOfWheels(); // abstract method declaration
         }

         class AutoMobile extends Vehicle {
            @Override
            public int getNoOfWheels() {
                return 4; // implementation of abstract method
            }
         }
          method >> only declaration, but not implementation   run(); //  >> getNoOfWheels();
                 >> ends with semicolon ;
                 >> child class responsible to provide implementation
                 >> must be implemented by subclasses/extending class having abstract methods
                 >> by declaring abstract method in parent class, we are forcing the child class to implement it.
                 >> guideline for child class

 *** abstract + ( private , final , static , synchronized , native , strictfp  >> illegal combination, can't be used together
 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
            // class

            abstract class Vehicle {
                // abstract method
                abstract public int getNoOfWheels();
            }

             abstract class Vehicle {
            }

            class AutoMobile extends Vehicle {
                @Override
                public int getNoOfWheels() {
                    return 4; // implementation of abstract method
                }
            }
            // any java class >> having partial implementation/marked as abstract >> cant create instance/object of it
            // class >> can have both abstract and non-abstract methods | can have 0 abstract methods
            // class >> can have instance variables, constructors, and static methods/variables
            // if a class having at least 1 abstract method, we have to declare class as abstract
               error : missing method body or declare Vehicle as abstract
            ex. HttpServlet , Adapter Class
            // abstract class >> can not be instantiated directly
            //final class >> cant be inherited by subclasses
            // inside abstract class >> final methods are allowed

 *** abstract + ( private , final , static , synchronized , native , strictfp  >> illegal combination, can't be used together
    */

  public static void main(String[] args){
  }
}
