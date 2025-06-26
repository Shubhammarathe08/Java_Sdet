package org.example.language_fundamentals;

public class InstanceParent {

    int i = 11;

    {
        m1();
        System.out.println("parent instance block");
    }

    InstanceParent(){
        System.out.println("parent constructor");
    }

    public static void main(String[] args){
        InstanceParent ip = new InstanceParent();
        System.out.println("parent main method executed");

    }

    public void m1(){
        System.out.println(j);
    }
    int j = 111;

}
