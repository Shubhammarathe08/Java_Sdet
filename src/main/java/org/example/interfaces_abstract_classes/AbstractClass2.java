package org.example.interfaces_abstract_classes;

public class AbstractClass2 extends AbstractClass1 {

    int child_age = 20;
    static double child_salary = 100.11;

    AbstractClass2(int parent_age, double parent_salary, int child_age, double child_salary) {
        super(parent_age, parent_salary); // calling parent class constructor
        this.child_age = child_age;
        this.child_salary = child_salary;
        System.out.println("Constructor AbstractClass2() child");
    }
    AbstractClass2() {
        System.out.println("no argConstructor AbstractClass2() child");
    }


    {
        System.out.println("instance block of AbstractClass2");
    }

    static {
        System.out.println("static block of AbstractClass2");
    }

    void m1() {
        System.out.println(this.parent_age);
        System.out.println(this.parent_salary);
        System.out.println(this.child_age);
        System.out.println(this.child_salary);
    }

    int m2() {
        return 0;
    }

    static int m3() {
        return 0;
    }

    void my_abstract_method() {
        System.out.println("my_abstract_method() implemented");
    }


    public static void main(String[] args) {
        AbstractClass2 abs1 = new AbstractClass2(20, 222.222,10,111.11);
        abs1.m1();
        AbstractClass2 abs2 = new AbstractClass2();

    }


}
