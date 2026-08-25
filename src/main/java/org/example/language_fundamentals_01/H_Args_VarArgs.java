package org.example.language_fundamentals_01;

/**
 * ARGS & VARARGS — COMPLETE REFERENCE
 *
 * ================================================================================================================
 * SECTION 1: WHAT IS AN "ARGUMENT"?
 * ================================================================================================================
 * An ARGUMENT is a VALUE supplied at the point of use — to a method, constructor,
 * program, or the JVM itself — so that code can operate on data it doesn't already have.
 *
 * - FORMAL ARGUMENT (parameter) → the variable declared in the method signature
 * - ACTUAL ARGUMENT (argument)  → the real value supplied at the call site
 *
 *     void greet(String name) { }     // 'name' = formal argument/parameter
 *     greet("Shubham");               // "Shubham" = actual argument
 *
 * ================================================================================================================
 * SECTION 2: TYPES OF ARGUMENTS IN JAVA
 * ================================================================================================================
 *
 * a) COMMAND-LINE ARGUMENTS — passed from the OS shell into `main(String[] args)`
 *     java Test A B C D          // args[0]="A", args.length=4
 *     WHY String[]? → most universal type; any value can be parsed from a String
 *     (Integer.parseInt(args[0]), Double.parseDouble(args[1]), etc.)
 *
 * b) METHOD ARGUMENTS — passed positionally, matched by TYPE + ORDER (not by name)
 *     void add(int a, int b) { }
 *     add(2, 3);                 // positional only — Java has NO named arguments
 *
 * c) VARARGS (variable-length arguments, Java 5+) — accept 0..N values as an array
 *     void print(String... items) { }        // internally treated as String[]
 *     print("a", "b", "c");                  // any count, including zero
 *
 * d) CONSTRUCTOR ARGUMENTS — same rules as method arguments, used to initialize state
 *     Employee e = new Employee("Raj", 50000);
 *
 * e) GENERIC TYPE ARGUMENTS — a TYPE passed in angle brackets, not a runtime value
 *     List<String> list = new ArrayList<String>();     // String = type argument
 *
 * f) LAMBDA PARAMETERS — arguments to a functional interface's abstract method
 *     (a, b) -> a + b
 *
 * g) JVM ARGUMENTS (not program arguments — consumed by the `java` launcher itself)
 *     java -Xmx512m -Dprop=value -cp . Test A B
 *     - `-X...`   → JVM tuning flags (heap size, GC, etc.)
 *     - `-D...`   → system properties, read via System.getProperty("prop")
 *     - Everything AFTER the class name → goes to `String[] args`, NOT the JVM
 *
 * ================================================================================================================
 * SECTION 3: HOW ARGUMENTS ARE PASSED — Java is ALWAYS Pass-by-Value
 * ================================================================================================================
 * - Primitives → the VALUE itself is copied; changes inside the method don't affect the caller
 * - Objects/arrays → the VALUE OF THE REFERENCE (the address) is copied — so the method
 *   can mutate the object's internal state, but REASSIGNING the parameter inside the
 *   method does NOT affect the caller's original reference
 *
 *     void rename(Employee e) { e.name = "X"; }        // ✅ caller sees the change
 *     void reset(Employee e) { e = new Employee(); }   // ❌ caller's reference unchanged
 *
 * - There is NO true "pass-by-reference" in Java, unlike C++.
 * - Java has NO default arguments and NO named arguments (unlike Kotlin/Python/C++) —
 *   the common workaround is METHOD OVERLOADING or a Builder pattern.
 *
 * ================================================================================================================
 * SECTION 4: VARARGS RULES (Java 5+)
 * ================================================================================================================
 * 1) The varargs parameter is INTERNALLY just an array — treat it exactly like one.
 *        int... x   ⟺  int[] x           (same bytecode signature)
 *        int[]... x ⟺  int[][] x
 *
 * 2) The varargs parameter MUST be the LAST parameter in the method signature.
 *        m1(int x, int... v)                 // ✅ valid
 *        m3(int... x, String v)              // ❌ invalid
 *
 * 3) At most ONE varargs parameter is allowed per method.
 *        m4(int... x, int... y)              // ❌ invalid
 *
 * 4) You CANNOT declare a varargs method AND its exact array-equivalent in the same
 *    class — they compile to the IDENTICAL signature (compile-time error).
 *        void m1(int... x) { }
 *        void m1(int[]  x) { }               // ❌ "method m1(int[]) is already defined"
 *
 * 5) Varargs methods CAN be overloaded. When both fixed-arity and varargs could match,
 *    the COMPILER ALWAYS PREFERS the fixed-arity (non-varargs) method.
 *        static void show(int x)      { println("fixed-arity"); }
 *        static void show(int... x)   { println("varargs"); }
 *        show(10);         // → "fixed-arity"
 *        show(10, 20);     // → "varargs"
 *        show();           // → "varargs"
 *
 * 6) Varargs works with ANY type — primitives, reference types, and generics:
 *        void m1(Student... s) { }              // reference type
 *        <T> void m1(T... t) { }                // generic type parameter
 *
 *    ⚠️ GENERIC varargs — heap pollution risk; since Java 7, mark safe methods with
 *    `@SafeVarargs` (only on `static`, `final`, `private`, or constructors).
 *        @SafeVarargs
 *        static <T> void printAll(T... items) { for (T t : items) println(t); }
 *
 * 7) At the CALL SITE, you may pass either individual values OR an actual array —
 *    both are equivalent for a varargs parameter:
 *        m1(10, 20, 30);
 *        m1(new int[]{10, 20, 30});             // ✅ same effect
 *
 * 8) The JVM entry point itself accepts either form interchangeably:
 *        public static void main(String[] args) { }
 *        public static void main(String... args) { }    // ✅ also valid
 *
 * ================================================================================================================
 * SECTION 5: JAVA 9–17 — ARGUMENT-RELATED CHANGES
 * ================================================================================================================
 * NEW:
 * - Java 11 (JEP 330) — Launch Single-File Source-Code Programs:
 *       java Hello.java A B          // compiles+runs in one step, args still work identically
 * - Java 9+ Module system adds new JVM launcher arguments:
 *       --module-path, --add-modules, --add-opens   (module-related, not program args)
 * - `--enable-preview` — JVM flag needed to run any class using a PREVIEW language
 *   feature (e.g. pattern matching for switch, a preview feature in Java 17)
 *
 * DEPRECATED:
 * - `-Djava.security.manager` system property — deprecated for removal in Java 17
 *   (JEP 411), since Security Manager itself is deprecated for removal
 * - Old GC-selection JVM flags for removed collectors (e.g. CMS flags removed Java 14)
 * - `jjs` launcher (Nashorn JS engine command-line tool) — removed in Java 15 (JEP 372)
 *
 * NOTE: Core "how you pass a method/constructor argument" has NOT changed since Java 1.
 * What HAS evolved is the `java` LAUNCHER's own argument set (modules, single-file run,
 * preview-feature flag) — not how your CODE receives arguments.
 * ================================================================================================================
 */

