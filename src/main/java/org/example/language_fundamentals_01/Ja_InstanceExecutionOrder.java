package org.example.language_fundamentals_01;

/**
 * Demonstrates instance member initialization and execution order in Java.
 *
 * When an object is created:
 * 1. main method is checked (static flow).
 * 2. Instance members are identified top-to-bottom.
 * 3. Instance field initializers and instance initializer blocks execute
 *    in source order (top to bottom).
 * 4. Constructor is executed for every object.
 *
 * Important:
 * - Instance fields have default values (0, false, null) before their
 *   explicit initializers run.
 * - Calling a method that uses a field before that field is explicitly
 *   initialized will see its default value.
 */
public class Ja_InstanceExecutionOrder {

    // Instance field: initialized first (to 10)
    int i = 10;

    // First instance initializer block
    {
        // m1() uses 'j' before its explicit initialization (j's default is 0)
        m1();
        System.out.println("First Instance Block");
    }

    // Constructor: runs after all instance field initializers and instance blocks
    Ja_InstanceExecutionOrder() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        // Triggers instance initialization flow exactly once for this object
        Ja_InstanceExecutionOrder t = new Ja_InstanceExecutionOrder();
        System.out.println("main");
    }

    // Method that reads 'j'
    public void m1() {
        // At this point, 'j' is still at its default value (0)
        System.out.println(j);
    }

    // Second instance initializer block
    {
        System.out.println("Second Instance Block");
    }

    // Instance field: initialized after both instance blocks
    int j = 20;
}

/*
Expected output when running main:

0
First Instance Block
Second Instance Block
Constructor
main

Explanation of the output:
- 0                -> m1() prints j (default value, since j is not yet initialized)
- First Instance Block
- Second Instance Block
- Constructor
- main
*/


