package org.example.language_fundamentals_01;

public class A_Jdk_Jre_Jvm {

    /*

1. Java as a Language
Java is a programming language that defines syntax, types, and OOP constructs.
It provides keywords, classes, interfaces, records, sealed classes, and pattern matching.
Developers use it to write source code in .java files, which is then compiled to bytecode.
--------------------------------------------------------------------------------------------------------------
2. Java as a Platform
Java is also a platform consisting of the JVM, runtime, and standard libraries.
The JVM handles class loading, memory management, security, and garbage collection.
JRE = JVM + core libraries; JDK = JRE + tools like javac, java, javadoc.
Java 17 is a specific LTS version of this platform (JDK 17, released in 2021).
It includes the JVM implementation, runtime, and all standard APIs available up to that release.
--------------------------------------------------------------------------------------------------------------
3. Java Platform APIs
Java exposes many standard APIs grouped in modules like java.base, java.util, java.io, etc.
Core APIs: Collections (List, Map), Streams, I/O & NIO, Concurrency (Executor, CompletableFuture).
Other key APIs: JDBC (java.sql), HTTP Client (java.net.http), Logging (java.util.logging).
Desktop/GUI APIs: AWT, Swing, JavaFX, plus imaging, printing, accessibility.
Management & monitoring: JMX (java.management), Flight Recorder (jdk.jfr), instrumentation.
Security APIs: Cryptography, SSL/TLS, JAAS, XML crypto (java.security.*, java.xml.crypto).
So: “Java” = language + platform + standard APIs; “Java 17” = one LTS version of that platform with its API set.
==================================================================================================================
    TOPIC 1: THE CORE JAVA ECOSYSTEM ARCHITECTURE (JDK vs. JRE vs. JVM)
    ====================================================================================

    ┌─────────────────────────────────────────────────────────────────┐
    │ JDK (Java Development Kit)                                      │
    │  Development Tools: javac, jar, javadoc, jdb, jcmd...           │
    │ ┌─────────────────────────────────────────────────────────────┐ │
    │ │ JRE (Java Runtime Environment)                              │ │
    │ │  Core Libraries & Modules: java.base, java.sql, util...     │ │
    │ │ ┌─────────────────────────────────────────────────────────┐ │ │
    │ │ │ JVM (Java Virtual Machine)                              │ │ │
    │ │ │  - Memory Areas (Heap, Stack, Metaspace)                │ │ │
    │ │ │  - Execution Engine (Interpreter + JIT Compiler)        │ │ │
    │ │ │  - Garbage Collector (G1 GC, ZGC)                       │ │ │
    │ │ └─────────────────────────────────────────────────────────┘ │ │
    │ └─────────────────────────────────────────────────────────────┘ │
    └─────────────────────────────────────────────────────────────────┘

    * JDK (Java Development Kit): Used for developing Java programs. Contains JRE + Development Tools (javac, etc.).
    * JRE (Java Runtime Environment): Used for running Java programs. Contains JVM + Core Libraries.
    * JVM (Java Virtual Machine): The engine that executes Java bytecode.

    The Modern Packaging Reality:
    ------------------------------------------------------------------------------------
    * JDK & JVM: Absolutely mandatory to build and run Java code.
    * Standalone JRE: No longer distributed independently by Oracle or OpenJDK vendors.
    * Modern Practice: Developers install the full JDK. For cloud/microservice deployments,
      developers use a JDK tool named 'jlink' to strip away unused platform components and
      bundle a highly optimized, custom micro-runtime directly inside the application artifact.

    Platform Dependency & WORA (Write Once, Run Anywhere):
    ------------------------------------------------------------------------------------
    * The Bytecode (.class) file is 100% platform-independent. The exact same bytecode file
      is generated whether you compile it on Windows, macOS, or Linux.
    * The JVM itself is platform-dependent. A Windows machine requires a Windows-specific JVM,
      while a Mac requires a macOS-specific JVM to properly translate bytecode into native OS commands.

    ====================================================================================
    TOPIC 2: SOURCE FILES & GENERATED OUTPUT STORAGE LOCATIONS
    ====================================================================================

    1. Where does 'Test.java' stay?
       * It stays on your local hard drive in the folder where you created it (e.g., your Desktop).
       * Example Path: C:\Users\YourName\Desktop\Test.java
       * The JVM binaries live inside your JDK installation directory (external to your files).
         Your code acts as an untrusted guest running inside the host JVM process environment.

    2. Where are '.class' files generated?
       * Default Behavior: Running 'javac Test.java' generates the compiled 'Test.class' file in
         the EXACT SAME directory where the source 'Test.java' file is located (e.g., right on your Desktop).
       * Redirecting Output (-d flag): If you do not want to clutter your working folder, you can use
         the destination flag to redirect the outputs:
         Command: javac -d bin Test.java (Generates the file inside a folder named 'bin')
         To execute this redirected file, you must specify the path using the classpath flag:
         Command: java -cp bin Test

    ====================================================================================
    TOPIC 3: COMPILATION WORKFLOW (BUILD TIME)
    ====================================================================================
    * File Creation: A developer creates a source text file (e.g., Test.java).
    * Command: javac Test.java

    1. Where does the compiler live?
       The 'javac' compiler is located strictly within the JDK. It does not exist inside
       the JRE or JVM. The runtime layers only know how to execute code; they cannot compile it.

    2. What does 'javac Test.java' actually do?
       It triggers the Frontend Compiler to perform three main sequential tasks:
       a) Syntax Checking: Validates code against language rules (e.g., checks for missing semicolons).
       b) Type Safety Verification: Ensures valid data assignments (e.g., prevents saving a String into an int).
       c) Translation: Converts human-readable Java text into intermediate binary Bytecode (.class).

    3. Class-to-File Naming Rules:
       * Rule 1: You can have multiple classes in a single file, but only one class can be 'public'.
       * Rule 2: The filename MUST exactly match the name of the single public class.
       * Reason: Enforces structural modularity and helps both 'javac' and the JVM instantly locate files.

    ====================================================================================
    TOPIC 4: ANATOMY OF MISTAKES & EXACT JAVA 17 ERROR MESSAGES
    ====================================================================================
    Below are the literal error responses emitted by the Java 17 toolchain for common developer mistakes:

    ------------------------------------------------------------------------------------
    MISTAKE A: Misspelling a variable or function name (Compile-Time)
    ------------------------------------------------------------------------------------
    Code snippet:
      int speed = 10;
      System.out.println(sped);
    Exact 'javac' Error:
      Test.java:4: error: cannot find symbol
              System.out.println(sped);
                                 ^
        symbol:   variable sped
        location: class Test
      1 error

    ------------------------------------------------------------------------------------
    MISTAKE B: Public class name does not match the file name (Compile-Time)
    ------------------------------------------------------------------------------------
    Code snippet: (Inside a file named TestJava.java)
      public class HelloWorld { }
    Exact 'javac' Error:
      TestJava.java:1: error: class HelloWorld is public, should be declared in a file named HelloWorld.java
      public class HelloWorld {
             ^
      1 error

    ------------------------------------------------------------------------------------
    MISTAKE C: Missing a semicolon (Compile-Time)
    ------------------------------------------------------------------------------------
    Code snippet:
      System.out.println("Hi")
    Exact 'javac' Error:
      Test.java:3: error: ';' expected
              System.out.println("Hi")
                                      ^
      1 error

    ------------------------------------------------------------------------------------
    MISTAKE D: Attempting to run a class file that does not exist (Runtime)
    ------------------------------------------------------------------------------------
    Command: java NonExistentClass
    Exact 'java' Launcher Error:
      Error: Could not find or load main class NonExistentClass
      Caused by: java.lang.ClassNotFoundException: NonExistentClass

    ------------------------------------------------------------------------------------
    MISTAKE E: Main method missing or declared with an invalid signature (Runtime)
    ------------------------------------------------------------------------------------
    Triggers: Declaring main as private, forgetting 'static', typos like 'maain', or wrong arguments.
    Exact 'java' Launcher Error:
      Error: Main method not found in class Test, please define the main method as:
         public static void main(String[] args)
      or a JavaFX application class must extend javafx.application.Application

    ====================================================================================
    TOPIC 5: CLASS LOCATING & LIFECYCLE PHASES
    ====================================================================================
    When you execute 'java Test', the JVM launches and initiates the class locating sequence.

    1. Locating the File via Classpath:
       * The JVM searches for 'Test.class', not the raw source file.
       * Classpath: An environment search path variable that tells the JVM exactly which folders
         and ZIP/JAR archives to look inside. It defaults to the current working directory (represented by '.').

    2. The 4 Subsystem Lifecycle Phases:
       * Phase 1: Loading -> The ClassLoader reads the raw bytes of the .class file from the Classpath
                            into JVM memory (Metaspace), creating the initial class representation.
       * Phase 2: Linking -> The JVM verifies the bytecode for security, allocates memory with default
                            values (e.g., 0, null) for static variables, and checks for the correct
                            'public static void main' signature (Throws error E here if invalid).
       * Phase 3: Initialization -> The JVM executes all 'static { ... }' blocks and assigns the programmer-defined
                                     values to static fields from top to bottom.
       * Phase 4: Invocation -> The JVM invokes the verified 'main(String[] args)' method, starting execution.

    3. Comprehensive Chronological Execution Sequence:
       [java Test Command]
              │
              ▼
       0. Create Test.java ──► Run 'javac Test.java' ──► Generate Test.class
              │
              ▼
       1. Load Test.class into Metaspace Memory
              │
              ▼
       2. Execute Static Fields & Static Blocks (Top-to-Bottom)
              │
              ▼
       3. Run main() Method Body
              │
              ▼
       4. Object Creation Triggered (new Test())
              │
              ▼
       5. Execute Instance Initializer Blocks
              │
              ▼
       6. Run Class Constructor
              │
              ▼
       7. Execute remaining code sequentially (Nested loops, instances, methods)

    ====================================================================================
    TOPIC 6: THE RUNTIME EXECUTION PIPELINE & UTILITIES
    ====================================================================================

    1. Visual Pipeline Diagram:

    [ Developer Level ]
           │  (Writes source code)
           ▼
       Test.java  ◀─── Source File (Human Readable)
           │
    ───────┼───────────────────────────────────────────── [ Build/Compile Time ]
           │  (Compiled via: javac Test.java)
           ▼
       Test.class ◀─── Bytecode File (Platform Independent)
           │
    ───────┼───────────────────────────────────────────── [ Runtime / Inside JVM ]
           │  (Loaded via: ClassLoader)
           ▼
       JVM Memory ◀─── Execution Engine Management Area (Metaspace / Heap)
           │
           ├───► [ Interpreter ] ─────► Line-by-line Execution (Fast Startup / Slow Run)
           │                                   │
           └───► [ JIT Compiler ] ────► Hot Code Optimization (Slow Startup / Maximum Speed)
                                               │
                                               ▼
                                        Native Machine Code (0s & 1s)
                                               │
    ───────┼───────────────────────────────────┼───────── [ System Level ]
           │                                   ▼
           │                            Operating System (OS Kernel via System Calls)
           │                                   │
    ───────┼───────────────────────────────────┼───────── [ Hardware Level ]
           │                                   ▼
           └─────────────────────────────► CPU & RAM (Physical Execution via Microchip Registers)

    2. Dual-Engine Architecture (Interpreter vs. JIT Compiler):
       * The Interpreter: Starts running bytecode immediately, line-by-line. It starts fast
         but executes slowly because it continuously re-parses identical instructions.
       * The JIT (Just-In-Time) Compiler: Monitors running code for "Hot Spots" (frequently used loops
         or methods). It compiles these segments directly into Native Machine Code and saves them to
         the system cache. Subsequent calls skip the interpreter entirely to run at hardware speed.

    3. OS and Hardware Integration Layers:
       * The Operating System Layer: The native machine code interacts with the host OS Kernel
         (Windows API, Linux POSIX, macOS Darwin) via system calls. The OS manages memory allocation
         safety bounds and schedules application execution threads onto physical CPU cores.
       * Physical Hardware Execution: The execution hits the bare metal. The CPU pulls binary data
         (assembly operations like MOV, ADD, PUSH) out of physical RAM registers to execute real-world actions.

    4. JDK Diagnostic Utilities:
       * Utility Command: javap Test.class
       * What it is: The official Java Class File Disassembler tool included exclusively in the JDK.
       * Function: Opens a compiled binary '.class' file and prints a human-readable structural breakdown
         of its methods, field signatures, and raw underlying bytecode instructions to your terminal screen.
    */

    static public void main(String[] my_args) {
        System.out.println("Java Architecture and Execution Pipeline Documented Successfully!");
    }
}