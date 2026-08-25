package org.example.language_fundamentals_01;

public class J_ExecutionOrder {

    /*   Top To Bottom
     *** this class has NO parent-child >> only step 1-6 apply here
     *** if parent-child existed >> parent static full done -> child static
                                  >> parent instance+constructor full done -> child instance+constructor (step 7-8)

     step 1 - identification of - static members
            >> static block 1, [ i2 , m2 ( 2 main methods) ] , static block 2 (parent-child >> top-bottom)
     step 2 - execution of static var + static blocks (parent-child >> top-bottom)
              i2 = 200
           op:- first static block executed
                second static block executed
     step 3 - execution of main | p s v m(String[] args)
               local_var = true
               op:- first static block executed
                    second static block executed
                    main method executed

     *** 2 main() methods in this class >> main(String[] args) is the ONLY real entry point (JVM picks EXACT
         match, String... also works since same erasure) >> main(Character... args) is just a normal
         overloaded static method, JVM never auto-calls it, has to be called manually like any other method

     *** static init >> guaranteed ONCE per class + thread-safe (JVM keeps a per-class init lock internally,
         other threads just wait if 2 threads trigger it at same time) >> good interview_programs_java point

     >>>> Object Creation >>>>
     step 4 -  identification of - instance members (parent-child >> top-bottom)
               >> instance block 1 , 3 constructors , i1, m1, instance block 2
     step 5 - execution of instance var + instance blocks (parent >> top-bottom)
               i1 = 100
               op:- first static block executed
               second static block executed
               main method executed
               first instance block executed
               second instance block

     step 6 - instance constructor (parent >> top-bottom)

               op:- first static block executed
               second static block executed
               main method executed
               first instance block executed
               second instance block
               no arg constructor executed

               first instance block executed
               second instance block
               int arg constructor executed

               first instance block executed
               second instance block
               var arg constructor executed

     step 7 - execution of instance var + instance blocks (child >> top-bottom)  [only if parent-child, not here]
     step 8 - instance constructor (child >> top-bottom)                          [only if parent-child, not here]

 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    BONUS >> mixed field-init + block + constructor order (kept as its own separate class, renamed from
    original Initialization so it doesn't clash with J_ExecutionOrder class name)

    class Initialization {
        private static String m1(String msg) { System.out.println(msg); return msg; }
        String m;                                    // default null

        public Initialization() {   // constructor >> declared FIRST in source but STILL runs LAST always
            m = m1("1");
        }

        {
            m = m1("2");            // 1st initializer textually >> runs 1st
        }

        String field3init = m1("3");   // 2nd initializer textually >> runs 2nd

        public static void main(String[] args) {
            Object o = new Initialization();
        }
    }

    output :- null | 2 (m=2) , 3 (m=3) , 1 (m=1)     >> final m = "1"
    *** rule >> initializers run in TEXTUAL order as written (interleaved), NOT "all blocks before all fields"
              constructor body always LAST, regardless of where its written in the source

 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    JAVA 17 - new/deprecated re: execution order
    *** core static/instance init order (step 1-8) unchanged since Java 1 >> Java 17 changes nothing here
    *** RECORDS (standard Java 16) >> new nuance >> compact constructor body runs BEFORE compiler's
        auto-generated field assignment at the end
            record Point(int x, int y) {
                public Point {                          // compact constructor runs FIRST
                    if (x < 0) throw new IllegalArgumentException();
                }                                            // then this.x=x; this.y=y; auto-assigned after
            }
    *** Object.finalize() >> "bookend" opposite of construction, deprecated since Java 9,
        deprecated-for-REMOVAL only from Java 18 (not 17) >> unrelated to init order itself, just end-of-life note
    *** no JVM launcher/arg changes affect this topic, `java ClassName` triggers step 1-3 same way Java 8 thru 17

    */

    {
        System.out.println("first instance block executed");
    }

    static {
        System.out.println("first static block executed");
    }

    J_ExecutionOrder() {
        System.out.println("no arg constructor executed");
    }

    J_ExecutionOrder(int x) {
        System.out.println("int arg constructor executed");
    }

    <T> J_ExecutionOrder(T... t) {
        System.out.println("var arg constructor executed");
    }

    int i1 = 100;
    static int i2 = 200;

    void m1() {
        System.out.println("void instance m1 executed");
    }

    static void m2() {
        System.out.println("static m2 executed");
    }

    public static void main(String[] args) {

        boolean local_var = true;

        System.out.println("main method executed");

        // Creating an instance of J_ExecutionOrder
        J_ExecutionOrder eo1 = new J_ExecutionOrder();

        // Creating an instance with int argument
        J_ExecutionOrder eo2 = new J_ExecutionOrder(10);

        // Creating an instance with var args
        J_ExecutionOrder eo3 = new J_ExecutionOrder(1, 2, 3);
    }

    static {
        System.out.println("second static block executed");
    }

    {
        System.out.println("second instance block");
    }

    // ⚠️ NOT the JVM entry point — just an overloaded static method (different erasure: Character[] vs String[])
    public static void main(Character... args) {
        System.out.println("var arg char main method executed");
    }
}