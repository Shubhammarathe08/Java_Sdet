package org.example.declaration_access_modifiers;

public class MemberMethodVariable {

    /*
                                                           Methods
    >> public , protected , private , default , abstract , final , static | access modifiers
    ** class public then only method and member is available + accessible
    default >> package level access | accessible within the same package only |
                - within same package >> with parent/child reference in child class
                - outside package >> in child class >> only with child reference
                -
                pack 1 class A >> protected m1();
                pack 2 B extends  A
                       C extends  B
                       D extends  C
                   - D obj = new D(); // default access modifier
                    no other B, C reference is allowed
                   - in multilevel inheritance last class reference is only allowed
    protected >> accessible within the same package and other package subclasses/child classes
    private >> accessible only within the same class | in other class not accessible
    *** private + abstract >> illegal, need to be accessible to child classes to implement the abstract method

                                                           Variables
    >> public , protected , private , default , final, static | access modifiers
    ** class public then only method and member is available + accessible
    default >> package level access | accessible within the same package only
    private >> accessible only within the same class | in other class not accessible
    protected >> accessible within the same package and other package subclasses/child classes

    >> final int x ;
    //invalid  - Instance var cant be reassigned and hence will throw error : might not have been initialized
                 final int x = 10; // initialize , whether we use or not, JVM will not assign default value
                 initialization is mandatory for >> before constructor completion
                       - at time of declaration
                       - inside instance block
                       - inside constructor
                *** inside methods , cant assign value to final variable, will throw compile time error

    >> final static int y ;
    //invalid  - Instance (static + final)  var cant be reassigned and hence will throw error : might not have been initialized
                 final int x = 10; // initialize , whether we use or not, JVM will not assign default value
                 initialization is mandatory for >> before constructor completion
                       - at time of declaration
                       - inside static block
                *** inside methods , constructor , cant assign value to final variable, will throw compile time error

     >> final local variable -  inside method, constructor, block , loops
        *** jvm doesn't provide default value for final local variable - before using

        {
        final int x; // no need to initialize at time of declaration for local var
        }

      >> local var - only applicable modifier  >> final


    * */
    static{
        int x;
        //   System.out.println(x);  throw error because using w/o initialization

    }
  public static  void m1(int x , int y){
        x=100;
        y=200;
        System.out.println("x="+x+", y="+y);
      // if while pasisng ( final int x , final int y)  >> compile time error : // cannot assign a value to final variable x
    }
    public static void main(String[] args){
        m1(11,22);
    }
}
class Test {
    // initialization is mandatory for final variable
    final int x = 10; // initialize at time of declaration
    final int y ;
    final int z ;
    final static int f = 30;
    final static int u;
    {
        // inside instance block
        y= 20;
    }
    static
    {
        // inside static block
        u = 40;
    }
    Test() {
        // inside constructor
        z = 30;
    }

}
