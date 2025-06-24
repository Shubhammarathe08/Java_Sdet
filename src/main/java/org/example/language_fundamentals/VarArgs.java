package org.example.language_fundamentals;

public class VarArgs {

    // Method with variable no of arguments
    /*  Var Arg methods allow you to pass a variable number of arguments to a method.
        1. It is useful when you want to create methods that can accept different numbers of parameters without overloading the method.
        2. The syntax for defining a var arg method is to use an ellipsis (...) after the data type in the method parameter list.
            m1(int ...x)
        3. Can call the method with any number of int arguments, including zero arguments.
            m1(10) , m1(10, 20), m1(10, 20, 30), m1() // all valid calls
        4. The var arg parameter must be the last parameter in the method signature.
        5. Var Arg parameter >> treated as an array of the specified type, allowing you to access the individual arguments passed to it.
        6. Access using index, like an array.  x.length gives the number of arguments passed.
           int... x >> int [] x
           int[]... x >> int[][] x
        7. can mix normal with var arg parameters, but the var arg parameter must always be the last parameter in the method signature.
         m1 (int x , int... v ) // valid
         m2 (String v , double... x ) // valid
         m3 (int... x , String v ) // invalid, var arg must be last
        8. At max 1 var arg parameter is allowed in a method signature.
          m4 (int... x, int... y) // invalid, two var args
        9. inside a class we cant declare var arg method and corresponding 1 d array method simultaneously,
            otherwise we will get compile time error
        10. Var arg methods can be overloaded with other methods,
        but the compiler will choose the most specific method based on the arguments passed.
        11. Var arg methods can be used with any data type, including primitive types and reference types.
           example :- m1 (Student... s) // valid, where Student is a class
        12. Var arg methods can be used with generic types,
            allowing you to create methods that can accept a variable number of arguments of any type.
            example :- m1 (T... t) // valid, where T is a generic type parameter
    13.  Just like Default in switch, if no other method matched, it will come into picture
                public static void main(int...){
           System.out.println("var arg method"):
        }
                public static void main(int x){
           System.out.println("general method"):
        }
                public static void main(String[] args){
           System.out.println(""):
           m1();  >> var arg method
           m1(10,20); >> var arg method
           m1(10); *** in case of conflict old will prevail | General method will be called
        }
      14. int[] x ==> int... x ( can be used interchangeably in var arg methods)
          main(String[] args) ==> main(String... args) (can be used interchangeably in var arg methods)
      15. Var arg methods can be used with lambda expressions and functional interfaces
           ex.
        Runnable r = () -> m1(10, 20, 30); // valid, passing variable number of arguments to the method


     */
}
