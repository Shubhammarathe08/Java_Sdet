package org.example.language_fundamentals_01;

public class La_InstanceChild extends L_InstanceParent {

    // child class Object
    // identification >> parent - child >> top - Bottom
    // execution of var + execution of instance block >> parent  top - Bottom
    // execution of parent constructor
    // execution of var + execution of instance block >> child  top - Bottom
    // execution of child constructor

    int x = 22;

    {
        m2();
        System.out.println("child instance block executed");
    }

    La_InstanceChild() {
        System.out.println("child constructor executed");
    }

    public static void main(String[] args) {
        La_InstanceChild ic = new La_InstanceChild();
        System.out.println("child main method executed");
    }

    public void m2() {
        System.out.println(y);
    }

    int y = 222;

}
