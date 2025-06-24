package org.example.language_fundamentals;

public class DataTypes {
    public static void main(String[] args) {

        /*
        Every Variable and Expression in Java has a data type, which defines the kind of data it can hold. ( Not possible to define var w/o data types )
        error : java: cannot find symbol
        Compile time data type checking is done by the Java compiler and throws error in case of type mismatch
        every assigment should be checked by compiler for type compatibility
        Strongly Typed Language
        ================================================================================================================================
        *** Not Pure Object Oriented Language -
        Several oops features nit satisfied by java -
        operator overloading
        multiple inheritance etc...
        Java has primitive data types (int, char, etc.) that are not objects.
        Procedural - has functional interfaces that can be implemented using lambda functions, but it does not treat everything as an object.

        *** null -> default value for object refence only | cant apply to primitives
        error : java: incompatible types: <nulltype> cannot be converted to char
         */

        //Primitive data types

        //Numeric data type

        //Integral data type | Signed data types
         // 1 bit for sign >>  +ve represented direct into memory  | -ve represented 2's complement form
        byte b = 127; // 1 byte >> 8-bit signed integer | range from -128 to 127 [def - 0]
        short s = 32767; // 2 bytes >> 16-bit signed integer | range from -32,768 to 32,767 [def - 0]
        int i = 2147483647; // 4 bytes >> 32-bit signed integer | range from -2,147,483,648 to 2,147,483,647 [def - 0]
        long l = 9223372036854775807L; //[def - 0]
        // 8 bytes >> 64-bit signed integer | range from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807


        //f.length() Return Type = Long *** may exceed int range

        //Floating-point data type  | Signed data types
        // less decimal point accuracy than float - single precision
        // more decimal point accuracy than double - double precision
        // only decimal rep allowed >> not octal or hexadecimal
        float f = 3.4028235E38f;
        // 10.56f || 4 bytes >> 32-bit floating point | range from approximately -3.4028235E38 to 3.4028235E38 [def - 0.0]
        double d = 1.7976931348623157E308;
        // 11.98990 || 8 bytes >> 64-bit floating point | range from approximately -1.7E38 to 1.7E38  [def - 0.0]

        //Non-numeric data type
        char c = 'z';
        //  '*' , '0' || 2 bytes >> single 16-bit Unicode character A-Z a-z and special characters || single char |  [def '\u0000' = 0 ]
        boolean bool = true;
        // 1 bit/1 byte Virtual machine dependent >> true or false value || Not 1 or 0, but true or false  [def - false ]
                            // | range is not defined as it can only be true or false
        // boolean b = 0 ; // compile time error : incompatible types: int cannot be converted to boolean
        // boolean b = True ; // compile time error : java: cannot find symbol | symbol:   variable True location: class org.example.Test
        // boolean b = "true" ; // compile time error :incompatible types: java.lang.String cannot be converted to boolean

/*
| **`byte`**         | Used for memory-efficient storage of small integer values (e.g., file I/O, network protocols)          | `byte a = 100;`                  |
| **`short`**        | Used when a larger range than `byte` is needed but still smaller than `int` (e.g., encoding data)      | `short temperature = -20;`       |
| **`int`**          | Common for general-purpose integer values (e.g., counters, measurements, array indexing)               | `int age = 25;`                  |
| **`long`**         | Used for larger numbers (e.g., timestamps, large datasets, population counts)                          | `long population = 7800000000L;` |
| **`float`**        | Used for floating-point values with lower precision (e.g., graphics, simulations)                      | `float pi = 3.14159f;`           |
| **`double`**       | Used for high-precision floating-point numbers (e.g., financial calculations, scientific computations) | `double price = 19.99;`          |
| **`char`**         | Represents a single character (e.g., letters, digits, or symbols)                                      | `char letter = 'A';`             |
| **`boolean`**      | Used for logical values (`true` or `false`), typically in conditions (e.g., `if`, `while`)             | `boolean isValid = true;`        |


        int x = 0;
        if (x){
            System.out.println("hello");
        }

        while (1){
            System.out.println("hi");
        }

        //error : java: incompatible types: int cannot be converted to boolean

// Java >> unicode not ASCII
ASCII >> 7-bit character set | 256 characters | 0-127
        // Java uses Unicode, which is a superset of ASCII, allowing for a much larger range of characters. (o to 65535)
        // Unicode supports characters from various languages and scripts, making it suitable for internationalization.
        // Java's char type is 16 bits (2 bytes) and can represent any Unicode character.
        // This allows Java to handle a wide variety of characters, including those from non-Latin scripts.
        // Java's String class is used to represent sequences of characters, and it supports Unicode natively.

*/


    }
}
