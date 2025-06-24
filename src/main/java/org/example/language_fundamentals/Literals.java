package org.example.language_fundamentals;
public class Literals {

    /* Any const value that can be assigned to a variable is called a literal.
      for INTEGRAL data type only >> byte, short, int, long
      int x = 10; // 10 is a literal of type int


     ***  10334050 // 10_3_340_50 // 10_3_340_50L // 10_3_340_50f // 10_3_340_50d | READABLE NUMBER LITERALS
     // _ can be used between digits to improve readability of large numbers
     //in-valid >> _10_3_340_50 // _10_3_340_50_.44 // 10_3_340_50_ // _10_3_340_50._66

     #############  Automatic Internal Promotion   ############
       1      2
     byte >> short      4       8         4        8
                    >> int  >> long ||  float >> double
     char >>
     2

     Even though float is 32-bit and long is 64-bit, Java allows this conversion because:
     The range of float is wider (can store very large/small values),
     But it may lose precision (can't represent all integers exactly).

     cant put char to short/byte and vice versa - its signed and char is unsigned

      decimal form  = base 10 = 10
      octal form    = base 8  = 012  [Allowed digits >> 0-7 | starts with 0]
      hexadecimal form = base 16 = 0xA  [Allowed digits >> 0-9, A-F/a-f | starts with 0x or 0X]
      binary form  = base 2  = 0b1010 [Allowed digits >> 0,1 | starts with 0b or 0B]

      // Allowed >> 10, 0777 , 0xA, , 0x1F2B , oxFace , oXBeeF
      // Not allowed >> 0786, oXBeer, 0x1.5F (hexadecimal cannot have decimal point)

      int x = 10 , int y = 010 , int z = 0X10  Sop(x+y+z); // Output: 28  (10, 8, 16 in decimal)
      float = 123.456 f
      double = 123.456789 // 123.456789d // 123.456789D
      default float literal is double, so we need to append f or F to indicate it's a float



        // byte b = 128 ; // compile time error : incompatible types: possible lossy conversion from int to byte
        // byte b = true ; // compile time error : incompatible types: boolean cannot be converted to byte
        // int i = 2147483648; // compile time error : integer number too large
        // int i = 2147483648L; // compile time error : incompatible types: possible lossy conversion from long to int
        // int i = true; // compile time error : incompatible types: boolean cannot be converted to int
        // long b = 2121212121212; // compile time error : java: integer number too large
        // long b = 21.21; // compile time error : java: incompatible types: possible lossy conversion from double to long
        // float b = 10.5; // compile time error : java: incompatible types: possible lossy conversion from double to float
        // double b =  0x123.456; // compile time error : java: malformed floating-point literal
        // int d = 0B1111; // 15
=======================================================================================================================
        float d = 111; // integral valid
        float d = 0777; // octal valid
                   *** not the wrong octal >> double d = 0786 (its int not floating point literal> int > octal starts with 0 > 8 not allowed)
                       compile time error : integer number too large
        float d = 0xFace;  // hexadecimal valid
        float d = ob1111; // binary valid



        float d = 123456
                float f = 123.456; // every floating literal default double and hence cant assign to Double
                float f = 123.456d; // every floating literal default double and hence cant assign to Double
                float f = 123.456D; // every floating literal default double and hence cant assign to Double
                // compile time error : java: incompatible types: possible lossy conversion from double to float
        float d = 123456f
        float d = 123.456f
        float d = 1.2e3f; // scientific notation valid  1.2 x 10^3 = 1200.0
        float d = 1.2e3F; // scientific notation valid  1.2 x 10^3 = 1200.0


>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        double d = 111; // integral valid
        double d = 0777; // octal valid
                   *** not the wrong octal >> double d = 0786 (its int not floating point literal> int > octal starts with 0 > 8 not allowed)
                       compile time error : integer number too large
        double d = 0xFace;  // hexa decimal valid
        double d = ob1111; // binary valid


        double d = 123.456
        double d = 123456f
        double d = 123.456f
        double d = 123.456d
        double d = 123.456D
        double d = 1.2e3; // scientific notation valid  1.2 x 10^3 = 1200.0

        double d = 0786.0; // treat as decimal, not octal | octal + point not allowed >> valid
        double d = oxFace.0; // syntax error : java: ';' expected >> Invalid as it has letters
        double d = 0x123.456; // compile time error : java: malformed floating-point literal
================================================================================================================================
        int x  = 10.0; // compile time error : incompatible types: possible lossy conversion from double to int
        boolean bool = true;
        boolean bool = 0; // Compile time error >> java: incompatible types: int cannot be converted to boolean
        boolean bool = 1; // Compile time error >> java: incompatible types: int cannot be converted to boolean
        boolean bool = True; //Compile time error >>  java: cannot find symbol  symbol:   variable True location: class org.example.Test
        boolean bool = "true"; // Compile time error >>  java: incompatible types: java.lang.String cannot be converted to boolean
=================================================================================================================================================
        char c = 'A'; // single character valid
        char c =  A; // compile time error : java: cannot find symbol  symbol:   variable A location: class org.example.Test
        char c = "A"; // compile time error : java: incompatible types: java.lang.String cannot be converted to char
        char c = 'AB'; // compile time error : java: unclosed character literal

        char c = 65; // valid, ASCII value of 'A' is 65
        char c = 0x41; // valid, hexadecimal value of 'A' is 0x41
        char c = 0777; // Valid, octal representation of a character

        char c = '\u0041'; // valid, Unicode representation of 'A' | hexadecimal
        char c = '\n'; // valid, newline character
        char c = '\u0000'; // valid, null character
        char c = ''; // compile time error : java: empty character literal

        char c= 1977
        print(c) // font nopt available hence char not printed and didnt gave error too

        char >. every escape char is char literal
        | **Escape Sequence** | **Character Represented** | **Description**                                                              |
| ------------------- | ------------------------- | ---------------------------------------------------------------------------- |
| `\'`                | Single quote              | Used in character literals to include a single quote: `'\'\''`               |
| `\"`                | Double quote              | Used in string literals to include a double quote: `"He said, \"Hi\""`       |
| `\\`                | Backslash                 | Represents a literal backslash: `"C:\\Users\\Name"`                          |
| `\n`                | Newline (Line Feed, LF)   | Moves to a new line: `"Hello\nWorld"`                                        |
| `\r`                | Carriage return (CR)      | Moves cursor to the beginning of the line (rarely used alone in modern Java) |
| `\t`                | Tab                       | Inserts a horizontal tab: `"Hello\tWorld"`                                   |
| `\b`                | Backspace                 | Moves cursor one character back (used in terminal output, not UI)            |
| `\f`                | Form feed                 | Advances the paper feed in printers (rarely used in modern Java)             |
| 'uXXXX'    | Unicode character         | Inserts a Unicode character by code point, e.g., `\u0041` is `'A'`           |

============================================================================================================================================

        // String literals

        Any sequence of characters enclosed in double quotes is a string literal.

        String str = "Hello, World!"; // double quotes for string literals
        String str2 = "Java\nProgramming"; // includes a newline character
        String str3 = "Escape: \"Quotes\" and \\Backslash\\"; // includes escaped quotes and backslashes

        // Multi-line string literals (Java 13+)
        String multiLineStr = """
                This is a multi-line string.
                It can span multiple lines.
                """;

        // Character literals
        char singleChar = 'A'; // single character in single quotes
        char escapeChar = '\n'; // newline character
        char unicodeChar = '\u0041'; // Unicode representation of 'A'

    /* Literals are constant values that can be assigned to variables or used directly in expressions.
       They represent fixed values in the code and are not variables themselves.



*/

}
