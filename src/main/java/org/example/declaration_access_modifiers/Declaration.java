package org.example.declaration_access_modifiers;
import java.util.ArrayList;
import java.util.Arrays;

public class Declaration {

    /*
  class A {
  }
  class B {
  }
  class C {
  }

  // java file >> can contain any no. of class
  // at most 1 class = public |1 or 0 *** a proram can not have multiple public classes
  // class  having >> public + main method + same file name // otherwise : compile time error
  // name of program == name of public class *** mandatory
  // if there is no public class , can use any name out of multiple classes


  class A {
  p s v main(){
  System.out.println("Hello from A");
              }
  }
  class B {
    p s v main(){
  System.out.println("Hello from A");
              }
  }
  class C {
  }
  file name >> Test.java

  we can compile | java program | java source file | .java file
  javac Test.java
  for every class >> in a program >> separate .class file is created

  java A / java B / java C
  we can run or executed |  java class file | .class file
  we can run any class from the file
  corresponding >> class >> main method wil be executed

  java c // runtime error >> NoSuchMethodError: main
  java Test // runtime error >> NoClassDefFoundError: Test

    Not recommended to have multiple classes in a single file

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

 fully qualified name >> package name + class name |  less compile time + same execution time
 *** reduces name conflicts , reduces readability
     - package org.example.DeclarationAccessModifiers;
     - java.lang.String
     - java.util.List

 import statements >> used to import classes/interfaces from other packages | MORE compile time + same execution time
 *** alternative to use fully qualified name + increases readability
 *** no .class file will be loaded at beginning,dynamic include at runtime, load on demand
    - import org.example.DeclarationAccessModifiers.Declaration;
    - import java.lang.String;
    - import java.util.List;
*** can't specify member(methods, var) in normal import / only name not()
 - import java.lang.String.length; // invalid


*** Subpackage level classes/interface/method not available to the parent package
need to write until the subpackage level to access the class/interface/method
      java
         util
            regex
                Pattern
   java.* >> can't use Pattern directly
   java.util.regex.* >> can use Pattern directly

        java
           lang
              reflect
                  Method
   java.lang.* >> can't use Pattern directly | java.lang.reflect.Method m ;

   java.lang.reflect.* >> can use Method directly

    import statement >> used to import classes/interfaces from other packages
    - import java.util.regex.Pattern; // explicit class import
    - import java.util.regex.*; // implicit class import | wildcard .*

Explicit Class Import >> import statement used to import a specific class from a package | specific
// more readable
    - import org.example.DeclarationAccessModifiers.Declaration;

Implicit Class Import >> import statement used to import all classes from a package | wildcard .*
// reduces readability
    - import org.example.DeclarationAccessModifiers.*;


import  java.util.*
import java.sql.*
Date d = new Date();
// runtime error >> Reference to Date is ambiguous, both 'java.util.Date' and 'java.sql.Date' match

List >> util , awt -> same ambiguity

Priority >> 1. Explicit Class Import
                            > classes present in current working directory (default package)
                                  > Implicit Class Import
                                      > Fully Qualified Name
import  java.util.Date
import java.sql.*
Date d = new Date(); //util.date

// all classes/interface >> present is available to all no need to import

         java.lang
         default package / current working directory

// static import >> used to import static members (fields and methods) of a class or interface

with static import >>
        double sqrtValue = Math.sqrt(25.0);
        System.out.println("Square root: " + sqrtValue);

        double piValue = Math.PI;
        System.out.println("Value of PI: " + piValue);

        import static java.lang.System.out;
        class System {
        static PrintStream out ;
        }
        >> out.println("Hello World");
        System >> class in java.lang
        out >> static var of type PrintStream
        println() >> method present in PrintStream class

        import static org.example.DeclarationAccessModifiers.Test.s
        class Test {
        static String s = "java";
        }
        >> s.length()

Priority >> 1. classes present in current working directory (default package)
                      > Explicit Class Import>
                             > Implicit Class Import
                                     > Fully Qualified Name

import static java.lang.Integer.*
import static java.lang.Byte.*

class A {
static int MAX_VALUE = 100;
}
System.out.println(MAX_VALUE);
}
// o/p 100 >> in this case
// o/p 2147483647 - if import static java.lang.Integer.MAX_VALUE;
// o/p 127 - if import static java.lang.Byte.MAX_VALUE;


--->>>>>>>>>----------->>>>>>>>>>---------------->>>>>>>>>>>-------------->>>>>>>>

without static import >>
        import static java.lang.Math.*;
        double sqrtValue = sqrt(25.0); // No need for Math.sqrt
        System.out.println("Square root: " + sqrtValue);

        double piValue = PI;         // No need for Math.PI
        System.out.println("Value of PI: " + piValue);

        class System {
        static PrintStream out ;
        }
        >> System.out.println("Hello World"); // static import not required
        System >> class in java.lang
        out >> static var of type PrintStream
        println() >> method present in PrintStream class

        class Test {
        static String s = "java";
        }
        >> Test.s.length() // static import not required

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
  Rules

  normal import
  1. after class name ;   java.lang.Math; not Math.*
  2. talks upto class level only, not members    java.lang.Math; not Math.sqrt
  3. after package name .* compulsory   java.lang.*;  make all classes available
  4. to import classes/interfaces of particular package | fully qualified name  ( not required )

  static import
  1. after class name .* applicable   java.lang.Math.*;  make all static member available
  2. talks upto class level  + members    java.lang.Math.sqrt; not Math.sqrt()
  3. to import static members of a class/interface | class name  (  not required )



     */
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(); // fully qualified name
        ArrayList<Integer> list2 = new ArrayList<>(); // import statement used

        java.lang.reflect.Method m ;

    }


}
class A extends ArrayList<Integer> {   // can use fully qualified names, no issue | but less readable

}
