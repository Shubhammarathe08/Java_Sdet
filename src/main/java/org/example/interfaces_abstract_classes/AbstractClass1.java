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

        *** MISSING >> Java 17 - Sealed abstract classes (JEP 409) - NEW way to control who can extend
            an abstract class, on top of the abstract-class rule that you can't instantiate it directly
            sealed abstract class AbstractClass1 permits ChildA, ChildB {}
            >> combines "cant create object directly" (abstract) with "only these classes may extend it" (sealed)
            >> every permitted subclass must be final / sealed / non-sealed
            >> without sealed, ANY class could extend AbstractClass1 - sealed restricts the child list explicitly

        *** MISSING >> when to prefer Records instead of Abstract class (Java 16+, standard in 17)
            >> if the "child" is really just an immutable data holder with no shared behavior/state
               initialization logic, consider a record instead of extending an abstract class
            >> records CANNOT extend an abstract class (or any class) - only implement interfaces -
               so this abstract class + constructor pattern is NOT compatible with records at all
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

    /*
    *** MISSING >> Pattern Matching instanceof (Java 16+, standard in 17) - relevant when
        working with abstract class references at call sites
        AbstractClass1 obj = new ChildClass();
        if(obj instanceof ChildClass c){    // no explicit cast needed
            c.someChildMethod();
        }
        >> useful since you often hold a reference of the abstract type but need child-specific behavior

    *** DEPRECATED >> nothing in abstract class syntax/rules itself is deprecated in Java 17.
        If this class or its children ever override Object.finalize() for cleanup, note:
        Object.finalize() - deprecated since Java 9, forRemoval since Java 18
        >> use try-with-resources / java.lang.ref.Cleaner (Java 9+) instead, if this abstract
           class manages any closeable resource that needs cleanup logic
    */

}