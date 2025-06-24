package org.example.oops;

public class PolyMorph2 extends PolyMorph1{

    int parent_p1 = 200;
    static String parent_name = "PolyMorph2";

    // child class
    int child_p1 = 200;
    static int child_p2 = 200;

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  overloaded constructor  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    PolyMorph2() {
        System.out.println("no arg Constructor Polymorph2 called");
    }

    PolyMorph2(String x) {
        System.out.println("overloaded Constructor Polymorph2 called");
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  overloaded method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    void my_method() {
        System.out.println("parent Method Polymorph2 called");
    }

    void my_method(int x) {
        System.out.println("child overloaded Method Polymorph2 called");
    }

    void m2(int x){
        System.out.println("child m2 Polymorph2 method called");
    }

    void check_method(int... x){
        System.out.println("child var arg check method called with int... x ");
    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  overridden method  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    String m3(){
        System.out.println("child m3 Polymorph2 method called");
        return "child m3";
    }

    Exception m4(){
        System.out.println("child m4 Polymorph2 method called");
        return new Exception();
    }

    private void m5(){
        System.out.println("child private  m5 Polymorph2 method called");
    }

    static void m6(){
        System.out.println("child static m6 Polymorph2 method called");
    }

//    final void m7(){
//        System.out.println("parent static m6 Polymorph2 method called");
//    }     :- cant let us write final method in child class, as it is already final in parent class , cant override final method in child class

// void m8(){ System.out.println("implemented");}

    public static void main(String[] args) {
//-------------------------------------------- over loaded methods parent-child (REFERENCE Matter - same as Inheritance ) ----------------------------------------------------------

        PolyMorph2 p2_0bj1 = new PolyMorph2(); // child Ref + Child Obj

        System.out.println("p2_0bj1.parent_p1 = " + p2_0bj1.parent_p1); // ref matters >> instance >> child ref >>  val = 200
        System.out.println("p2_0bj1.parent_name = " + p2_0bj1.parent_name); // ref matters >> static >> child ref >>  val = PolyMorph2


        p2_0bj1.m2(); // child ref >> Access to parent + child (var + method + constructor + instance + static blocks)
        p2_0bj1.my_method(1); // child ref >> Access to parent + child (var + method + constructor + instance + static blocks)
        p2_0bj1.check_method(1); // child ref >> Access to parent + child (var + method + constructor + instance + static blocks)
        p2_0bj1.check_method(1,2,3); // child ref >> Access to parent + child (var + method + constructor + instance + static blocks)

        p2_0bj1.m3(); // child OBJ >> child overridden method will get chance
        p2_0bj1.m4(); // child OBJ >> child overridden method will get chance
        p2_0bj1.m5(); // not over riding - OBJ child - so child method called
        p2_0bj1.m6(); // not over riding - method hiding - Reference matters >> child method called

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        PolyMorph1 p1_0bj1 = new PolyMorph1(); // parent Ref + Parent Obj

        System.out.println("p1_0bj1.parent_p1 = " + p1_0bj1.parent_p1); // ref matters >> instance >> parent ref >>  val = 100
        System.out.println("p1_0bj1.parent_name = " + p1_0bj1.parent_name); // ref matters >> static >> parent ref >>  val = PolyMorph1

        p1_0bj1.m2(); // parent ref >> Access to ONLY parent (var + method + constructor + instance + static blocks)
        // p1_0bj1.m2(1); cant call child method on parent ref
        p1_0bj1.check_method(11); // parent ref >> Access to ONLY parent (var + method + constructor + instance + static blocks)

        p1_0bj1.m3(); // parent OBJ >> parent overridden method will get chance
        p1_0bj1.m4(); // parent OBJ >> parent overridden method will get chance
        // p1_0bj1.m5(); // Not Overridden Nor inherited - private method of one class cant be accessed in other class
        p1_0bj1.m6(); // not over riding - method hiding - Reference matters >> parent method called

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        PolyMorph1 p1_0bj2 = new PolyMorph2(); // parent Ref + Child Obj

        System.out.println("p1_0bj2.parent_p1 = " + p1_0bj2.parent_p1); // ref matters >> instance >> parent ref >>  val = 100
        System.out.println("p1_0bj2.parent_name = " + p1_0bj2.parent_name); // ref matters >> static >> parent ref >>  val = PolyMorph1

        p1_0bj2.m2(); // parent ref >> Access to ONLY parent (var + method + constructor + instance + static blocks)
        // p1_0bj2.m2(1); //  cant call child method on parent ref
        p1_0bj2.check_method(11); // parent ref >> Access to ONLY parent (var + method + constructor + instance + static blocks)

        p1_0bj2.m3(); // child OBJ >> child overridden method will get chance
        p1_0bj2.m4(); // child OBJ >> child overridden method will get chance
        // p1_0bj1.m5(); //Compile time error :-  java: m5() has private access in org.example.Oops.PolyMorph1
        /* Not Overridden Nor inherited - private method of one class - cant let us access in other class
        The compiler looks at obj's declared type, which is A.
        It sees that m1() is private in A, and therefore not visible—so it fails right there.
        It never considers that the object is actually of class B, or that B might have a method named m1().
         */
        p1_0bj2.m6(); // not over riding -method hiding - Reference matters >> parent method called
        PolyMorph2.m6();// if i use child ref >> child will come into picture

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        // PolyMorph2 p2_0bj2 = new PolyMorph1(); // parent Ref + Child Obj
        // child ref cant hold parent obj
        // compiler time error :- java: incompatible types: org.example.Oops.PolyMorph1 cannot be converted to org.example.Oops.PolyMorph2




    }
}