public class H_Args_VarArgs {

    // ======================== MAIN METHOD ========================

    public static void main(String[] args) {
        System.out.println("=== ARGS & VARARGS DEMONSTRATION ===\n");

        // ========== COMMAND-LINE ARGUMENTS DEMO ==========
        System.out.println("--- Command-Line Arguments ---");
        System.out.println("Number of arguments: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] = " + args[i]);
        }

        if (args.length >= 4) {
            String name = args[0];
            int age = Integer.parseInt(args[1]);
            double salary = Double.parseDouble(args[2]);
            boolean isActive = Boolean.parseBoolean(args[3]);

            System.out.println("\nParsed values:");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Salary: " + salary);
            System.out.println("Active: " + isActive);
        }

        // ========== PASS-BY-VALUE DEMO ==========
        System.out.println("\n--- Pass-by-Value Demo ---");

        // Primitive example
        int x = 10;
        System.out.println("Before primitive method: x = " + x);
        modifyPrimitive(x);
        System.out.println("After primitive method: x = " + x + " (unchanged)");

        // Object example
        PersonDemo p = new PersonDemo("Original");
        System.out.println("\nBefore object method: p.name = " + p.name);
        modifyObject(p);
        System.out.println("After object method: p.name = " + p.name + " (changed!)");

