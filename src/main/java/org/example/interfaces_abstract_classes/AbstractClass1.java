package org.example.interfaces_abstract_classes;

public abstract class AbstractClass1 {
        /*
        cant create object of abstract class
        why constructor ?
        >> for child object creation, parent constructor is called first
        >> to perform initialization of child class object, parent class constructor is called and initialize values in child class objects
        >> code reusability
        >> parent class constructor executed for child object purpose
        >> directly / indirectly 0 cant create object of abstract class
        >> Anyway we cant create object of abstract class + interface BUT abstract class contain constructor
           :-  initialization of instance variable, static variable , instance block, static block ( required for child objects )
        >> when all methods are abstract, simply go for Interface not Abstract class

        */

    int parent_age = 10;
    static double parent_salary = 20000.345; // static variable, shared across all instances of the class

    AbstractClass1(int parent_age, double parent_salary) {
        System.out.println("Constructor AbstractClass1() parent");
        this.parent_age = parent_age;
        this.parent_salary = parent_salary;
    }
    AbstractClass1() {
        System.out.println("no arg Constructor AbstractClass1() parent");
    }

    {
        System.out.println("instance block of AbstractClass1");
    }

    static{
        System.out.println("static block of AbstractClass1");
    }

    void m1(){
        System.out.println(this.parent_age);
        System.out.println(this.parent_salary);
    }

    int m2(){
        return 0;
    }

    static int m3(){
        return 0;
    }
    abstract void my_abstract_method();

}

