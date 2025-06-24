package org.example.oops;

public class Class_1 {
    // super parent / base class
    int p1;
    static String p1_surname = "Marathe";

    Class_1() {
        System.out.println("no arg Constructor Class_1 called");
    }

    {
        System.out.println("parent class1 instance block called");
    }

    static{
        System.out.println("parent class1 static block called");
    }

    Class_1(int p1, String surname) {
        System.out.println("Constructor Class_1 called");
        this.p1 = p1;
        this.p1_surname = surname;
    }

    void p1_m1() {
        System.out.println("Method p1_m1() of Class_1 called");
        System.out.println("p1: " + this.p1);
        System.out.println("surname: " + this.p1_surname);
    }

    static void p2_m2() {
        System.out.println("static method p2_m2() of Class_1 called");
        System.out.println("surname: " + p1_surname);
    }

    public static void main(String[] args) {
        // Creating an object using no-arg constructor
        Class_1 obj2 = new Class_1();
        obj2.p1_m1();

        // arg constructor
        Class_1 obj = new Class_1(10, "Patil");
        obj.p1_m1();
        p2_m2();

        // Accessing static method
        Class_1.p2_m2();

    }
}
