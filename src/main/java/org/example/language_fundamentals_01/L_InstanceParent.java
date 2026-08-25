package org.example.language_fundamentals_01;

public class L_InstanceParent {

    int i = 11;

    {
        m1();
        System.out.println("parent instance block");
    }

    L_InstanceParent(){
        System.out.println("parent constructor");
    }

    public static void main(String[] args){
        L_InstanceParent ip = new L_InstanceParent();
        System.out.println("parent main method executed");

    }

    public void m1(){
        System.out.println(j);
    }
    int j = 111;

}
