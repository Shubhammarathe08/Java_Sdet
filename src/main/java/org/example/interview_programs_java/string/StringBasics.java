package org.example.interview_programs_java.string;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class StringBasics {

    /*
| Value         | Meaning                               | Example                |
| ------------- | ------------------------------------- | ---------------------- |
| null          | No String object exists               | String value = null;   |
| Empty         | String exists but has zero characters | ""                     |
| Blank         | Empty or contains only whitespace     | "   ", "\\t", "\\n"    |
| Normal space  | Keyboard space, Unicode U+0020        | " "                    |
| Unicode space | Other space-like characters           | U+00A0, U+2003, U+3000 , u+2009 |

Normal Space: The standard ASCII space (\u0020)
Unicode Spaces:
               Non-breaking spaces (\u00A0)
               ideographic spaces (\u3000)
               thin spaces (\u2009)

| Requirement           | Java 17 method  |
| --------------------- | --------------- |
| Left/front whitespace | stripLeading()  |
| Right/back whitespace | stripTrailing() |
| Both sides/full trim  | strip()         |
| Older normal trimming | trim()          |

trim() >>  Removes leading and trailing characters with ASCII values less than or equal to \u0020.
           *** Does not remove Unicode spaces like \u00A0.
strip() >> Trimming All Spaces ( Java 11+)
             Removes all leading and trailing [[ Unicode + ASCII ]]  whitespace characters.
             Uses Character.isWhitespace() under the hood.
======================================================================================
--> identify spaces
Character.isWhitespace(): Checks for ASCII whitespace and most Unicode spaces.
Character.isSpaceChar(): Detects all Unicode space characters, including non-breaking spaces.

--> regex for removing - single/multi spaces

?  means zero or one
*  means zero or more
+  means one or more
^  beginning of string
$  end of string
|  OR


Removing All Internal Spaces (Regex)
 >> replaceAll("\\s+", "")
    removes all standard whitespace.
 >> replaceAll("\\p{Z}+", "")
    removes all Unicode separator spaces.


split()       → divide text into pieces
replace()     → replace literal text
replaceAll()  → replace regex matches



[] combines both patterns. Java’s Pattern supports Unicode character classes and the (?U) flag.


 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Regex

1. isDigit()  | "\\d+" | "(?U)\\d+" | "\\p{Nd}+ | "(?U)[\\p{N}]+"
2. isAlphabet()  | "[a-zA-Z]+"  | "(?U)[\\p{L}]+"
3. isAlphaNumeric()  | "[a-zA-Z0-9]+"  | "[\\p{L}\\p{N}]+"
4. isWhiteSpace()  | "\\s+"  | "(?U)\\p{Z}+" | "(?U)[\\s\\p{Z}]+"
5. isSepcialCharacter() normal | "[^A-Za-z0-9\\s]+"
6. isSepcialCharacter() unicode | "(?U)[^\\p{L}\\p{N}\\s\\p{Z}]+"


Here: not letter , not digits , not spaces

\\p{L} = Unicode letters.
\\p{N} = Unicode numbers/digits.
\\s = whitespace.
\\p{Z} = Unicode separator spaces.
[^...] = anything except the listed character classes.
==================================================================
  */


    public static void main(String[] args){
        String input_str = "11Hdns&53211ff1111f";
        //
        Pattern pattern = Pattern.compile("11");
        Matcher matcher = pattern.matcher(input_str);

        while (matcher.find()) {
            System.out.println(
                    matcher.group() + " at index " + matcher.start()
            );
        }

    }

}


