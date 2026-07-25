package org.example.language_fundamentals_01;

public class MainMethod {

    /*
    ====================================================================================
    1. DURGASOFT EXPLANATION OF: public static void main(String[] args)
    ====================================================================================
    To the JVM, this specific method is the mandatory configuration entry point.
    Whether a class contains the main method depends entirely on your project requirements.

    * Compilation Check: Running 'javac Test.java' without a main method is completely VALID.
    * Runtime Check: Running 'java Test' without a main method is INVALID. The JVM will check
      for the entry point at runtime and throw an exception if it is missing

 During Runtime (java Test): The error happens the moment the JVM tries to launch the application

 Error: Main method not found in class Test, please define the main method as:
   public static void main(String[] args)
or a JavaFX application class must extend javafx.application.Application

    Detailed Breakdown of the Signature Components:
    ------------------------------------------------------------------------------------
    * public       : Gives global access to the JVM (which lives outside your application's package).
                     If it's not public, access rules block the JVM, causing a runtime error.
    * static       : Allows the JVM to invoke the method without creating an instance of the class first.
                     If it weren't static, the JVM would have to guess how to invoke your class constructor.
    * void         : Tells the system that the main method returns no value to the JVM. When this method
                     finishes executing, the JVM process shuts down completely.
    * main         : The strict name configured directly inside the JVM's source code instructions.
    * String[] args: The command-line arguments array. Whatever input strings you type after the
                     filename (e.g., java Test arg1 arg2) are gathered by the JVM and passed here.
                     Can be written as 'String[] args', 'String... args', or 'String[] my_args'.

    ====================================================================================
    2. VALID SYNTAX VARIATIONS & MODIFIERS
    ====================================================================================
    You can alter the main syntax within strict Java rules, and the JVM will still accept it:

    * Order of Modifiers : You can swap public and static.
                           -> static public void main(String[] args)
    * Array Notation     : Brackets can go anywhere near the type or identifier.
                           -> public static void main(String []args)
                           -> public static void main(String args[])
    * Var-args Syntax    : You can replace the array syntax with var-args (...).
                           -> public static void main(String... args)
    * Allowed Keywords   : The only extra modifiers allowed are final, synchronized, and strictfp.
    * Ultimate Combination:
                           -> final synchronized strictfp static public void main(String... my_args)

    ====================================================================================
    3. METHOD OVERLOADING (Multiple main methods)
    ====================================================================================
    * Rule        : Overloading of the main method is fully allowed. You can write as many main methods
                    as you want, provided their parameter lists are different.
    * JVM Behavior: The JVM will ONLY call the standard String[] args version automatically.
                    Other overloaded versions act as normal methods and must be called explicitly.

    Example:
    public class Test {
        public static void main(String[] args) {
            System.out.println("Hello World");
            main(1); // Explicitly calling the overloaded version
        }
        public static void main(int... args) {
            System.out.println("bye World");
        }
    }

    ====================================================================================
    4. INHERITANCE, METHOD OVERRIDING VS. METHOD HIDING
    ====================================================================================
    * Inheritance : The parent class main method is fully inherited by the child class.
                    If the child doesn't define its own main method, executing the child class
                    will automatically run the parent class main method.
                    - java P -> prints "parent class main method"
                    - java C -> prints "parent class main method"

    * Overriding  : Dynamic method overriding is NOT allowed for static methods.
                    If a child class declares a static method with the exact same signature,
                    it is called METHOD HIDING, not overriding.

    * Why it's Hiding: Polymorphism relies on instance object types at runtime. Because static
                       methods undergo early binding (bound to the class at compile-time),
                       true dynamic overriding is structurally impossible for main.
    */

    // JVM checks syntax during linking and successfully matches this as the entry point
    static public void main(String[] my_args) {
        System.out.println("Standard JVM Entry Main Method Executed!");

        // Explicitly invoking the overloaded method
        main(new int[]{1, 2, 3});

        // Demonstrating Hiding Execution manually
        System.out.println("\n--- Inheritance & Hiding Demo ---");
        P.main(new String[]{});
        C.main(new String[]{});
    }

    // Overloaded Main Method (Acts as a standard user method)
    static public void main(int... my_int) {
        System.out.println("Overloaded Main Method with int var-args Executed!");
    }

    // Overloaded Main Method (Acts as a standard user method)
    static public void main(char c) {
        System.out.println("Overloaded Main Method with char c Executed!");
    }
}

// ====================================================================================
// COMPANION CLASSES TO DEMONSTRATE INHERITANCE & METHOD HIDING
// ====================================================================================
class P {
    public static void main(String[] my_args) {
        System.out.println("Parent class main method");
    }
}

class C extends P {
    // This hides P.main instead of overriding it due to the static modifier
    public static void main(String[] args) {
        System.out.println("Child class main method (Method Hiding)");
    }
}