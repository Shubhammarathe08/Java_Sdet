package org.example.oops;

public class Constructor {

    /*  new VS constructor
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
        paranet_constructor
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
}
