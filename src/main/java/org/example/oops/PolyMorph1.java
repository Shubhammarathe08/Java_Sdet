package org.example.oops;

 public class PolyMorph1 {

    int parent_p1 = 100;
    static String parent_name = "PolyMorph1";

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  overloaded constructor  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    PolyMorph1(){
        System.out.println("no arg Constructor Polymorph1 called");
    }

    // overloaded constructor
    PolyMorph1(int x){
        System.out.println("overloaded Constructor Polymorph1 called");
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  overloaded method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     void my_method(){
         System.out.println("parent Method Polymorph1 called");
     }

     // overloaded method
    void  my_method(int x){
        System.out.println("parent overloaded int Method Polymorph1 called");
    }

    // overloaded method
    void  my_method(int... x){
        System.out.println("overloaded var arg int... Method Polymorph1 called");
    }

    // overloaded method
    void  my_method(float x){
        System.out.println("overloaded float  Method Polymorph1 called");
    }

    // overloaded method
    void  my_method(String x){
        System.out.println("overloaded String  Method Polymorph1 called");
    }

    // overloaded method
    void  my_method(Object x){
        System.out.println("overloaded Object  Method Polymorph1 called");
    }

    // overloaded method
    void  my_method(StringBuffer x){
        System.out.println("overloaded StringBuffer  Method Polymorph1 called");
    }

    // overloaded method
    void  my_method(int i,float f){
        System.out.println("overloaded int i,float f  Method Polymorph1 called");
    }

    // overloaded method
    void  my_method(float f,int i){
        System.out.println("overloaded float f,int i  Method Polymorph1 called");
    }

    void m2(){
        System.out.println("parent m2  Polymorph1 method called");
    }

    void check_method(int x){
        System.out.println("parent check method called with int x ");
    }

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  overridden method  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    String m3(){
        System.out.println("parent m3 Polymorph1 method called");
        return "parent m3";
    }

    Object m4(){
        System.out.println("parent m4 Polymorph1 method called");
        return new Object();
    }

    private void m5(){
        System.out.println("parent private Polymorph1 m5 method called");
    }

    static void m6(){
        System.out.println("parent static Polymorph1 m6 method called");
    }

    final void m7(){
        System.out.println("parent final m7 Polymorph1 method called");
    }

    // public abstract void m8();

     void m9(){
            System.out.println("parent m9 Polymorph1 method called");
     }

     //overloaded method
    public static void main(String[] args) {

         //     byte > short
         //                  > int > long > float > double
         //            char

        PolyMorph1 p = new PolyMorph1(); // parent ref >> parent method will get chance
        p.my_method();
        p.my_method(1); // int
        p.my_method(23l); // long
        p.my_method('a'); // char
        p.my_method(10.0f); // float
        // p.my_method(111.111); //double - compile time error - no such method with double argument : method my_method(double) not found in method table
        p.my_method(new Object());
        p.my_method("Hello");
        p.my_method(new StringBuffer("Hello StringBuffer"));
        // p.my_method(null);// valid for String+obj | out of Object >> String - child is available then preference given to child class method
        // p.my_method(null);// valid for String+StringBuffer |
        //                      Compile time error - ambiguous method call: both my_method(String) and my_method(StringBuffer) match the null argument
        p.my_method(10,10.0f); // int + float
        p.my_method(10.0f,10); // float + int

       //  p.my_method(10,10);   1. 10 , 10.0f (promotion)  2. 10.of (promotion) ,10 >> both matching
           // compile time error :-  reference to my_method is ambiguous

        // p.my_method(10.0f, 10.0f);
            // compile time error >> java: no suitable method found for my_method(float,float)
        p.my_method();
        p.my_method(10, 20, 30); // var arg >> int... >> int[] >> int | least priority
        p.my_method(11);// general int method will get chance, old version



    }
}