        // Reassignment example
        PersonDemo q = new PersonDemo("Original");
        System.out.println("\nBefore reassign method: q.name = " + q.name);
        reassignObject(q);
        System.out.println("After reassign method: q.name = " + q.name + " (unchanged!)");

        // ========== VARARGS DEMO ==========
        System.out.println("\n--- Varargs Demo ---");

        // Basic varargs, any count including zero
        m1();                        // 0 args
        m1(10);                      // 1 arg
        m1(10, 20, 30);              // 3 args

        // Varargs with other parameters (must be last)
        m2("scores", 90, 85, 100);
        m2("empty");

        // Overloading priority (fixed-arity wins)
        System.out.println("\n--- Overloading Priority ---");
        show(5);                     // fixed-arity
        show(5, 10);                 // varargs
        show();                      // varargs

        // Reference types with varargs
        System.out.println("\n--- Reference Types ---");
        printStudents(
                new StudentDemo("Shubham"),
                new StudentDemo("Raj"),
                new StudentDemo("Priya")
        );

        // Generic varargs with @SafeVarargs
        System.out.println("\n--- Generic Varargs ---");
        printAll("Java", "Python", "SQL");
        printAll(1, 2, 3, 4, 5);
        printAll();                            // Zero arguments

        // Array vs individual values are interchangeable
        System.out.println("\n--- Array vs Individual Arguments ---");
        System.out.print("Individual values: ");
        m1(100, 200, 300);
        System.out.print("Array equivalent: ");
        m1(new int[]{100, 200, 300});

        // Varargs in lambdas
        System.out.println("\n\n--- Varargs in Lambdas ---");
        Runnable r = () -> m1(100, 200, 300);
        System.out.print("Lambda calling varargs: ");
        r.run();

        // ========== JVM SYSTEM PROPERTIES DEMO ==========
        System.out.println("\n\n--- JVM System Properties ---");
        System.out.println("java.version: " + System.getProperty("java.version"));
        System.out.println("user.home: " + System.getProperty("user.home"));
        System.out.println("os.name: " + System.getProperty("os.name"));

        // Custom property: java -Dmy.property=HelloWorld Args_VarArgs
        String customProp = System.getProperty("my.property");
        if (customProp != null) {
            System.out.println("Custom property 'my.property': " + customProp);
        } else {
            System.out.println("Custom property 'my.property' not set");
            System.out.println("Try: java -Dmy.property=HelloWorld Args_VarArgs");
        }

        // ========== PRACTICAL VARARGS USAGE ==========
        System.out.println("\n--- Practical Varargs Usage ---");

        // Logger example
        LoggerDemo logger = new LoggerDemo();
        logger.log(LoggerDemo.Level.INFO, "Starting", "processing", "data");

        // Math operations
        System.out.println("Sum of 1,2,3,4,5: " + MathUtilsDemo.sum(1, 2, 3, 4, 5));
        System.out.println("Max of 10,20,15,30: " + MathUtilsDemo.max(10, 20, 15, 30));

        // String concatenation
        System.out.println("Concat: " + StringUtilsDemo.concat(" | ", "A", "B", "C"));

