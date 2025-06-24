package org.example.language_fundamentals;

public class LangFundamental {
        /* name in java program considered as >> identifiers
        Those are not reserved keywords, are identifiers ( apart from values like `int`, `String`, etc. )
    class, method, variable, package, interface, enum, annotation , label name

                class Test {
            public static void main (String[] args){
                      int x =10;
                          }
            }

    | Concept        | Is it an Identifier?                                                    | Explanation |
            | -------------- | ----------------------------------------------------------------------- | ----------- |
            | **Class**      | ✅ **The name** of a class is an identifier.                             | Test  , String |
            | **Method**     | ✅ **The name** of a method is an identifier.                            |      main      |
            | **Variable**   | ✅ **The variable name** is an identifier.                               |    x , args    |
            | **Package**    | ✅ **The package name** (or parts of it) is an identifier.               |             |
            | **Interface**  | ✅ **The name** of an interface is an identifier.                        |             |
            | **Enum**       | ✅ The **enum name** and **its constants** are identifiers.              |             |
            | **Annotation** | ✅ **The annotation name** (e.g., `@Override`) is an identifier.         |             |
            | **Label name** | ✅ Label names (used with loops and `break`/`continue`) are identifiers. |             |

   Naming Convention
   allowed characters in identifiers : a-z , A-Z , 0-9 , _ , $ (dollar sign)
   ***(cannot start with a digit)
   ***JAVA LANGUAGE CASE SENSITIVE
   ***No Length limit for name  but recommended to keep it meaningful and concise
   ***(cannot use reserved keywords as identifiers)
   ***(cannot use special characters like @, #, %, etc. in identifiers)
   ***All predefined class/interface names we can use as identifiers BUT not recommended , reduces readability + creates confusion

   package name - all lowercase, separated by dots (e.g., `com.example.project`)
   class name - PascalCase , Starts with Uppercase letter (Capitalized)
   method name - camelCase, Starts with Lowercase letter
   variable name - camelCase, Starts with Lowercase letter


   Valid >> total_number ,TotalNumber, _total, $total, total123 ,Int , _$_ ,Integer
   invalid >> total# , 1Total , if , int , All@Hands
   total != Total != TOTAL (all are different identifiers)
================================================================================================================================
Reserved Words (53)  *** all small letter
Used key word >> 48
Un Used key word >> 2 (goto, const)
Reserved literals >> 3 (true, false, null)

Reserved words in Java are keywords that have a predefined meaning in the language and cannot be used as identifiers (names for classes, methods, variables, etc.). These keywords are reserved by the Java language syntax and serve specific purposes.

Used key word >> 48
       data types >> byte, short, int, long, float, double, boolean, char
       flow control >> if, else, for, break, continue, return, while, do, switch, case, default
       Access Modifiers >> public, private, protected , abstract , static, final, synchronized, native, strictfp , transient, volatile
       Exception Handling >> try, catch, finally, throw, throws , assert
       Class related >> class, interface, extends, implements, package, import
       object related >> new, this, super, instanceof
       return type >> void
       extra >> enum ( to define grp of named constants, like enum Days { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY } )


Un Used key word >> 2
        goto, const (not used in Java, they are reserved for future use, banned due to problems in other lang)

Reserved literals >> 3
        (true , false , null *** default val for object reference)

    | Keyword     | Exists in Java 17 | Applies to                | Purpose/Use                                                         |
    | ----------- | ----------------- | ------------------------- | ------------------------------------------------------------------- |
    | `abstract`  | Yes               | Class/Method              | Declares a class as abstract or a method as abstract.               |
    | `assert`    | Yes               | Statement                 | Used for debugging purposes to make assertions.                     |
    | `break`     | Yes               | Statement                 | Exits a loop or switch statement.                                   |
    | `case`      | Yes               | Switch statement          | Defines a branch in a switch statement.                              |
    | `catch`     | Yes               | Exception handling        | Catches exceptions thrown by try blocks.                             |
    | `class`     | Yes               | Class declaration

| Keyword     | Exists in Java 17 | Applies to                | Purpose/Use                                                         |
| ----------- | ----------------- | ------------------------- | ------------------------------------------------------------------- |
| `native`    | Yes               | Method                    | Indicates a method is implemented in native code (JNI).             |
| `strictfp`  | Yes               | Class/Method              | Ensures floating-point calculations are platform-independent.       |
| `transient` | Yes               | Field (Instance variable) | Excludes field from object serialization.                           |
| `volatile`  | Yes               | Field (Instance variable) | Ensures the most recent value of a field is visible across threads. |


No delete keyword >> destruction of useless object responsibility of garbage collector

    */
}
