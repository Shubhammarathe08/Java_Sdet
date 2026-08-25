package org.example.language_fundamentals_01;

public class G_ClassObject {

    /*
    ================================================================================================================
    CLASS & OBJECT - CORE CONCEPTS
    ================================================================================================================
    1) WHAT IS A CLASS?
    ================================================================================================================
    - A CLASS is a BLUEPRINT/TEMPLATE — it defines STRUCTURE (fields) and BEHAVIOR (methods)
      but is NOT itself a runtime "thing" you interact with directly.
    - A class does NOT hold actual data values (except static ones) — it only describes
      what data an OBJECT of that type will hold.
    - One class → many possible objects, each with its own independent state.

        class Employee {
            int empId;              // structure — a blueprint field, no value yet
            void work() { }           // behavior — a blueprint method
        }
===========================================================================================================
* CLASSLOADING DEEP DIVE - IDE REFERENCE
 *
 * WHY IT MATTERS:
 * - NoClassDefFoundError vs ClassNotFoundException explained
 * - Static-init order bugs (circular dependencies, parent-child ordering)
 * - ClassCastException when same class loaded by 2 different ClassLoaders (app servers/OSGi)
 * - Singleton = singleton PER classloader only (not JVM-wide!)
 * - Classloader memory leaks in long-running apps (undeployed classes never GC'd)
 * - Why Class.forName() is needed for JDBC drivers (ServiceLoader now preferred)
 *
 * ELEMENTS TOUCHED PER PHASE:
 * ┌────────────┬────────────────────────────────────────────────────┐
 * │ Phase      │ Touches                                            │
 * ├────────────┼────────────────────────────────────────────────────┤
 * │ Loading    │ .class bytes, constant pool, Class object         │
 * │ Verify     │ Bytecode instructions only (no data init)         │
 * │ Prepare    │ STATIC fields → default values (0/null/false)     │
 * │ Resolve    │ Symbolic refs → real memory addresses             │
 * │ Initialize │ STATIC fields → actual values; static{} runs once │
 * └────────────┴────────────────────────────────────────────────────┘
 *
 * NOTE: Instance fields are NEVER touched here — only later, during `new`
 *
 * FAILURES BY PHASE:
 * ┌────────────┬────────────────────────┬──────────────────────────────────────┐
 * │ Phase      │ Error                  │ Real cause                          │
 * ├────────────┼────────────────────────┼──────────────────────────────────────┤
 * │ Loading    │ ClassNotFoundException │ Class.forName() missing on classpath│
 * │            │ NoClassDefFoundError   │ JVM needed it implicitly, missing   │
 * │ Verify     │ VerifyError            │ Corrupted/incompatible bytecode     │
 * │ Resolve    │ NoSuchMethodError      │ Classpath skew - dependent not      │
 * │            │ NoSuchFieldError       │ recompiled with new version         │
 * │ Initialize │ ExceptionInInitializer │ Exception inside static block/field │
 * │            │ NoClassDefFoundError   │ Class marked "erroneous" forever    │
 * │            │ (retry)                │ after 1st init fail                 │
 * └────────────┴────────────────────────┴──────────────────────────────────────┘
 *
 * WORKED EXAMPLE — Helper (dependency), Base (parent), Derived extends Base { Helper h; }
 * `new Derived();` executes in this order:
 *
 * STATIC ORDER (once per class):
 *   1. Helper static block    → dependency loads first
 *   2. Base static block      → parent always inits before child
 *   3. Derived static block   → child's own static runs last
 *
 * INSTANCE ORDER (every `new`):
 *   4. Helper constructor     → object creation: dependency built first
 *   5. Base constructor       → super() always runs before subclass body
 *   6. Derived constructor    → runs last, after super() + its own field inits
 *
 * RULE:
 *   STATIC order = Dependency → Parent → Child (once, at class load).
 *   INSTANCE order = Dependency obj → super() chain → own constructor (every `new`).

 ==============================================================================================================


    2) WHAT IS AN OBJECT?
    ================================================================================================================
    - An OBJECT is a runtime INSTANCE of a class — it's the actual "thing" with real
      values filled into the class's structure.
    - Created using the `new` keyword (or reflection/clone/deserialization — see
      earlier G_ClassObject.java notes for all 7 creation methods).
    - Every object has 3 characteristics: STATE (field values), BEHAVIOR (methods it
      can perform), and IDENTITY (a unique reference/memory location).

        Employee e = new Employee();      // e = reference, new Employee() = the object
        e.empId = 101;                       // this object's own state


    WHERE THEY LIVE (Memory):
    +--------------------------------------+----------------------------------+
    | Element                              | Location                         |
    +--------------------------------------+----------------------------------+
    | Class structure/bytecode/method code | Metaspace (native memory)        |
    | Class mirror + static field values   | Heap                             |
    | Object instance data                 | Heap                             |
    | Reference variable (e.g., `e`)       | Stack (per-thread)               |
    +--------------------------------------+----------------------------------+




    OBJECT CREATION PROCESS — Employee e = new Employee();
    ================================================================================================================

    +--------------------------------------------------------------------------------------------------------------+
    | Step | Input                          | Output                                                       |
    +------+--------------------------------+--------------------------------------------------------------+
    | 1    | Class name "Employee"          | Employee class LOADED, LINKED, INITIALIZED (done once)      |
    +------+--------------------------------+--------------------------------------------------------------+
    | 2    | Ready class metadata           | Memory allocated for object on HEAP                         |
    +------+--------------------------------+--------------------------------------------------------------+
    | 3    | Allocated memory               | Instance fields assigned DEFAULT values (0/null/false)      |
    +------+--------------------------------+--------------------------------------------------------------+
    | 4    | Default-valued object          | Instance variable initializers + initializer blocks run     |
    |      |                                | (top-to-bottom in source order)                             |
    +------+--------------------------------+--------------------------------------------------------------+
    | 5    | Initialized object             | super() constructor chain executes (root-first)             |
    |      |                                | Then this() constructor body executes                       |
    +------+--------------------------------+--------------------------------------------------------------+
    | 6    | Constructed object             | Reference to new object returned and assigned to `e`        |
    |      |                                | (reference stored on Stack)                                 |
    +------+--------------------------------+--------------------------------------------------------------+

    Object Header (HotSpot JVM):
    +--------------------------------------------------------------------------------------------------------------+
    |                    OBJECT HEADER (12-16 bytes in HotSpot)                                                   |
    +--------------------------------------------------------------------------------------------------------------+
    |  MARK WORD (8 bytes)          |  KLASS POINTER (4-8 bytes)       |  INSTANCE DATA (variable)      |
    |  - Hash code                   |  - Points to class metadata       |  - Actual field values         |
    |  - GC generation age           |  - Identifies object's type       |  - Object's state              |
    |  - Lock state info             |                                   |                                |
    +--------------------------------------------------------------------------------------------------------------+
    |  Note: In compressed OOPs (64-bit JVM with -XX:+UseCompressedOops), Klass pointer is 4 bytes               |
    |        Array objects have an additional 4 bytes for length                                                  |
    +--------------------------------------------------------------------------------------------------------------+

    ================================================================================================================
    MEMORY LAYOUT QUICK REFERENCE
    ================================================================================================================

    +--------------------------------------------------------------------------------------------------------------+
    | Element                              | Memory Area                         | Description                              |
    +--------------------------------------+-------------------------------------+------------------------------------------+
    | Class structure/bytecode/method code | Metaspace (native memory)           | Class definitions, method bytecode      |
    | Class mirror + static field values   | Heap                                | java.lang.Class object + static data    |
    | Object instance data (fields)        | Heap                                | Each object's own state                 |
    | Reference variable (e.g., `e`)       | Stack (per-thread)                  | Points to Heap object                   |
    | Method local variables               | Stack (per-thread)                  | Primitives and references               |
    | Method call frames                   | Stack (per-thread)                  | Each method call creates a frame        |
    +--------------------------------------+-------------------------------------+------------------------------------------+

    ================================================================================================================
    TYPES OF OBJECTS (by lifecycle)
    ================================================================================================================
    | Type                     | Description                                                          |
    +--------------------------+----------------------------------------------------------------------+
    | LOCAL OBJECT             | Created in method; dies on method return; GC-eligible                |
    |                          | void process() { Employee e = new Employee(); }                      |
    +--------------------------+----------------------------------------------------------------------+
    | INSTANCE/MEMBER OBJECT   | Held as field; lives as long as container                            |
    |                          | class Department { Employee manager = new Employee(); }              |
    +--------------------------+----------------------------------------------------------------------+
    | ANONYMOUS OBJECT         | No reference; used once; immediately GC-eligible                     |
    |                          | new Employee().work();                                               |
    +--------------------------+----------------------------------------------------------------------+
    | STATIC OBJECT            | Referenced via static field; lives as long as class                  |
    |                          | class Cache { static Employee shared = new Employee(); }             |
    +--------------------------+----------------------------------------------------------------------+
    | SINGLETON OBJECT         | Exactly ONE instance (design pattern)                                 |
    |                          | class DBConn { private static final DBConn INSTANCE = new DBConn(); } |
    +--------------------------+----------------------------------------------------------------------+
    | IMMUTABLE OBJECT         | State never changes; thread-safe                                     |
    |                          | record Point(int x, int y) { }                                       |
    +--------------------------+----------------------------------------------------------------------+
    | CLONED OBJECT            | Copy via clone() (needs Cloneable)                                   |
    +--------------------------+----------------------------------------------------------------------+
    | DESERIALIZED OBJECT      | Restored from byte stream (needs Serializable)                       |
    +--------------------------+----------------------------------------------------------------------+

    ================================================================================================================
    CRUD OPERATIONS ON OBJECTS
    ================================================================================================================
    | Operation | How it's done                                                    | Example                           |
    +-----------+------------------------------------------------------------------+-----------------------------------+
    | CREATE    | new, factory, clone, deserialization, reflection                | Employee e = new Employee();      |
    +-----------+------------------------------------------------------------------+-----------------------------------+
    | READ      | Access fields/getters, or reflection                            | e.getName(); field.get(e);        |
    +-----------+------------------------------------------------------------------+-----------------------------------+
    | UPDATE    | Setters, direct field assignment (if mutable)                   | e.setName("Raj");                 |
    +-----------+------------------------------------------------------------------+-----------------------------------+
    | DELETE    | No free() - nullify reference; GC reclaims when unreachable     | e = null;                         |
    +-----------+------------------------------------------------------------------+-----------------------------------+
    NOTE: "Delete" = "make unreachable" - actual memory reclaim is GC's job

    CRUD OPERATIONS ON CLASSES (Reflection/Classloading)
    +-----------+------------------------------------------------------------------+-----------------------------------+
    | CREATE    | Class LOADING - ClassLoader reads .class → builds Class object  | Class.forName("Employee");        |
    +-----------+------------------------------------------------------------------+-----------------------------------+
    | READ      | Reflection - inspect structure at runtime                       | clazz.getFields();                |
    +-----------+------------------------------------------------------------------+-----------------------------------+
    | UPDATE    | Normally not possible - bytecode fixed                          | Bytecode manipulation (ASM)       |
    +-----------+------------------------------------------------------------------+-----------------------------------+
    | DELETE    | CLASS UNLOADING - rare; only when ClassLoader + all instances   | Custom ClassLoaders               |
    |           | become unreachable                                               |                                   |
    +-----------+------------------------------------------------------------------+-----------------------------------+

    ================================================================================================================
    7 WAYS TO CREATE AN OBJECT
    ================================================================================================================
    | # | Method                       | Use Case                                                      |
    +---+------------------------------+---------------------------------------------------------------+
    | 1 | `new` operator               | Direct object creation - most common                         |
    +---+------------------------------+---------------------------------------------------------------+
    | 2 | Reflection - Class.forName() | Dynamic class loading - JDBC, Spring                         |
    +---+------------------------------+---------------------------------------------------------------+
    | 3 | Factory method               | Singleton or centralized/cached creation                     |
    +---+------------------------------+---------------------------------------------------------------+
    | 4 | `clone()`                    | Copy object without constructor (needs Cloneable)            |
    +---+------------------------------+---------------------------------------------------------------+
    | 5 | Deserialization              | Restore from file/stream (needs Serializable)                |
    +---+------------------------------+---------------------------------------------------------------+
    | 6 | Constructor reference        | Functional style - ClassName::new (Java 8+)                  |
    +---+------------------------------+---------------------------------------------------------------+
    | 7 | Array reflection             | Dynamic arrays - Array.newInstance()                         |
    +---+------------------------------+---------------------------------------------------------------+

    Example 1 — new:
        Test t = new Test();

    Example 2 — reflection (⚠️ DEPRECATED since Java 9):
        // ❌ AVOID: Class.newInstance()
        Test t = (Test) Class.forName("Test").newInstance();
        // ✅ USE: getDeclaredConstructor().newInstance()
        Test t = (Test) Class.forName("Test").getDeclaredConstructor().newInstance();

    Example 3 — factory method:
        Runtime r = Runtime.getRuntime();
        DateFormat df = DateFormat.getInstance();

    Example 4 — clone():
        Test t1 = new Test();
        Test t2 = (Test) t1.clone();     // needs Cloneable
        // ⚠️ Cloneable/clone() is a design flaw - prefer copy constructor

    Example 5 — deserialization:
        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Dog d2 = (Dog) ois.readObject();     // needs Serializable

    Example 6 — constructor reference:
        Supplier<Test> supplier = Test::new;
        Test t = supplier.get();

    Example 7 — array reflection:
        Test[] arr = (Test[]) Array.newInstance(Test.class, 10);

    ================================================================================================================
    TYPES OF CLASSES IN JAVA
    ================================================================================================================

    a) CONCRETE CLASS
    ─────────────────────────────────────────────────────────────────────────────────
    Fully implemented, directly instantiable
        class Employee { }
        Employee e = new Employee();     // ✅ Can instantiate

    b) ABSTRACT CLASS
    ─────────────────────────────────────────────────────────────────────────────────
    Cannot instantiate; may mix abstract + concrete methods
        abstract class Vehicle {
            abstract void start();                    // no body
            void honk() { System.out.println("Beep!"); }  // concrete
        }
        // Vehicle v = new Vehicle();    // ❌ Cannot instantiate

    c) INTERFACE
    ─────────────────────────────────────────────────────────────────────────────────
    Contract - 100% abstract before Java 8
    - Java 8+: default and static methods
    - Java 9+: private methods
    - Multiple inheritance of TYPE
        interface Drawable {
            void draw();                                   // abstract
            default void show() { System.out.println("Showing"); }  // Java 8+
            static void info() { System.out.println("Drawable"); }   // Java 8+
            private void helper() { }                         // Java 9+
        }

    d) FINAL CLASS
    ─────────────────────────────────────────────────────────────────────────────────
    Cannot be extended/subclassed
        final class Constants { }
        // class MyConstants extends Constants { }    // ❌ Compile error

    e) STATIC NESTED CLASS
    ─────────────────────────────────────────────────────────────────────────────────
    Declared 'static' inside another class; no outer instance needed
    Can only access STATIC members of outer class
        class Outer {
            static class Nested { }
        }
        Outer.Nested obj = new Outer.Nested();    // ✅ No outer instance needed

    f) INNER CLASS (Non-static Nested)
    ─────────────────────────────────────────────────────────────────────────────────
    Tied to outer-class instance; can access ALL members (including private)
        class Outer {
            class Inner { }
        }
        Outer o = new Outer();
        Outer.Inner in = o.new Inner();    // ✅ Requires outer instance

    g) LOCAL CLASS
    ─────────────────────────────────────────────────────────────────────────────────
    Defined INSIDE a method; scope limited to that method
    Can access final/effectively-final local variables
        void process() {
            class Helper { }
            Helper h = new Helper();
        }

    h) ANONYMOUS CLASS
    ─────────────────────────────────────────────────────────────────────────────────
    No name; declared and instantiated in one expression
    One-off implementation of interface/abstract class
        Runnable r = new Runnable() {
            public void run() { System.out.println("running"); }
        };
        // Often replaced by LAMBDA for functional interfaces

    i) ENUM CLASS
    ─────────────────────────────────────────────────────────────────────────────────
    Fixed set of constants; extends java.lang.Enum
    Can have fields/methods/constructors
        enum Status {
            ACTIVE, INACTIVE;
            boolean isActive() { return this == ACTIVE; }
        }

    j) UTILITY CLASS
    ─────────────────────────────────────────────────────────────────────────────────
    All-static methods; private constructor; ends with "Utils"/"Helper"
        final class MathUtils {
            private MathUtils() { }    // Prevent instantiation
            static int add(int a, int b) { return a + b; }
        }

    ================================================================================================================
    MODERN CLASSES (Java 17+)
    ================================================================================================================

    k) RECORD CLASS (Preview Java 14, STANDARD Java 16)
    ─────────────────────────────────────────────────────────────────────────────────
    Compact, immutable DATA-CARRIER class
    - Auto-generates: constructor, accessors, equals(), hashCode(), toString()
    - All components are 'private final'
    - Cannot extend another class; CAN implement interfaces

        record Point(int x, int y) {
            // Compact constructor - validation
            public Point {
                if (x < 0 || y < 0) throw new IllegalArgumentException("Must be positive");
            }
            // Additional methods allowed
            double distance() { return Math.sqrt(x*x + y*y); }
        }

        Point p = new Point(3, 4);
        p.x();                    // Accessor - no "get" prefix → 3
        p.toString();             // Auto-generated → Point[x=3, y=4]

    Use Case: DTOs, immutable test-data models, API request/response payloads

    l) SEALED CLASS / INTERFACE (STANDARD Java 17 - JEP 409)
    ─────────────────────────────────────────────────────────────────────────────────
    Restricts WHICH classes can extend/implement via 'permits'
    Controlled middle ground between 'final' and open inheritance

        sealed interface Shape permits Circle, Square { }
        final class Circle implements Shape { }
        non-sealed class Square implements Shape { }  // Opts back into open inheritance

        // class Triangle implements Shape { }    // ❌ Not permitted

    Every permitted subtype must be: final, sealed, or non-sealed
    Pairs naturally with pattern matching for exhaustive type checks

    m) PATTERN MATCHING for instanceof (STANDARD Java 16)
    ─────────────────────────────────────────────────────────────────────────────────
    Removes manual cast after instanceof check
        if (obj instanceof Circle c) {
            System.out.println(c.radius());    // No explicit cast needed
        }

    ================================================================================================================
    DEPRECATED / REMOVED FEATURES (Java 17)
    ================================================================================================================
    | API / Feature                    | Status                          | Replacement/Note                     |
    +----------------------------------+---------------------------------+--------------------------------------+
    | Class.newInstance()              | Deprecated since Java 9          | getDeclaredConstructor().newInstance()|
    +----------------------------------+---------------------------------+--------------------------------------+
    | Object.finalize()                | Deprecated (forRemoval Java 18)  | AutoCloseable + try-with-resources   |
    +----------------------------------+---------------------------------+--------------------------------------+
    | RMI Activation                   | REMOVED in Java 17 (JEP 407)     | Was deprecated in Java 15            |
    +----------------------------------+---------------------------------+--------------------------------------+
    | Applet API                       | Deprecated for removal Java 17  | Browser plugin support is gone       |
    +----------------------------------+---------------------------------+--------------------------------------+
    | Security Manager                 | Deprecated for removal Java 17  | OS/container-level security          |
    +----------------------------------+---------------------------------+--------------------------------------+
    | CORBA                            | REMOVED in Java 11 (JEP 320)    | Modern RPC/gRPC/REST                 |
    +----------------------------------+---------------------------------+--------------------------------------+
    | Experimental AOT/Graal Compiler  | REMOVED in Java 17 (JEP 410)    | Saw little adoption                   |
    +----------------------------------+---------------------------------+--------------------------------------+
    | Cloneable / Object.clone()       | NOT deprecated, but DISCOURAGED | Copy constructor / builder           |
    +----------------------------------+---------------------------------+--------------------------------------+

    Why finalize() matters:
    - Meant for pre-GC cleanup, but timing is UNPREDICTABLE
    - Bad finalizer can "resurrect" an unreachable object
    - Modern: AutoCloseable + try-with-resources, or Cleaner API

    ================================================================================================================
    NEW FEATURES - Java 9 → 17
    ================================================================================================================
    | Feature                                  | Status in Java 17                    |
    +------------------------------------------+--------------------------------------+
    | Private interface methods (Java 9)       | Standard                             |
    | var local type inference (Java 10)       | Standard - LOCAL variables only      |
    | Text blocks (Preview 13, Standard 15)    | Standard                             |
    | Switch expressions (Standard Java 14)    | Standard                             |
    | Records (Preview 14, Standard 16)        | Standard                             |
    | Pattern matching for instanceof (Java 16)| Standard                             |
    | Sealed classes/interfaces (Java 17)      | Standard (JEP 409)                   |
    | Pattern matching for switch (JEP 406)    | PREVIEW ONLY in 17                   |
    | Foreign Function & Memory API (JEP 412)  | Incubator in 17                      |
    | Vector API (JEP 414)                     | Second incubator round in 17         |
    +------------------------------------------+--------------------------------------+

    ================================================================================================================
    QUICK RECALL TABLE
    ================================================================================================================
    | Concept              | Key Trait                                         | Status in Java 17               |
    +----------------------+---------------------------------------------------+---------------------------------+
    | Concrete class       | Fully implemented, instantiable                   | Java 1                          |
    | Abstract class       | Cannot instantiate, may have abstract methods     | Java 1                          |
    | Interface            | Contract, multiple inheritance                    | Java 8/9 enhancements           |
    | Final class          | Cannot be subclassed                              | Java 1                          |
    | Static nested class  | Doesn't need outer instance                       | Java 1                          |
    | Inner class          | Needs outer instance, full member access          | Java 1                          |
    | Local class          | Scoped to a method                                | Java 1                          |
    | Anonymous class      | No name, one-off implementation                   | Java 1                          |
    | Enum class           | Fixed set of constants                            | Java 5                          |
    | Record class         | Immutable data carrier, auto-generated            | Standard Java 16                |
    | Sealed class/interface| Restricts permitted subclasses via 'permits'     | Standard Java 17 (JEP 409)      |
    | Class.newInstance()  | Deprecated - use getDeclaredConstructor()         | Deprecated Java 9               |
    | Object.finalize()    | Deprecated; forRemoval from Java 18               | Deprecated Java 9               |
    | RMI Activation       | Fully REMOVED in Java 17                          | Removed Java 17 (JEP 407)       |
    +----------------------+---------------------------------------------------+---------------------------------+

    ================================================================================================================
    INTERVIEW QUICK RECALL - Q&A
    ================================================================================================================

    Q: How many ways to create an object in Java?
    A: 7 ways (new, Class.forName(), factory, clone, deserialization, constructor ref, array reflection)

    Q: What are the class types in Java?
    A: Concrete, Abstract, Interface, Final, Static Nested, Inner, Local, Anonymous, Enum, Utility, Record, Sealed

    Q: What's new in Java 17 for classes?
    A: Sealed classes/interfaces (standard), enhanced pattern matching, records (enhanced)

    Q: Difference between Abstract Class and Interface in Java 17?
    A: Abstract class: state/fields, constructor. Interface: default/static methods (Java 8+),
       private methods (Java 9+), multiple inheritance

    Q: Difference between Record and Class?
    A: Record is immutable, auto-generates constructor, accessors, equals, hashCode, toString.
       Class requires manual implementation.

    Q: When to use Sealed Classes?
    A: When you want to restrict inheritance (domain modeling, algebraic data types)

    Q: Why is Class.newInstance() deprecated?
    A: Propagates exceptions incorrectly and bypasses checked exceptions

    Q: What replaced finalize()?
    A: AutoCloseable + try-with-resources, or Cleaner API

    Q: Where do classes and objects live in memory?
    A: Class structure in Metaspace, Class mirror + static values in Heap,
       Objects in Heap, References in Stack

    Q: What is the class loading process?
    A: Loading → Linking (Verification, Preparation, Resolution) → Initialization

    ================================================================================================================
    REAL JDK EXAMPLES - For Every Class Type
    ================================================================================================================
    Everything below is from standard JDK - useful to quote in interviews

    | Type                | Real JDK Example                                                              |
    +---------------------+-------------------------------------------------------------------------------+
    | Concrete class      | java.util.ArrayList                                                           |
    | Abstract class      | java.util.AbstractList, java.io.InputStream                                   |
    | Interface           | java.util.List, java.lang.Runnable, java.io.Serializable (marker)             |
    | Final class         | java.lang.String, java.lang.Integer, java.lang.Math                           |
    | Static nested class | java.util.Map.Entry, java.lang.Character.UnicodeBlock                         |
    | Inner class         | java.util.ArrayList.Itr (private inner - Iterator)                            |
    | Local class         | Rarely in JDK public API - application-level pattern                          |
    | Anonymous class     | Comparator<String> byLength = new Comparator<String>() { ... }                |
    | Enum class          | java.time.DayOfWeek, java.util.concurrent.TimeUnit, java.lang.Thread.State    |
    | Utility class       | java.util.Collections, java.util.Arrays, java.lang.Math, java.nio.file.Files  |
    | Singleton           | java.lang.Runtime.getRuntime() - textbook singleton                           |
    | Immutable object    | java.lang.String, java.time.LocalDate, all wrapper classes                    |
    | Cloneable object    | java.util.ArrayList, java.util.HashMap, java.util.Date                        |
    | Serializable object | java.util.ArrayList, java.util.HashMap, java.lang.String                      |
    | Sealed interface    | java.lang.constant.ConstantDesc (cited in JEP 409)                            |
    | Record class        | None in java.base yet - application-level pattern                             |

    NOTES ON JDK EXAMPLES:
    - java.util.ArrayList.Itr: inner class with implicit reference to ArrayList
    - java.lang.constant.ConstantDesc: sealed interface introduced in Java 12
    - java.lang.Runtime: classic singleton with private constructor + static getRuntime()
    - Local class: rarely appears in JDK's public API - mostly application-level
    */
}