        System.out.println("\n=== DEMONSTRATION COMPLETE ===");
    }

    // ======================== HELPER METHODS ========================

    // Primitive pass-by-value
    static void modifyPrimitive(int value) {
        value = 100;
        System.out.println("Inside modifyPrimitive: value = " + value);
    }

    // Object pass-by-value (value of reference copied)
    static void modifyObject(PersonDemo person) {
        person.name = "Modified";
        System.out.println("Inside modifyObject: person.name = " + person.name);
    }

    // Object reassignment (doesn't affect caller)
    static void reassignObject(PersonDemo person) {
        person = new PersonDemo("New Object");
        System.out.println("Inside reassignObject: person.name = " + person.name);
    }

    // Rule 1 & 3 — basic varargs, any count including zero
    static void m1(int... x) {
        System.out.print("m1 called with " + x.length + " args: ");
        for (int val : x) System.out.print(val + " ");
        System.out.println();
    }

    // Rule 2 — normal parameter first, varargs must be last
    static void m2(String label, int... nums) {
        System.out.println(label + " -> count=" + nums.length);
    }

    // Rule 5 — overloading: fixed-arity vs varargs, fixed-arity always wins when it matches
    static void show(int x) {
        System.out.println("show(int) -> fixed-arity method called");
    }

    static void show(int... x) {
        System.out.println("show(int...) -> varargs method called, count=" + x.length);
    }

    // Rule 6 — varargs with a reference type
    static class StudentDemo {
        String name;
        StudentDemo(String name) { this.name = name; }
    }

    static void printStudents(StudentDemo... students) {
        for (StudentDemo s : students) {
            System.out.println("Student: " + s.name);
        }
    }

    // Rule 6 (generic) + @SafeVarargs — safe because we only ever READ from the array
    @SafeVarargs
    static <T> void printAll(T... items) {
        for (T item : items) {
            System.out.println("Item: " + item);
        }
    }

    // ======================== INNER CLASSES ========================

    static class PersonDemo {
        String name;
        PersonDemo(String name) {
            this.name = name;
        }
    }
}

// ======================== ADDITIONAL EXAMPLES ========================

/**
 * Example: Builder pattern for named/optional arguments
 */
class EmployeeDemo {
    private final String name;
    private final int age;
    private final double salary;
    private final String department;

    private EmployeeDemo(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.salary = builder.salary;
        this.department = builder.department;
    }

    static class Builder {
        private String name;
        private int age = 30;      // default value
        private double salary = 50000; // default value
        private String department = "General";

        Builder name(String name) {
            this.name = name;
            return this;
        }

        Builder age(int age) {
            this.age = age;
            return this;
        }

        Builder salary(double salary) {
            this.salary = salary;
            return this;
        }

        Builder department(String department) {
            this.department = department;
            return this;
        }

        EmployeeDemo build() {
            return new EmployeeDemo(this);
        }
    }

    // Usage: EmployeeDemo e = new EmployeeDemo.Builder().name("Raj").salary(60000).build();
}

/**
 * Example: Method overloading as alternative to default arguments
 */
class CalculatorDemo {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    int add(int... numbers) {
        int sum = 0;
        for (int n : numbers) sum += n;
        return sum;
    }
}

/**
 * Example: Logger with variable arguments
 */
class LoggerDemo {
    enum Level { INFO, WARNING, ERROR }

    void log(Level level, String... messages) {
        System.out.print("[" + level + "] ");
        for (String msg : messages) {
            System.out.print(msg + " ");
        }
        System.out.println();
    }
}

/**
 * Example: Mathematical operations
 */
class MathUtilsDemo {
    static int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) total += n;
        return total;
    }

    static int max(int... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("At least one number required");
        }
        int max = numbers[0];
        for (int n : numbers) {
            if (n > max) max = n;
        }
        return max;
    }
}

/**
 * Example: String concatenation
 */
class StringUtilsDemo {
    static String concat(String delimiter, String... parts) {
        if (parts.length == 0) return "";
        return String.join(delimiter, parts);
    }
}

/*
 * QUIZ: Test your understanding
 *
 * 1. What's the output?
 *    void test(String... args) { System.out.println(args.length); }
 *    test("A", "B"); → __________
 *
 * 2. Is this valid? void test(int x, int... y, String z) { }
 *    Answer: ________
 *
 * 3. Which method is called?
 *    void test(int x) { }
 *    void test(int... x) { }
 *    test(10); → __________
 *
 * 4. True or False: You can pass an array to a varargs parameter
 *    Answer: ________
 *
 * 5. What annotation reduces warnings for generic varargs?
 *    Answer: ________
 *
 * Answers: 1) 2, 2) No (varargs must be last), 3) test(int x),
 *          4) True, 5) @SafeVarargs
 */