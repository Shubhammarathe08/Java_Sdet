package org.example.oops;

public class Constructor {

    /*

    class_name () {
    }
    class name == constructor *** mandatory
    no return type >> because return thing and not for returning anything
    public, private, default, protected >> no other access modifier valid
    compiler >> responsible to generate default generate (if no constructor provided by programmer )
    so, every class can contains 1 default constructor, provided by Compiler
    >> first line should be super() OR this() | no other or both accepted
    >> compiler will either generate or place super() ** if not olaced as first line
    >> super() - call immediate parent class constructor |based on args >> *** not use with method or block
    >> this() - call current class object >> constructor | based on args
    >> inheritance concept not available for - Constructors | we can call using super() | default not available
    >> can be Overloaded BUT not Override

    class Test{
       Test(){
       }
    }

    class TestChild extends Test{
        Test(int i){
       }

       public static void main(){
       TestChild obj = new TestChild(); // child class doesn't have no arg constructor
       }
    }

    *** Child classes should have >> matched constructor in parent same as class
   >> if parent class constructor Throws Checked Exception | child class constructor should throw Same/parent exception
     ** not applicable for unchecked exception

     >> private constructor -
        used in singleton >> only/at max one object
        Ex. Runtime , Business Delegate , Service Locator
    >> declare every constructor as Private - child classes cant access parent class constructor | works as final class

    >> every class can contain -constructor >> ** include - abstract | Except - Interface

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
       Constructor >> initialize the object

       why ??
       >> where to initialize object -
   if || declaration- X | instance block- X | after obj.var ="" (length++)- X >> same value for all object
   if || constructor >> separate copy for each object

       executed >> automatically at the time of object creation | every time

       int i=0;

       Student (i){
          this.i = i;
          System.out.println(i);
       }

       Student s1 = new Student(111);

       op:- 111
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
       *** Instance Block VS Constructor
other than initialization, if we want to perform certain activity for every object
ex. incr count val for every obj creation
Replacing one concept with another may not work always.
first priority >> instance block THEN Constructor


>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

                       Default Constructor
>> created by - Compiler  ** if no constructor defined/written by programmer
>> cant contain both default and non default constructor
>> executed by - JVM -> for every object creation
>> modifier same as class modifier
>> no arg constructor
>> no arg constructor , only one line >> super() | no arg call to super class constructor
    class_name () {
      super()
    }
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                    user defined Constructor

no arg + empty

Test(){
}
** first line should be either super() or this()
compiler Auto places super() | without showing to programmer
Test(){
super()
}
------------------------------------------------------------------
Test(int i){
this.i = i;
}

Test(){
}

** for no arg >> compiler will place super() automatically w/o showing
Test(){
super()
}
-----------------------------------------------------------------------------------------------
                                            arg constructor

Test(int i){
}

--------------------------------------------------------------------------------------------------
                                             var arg constructor

Test(int... i){
}
---------------------------------------------------------------------------------------------------
                                        Overloaded Constructor
                                       same name + differ arg(type/number)
Test(){
}

Test(int i){
}

Test(int... i){
}
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     new VS constructor
             int age x;
            new -> Student s = new Student(111);   // step 1
            >> new keyword is used to create an object of a class
            >> age = 0 ; default

            Student(int age){                         // step 2
            System.out.println("Constructor called");
            this.age = age; // initializing instance variable
            // hashcode of object is generated >>> 111111111 [ this.hashcode() ]
           }
           >> facility to initialize instance variables at the time of object creation
           >> age = 111; // initializing values of an object , passed through constructor

    // child extends parent >> child object | parent + child class constructor >> executed for child object initialization only
        // parent class constructor
       parent class  Person >>
        age
        name
        parent_constructor
        person(int age, String name) { // step 1
            System.out.println("Constructor Person called");
            this.age = age; // initializing instance variable
            this.name = name; // initializing instance variable
             // hashcode of object is generated >>> 111111111  [ this.hashcode() ]

        }
        // if u dont want properties from parent class constructor
        person(){
            System.out.println("no arg constructor Person called");
        }

       child class Student>>
         roll_no
         marks
         child_constructor
        Student(int roll_no, String name, int age, double marks) { // step 2
            super(age, name); // calling parent class constructor
            System.out.println("Constructor Student called");
            this.roll_no = roll_no;
            this.marks = marks;

         Student s  = new Student(111, "John", 101, 90.5); // step 1
         // hashcode of object is generated >>> 111111111 [ c.hashcode() ]
         // same hashcode | why ? - because only child object created  1 object created


        // if u don't want parent class constructor to be called, use default constructor
        // if u don't want properties from parent class constructor to be initialized, use overloaded no arg constructor
         Student(int roll_no,double marks){
            super(); // calling parent class no arg constructor
            System.out.println("Constructor Student called");
            this.roll_no = roll_no;
            this.marks = marks;
                                           }

    */
    static int count = 0;

    Constructor() {
        this(10);
        System.out.println("no arg");
    }

    Constructor(int i) {
        this(10.111);
        System.out.println("int arg");
    }

    Constructor(double d) {
        System.out.println("double arg");
    }


   /*
    Constructor(boolean b){
        this(10.00f);
    }

    Constructor(float f){
        this(true);
    }
     // Compile Time Error :-  Recursive Constructor Call Error
    */


    {
        count++;
        System.out.println(count);
    }

    void m1() {
        m2();
    }

    void m2() {
        m1();
    }

    public static void main(String[] args) {

        Constructor c1 = new Constructor();
        System.out.println("/////////////////////////////////////////////////////////////////////////");
        Constructor c2 = new Constructor(10);
        System.out.println("/////////////////////////////////////////////////////////////////////////");
        Constructor c3 = new Constructor(10.111);
        System.out.println("/////////////////////////////////////////////////////////////////////////");
        Constructor c4 = new Constructor('a');
        System.out.println("/////////////////////////////////////////////////////////////////////////");
        Constructor c5 = new Constructor(10l);
        System.out.println(count);

        // c1.m1(); Recursive Method Call >> Runtime Exception in thread "main" java.lang.StackOverflowError

    }
}
