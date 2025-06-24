package org.example.declaration_access_modifiers;

public class StaticModifier {

    /*
       applicable for >> method , var , top level  [ inner class ** can be declared as static -static nested classes ]
       for total class >> one copy is created and shared by all instances of the class
        static >> belongs to the class itself rather than an instance of the class

        static var >> can be accessed from anywhere(Instance area too
                      BUT instance variable can not be accessed from static area

        Over Loading >>
        static method can be overloaded
        public static void main(String[] args) {
        }
        public static void main(int[] args) {
        }
        // but JVM will always call String[] rags only

        Inheritance >>>
        applicable for static methods , including main method
        parent class static method will be by default available to child classes

        class P {
         public static void main(String[] args) {
            System.out.println("Parent main method");
                                                }
        }
        class C extends P {
        }
        // P.java >> javac p.java [as no class is public, we can put any class name]
        // C.class , P.class
        // java P java C >> same result | Parent main method




        Overriding >>> *** its not over-riding , its method hiding
        applicable for static methods , including main method
        parent class static method will be by default available to child classes

        class P {
         public static void main(String[] args) {
            System.out.println("Parent main method");
                                                }
        }
        class C extends P {
                 public static void main(String[] args) {
            System.out.println("Child main method");
                                                }
        }
        // java P >> Parent main method | java C >> Child main method
 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 // when to go for instance and static method
   1. at least 1 instance variable is there >> instance method
   2. no instance variable is there | method not related to object

  >> for static method =  implementation should be available
  hence >> abstract + static - illegal combination, can't be used together



     *
    * */
  static int x = 10;
         int y = 20;
         int x1 = 11;
         static int y1 = 21;



    public static void main(String[] args) {
        // Accessing static method
        staticMethod();
        // Accessing static variable
        System.out.println("Static Variable: " + staticVariable);

        StaticModifier sd = new StaticModifier();
        sd.x = 888;
        sd.y = 999;

        StaticModifier sd1 = new StaticModifier();

        System.out.println(sd1.x+" "+sd1.y); // 888 , 20


    }

    // Static variable
    static int staticVariable = 42;

    // Static method
    static void staticMethod() {
        System.out.println("This is a static method.");
    }

}
