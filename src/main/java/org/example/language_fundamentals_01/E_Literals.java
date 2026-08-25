package org.example.language_fundamentals_01;

public class E_Literals {

    /*
    ================================================================================================================
    WHAT IS A LITERAL?
    ================================================================================================================
    Any constant value that can be assigned to a variable is called a LITERAL.
    E_Literals are fixed values written directly in code — they are NOT variables themselves.

    Example:
        int x = 10;   // 10 is a literal of type int

    +--------------------------------------------------------------------------------------------------------------+
    |                                   NUMBER BASE QUICK REFERENCE                                                |
    +--------------------------------------------------------------------------------------------------------------+
    | Form            | Base | Prefix     | Allowed digits        | Example       | Decimal Value                   |
    +-----------------+------+------------+-----------------------+---------------+---------------------------------+
    | Decimal         | 10   | none       | 0-9                   | 10            | 10                              |
    | Octal           | 8    | starts 0   | 0-7                   | 012           | 10                              |
    | Hexadecimal     | 16   | 0x or 0X   | 0-9, A-F/a-f         | 0xA           | 10                              |
    | Binary          | 2    | 0b or 0B   | 0, 1                  | 0b1010        | 10                              |
    +--------------------------------------------------------------------------------------------------------------+

    ================================================================================================================
    1) INTEGER LITERALS (byte, short, int, long)
    ================================================================================================================
    - Underscore ( _ ) can be used BETWEEN digits for readability
    - CANNOT be at start, end, or next to decimal point

    Valid:
        int x = 10_334_050;          // ✅ readable grouping
        long l = 10_334_050L;        // ✅ L suffix for long
        float f = 10_334_050f;       // ✅ valid
        double d = 10_334_050d;      // ✅ valid

    Invalid:
        _10_334_050                  // ❌ starts with underscore
        10_334_050_                  // ❌ ends with underscore
        10_334_050_.44               // ❌ touches decimal point

    ================================================================================================================
    2) TYPE PROMOTION (Widening) - Automatic
    ================================================================================================================

    +---------------------------+---------------------------+---------------------------+---------------------------+
    |                       IMPLICIT WIDENING CHAIN (small → large)                                              |
    +---------------------------+---------------------------+---------------------------+---------------------------+
    |  byte (1B)  →  short (2B)  →  int (4B)  →  long (8B)  →  float (4B)  →  double (8B)                      |
    |  char (2B)  →  int (4B)    →  long (8B)  →  float (4B)  →  double (8B)                                   |
    +---------------------------+---------------------------+---------------------------+---------------------------+

    IMPORTANT NOTES:
    - float (32-bit) can hold long (64-bit) values → range is wider, but PRECISION may be lost
    - char CANNOT be assigned to/from byte or short directly → different signed/unsigned ranges
    - byte/short are SIGNED (-128 to 127) / (-32768 to 32767) → char is UNSIGNED (0 to 65535)

    ================================================================================================================
    3) NUMBER BASES EXAMPLES
    ================================================================================================================

    // All three assignments evaluate to their decimal equivalent
    int decimal   = 10;      // decimal  (base 10) → 10
    int octal     = 012;     // octal    (base 8)  → 8
    int hex       = 0X10;    // hex      (base 16) → 16
    int binary    = 0b1010;  // binary   (base 2)  → 10

    System.out.println(decimal + octal + hex);   // Output: 28 (10 + 8 + 16 + 16)

    ================================================================================================================
    4) FLOATING-POINT LITERALS - float vs double
    ================================================================================================================

    +--------------------------------------------------------------------------------------------------------------+
    |  DEFAULT TYPE: ANY floating-point literal is a DOUBLE                                                       |
    |  TO MAKE A FLOAT: Must append 'f' or 'F' suffix                                                            |
    |  TO MAKE A DOUBLE: 'd' or 'D' suffix is optional (default)                                                 |
    +--------------------------------------------------------------------------------------------------------------+

    float f1 = 123.456f;      // ✅ valid — 'f' suffix required
    float f2 = 123.456;       // ❌ error — defaults to double, can't assign to float
    double d1 = 123.456;      // ✅ valid — default type
    double d2 = 123.456d;     // ✅ valid — explicit 'd' (optional)

    ================================================================================================================
    5) FLOAT LITERAL — ALL VALID FORMS
    ================================================================================================================

    +--------------------------------------------------------------------------------------------------------------+
    |  float f;                                                                                                   |
    +--------------------------------------------------------------------------------------------------------------+
    |  f = 111;                // ✅ integral value                                                               |
    |  f = 0777;               // ✅ octal (valid)                                                                |
    |  f = 0xFace;             // ✅ hex                                                                          |
    |  f = 0b1111;             // ✅ binary                                                                       |
    |  f = 123456f;            // ✅ with 'f' suffix                                                              |
    |  f = 123.456f;           // ✅ fractional with 'f'                                                          |
    |  f = 1.2e3f;             // ✅ scientific notation: 1.2 × 10³ = 1200.0                                     |
    |  f = 1.2e3F;             // ✅ same, uppercase F                                                           |
    +--------------------------------------------------------------------------------------------------------------+

    Invalid:
    float f = 123.456;        // ❌ needs 'f' suffix — default double won't fit
    float f = 123.456d;       // ❌ 'd' suffix forces double → incompatible
    float f = 123.456D;       // ❌ same error

    ================================================================================================================
    6) DOUBLE LITERAL — ALL VALID FORMS
    ================================================================================================================

    +--------------------------------------------------------------------------------------------------------------+
    |  double d;                                                                                                  |
    +--------------------------------------------------------------------------------------------------------------+
    |  d = 111;                // ✅ integral, valid                                                              |
    |  d = 0777;               // ✅ octal                                                                        |
    |  d = 0xFace;             // ✅ hex                                                                          |
    |  d = 0b1111;             // ✅ binary                                                                       |
    |  d = 123.456;            // ✅ default double                                                               |
    |  d = 123456f;            // ✅ float → widens to double                                                     |
    |  d = 123.456f;           // ✅ float → widens to double                                                     |
    |  d = 123.456d;           // ✅ explicit double                                                              |
    |  d = 123.456D;           // ✅ explicit double                                                              |
    |  d = 1.2e3;              // ✅ scientific: 1200.0                                                           |
    +--------------------------------------------------------------------------------------------------------------+

    // ✅ valid: has decimal point → treated as DECIMAL, not octal
    double d = 0786.0;

    // ❌ error: hex can't have a decimal point
    double d = 0xFace.0;

    // ❌ error: hex + decimal point not allowed
    double d = 0x123.456;

    ================================================================================================================
    7) COMMON COMPILE-TIME ERRORS
    ================================================================================================================

    byte b1 = 128;              // ❌ possible lossy conversion → byte max = 127
    byte b2 = true;             // ❌ boolean → byte conversion not allowed
    int i1 = 2147483648;        // ❌ integer number too large → int max = 2147483647
    int i2 = 2147483648L;       // ❌ possible lossy conversion from long to int
    int i3 = true;              // ❌ boolean → int conversion not allowed
    long l = 21.21;             // ❌ double → long conversion not allowed
    float f = 10.5;             // ❌ double → float conversion not allowed
    double d = 0x123.456;       // ❌ malformed floating-point literal
    int d = 0B1111;             // ✅ valid → equals 15 (binary)

    ================================================================================================================
    8) BOOLEAN LITERALS
    ================================================================================================================

    +--------------------------------------------------------------------------------------------------------------+
    |  Only TWO literal values: true and false (case-sensitive, lowercase only)                                   |
    +--------------------------------------------------------------------------------------------------------------+

    boolean bool1 = true;       // ✅ valid
    boolean bool2 = false;      // ✅ valid
    boolean bool3 = 0;          // ❌ int → boolean not allowed
    boolean bool4 = 1;          // ❌ int → boolean not allowed
    boolean bool5 = True;       // ❌ 'True' not a keyword → treated as identifier
    boolean bool6 = "true";     // ❌ String → boolean not allowed

    ================================================================================================================
    9) CHAR LITERALS
    ================================================================================================================

    +--------------------------------------------------------------------------------------------------------------+
    |  A char literal is a SINGLE character in single quotes — or numeric/Unicode equivalent.                     |
    +--------------------------------------------------------------------------------------------------------------+

    char c1 = 'A';              // ✅ single character
    char c2 = A;                // ❌ missing quotes → treated as identifier
    char c3 = "A";              // ❌ double quotes → String
    char c4 = 'AB';             // ❌ too many characters
    char c5 = '';               // ❌ empty character literal

    // Valid numeric assignments (char is 16-bit unsigned integer)
    char c6 = 65;               // ✅ ASCII 'A'
    char c7 = 0x41;             // ✅ hex → 'A'
    char c8 = 0777;             // ✅ octal → still numeric
    char c9 = '\u0041';         // ✅ Unicode → 'A'
    char c10 = '\n';            // ✅ newline
    char c11 = '\u0000';        // ✅ null character
    char c12 = 1977;            // ✅ compiles & runs → may not display a glyph

    // Escape sequences (each IS a valid char literal)
    +--------------------------------------------------------------------------------------------------------------+
    |  Escape  | Meaning             | Example                                  |
    +----------+---------------------+------------------------------------------+
    |  \'      | Single quote        | '\''                                     |
    |  \"      | Double quote        | "He said, \"Hi\""                        |
    |  \\      | Backslash           | "C:\\Users\\Name"                        |
    |  \n      | Newline (LF)        | "Hello\nWorld"                           |
    |  \r      | Carriage return     | rarely used alone                        |
    |  \t      | Tab                 | "Hello\tWorld"                           |
    |  \b      | Backspace           | moves cursor back one char               |
    |  \f      | Form feed           | rarely used in modern Java               |
    +--------------------------------------------------------------------------------------------------------------+

    ================================================================================================================
    10) STRING LITERALS
    ================================================================================================================

    // Any sequence of characters in DOUBLE quotes
    String s1 = "Hello, World!";                    // ✅ basic
    String s2 = "Java\nProgramming";                // ✅ with escape
    String s3 = "Escape: \"Quotes\" and \\Backslash\\"; // ✅ escaped

    // Text Block (Java 13+, standard in Java 15+)
    String multiLine = """
            This is a multi-line string.
            It preserves line breaks.
            """;

    ================================================================================================================
    QUICK RECALL TABLE
    ================================================================================================================

    +-------------------+--------------------------+-----------------------------------+
    | Literal Type      | Default Type             | Suffix Needed                     |
    +-------------------+--------------------------+-----------------------------------+
    | Integer           | int                      | L/l for long                      |
    | Floating-point    | double                   | f/F for float, d/D optional for double |
    | Character         | char                     | none — single quotes              |
    | Boolean           | boolean                  | none — true/false only            |
    | String            | String                   | none — double quotes              |
    +-------------------+--------------------------+-----------------------------------+
    */
}