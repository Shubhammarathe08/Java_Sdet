package org.example.language_fundamentals_01;

public class F_DataTypes {
    public static void main(String[] args) {

        /*
        ================================================================================================================
        DATA TYPES — CORE CONCEPT
        ================================================================================================================
        Every variable and expression in Java has a data type, which defines the kind of
        data it can hold. (Not possible to define a variable without SOME data type —
        even `var` requires the compiler to INFER one at compile time, see note below.)

        error: java: cannot find symbol
        Compile-time data type checking is done by the Java compiler and throws an error
        in case of type mismatch. Every assignment is checked by the compiler for type
        compatibility → Java is a STRONGLY TYPED language.

        ================================================================================================================
        *** Java is NOT a Pure Object-Oriented Language
        ================================================================================================================
        Several OOP features are not (fully) satisfied by Java:
        - No operator overloading
        - No multiple inheritance of CLASSES (only via interfaces)
        - Primitive data types (int, char, etc.) exist and are NOT objects
        - Procedural leftovers: functional interfaces can be implemented via lambdas,
          but Java still doesn't treat EVERYTHING as an object (unlike, say, Python)

        *** null → default value for OBJECT REFERENCES ONLY. Cannot apply to primitives.
        error: java: incompatible types: <nulltype> cannot be converted to char
        */

        // ============================================================================================================
        // PRIMITIVE DATA TYPES
        // ============================================================================================================

        // ---- Numeric — Integral (Signed) data types ----
        // 1 bit reserved for sign → +ve stored directly | -ve stored in 2's complement form
        byte b = 127;   // 1 byte  → 8-bit signed  | range -128 to 127                                   [default 0]
        short s = 32767; // 2 bytes → 16-bit signed | range -32,768 to 32,767                              [default 0]
        int i = 2147483647; // 4 bytes → 32-bit signed | range -2,147,483,648 to 2,147,483,647               [default 0]
        long l = 9223372036854775807L; // 8 bytes → 64-bit signed | range ±9,223,372,036,854,775,807 approx.  [default 0]

        // Example: File.length() returns type LONG — file size may exceed int's range

        // ---- Numeric — Floating-point (Signed) data types ----
        // float  = single precision → less decimal accuracy
        // double = double precision → more decimal accuracy
        // Only DECIMAL representation allowed for float/double literals — NOT octal or hex
        float f = 3.4028235E38f;   // 4 bytes → 32-bit  | range ≈ -3.4028235E38 to 3.4028235E38   [default 0.0]
        double d = 1.7976931348623157E308; // 8 bytes → 64-bit | range ≈ -1.7976931348623157E308 to +same [default 0.0]

        // ---- Non-numeric data types ----
        char c = 'z';
        // 2 bytes → single 16-bit UNICODE character, range 0 to 65535, i.e. '\u0000' to '\uFFFF'  [default '\u0000']
        // NOTE: char stores a single UTF-16 CODE UNIT, not always a full Unicode CODE POINT.
        // Characters outside the Basic Multilingual Plane (e.g. many emoji) need a SURROGATE
        // PAIR — two char values together — since one char alone can't hold them.

        boolean bool = true;
        // Size is JVM-dependent (commonly treated as 1 byte, sometimes word-aligned internally)
        // Holds ONLY true or false — NOT 1 or 0 like C/C++                                        [default false]
        // No numeric range applies — it is not a number.

        // boolean b = 0;      // ❌ compile-time error: incompatible types: int cannot be converted to boolean
        // boolean b = True;    // ❌ compile-time error: cannot find symbol (Java is case-sensitive, keyword is `true`)
        // boolean b = "true";    // ❌ compile-time error: java.lang.String cannot be converted to boolean

        /*
        +==============================================================================================================+
        |                                   PRIMITIVE DATA TYPES SUMMARY                                               |
        +==============================================================================================================+
        | Type    | Size    | Range (approx)                         | Default   | Example                            |
        +---------+---------+----------------------------------------+-----------+------------------------------------+
        | byte    | 1 byte  | -128 to 127                            | 0         | byte b = 100;                      |
        | short   | 2 bytes | -32,768 to 32,767                      | 0         | short s = 30000;                   |
        | int     | 4 bytes | -2,147,483,648 to 2,147,483,647       | 0         | int i = 100000;                    |
        | long    | 8 bytes | -9.2e18 to 9.2e18                     | 0L        | long l = 100000L;                  |
        | float   | 4 bytes | ±3.4e38                                 | 0.0f      | float f = 10.5f;                   |
        | double  | 8 bytes | ±1.7e308                                | 0.0d      | double d = 10.5;                   |
        | char    | 2 bytes | 0 to 65,535 (Unicode)                   | '\u0000'  | char c = 'A';                      |
        | boolean | 1 byte* | true / false                            | false     | boolean flag = true;               |
        +---------+---------+----------------------------------------+-----------+------------------------------------+
        *Size is JVM-dependent (typically 1 byte, but may be word-aligned)

        ================================================================================================================
        WHEN TO USE WHICH — QUICK REFERENCE
        ================================================================================================================

        +-------------------+----------------------------------------------------+----------------------------------+
        | Type              | Typical Use Case                                   | Example                          |
        +-------------------+----------------------------------------------------+----------------------------------+
        | byte              | Memory-efficient storage of small integers         | byte a = 100;                    |
        |                   | (file I/O, network buffers)                        |                                  |
        +-------------------+----------------------------------------------------+----------------------------------+
        | short             | Larger range than byte, smaller than int           | short temp = -20;                |
        |                   | (encoded sensor data)                              |                                  |
        +-------------------+----------------------------------------------------+----------------------------------+
        | int               | General-purpose integers                           | int age = 25;                    |
        |                   | (counters, indexing, measurements)                 |                                  |
        +-------------------+----------------------------------------------------+----------------------------------+
        | long              | Large numbers                                      | long pop = 7800000000L;          |
        |                   | (timestamps, population counts, file sizes)        |                                  |
        +-------------------+----------------------------------------------------+----------------------------------+
        | float             | Lower-precision decimals                           | float pi = 3.14159f;             |
        |                   | (graphics, simulations, ML weights)                |                                  |
        +-------------------+----------------------------------------------------+----------------------------------+
        | double            | High-precision decimals                            | double price = 19.99;            |
        |                   | (financial/scientific calculations)                |                                  |
        +-------------------+----------------------------------------------------+----------------------------------+
        | char              | A single character                                 | char letter = 'A';               |
        +-------------------+----------------------------------------------------+----------------------------------+
        | boolean           | Logical true/false in conditions                   | boolean isValid = true;          |
        |                   | (if, while, for loops)                             |                                  |
        +-------------------+----------------------------------------------------+----------------------------------+

        ================================================================================================================
        JAVA DOES NOT AUTO-CONVERT int TO boolean (unlike C/C++)
        ================================================================================================================

        +--------------------------------------------------------------------------------------------------------------+
        |  int x = 0;                                                                                                 |
        |  if (x) { }            // ❌ compile-time error: incompatible types: int cannot be converted to boolean      |
        |  while (1) { }         // ❌ same error — Java requires an actual boolean expression                        |
        +--------------------------------------------------------------------------------------------------------------+

        ================================================================================================================
        CHARACTER ENCODING — Java uses UNICODE, not ASCII
        ================================================================================================================

        +--------------------------------------------------------------------------------------------------------------+
        |  ASCII           → 7-bit character set → 128 characters, range 0-127                                        |
        |  Extended ASCII   → 8-bit → 256 characters, range 0-255                                                     |
        |  Unicode          → 16-bit (UTF-16) → 65,536+ code points → SUPERSET of ASCII                               |
        |                                                                                                              |
        |  Java's char is 16-bit Unicode-based (0 to 65,535 directly addressable)                                      |
        |  Unicode supports every language/script → essential for internationalization                                  |
        |  String class uses UTF-16 internally to represent Unicode sequences                                          |
        +--------------------------------------------------------------------------------------------------------------+

        ================================================================================================================
        TYPE CONVERSION HIERARCHY (Implicit Widening)
        ================================================================================================================

        +--------------------------------------------------------------------------------------------------------------+
        |                                   IMPLICIT WIDENING CHAIN                                                    |
        |                                                                                                              |
        |   byte(1B)  →  short(2B)  →  int(4B)  →  long(8B)  →  float(4B)  →  double(8B)                              |
        |   char(2B)  →  int(4B)    →  long(8B)  →  float(4B)  →  double(8B)                                          |
        |                                                                                                              |
        |  NOTE: float (4B) can hold long (8B) values → range is wider, but PRECISION may be lost!                    |
        |  char CANNOT be assigned to/from byte or short directly → different signed/unsigned ranges                   |
        +--------------------------------------------------------------------------------------------------------------+

        ================================================================================================================
        JAVA 17 — WHAT'S CHANGED / RELEVANT ADDITIONS
        ================================================================================================================

        The 8 primitive types above (byte, short, int, long, float, double, char, boolean) are
        UNCHANGED since Java 1.0 — none are deprecated, none were added. What HAS evolved by
        Java 17 is how you DECLARE and MATCH variables/types:

        +--------------------------------------------------------------------------------------------------------------+
        |  FEATURE                    |  INTRODUCED  |  DESCRIPTION                                                 |
        +-----------------------------+--------------+--------------------------------------------------------------+
        |  var (Local Type Inference) |  Java 10     |  Compiler infers type at compile time — NOT dynamic typing   |
        |                             |              |  var count = 10;        // inferred as int                   |
        |                             |              |  var name = "Shubham";  // inferred as String                |
        |                             |              |  *** var CANNOT be used for fields, method params, or        |
        |                             |              |  return types — local variables only, MUST initialize        |
        +-----------------------------+--------------+--------------------------------------------------------------+
        |  Text Blocks (""")          |  Java 13     |  Multi-line String literals (standard since Java 15)         |
        |                             |  (preview)   |  String json = """                                           |
        |                             |  Java 15     |      {"name": "John"}                                        |
        |                             |  (standard)  |      """;                                                    |
        +-----------------------------+--------------+--------------------------------------------------------------+
        |  Pattern Matching for       |  Java 16     |  Removes need for manual cast after instanceof              |
        |  instanceof                 |              |  if (obj instanceof String str) {                           |
        |                             |              |      System.out.println(str.length());                      |
        |                             |              |  }                                                          |
        +-----------------------------+--------------+--------------------------------------------------------------+
        |  Records                    |  Java 16     |  Compact syntax for immutable data-carrier classes          |
        |                             |              |  record Point(int x, int y) { }                             |
        +-----------------------------+--------------+--------------------------------------------------------------+
        |  Sealed Classes             |  Java 17     |  Restrict which classes can extend/implement a type         |
        |                             |              |  sealed class Shape permits Circle, Rectangle { }           |
        +-----------------------------+--------------+--------------------------------------------------------------+

        None of these replace or deprecate byte/short/int/long/float/double/char/boolean —
        they change how you write code AROUND those types, not the types themselves.

        ================================================================================================================
        QUICK INTERVIEW SUMMARY
        ================================================================================================================

        +--------------------------------------------------------------------------------------------------------------+
        |  Q: How many primitive types in Java?              A: 8 (byte, short, int, long, float, double, char, bool)  |
        |  Q: Is Java pure OOP?                              A: No — has primitives, no operator overloading, etc.     |
        |  Q: Default value of int?                          A: 0                                                      |
        |  Q: Default value of boolean?                      A: false                                                  |
        |  Q: Can null be assigned to int?                   A: No — compile-time error                               |
        |  Q: What's the range of byte?                      A: -128 to 127                                            |
        |  Q: Which type should I use for file size?         A: long (file size may exceed int's range)               |
        |  Q: What is var?                                   A: Local variable type inference (Java 10+)              |
        |  Q: Does Java auto-convert int to boolean?         A: No — unlike C/C++, requires boolean expression        |
        +--------------------------------------------------------------------------------------------------------------+
        */
    }
}