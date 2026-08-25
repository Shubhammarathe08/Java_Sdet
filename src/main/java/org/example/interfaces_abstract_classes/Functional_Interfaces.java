package org.example.interfaces_abstract_classes;

public class Functional_Interfaces {
    /*
                              Functional Interfaces

>> interface which contains EXACTLY ONE abstract method
>> also called SAM (Single Abstract Method) interface
>> introduced concept in Java 8, heavily used in Java 17 for lambda expressions + method references
>> can have any number of default methods, static methods, private methods (Java 9+) - NO restriction on those
>> ONLY the abstract method count is restricted to 1

@FunctionalInterface
interface MyFunc {
    void m1();     // exactly 1 abstract method
}

>> @FunctionalInterface annotation - OPTIONAL but recommended
   >> if annotation present + interface has 0 or 2+ abstract methods >> compile time error
   >> if annotation absent + interface still qualifies (1 abstract method) >> still treated as functional interface
   >> purpose - compiler enforced safety net, prevents accidental addition of a 2nd abstract method later

------------------------------------------------------------------------------------------------------------------------------
                         Why Functional Interfaces Matter

>> enables LAMBDA EXPRESSIONS - concise way to implement SAM interfaces without anonymous class boilerplate

Before (anonymous inner class):
    MyFunc f = new MyFunc(){
        public void m1(){
            System.out.println("hello");
        }
    };

After (lambda, Java 8+, still standard in 17):
    MyFunc f = () -> System.out.println("hello");

>> lambda body implements the SINGLE abstract method - compiler infers which method based on
   functional interface's abstract method signature

------------------------------------------------------------------------------------------------------------------------------
                         Object class methods - special case

>> if interface has 1 abstract method + also redeclares public methods from Object class
   (equals, hashCode, toString) >> STILL considered functional interface
   >> Object class methods are NOT counted towards the "single abstract method" rule

@FunctionalInterface
interface MyFunc {
    void m1();
    boolean equals(Object obj);   // redeclaring Object method - doesn't count as 2nd abstract method
}
// still valid functional interface - only m1() counts

------------------------------------------------------------------------------------------------------------------------------
                         Built-in Functional Interfaces (java.util.function package, Java 8+)

1. Function<T,R>
   >> R apply(T t)
   >> takes 1 input, produces 1 output (different types)
   ex. Function<Integer,String> f = x -> "value: " + x;

2. Supplier<T>
   >> T get()
   >> takes NO input, produces 1 output
   ex. Supplier<String> s = () -> "hello";

3. Consumer<T>
   >> void accept(T t)
   >> takes 1 input, produces NO output (side-effect only)
   ex. Consumer<String> c = x -> System.out.println(x);

4. Predicate<T>
   >> boolean test(T t)
   >> takes 1 input, produces boolean output
   ex. Predicate<Integer> p = x -> x > 10;

5. BiFunction<T,U,R>
   >> R apply(T t, U u)
   >> takes 2 inputs (different types), produces 1 output
   ex. BiFunction<Integer,Integer,Integer> add = (a,b) -> a+b;

6. UnaryOperator<T> extends Function<T,T>
   >> T apply(T t)
   >> input and output SAME type
   ex. UnaryOperator<Integer> square = x -> x*x;

7. BinaryOperator<T> extends BiFunction<T,T,T>
   >> T apply(T t1, T t2)
   >> both inputs + output SAME type
   ex. BinaryOperator<Integer> sum = (a,b) -> a+b;

8. Runnable (from java.lang, pre-existing, retrofitted as functional interface in Java 8)
   >> void run()
   >> no input, no output
   ex. Runnable r = () -> System.out.println("running");

9. Comparator<T> (retrofitted as functional interface in Java 8)
   >> int compare(T o1, T o2)
   ex. Comparator<Integer> c = (a,b) -> a-b;

------------------------------------------------------------------------------------------------------------------------------
                         Method References (Java 8+, still current in 17)

>> shorthand for lambdas that just call an existing method

1. Static method reference       >> ClassName::staticMethod
   Function<String,Integer> f = Integer::parseInt;

2. Instance method ref (specific object)  >> object::instanceMethod
   Consumer<String> c = System.out::println;

3. Instance method ref (arbitrary object of a type)  >> ClassName::instanceMethod
   Function<String,Integer> f = String::length;

4. Constructor reference          >> ClassName::new
   Supplier<ArrayList<Integer>> s = ArrayList::new;

------------------------------------------------------------------------------------------------------------------------------
                         MISSING >> Java 17 relevant additions

*** Records used AS functional interface implementations (Java 16+, standard in 17)
    @FunctionalInterface
    interface Calculator { int calculate(int a, int b); }

    record AddCalculator() implements Calculator {
        public int calculate(int a, int b){ return a+b; }
    }
    >> records CAN implement functional interfaces (they can implement any interface)
    >> still just ONE way among many to implement a functional interface (lambda is usually simpler)

*** Sealed interfaces + Functional interfaces (Java 17) - generally DON'T mix well
    >> a sealed interface restricts WHO can implement it (permits clause)
    >> BUT lambda expressions are compiler-generated implementations - they do NOT go through
       a named permitted class, so combining sealed + functional interface intent is unusual;
       if you need exactly one abstract method AND a closed set of implementers, prefer sealed
       WITHOUT lambda usage, and implement via named permitted classes instead

*** Pattern Matching instanceof (Java 16+, standard in 17) - relevant when a functional interface
    reference is inspected at runtime
    Object obj = (Runnable) () -> System.out.println("hi");
    if(obj instanceof Runnable r){     // no explicit cast needed
        r.run();
    }

------------------------------------------------------------------------------------------------------------------------------
                         DEPRECATED >> related to this topic

>> nothing in the functional interface mechanism itself (SAM rule, @FunctionalInterface,
   lambda syntax, method references) is deprecated in Java 17 - all fully current since Java 8.

1. Anonymous inner classes for SAM implementation - NOT deprecated (still valid Java), but
   DISCOURAGED in modern style for simple SAM cases since lambdas (Java 8+) are more concise
   MyFunc f = new MyFunc(){ public void m1(){ System.out.println("hi"); } }; // verbose, avoid
   MyFunc f = () -> System.out.println("hi");                                // preferred

2. new Integer(x) / new Boolean(x) etc. inside lambda bodies - DEPRECATED since Java 9 (forRemoval)
   Function<Integer,Integer> f = x -> new Integer(x) + 1;   // ❌ avoid
   Function<Integer,Integer> f = x -> x + 1;                 // ✅ autoboxing handles it
    */
}