package org.example.operators_assignment;

public class TypeCastingBoxingAutoboxingWrapping {

    /*
     Implicit Type casting / Up casting (Widening Conversion)
     *** when we assign smaller type to bigger data type variable >> implicit type casting happens
     keeping small value in big container , no loss of information >> Widening Conversion

     int x  = 'a'; // 97 char to int -> internally compiler converts char to int
     double d = 10; // 10.0 int to double -> internally compiler converts int to double

     Explicit Type casting (Narrowing Conversion)
     *** when we assign bigger type to smaller data type variable >> explicit type casting happens
     keeping bigger value in small container , loss of information >> Narrowing Conversion
     programmer is responsible for this conversion, as there is a loss of information

     int x  = 130;
     byte b = (byte) x; // 130 int to byte -> explicit type casting required as there is a loss of information
     System.out.println(b); // -126 (130 exceeds byte range -128 to 127, wraps around)


    We can use parent reference to hold child object
    We can use Interface Reference to hold implemented class object
        Object o = new String();
        Runnable r = new Thread();

        A b = (C) d ;

        A - class / interface name
        b - name of ref var
        C - class / interface name
        d -

        trying to convert >> d type object to C type
        C type assigning to >> A type
        compiler
        1. conversion - legal
        type of C and D must have some relation
        underlying object type of C must be
        parent <> child | child <> parent | same type | ** NOT Sibling on same level
        2. assignment - legal
        C should be same or child / derived type ->  of A

        compile time error >> found d type required c

         Object
        /      \
     Base1    Base2
     /   \     /   \
 Der1 Der2  Der3  Der4

        // 1 ✅ Valid: Any class can be upcast to Object
        Object o1 = (Base2) b;

        // 2 ❌ Compile-time Error: Base2 and Base1 are siblings (no relationship)
        // Object o2 = (Base1) b; // CE: incompatible types

        // 3 ❌ Runtime Error: b is not a Der3 instance (it is)
        // Object o3 = (Der3) b; // ✅ Actually VALID, and won't throw RE
        Object o3 = (Der3) b; // ✅ This works, because b is new Der3()

        // 4 ❌ Compile-time Error: Base2 and Base1 not related
        // Base2 b1 = (Base1) b; // CE: incompatible types

        // 5 ❌ Compile-time Error: Der4 is not related to Base1
        // Base1 b2 = (Der4) b; // CE: incompatible types

        // 6 ❌ Compile-time Error: Der1 is not related to Base2
        // Base1 b3 = (Der1) b; // CE: incompatible types

   // we are proving another ref variable , no new object is created
   it is typecasting , not object casting | just provide another ref var

   String s = new String("type_cast");
   Object o = (Object)s
   Object 0 = new String("type_cast");
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
   Integer i = new Integer(10);
   Number n = (Number) i
   Object o = (Object) n
   Integer >> Number >> Object >> | 10  all pointing to single object 10
   Object 0 = new Integer(10);
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

String s = new String(" str ");
Object o = (Object) s ;  // allowed   (Parent)child

Object o = new Object();
String s1 = (String)o; //not allowed (Child)parent

Object o = new String("gta5");
String s1 = (String)o; // allowed (Child)child - underlying obj is same or lesser


Overloading - Ref matter
Parent p , Child c
        C c = new C();  // Case: C c = new C();

        c.m1();         // ✅ Allowed: inherited from P
        c.m2();         // ✅ Allowed: defined in C

        ((P) c).m1();   // ✅ Allowed: m1 is in P | ref - p
        // ((P) c).m2(); //  ❌ Not allowed – will not compile | ref - p
                Parent p = new Child();

        // If you force this using a reference:
        P p = new C();
        p.m1();         // ✅ Allowed
        // ❌ p.m2(); // Compile-time error: method m2() is not in class P
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Over riding
   obj matter - underlying  obj is always C
        C c = new C();         // C c = new C();

        c.m1();                // Output: C

        ((B)c).m1();           // Cast C to B, still calls C's m1() due to dynamic dispatch
                              // Output: C

        ((A)((B)c)).m1();      // Cast C to B to A, still calls C's m1() at runtime
                              // Output: C
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Method Hiding

ref matters >> vars + method hiding

       A (static m1() → A)  777
       ↑
       B (static m1() → B) 888
       ↑
       C (static m1() → C)  999


        C c = new C();
        c.m1();                         // Output: C (reference type = C) // 999

        ((B)c).m1();                    // Output: B (reference type = B) // 888

        ((A)((B)c)).m1();              // Output: A (reference type = A) // 777
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>







    */

    public static void main(String[] args){

        // parent class ref == child class obj
        Object o = new String();
        String s = new String("test");

        // StringBuffer sb1 = (StringBuffer)s;
        // java: incompatible types: java.lang.String cannot be converted to java.lang.StringBuffer

        // StringBuffer sb2 = (String)o;
        // String-Object - ok | BUT SStringBuffer cant hold String

        // parent interface ref == child implementation class object
        Runnable r = new Thread();

        // run time object type of d must be either same or derived type of C
        // otherwise we will et runtime exception
        // class cast exception : java.lang.string cant be cast to java.lang.string buffer
        Object o1 = new String("fff");
       // StringBuffer sb2 = (StringBuffer)o1; // invalid at run time
        Object o2 = (String)o1; // valid , underlying obj - string , casted to String



    }
}
