package org.example.flow_control;

public class SwitchCase {

    /*

    When several options are available to choose from, we can use a switch case statement.
    The switch case statement allows us to execute a block of code based on the value of an expression.
    The switch case statement is more readable and efficient than using multiple if-else statements.

    Switch Case Statement

    *** expression / arg type - should be of type byte, short, int, char, String, or an enum type.
    why not boolean? - because boolean has only two values, true and false, which can be handled with if-else statements.
    why not others? - because switch case statement is designed to handle multiple cases based on the value of an expression.

    {} -  mandatory for switch case block

    case :
       action
       break; // optional - if not present, the control will fall through to the next case

    default :
         action // optional - if not present, no action will be taken if nothing matches
    inside switch {  case , default expected other than that independent statements are allowed }

    every case label case 10 : >> should be constant expression case (y) : // compile time error

    duplicate case able not allowed >> case 95: case 'a' : // compile time error duplicate case labels

    1. switch (expression) {
            case value1:
                // code block action1
                break;
            case value2:
                // code block action 2
                break;
            default:
                // code block default action *** if nothing matches
                // max 1 time | min 0 ** can take anywhere but executes when no other cases matches
        }


        fall though inside switch
        >> from matched case >> to >> until u get break statement or end of switch block
        >> can define common action for multiple cases

                int x = 10;
        switch (x) {
            case 0 :
                System.out.println(0);

            case 1 :
                System.out.println(1);
                break;

            case 2 :
                System.out.println(2);

            default :
                System.out.println("def");
               // end of switch case block
                }

                x= 0 >> 0 , 1
                x= 1 >> 1
                x= 2 >> 2, def
                x=  >> def


        switch (x) {

            default :
                System.out.println("def");

            case 0 :
                System.out.println(0);
                break;

            case 1 :
                System.out.println(1);

            case 2 :
                System.out.println(2);
             // end of switch case block
                }


                x= 0 >> 0
                x= 1 >> 1 , 2
                x= 2 >> 2
                x=  >> def, 0
 */

    public static void main(String[] args){
        int x = 'a';
        switch (x) {
            case 10 :
                System.out.println(10);
                break;
            case -127 :
                System.out.println(-127);
                break;
            case 'a' :
                System.out.println('a');
                break;
            default :
                System.out.println(100);

        }

        switch (x) {

            default :
                System.out.println("def");

            case 0 :
                System.out.println(0);
                break;

            case 1 :
                System.out.println(1);

            case 2 :
                System.out.println(2);
                // end of switch case block
        }

        switch (x) {
            case 0 :
                System.out.println(0);

            case 1 :
                System.out.println(1);
                break;

            case 2 :
                System.out.println(2);

            default :
                System.out.println("def");
                // end of switch case block
        }

    }

}
