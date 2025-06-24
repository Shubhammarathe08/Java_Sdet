package org.example.language_fundamentals;

public class Variables {

    /*                    Variables

To store data, for intermediate processing
Strongly typed language  >>> define data type (in advance)

When you declare and initialize variables in a Java program,
>> The values are stored in the computer's memory (RAM) during the execution of the program.

*** Depend on type of val it represents
1. Primitive type variables hold the actual data | represent primitive vals
     int x = 10; // x holds the value 10 directly
2. Reference type variables hold references to the objects in memory
   A reference variable is any variable that points to an object, not a primitive value.
     Student s = new Student(); // s holds a reference to a Student object in memory

*** Depend on position of declaration + behavior

1. Instance var / attributes / object level variables
>> val of variable vary from object to object, for every object a separate copy of instance variable is created
>> Declared :- inside a class but outside any method, constructor, or block.
>> Creation/Destruction :- at the time of object creation and destroyed when the object is destroyed. (Memory >> heap)
>> Scope :- of instance variable is the entire class, meaning they can be accessed by all methods, constructors, and blocks in the class.
>> Accessible in :- Static area/Instance area [using object reference (e.g., objectName.variableName)]
>> Default Val :- 0, false, null (for reference types) *** no need to initialize explicitly , JVM provides default values
>> No Access modifier defined - default access modifier (package-private) is applied, meaning it can be accessed within the same package.



2. Static var / class level variables / fields
>> val of variable Doesn't vary from object to object, declare as Static var
>> one copy of static variable is created, shared by all objects of the class
>> Declared :-  inside a class with the static keyword, outside any method, constructor, or block.
>> Creation/Destruction :- at the time of class loading and destroyed when the class is unloaded. (Memory >> method area)
>> java test > start JVM > create and start main thread >locate test.class >
                                      > load class bytecode > execute main method
                                                         > unload class bytecode > terminate main thread > shutdown jvm
>> Scope :-  of instance variable is the entire class, meaning they can be accessed by all methods, constructors, and blocks in the class.
>> Accessible in :- Static Area/Instance area  [
                          using object reference (e.g., objectName.variableName) ,
                          classname.variableName ,
                          directly using variable name in static methods, static blocks, and static constructors of the same class
                          ]
>> Default Val :- 0, false, null (for reference types) *** no need to initialize explicitly , JVM provides default values
>> No Access modifier defined - default access modifier (package-private) is applied, meaning it can be accessed within the same package.
>> single instance can be accessed by multiple thread >> not thread safe


3. local var / temporary variables / block level variables / thread safe variables
>> sometimes to meet temporary requirements, we need to declare variables inside methods, constructors, or blocks
>> Declared :- inside a method, constructor, or block.
>> Creation/Destruction :- at the time of method call/constructor call/block execution
                           and destroyed when the method/constructor/block execution is completed. (Memory >> stack)
>> Scope :- of instance variable is the method, constructor, or block in which they are declared.
>> Accessible in :- Static area/Instance area [using object reference (e.g., objectName.variableName)]
>> Default Val :- no default value is provided, so they must be initialized before use.
                  If not initialized, the compiler will throw an error.
   *** can define int x ; but cant use without initializing it first
>> Only Applicable modifier - final (any other modifier will throw an error)
   final int x = 10; // x is a constant, its value cannot be changed after initialization
>> for every thread separate copy of local var are created | single instance can be accessed by multiple thread >> not thread safe
#################################################################################
    -> Dangerous cope f local variables
               try{
                int k = Integer.parseInt("Ten");
            }
            catch(NumberFormatException e){
                 k = 10;
            }
            System.out.println(k);
###################################################################################

     -> variables primitive vs reference / instance vs static vs local

    int x =100; // instance + primitive
    static String s = "Hello"; // static + reference
    public static void main(String[] args){
     int[] a = new int[]{1,2,3}; // local + reference
    }
###################################################################################


// static + instance + local variables
     int[] x ; >> ref var + instance var
     int[] y = new int[3];
     int[] z = {1,2,3};

    public static void main(String[] args){
    System.out.println(x + x[0]); // null + null pointer exception
    System.out.println(y + y[0]); // [I@15db9742 + 0
    System.out.println(z + z[0]); // [I@6d06d69c + 1

// local variable
     int[] x ; >> ref var + local var
     int[] y = new int[3];
     int[] z = {1,2,3};

    public static void main(String[] args){
    System.out.println(x + x[0]); // compile time error >> x might not have been initialized
    System.out.println(y + y[0]); // [I@15db9742 + 0
    System.out.println(z + z[0]); // [I@6d06d69c + 1
    }


The exact location in memory depends on the type of variable:
all these memory areas (stack, heap, method area) are part of the computer's RAM.


=========================================================================================================================================
                                        MEMORY AREAS IN JAVA


Heap >>
Instance Variables , Objects , Arrays , Object Fields || Per Objects

Stack >>
Local variables , references ( p - Pol p = new Pol()) , methods <parameters, calls> (general / nested) || Per method call
Class/Method Area >> Static variables , class definition (class names,method codes) , bytecode(class,method) || Shared by all objects
Pc Register >> current instruction for thread

Same .class bytecode file
Class Bytecode >> Metadata: class name, fields, structure
Method Byte code >> Instructions for each method's behavior

When a program is connected to a database and uses variables, the handling of data involves several steps:


Retrieving Data: Data is fetched from the database and stored in variables for processing.
Processing Data: Variables are used to manipulate or transform the data as needed.
Storing Data: Processed data can be stored back into the database.
    * */

    static int x = 10;   // same copy shared , one change affects all objects
    boolean y = true; // separate copy, for every object a separate copy of instance variable is created

    public static void main(String[] args){
        Variables v1 = new Variables ();
           v1.x = 1000;
           v1.y = false;
        Variables v2 = new Variables ();
        System.out.println(v2.x+ " " + v2.y); // 1000 , true
        int j=0;
        for(int i=0; i<10; i++){
            j = i+j;
        }
        //System.out.println(i+j);

        // j and k local var >> cant be accessed outside block or method


    }
}
