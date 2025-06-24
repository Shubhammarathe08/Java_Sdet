package org.example.oops;

public class Methods {

    /*
       Method -

       access modifier + return type + method name + (parameter list) {
           // method body
       }

       public void m1(int x, float y) {
               System.out.println(x + y);
               }
 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
       signature - method name + argument types |  ex.  m1 ( int x , float y )
       ** return type + access modifier >> nit part of method signature

       for every class >> compiler maintain >> method table
       m1(int x )   m2(String s)
       Test t = new Test();
       t.m1(10); // m1(int x)
       t.m2("hello"); // m2(String s)
       t.m3(10.11); // error - no such method with double argument : method m3(double) not found in method table

       *** compiler use ,method signature to resolve method calls
 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

       2 method with same signature in same class - not allowed
       public int     m1(int x) { return 10; }
              String  m1()(int x) { return "hello"; }
       // compile time error :- m1 already defined in class Methods

 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   Over Loading     >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


       Overloading / Compile time polymorphism / Static polymorphism / Early binding

      2 method >> same name + diff argument ( type or number differs)
      *** access modifier + return type not part of method signature

      >> works in same class or in child class
      >> var - cant be overloaded
      >> constructor -can be overloaded
      >> method - can be overloaded *** including main() method , but JVM looks for main() method with signature
         public static void main(String[] args) { ... }  >> this is the entry point of Java program
      >> method resolution - done by compiler at compile time - based on REFERENCE TIME |  *** just like Inheritance

      Advantage of Overloading -
        >> same method name - easy to remember , use ,maintain , multiple version of same method


 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   Over Loading     >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

      Over riding / Run time polymorphism / Dynamic polymorphism / Late binding

      whatever methods parent has, by default available to child through inheritance
      if child class not satisfied with parent class implementation of method,
      child is allowed to redefine the method, based on its requirement

      2 methods >> same name + same argument ( type and number same) BUT different implementation (** for redefining)

      >> works in child class only | *** in same class compile time error - method already defined
      >> var - cant be overridden
      >> constructor - cant be overridden
      >> method - can be overridden | *** only in child class
      >> method resolution - done by JVM at run time - based on OBJECT

      Advantage of Overriding -
        >> child class can provide its own implementation of method, based on its requirement
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>





    */
    public static void main(String[] args){

    }
}
