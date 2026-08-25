package org.example.language_fundamentals_01;

public class C_LangFundamental {
    /*
    ================================================================================================================
    ⭐ THE BIG PICTURE FIRST — IDENTIFIER vs VALUE vs KEYWORD (how they differ)
    ================================================================================================================

    Every word/token you type in Java code falls into ONE of these buckets:

    | Bucket           | What it IS                                      | Who decides it         | Example                           |
    |------------------|--------------------------------------------- - -|------------------------|-----------------------------------|
    | KEYWORD          | A word Java reserves for its own grammar/syntax | Java language spec     | class, int, if, static, public    |
    | IDENTIFIER       | A NAME you give to something (YOU create it)    | The programmer         | Test, main, x, args, empId        |
    | VALUE / LITERAL  | The actual DATA stored in memory                | The programmer (data)  | 10, "Hello", true, 3.14, null     |

    Simple one-line rule to remember:
    → KEYWORD = Java's own vocabulary (fixed, can't touch it)
    → IDENTIFIER = the NAME you pick for a class/method/variable/etc.
    → VALUE = the actual DATA that gets stored/assigned

    Example line:
        int x = 10;
        ─┬─ ┬   ─┬─
         │  │    └── VALUE (literal — the data itself)
         │  └─────── IDENTIFIER (name YOU chose for the variable)
         └────────── KEYWORD (Java's reserved word for data type)

    Another example:
        public class Test {
            public static void main(String[] args) {
                int x = 10;
            }
        }
        - public, class, static, void, int   → KEYWORDS (fixed vocabulary)
        - Test, main, args, x                → IDENTIFIERS (names YOU gave)
        - 10                                  → VALUE / LITERAL (the data)
        - String                              → technically a predefined CLASS NAME
                                                  (itself an identifier — just one Java
                                                  already defined for you in java.lang)

    Why this distinction matters in interviews:
    - A KEYWORD can NEVER be used as an IDENTIFIER (e.g. you cannot write `int int = 5;`)
    - An IDENTIFIER can technically reuse a predefined class name (e.g. `int String = 5;`
      compiles!) — but it's a terrible idea, hides the real `String` class in that scope.
    - A VALUE has no naming rules at all — it's just data (numbers, text, true/false, null).
      The ONLY "identifier-like" rule that touches values is that `true`, `false`, and `null`
      are RESERVED LITERALS — meaning even though they look like values (not names), Java
      still reserves those exact words so you can't use them as identifiers either.

    ================================================================================================================
    1) IDENTIFIERS — names YOU create in a Java program
    ================================================================================================================
    Identifiers = names for: class, method, variable, package, interface, enum, annotation, label

                class Test {
            public static void main (String[] args){
                      int x =10;
                          }
            }

    | Concept        | Is it an Identifier?                                                      | Example        |
    | -------------- | ------------------------------------------------------------------------  | -------------- |
    | Class          | ✅ The NAME of a class is an identifier.                                  | Test, String   |
    | Method         | ✅ The NAME of a method is an identifier.                                 | main           |
    | Variable       | ✅ The variable NAME is an identifier.                                    | x, args        |
    | Package        | ✅ The package NAME (or parts of it) is an identifier.                    | org, example   |
    | Interface      | ✅ The NAME of an interface is an identifier.                             |                |
    | Enum           | ✅ The enum NAME and its constants are identifiers.                       |                |
    | Annotation     | ✅ The annotation NAME (e.g. @Override) is an identifier.                 |                |
    | Label name     | ✅ Label names (used with loops and break/continue) are identifiers.      |                |

    NOTE: an identifier is just the NAME — it does not carry any data itself.
    The VALUE is what gets stored inside/behind that name.

    --- Naming rules for identifiers ---
    Allowed characters : a-z , A-Z , 0-9 , _ , $ (dollar sign)
    *** cannot start with a digit
    *** JAVA IS CASE SENSITIVE        → total != Total != TOTAL (3 different identifiers)
    *** No length limit                 → but keep it meaningful and concise
    *** cannot use reserved KEYWORDS as identifiers
    *** cannot use special characters like @, #, %, etc.
    *** predefined class/interface names CAN be reused as identifiers, but NOT recommended
        → reduces readability + creates confusion (shadows the real class)

    --- Naming CONVENTIONS (style, not compiler rules) ---
    package name  → all lowercase, dot separated      e.g. com.example.project
    class name    → PascalCase, starts uppercase       e.g. Employee, C_LangFundamental
    method name   → camelCase, starts lowercase        e.g. calculateSalary()
    variable name → camelCase, starts lowercase        e.g. totalAmount

    Valid identifiers   → total_number, TotalNumber, _total, $total, total123, Int, _$_, Integer
    Invalid identifiers → total#, 1Total, if, int, All@Hands
    (Int and Integer are valid identifiers — but int and if are KEYWORDS, so invalid)

    ================================================================================================================
    2) VALUES / LITERALS — the actual data (not a name, not Java's vocabulary)
    ================================================================================================================
    A value/literal is the raw DATA that gets assigned to a variable or passed around.
    It has NO naming rules (it's not a name at all) — it just needs to match the correct
    format/type.

    | Literal type        | Examples                          |
    |----------------------|-------------------------------------|
    | Integer literal      | 10, -5, 0, 1_000_000                |
    | Floating-point literal | 3.14, 2.0f, 1.5e10                |
    | Character literal    | 'a', 'Z', '\n'                       |
    | String literal       | "Hello", "" (empty string)          |
    | Boolean literal      | true, false                         |
    | Null literal         | null (default value for object refs)|

    Difference from identifier:
        int x = 10;
        → x    is an IDENTIFIER (a name YOU created, points to a memory location)
        → 10   is a VALUE/LITERAL (the actual data stored at that location)
    Identifiers can change what value they point to (unless final); the literal itself
    (e.g. 10) never changes — it IS the data.

    ================================================================================================================
    3) KEYWORDS — Java's own reserved vocabulary (53 total, all lowercase)
    ================================================================================================================
    Reserved words in Java have a predefined meaning in the language and CANNOT be used as
    identifiers (names for classes, methods, variables, etc.).

    Used keywords     >> 48
    Unused keywords    >> 2   (goto, const)
    Reserved literals  >> 3   (true, false, null)

    NOTE: true/false/null are technically "reserved literals," not keywords in the strict
    JLS sense — but practically they behave like keywords: reserved words + they ARE values
    at the same time. That's why they sit in their own row in the table above — the one
    place where "value" and "reserved word" overlap.

    --- Used keywords (48), grouped by purpose ---
    data types        → byte, short, int, long, float, double, boolean, char
    flow control       → if, else, for, break, continue, return, while, do, switch, case, default
    access modifiers    → public, private, protected, abstract, static, final, synchronized,
                          native, strictfp, transient, volatile
    exception handling   → try, catch, finally, throw, throws, assert
    class related        → class, interface, extends, implements, package, import
    object related        → new, this, super, instanceof
    return type            → void
    extra                   → enum (defines a group of named constants,
                              e.g. enum Days { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY })

    --- Unused keywords (2) ---
    goto, const → reserved but NOT used in Java; kept reserved for future use / banned due
    to problems they caused in other languages (C/C++).

    --- Reserved literals (3) ---
    true, false, null → null is the default value for any uninitialized object reference.

    | Keyword     | Exists in Java 17 | Applies to                 | Purpose/Use                                                         |
    | ----------- | ------------------ | --------------------------- | -------------------------------------------------------------------- |
    | abstract    | Yes                 | Class/Method                 | Declares a class as abstract or a method as abstract.               |
    | assert      | Yes                 | Statement                    | Used for debugging purposes to make assertions.                     |
    | break       | Yes                 | Statement                    | Exits a loop or switch statement.                                    |
    | case        | Yes                 | Switch statement              | Defines a branch in a switch statement.                              |
    | catch       | Yes                 | Exception handling            | Catches exceptions thrown by try blocks.                              |
    | class       | Yes                 | Class declaration             | Declares a class.                                                    |
    | native      | Yes                 | Method                        | Indicates a method is implemented in native code (JNI).              |
    | strictfp    | Yes                 | Class/Method                   | Ensures floating-point calculations are platform-independent.        |
    | transient   | Yes                 | Field (Instance variable)       | Excludes field from object serialization.                            |
    | volatile    | Yes                 | Field (Instance variable)       | Ensures the most recent value of a field is visible across threads.  |

    No `delete` keyword in Java → destruction of unused objects is the responsibility of
    the Garbage Collector, not the programmer.

    ================================================================================================================
    4) SIDE-BY-SIDE SUMMARY — quick recall
    ================================================================================================================
    | Aspect                | Keyword                            | Identifier                     | Value/Literal                |
    |-------------------   -|---------------------------------   |-----------------------------------|---------------------------------|
    | What it is            | Java's fixed vocabulary            | A name YOU create                  | The actual data                 |
    | Who defines it        | Java language spec                 | The programmer                      | The programmer (as data)         |
    | Can you create new ones? | ❌ No — fixed list of 53        | ✅ Yes — unlimited (follow rules)    | ✅ Yes — any valid literal format |
    | Case sensitive?       | ✅ Yes (always lowercase)          | ✅ Yes                                | Depends on type (String is)      |
    | Example               | class, int, static, if             | Employee, main, x, empId             | 10, "Hello", true, null          |
    | Can it change?        | Never — fixed meaning              | Points to different values over time (unless final) | The literal itself is constant   |
    */
}