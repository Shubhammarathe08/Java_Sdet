package org.example.language_fundamentals;

public class InstanceChild extends InstanceParent {

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

    InstanceChild() {
        System.out.println("child constructor executed");
    }

    public static void main(String[] args) {
        InstanceChild ic = new InstanceChild();
        System.out.println("child main method executed");
    }

    public void m2() {
        System.out.println(y);
    }

    int y = 222;

}
