package org.example.oops;

public class Class_2 extends Class_1 {
    // super parent / base class
    int child1_property;

    Class_2() {
        System.out.println("no arg Constructor Class_2 called");
    }

    Class_2(int p1, String surname, int child1_property) {
        System.out.println("Constructor Class_2 called");
        this.p1 = p1;
        this.p1_surname = surname;
        this.child1_property = child1_property;
    }

    {
        System.out.println("child class2 instance block called");
    }

    static{
        System.out.println("child class2 static block called");
    }

    void c1_m1() {
        System.out.println("Method c1_m1() of child called");
        System.out.println("p1: " + this.p1);
        System.out.println("surname: " + this.p1_surname);
        System.out.println("child1_property: " + this.child1_property);
    }

    static void c2_m2() {
        System.out.println("static method c2_m2() of child called");
        System.out.println("surname: " + p1_surname);
    }

    public static void main(String[] args) {

  // parent + child >> static block |parent + child instance block |parent + child  constructor
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

        // parent reference + parent object
        // no child variable or method available
        // static block (class load - parent+child) > instance block parent (obj-parent)  > constructor parent (obj-parent)
        Class_1 P_r_P_o = new Class_1();
        System.out.println(P_r_P_o.p1); // parent instance variable
        System.out.println(P_r_P_o.p1_surname); //parent static variable
        P_r_P_o.p1_m1(); // parent instance method
        P_r_P_o.p2_m2(); // parent static method

        System.out.println(" parent ref - parent obj  >>> ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");


        // child reference + child object
        // parent + child variable or method available
        // static block (class load - parent+child) > instance block parent+child (obj-child)  > constructor parent+child (obj-child)
        Class_2 C_r_C_o = new Class_2();
        System.out.println(C_r_C_o.p1); // parent instance variable
        System.out.println(C_r_C_o.p1_surname); // parent static variable
        System.out.println(C_r_C_o.child1_property); // child instance variable
        C_r_C_o.p1_m1(); // parent instance method
        C_r_C_o.p2_m2(); // parent static method
        C_r_C_o.c1_m1(); // child instance method
        C_r_C_o.c2_m2(); // child static method

        System.out.println(" child ref - child obj  >>> ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");


        // parent reference + child object
        // no child variable or method available
        // static block (class load - parent+child) > instance block parent+child (obj-child)  > constructor parent+child (obj-child)
        Class_1 P_r_C_o = new Class_2();
        System.out.println(P_r_C_o.p1);
        System.out.println(P_r_C_o.p1_surname);
        P_r_C_o.p1_m1();
        P_r_C_o.p2_m2();

        System.out.println(" parent ref - child obj  >>> ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

        // child reference + child object
        // cant hold parent object in child's reference

        // Class_2 C_r_P_o = new Class_1();
        // compile time error : java: incompatible types: org.example.Oops.Class_1 cannot be converted to org.example.Oops.Class_2

        System.out.println(" child ref - parent obj  >>> ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

        // no arg
        Class_2 c1 = new Class_2();

        //arg constructor
        Class_2 c2 = new Class_2(10, "Patil", 1);







    }

}
