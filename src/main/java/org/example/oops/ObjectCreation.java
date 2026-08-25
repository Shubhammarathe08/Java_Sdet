package org.example.oops;

public class ObjectCreation {
    /*
| # | Method                        | Example Code                                                                                  | Use Case / When to Use                                             |
|---|-------------------------------|-----------------------------------------------------------------------------------------------|---------------------------------------------------------------------|
| 1 | Using `new` operator          | Test t = new Test();                                                                          | Direct object creation, most common approach in standard coding     |
| 2 | Using `Class.forName()`       | Test t = (Test) Class.forName("Test").newInstance();                                          | Dynamic class loading, frameworks like JDBC or Spring use this      |
| 3 | Using Factory Method          | Runtime r = Runtime.getRuntime();                                                             |
|                                   | DateFormat df = DateFormat.getInstance();                                                     | Singleton or centralized object creation logic                      |
| 4 | Using `clone()` method        | Test t1 = new Test();                                                                         |
|                                   | Test t2 = (Test) t1.clone();                                                                  | Copying objects without calling constructor (needs Cloneable)       |
| 5 | Using Deserialization         | FileInputStream fis = new FileInputStream("abc.ser");                                        |
|                                   | ObjectInputStream ois = new ObjectInputStream(fis);                                        |
|                                   | Dog d2 = (Dog) ois.readObject();                                                          | Restoring object from file or stream (needs Serializable interface) |

    * */

    /*
🚫 DEPRECATED — Related to Object Creation

    1. Class.newInstance() — DEPRECATED since Java 9
    Test t = (Test) Class.forName("Test").newInstance();  // ❌ Deprecated

    Reasons for deprecation:
    - throws any exception thrown by the constructor (even checked ones)
      WITHOUT declaring them - bypasses compile-time exception checking
    - only works with public, no-arg constructors - cannot pass constructor arguments
    - error-prone compared to reflection alternative below

    ✅ Use instead (since Java 9) >> Constructor.newInstance() via getDeclaredConstructor()
    Test t = (Test) Class.forName("Test")
                     .getDeclaredConstructor()
                     .newInstance();

    >> supports parameterized constructors too:
    Test t = (Test) Class.forName("Test")
                     .getDeclaredConstructor(int.class, String.class)
                     .newInstance(10, "abc");

    >> wraps constructor exceptions properly in InvocationTargetException
       (checked exceptions are declared/handled correctly, unlike newInstance())


    2. Wrapper class constructors — DEPRECATED since Java 9, forRemoval in later versions
    Integer i = new Integer(10);   // ❌ Deprecated
    Boolean b = new Boolean(true); // ❌ Deprecated
    Long l = new Long(100L);       // ❌ Deprecated
    Double d = new Double(3.14);   // ❌ Deprecated

    ✅ Use instead >> factory methods / autoboxing (uses internal caching, e.g. Integer cache -128 to 127)
    Integer i = Integer.valueOf(10);
    Integer i = 10;      // autoboxing
    Boolean b = Boolean.valueOf(true);


    3. new String(String) constructor — discouraged (not formally deprecated, but bad practice)
    String s = new String("Hello");   // ⚠️ creates unnecessary duplicate object outside String pool

    ✅ Use instead >> String literal (uses String pool, avoids duplicate object)
    String s = "Hello";
    */

    /*
🆕 JAVA 17 ADDITIONS RELATED TO OBJECT CREATION

    6 | Using Records (Java 16+, standard in 17)  |  record Point(int x, int y) {}  |  Point p = new Point(1, 2);
      >> still uses `new`, but constructor (canonical) is auto-generated
      >> compact constructor can validate args before fields are assigned
      >> records are implicitly final - cannot be subclassed, only directly instantiated

    7 | Sealed Classes restricting instantiation (Java 17)  |  sealed class Shape permits Circle {}  |  Shape s = new Circle();
      >> doesn't add a NEW way to create objects, but restricts WHICH classes
         are even eligible to be instantiated as subtypes of a sealed type
      >> permitted subclasses must be final / sealed / non-sealed
      >> abstract sealed classes still can't be instantiated directly (same as any abstract class)

    8 | var with object creation (Java 10+)  |  var t = new Test();  |  convenience only
      >> var infers the declared type from the right-hand `new` expression
      >> does NOT change how the object is created - just local variable type inference
      >> cannot use var on the LEFT if there's no `new`/initializer to infer from

    9 | Pattern Matching instanceof (Java 16+, standard in 17) - relevant when using clone()/deserialization results
      Object obj = t1.clone();
      if(obj instanceof Test t){          // no explicit cast needed after pattern match
          System.out.println(t);
      }
      >> useful right after object-creation-via-clone/deserialization since both return Object,
         requiring a cast before Java 16 - pattern matching removes that extra step


📝 QUICK SUMMARY TABLE

| Approach                      | Status in Java 17          | Notes                                              |
|--------------------------------|-----------------------------|------------------------------------------------------|
| new operator                   | ✅ Standard, unchanged       | Most common, works for classes and records            |
| Class.forName().newInstance()  | ❌ Deprecated (Java 9)       | Use getDeclaredConstructor().newInstance() instead     |
| getDeclaredConstructor().newInstance() | ✅ Preferred reflection way | Supports args, proper exception wrapping         |
| Factory methods                | ✅ Standard, unchanged       | Runtime.getRuntime(), Integer.valueOf(), etc.          |
| clone()                        | ✅ Standard, unchanged       | Still needs Cloneable, still shallow copy by default   |
| Deserialization                | ✅ Standard, unchanged       | Still needs Serializable                               |
| Records (new Point(x,y))       | 🆕 Java 16+/17               | Auto canonical constructor, compact constructor rules  |
| Sealed classes (instantiation) | 🆕 Java 17                   | Restricts eligible subclasses, not the creation syntax  |
| var with new                   | 🆕 Java 10+                  | Local type inference only, no creation-logic change     |
| Wrapper constructors (new Integer(10)) | ❌ Deprecated (Java 9) | Use Integer.valueOf(10) or autoboxing                  |
    */
}