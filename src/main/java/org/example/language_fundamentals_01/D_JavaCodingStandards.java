package org.example.language_fundamentals_01;

public class D_JavaCodingStandards {

    /*
    ================================================================================================================
    1) PACKAGE NAMING CONVENTION
    ================================================================================================================
    - All lowercase, no camelCase, no underscores
    - Pattern: companyname.projectname.module

    Example:
        com.tradein.invoice
        com.tradein.invoice.controller

    ================================================================================================================
    2) CLASS / INTERFACE / ABSTRACT CLASS NAMING CONVENTION
    ================================================================================================================
    - PascalCase → starts with CAPITAL letter, first letter of EACH word UpperCase
    - Name must be MEANINGFUL → tells what the class/interface does, not vague

    Interface-specific rule:
    - Do NOT prefix with "I" (like ISomething) — that's a C#/legacy convention, not Java
    - Prefer capability-based names, often ending "-able"
    - Implementation class → descriptive name, or same name + "Impl" suffix

    Abstract class-specific rule:
    - Prefix "Abstract" or suffix "Base" to signal it can't be instantiated directly

    Example:
        class InvoiceGenerator { }              // ✅ meaningful class
        class Test { }                           // ❌ too vague

        interface Runnable { }                    // ✅ capability-based, -able
        interface PaymentGateway { }               // ✅ role-based
        interface IPaymentGateway { }               // ❌ don't use "I" prefix
        class RazorpayPaymentGateway { }             // ✅ implementation
        class PaymentGatewayImpl { }                  // ✅ alternative: "Impl" suffix

        abstract class AbstractVehicle { }
        abstract class BaseController { }

    ================================================================================================================
    3) METHOD DECLARATION RULE — static vs instance
    ================================================================================================================
    - Declare method as STATIC if it does NOT use any instance variable
    - If it depends on instance state (this.something), keep it as an instance method

    Example:
        static int add(int a, int b) { return a + b; }   // ✅ static, no instance var used

        class Employee {
            int salary;
            int getSalary() { return salary; }             // ❌ not static — uses instance var
        }

    ================================================================================================================
    4) METHOD / VARIABLE NAMING CONVENTION
    ================================================================================================================
    - camelCase → starts LOWER case, each subsequent word starts UpperCase
    - Method name → describes the SPECIFIC action/functionality (a verb/action phrase)
    - Variable name → describes WHAT IT STORES, in plain language

    Example:
        calculateTotalAmount()    // ✅ meaningful method
        process()                  // ❌ too vague

        int totalAmount = 5000;      // ✅ clear
        int a = 5000;                  // ❌ meaningless

    ================================================================================================================
    5) CONSTANT & ENUM CONSTANT NAMING CONVENTION
    ================================================================================================================
    - ALL UPPER CASE, words separated by underscore
    - Constants usually declared as: static final
    - Enum TYPE name itself → PascalCase (like a class); only its constants use UPPER_CASE

    Example:
        static final int MAX_VALUE = 100;
        static final String DEFAULT_CURRENCY = "INR";

        enum OrderStatus { PENDING, SHIPPED, DELIVERED, CANCELLED }

    ================================================================================================================
    6) BEAN NAMING CONVENTION (Getters / Setters)
    ================================================================================================================
    - Fields → PRIVATE. Access via PUBLIC getters/setters.
    - Getter → "get" + FieldName. Setter → "set" + FieldName
    - *** Exception: boolean fields use "is" instead of "get" → isActive(), isEmpty()

    Example:
        private String name;
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        private boolean active;
        public boolean isActive() { return active; }   // ✅ "is" not "get" for boolean

    ================================================================================================================
    7) LISTENER NAMING CONVENTION
    ================================================================================================================
    - Event handler method → "on" + EventName          → onClick(), onSubmit()
    - Register listener   → "add" + ListenerType         → addMouseListener(listener)
    - Deregister listener → "remove" + ListenerType        → removeMouseListener(listener)
    - Argument type name = the "add"/"remove" method name minus the add/remove prefix

    Example:
        public void addMouseListener(MouseListener listener) { }      // REGISTER
        public void removeMouseListener(MouseListener listener) { }     // DEREGISTER
        // Rule of thumb: every addXListener should have a matching removeXListener
        // to avoid memory leaks

    ================================================================================================================
    8) EXCEPTION CLASS NAMING CONVENTION
    ================================================================================================================
    - PascalCase, MUST end with "Exception"

    Example:
        class InvalidInvoiceException extends RuntimeException { }
        class UserNotFoundException extends RuntimeException { }

    ================================================================================================================
    9) ANNOTATION NAMING CONVENTION
    ================================================================================================================
    - PascalCase (annotations are a special kind of interface)
    - Name describes what it marks/enables

    Example:
        @Override
        @LogExecutionTime
        @NotNull

    ================================================================================================================
    10) GENERIC TYPE PARAMETER NAMING CONVENTION
    ================================================================================================================
    - Single uppercase letter, not a full word
        T → Type   |   E → Element (collections)   |   K → Key   |   V → Value   |   N → Number

    Example:
        class Box<T> { }
        Map<K, V>
        List<E>

    ================================================================================================================
    11) TEST CLASS / UTILITY CLASS NAMING CONVENTION
    ================================================================================================================
    - Test class → class name being tested + "Test" suffix
    - Test method → descriptive, sentence-like: should...when...
    - Utility class → ends "Utils"/"Helper", only static methods, private constructor
      (ties back to rule #3 — no instance variables, so make it fully static)

    Example:
        class EmployeeService { }      →   class EmployeeServiceTest { }
        void shouldThrowException_whenInvoiceIsNull() { }

        class StringUtils {
            private StringUtils() { }                                     // prevent instantiation
            static boolean isEmpty(String s) { return s == null || s.isEmpty(); }
        }

    ================================================================================================================
    12) QUICK RECALL TABLE
    ================================================================================================================
    | Element                  | Case Style                          | Example                              |
    |----------------------------|----------------------------------------|-------------------------------------|
    | Package                     | all lowercase                            | com.tradein.invoice                    |
    | Class / Abstract Class        | PascalCase (Abstract/Base for abstract)    | InvoiceGenerator, AbstractVehicle        |
    | Interface                       | PascalCase, no "I" prefix, often "-able"     | Runnable, PaymentGateway                    |
    | Method / Variable                 | camelCase                                       | calculateTotalAmount(), totalAmount          |
    | Constant                            | UPPER_CASE_WITH_UNDERSCORE                        | MAX_VALUE                                       |
    | Enum type / constants                 | PascalCase type, UPPER_CASE constants                | OrderStatus.PENDING                                |
    | Getter / Setter (boolean)               | get.../set... ("is..." for boolean)                     | getName(), isActive()                                 |
    | Listener (handler/add/remove)             | on.../add.../remove...                                    | onClick(), addMouseListener()                            |
    | Exception class                             | PascalCase, ends "Exception"                                 | InvalidInvoiceException                                     |
    | Annotation                                    | PascalCase                                                      | @LogExecutionTime                                              |
    | Generic type parameter                          | Single uppercase letter                                            | T, E, K, V                                                        |
    | Test class / method                               | ClassNameTest / should...when...                                       | InvoiceGeneratorTest                                                |
    | Utility class                                       | PascalCase, ends "Utils"/"Helper", static-only                            | StringUtils                                                            |
    */
}