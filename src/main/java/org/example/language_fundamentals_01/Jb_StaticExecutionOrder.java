package org.example.language_fundamentals_01;

/*
 * Static execution order in Java
 *
 * 1. Static members are identified top to bottom.
 * 2. Static field initializers and static blocks execute top to bottom.
 * 3. main() runs after class loading completed.
 *
 * Important points:
 * - Static variables get default values first.
 * - Static methods can read static variables directly.
 * - If a static method reads a variable before its explicit assignment,
 *   it gets the default value.
 *
 * Example use of static block:
 * - Class loading time initialization
 * - JDBC driver registration
 *
 * Ways to print without main():
 * - static block
 * - static field initializer calling a method
 * - static object creation in static context
 */

public class Jb_StaticExecutionOrder {

    // static field initialization
    static int i = 10;

    // first static block
    static {
        m1(); // j is still 0 here
        System.out.println("First static block");
    }

    // second static block
    static {
        m2(); // oll is still 0 here
    }

    // static field initialized after the second block
    static int oll = 100;

    public static void main(String[] args) {
        m1(); // now j is 20
        System.out.println("main method");
    }

    public static void m1() {
        System.out.println(j);
    }

    // third static block
    static {
        System.out.println("Second static block");
    }

    // static field initialized last
    static int j = 20;

    public static void m2() {
        System.out.println(oll);
    }
}