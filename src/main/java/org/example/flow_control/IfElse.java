package org.example.flow_control;

public class IfElse {

    public static void main(String[] args) {

        // Example 1: Basic if-else
        // argument - should be boolean type ** any other type - Compile Time Error java: incompatible types: int cannot be converted to boolean
        // > , < , == , <= , >= , !=
        // else part - optional
        // without {} - max 1 statement | should not be declarative statement
        // every else is mapped to the nearest if statement

        if (true)
            System.out.println();

        if (true);

        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        int a = 10;
        if (a > 5) {
            System.out.println("a is greater than 5");
        } else {
            System.out.println("a is not greater than 5");
        }
        // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        // Example 2: Nested if-else
        int b = 20;
        if (b > 15) {
            System.out.println("b is greater than 15");
            if (b > 25) {
                System.out.println("b is also greater than 25");
            } else {
                System.out.println("b is not greater than 25");
            }
        } else {
            System.out.println("b is not greater than 15");
        }

        // Example 3: Ternary operator
        int c = (a > b) ? a : b;
        System.out.println("The larger value is: " + c);

        // Example 4: nested ternary operator
        int d = (a > b) ? a : ((b < 30) ? b : 0);
        System.out.println("The value of d is: " + d);

        // Example 5: Using if-else with logical operators
        boolean condition1 = true;
        boolean condition2 = false;
        if (condition1 && condition2) {
            System.out.println("Both conditions are true");
        } else if (condition1 || condition2) {
            System.out.println("At least one condition is true");
        } else {
            System.out.println("Neither condition is true");
        }

    }
}
