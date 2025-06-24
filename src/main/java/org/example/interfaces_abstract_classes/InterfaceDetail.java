package org.example.interfaces_abstract_classes;

public class InterfaceDetail {

    interface my_interface {
        // This is an example of an interface in Java.
        // It can contain abstract methods, default methods, static methods, and private methods.
        void myMethod(); // Abstract method
    }

    public static void main(String[] args) {
        // InterfaceDetail class is a placeholder for the explanation of interfaces in Java.
        // It does not contain any executable code.
    }

    /* Interface

    >> any contract between client and service provider can be considered as an interface.
    client - set of services he is expecting
    service provider - set of services he is providing

   ex. JDBC API acts as an interface between Java application and database.
       implementation of JDBC API is provided by different vendors like Oracle, MySQL driver classes etc...

       Servlet API is an interface between Java application and web server.
       implementation of Servlet API is provided by different vendors like Apache Tomcat, Jetty server classes etc...


    >> Can only contain abstract methods (Java 8 onwards can have default and static methods)
    >> variables/fields =
                        implicitly public [available to implementing class]
                        + implicitly static [cant create object of interface]
                        + implicitly final [common var for all implementing classes] *** if 1 implementing class changes val, others will be affected
    >> dont have instance/static blocks , constructors - need to initialize variable at the time of declaration only.
    >> methods are implicitly public + abstract  | *** (except default, static, or private)
    >> Interfaces cannot be X - final, but they can be sealed to control inheritance.
    >> Interfaces cannot have X - constructors , instance fields.
    >> while over-riding method - don't reduce scope of method  *** declare as public
    >> every abstract method should be implemented in the class that implements the interface.

                             extends vs implements

       interface  D extends  A,B,C {
       // D is extending multiple interfaces A, B, C simultaneously
       }
       >> interface can extends multiple interfaces
       A,B,C has same method >> fly()
       -------------------------------------------------------------------------------------
       class D extends Z implements A,B,C{
       // D is implementing multiple interfaces A, B, C simultaneously
       }
       >> a class can implement multiple interfaces + extends a single class
       >> class cant extends multiple classes (Java does not support multiple inheritance)
       >> we have to take extends first them implements
       x implements y extends z // not allowed | illegal

        A,B,C has same method >> fly() | same signature + same return type
        ??? implementation
        1. we have to provide implementation of fly() method | once is enough

        A,B,C has same method >> fly() | same name + diff arg type + same return type |
        ??? implementation
        1. we have to provide implementation of  [ BOTH ] fly() method , overloaded methods

         A,B,C has same method >> fly() | same name + same arg type + diff return type  ** if return types are not co-variant
        ??? implementation - IM-POSSIBLE X X X
        1. Can't provide implementation of fly() method | compile time error

           same var in interface A,B,C
           System.out.println(A.var); // compile time error
           correct - System.out.println(A.varA); // A.varA
                     System.out.println(B.varB); // B.varB
                     System.out.println(C.varC); // C.varC

 --------------------------------------------------------------------------------------------------------------------------------------------------
       Abstract Methods
       >> Still the foundation: interfaces define contracts via abstract methods.
       >> always public [available to implementing class] + abstract [just a template , class must implement it]
         java
         interface Vehicle {
                        void start();
                            }
-----------------------------------------------------------------------------------------------------------------------------------------------------
       Default Methods (since Java 8)
          >> Allow interfaces to provide method implementations.
          >> Use case: When you want to add new functionality to an interface without breaking existing implementations.
          java
          default void honk() {
                System.out.println("Beep!");
                           }
-----------------------------------------------------------------------------------------------------------------------------------------------------
        Static Methods (since Java 8)
            >> Belong to the interface itself, not instances.

            java
            static void info() {
                 System.out.println("Vehicle interface");
                           }
-----------------------------------------------------------------------------------------------------------------------------------------------------
        Private Methods (since Java 9)
            >> Help organize reusable logic inside default or static methods.

              java
              private void log(String msg) {
                 System.out.println("LOG: " + msg);
                          }
-----------------------------------------------------------------------------------------------------------------------------------------------------
        Sealed Interfaces (new in Java 17)
           >> Restrict which classes can implement the interface.
               java
               public sealed interface Shape permits Circle, Square {}
-----------------------------------------------------------------------------------------------------------------------------------------------------
       Marker/Ability/Tag Interfaces
         >> Interfaces with no - methods + fields
         >> by implementing a marker interface, a class can signal that it has a specific property or behavior.
         >> used to mark classes for specific behavior.
         >> marked for some ability or property

         ex. serializable, cloneable, remote, etc.
-----------------------------------------------------------------------------------------------------------------------------------------------------
     Adapter Classes
         >> Interfaces can be used to create adapter classes that provide default implementations for methods.
         >> This allows developers to focus on the methods they care about while still adhering to the interface contract.

         ex. in Java Swing, ActionListener is an interface with a single method actionPerformed().
              Developers can create adapter classes that implement ActionListener and override only the methods they need.

              interface X {
                 void m1();
                 void m2();
                 void m3();
              }

              class My_adapter_class implements x {
                 @Override
                 public void m1() {
                 }
                 @Override
                 public void m2() {
                 }
              }
              // to implement m1() from interface x, extend adapater class

              class Test extends My_adapter_class {
                 @Override
                 public void m3() {
                 }
              }

              Servlet (I) >> GenericServlet (Abstract + Adapter class) >> HttpServlet (Abstract + Adapter class)

              My_Servlet (Concrete class) extends HttpServlet{
              @Override}
                 public void doGet(HttpServletRequest req, HttpServletResponse resp) {
                 }
                                                          }

    * */
}
class RandomClass {

}
