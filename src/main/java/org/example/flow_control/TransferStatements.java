package org.example.flow_control;

public class TransferStatements {

    /*

break >>
inside switch >> it exits the switch block
inside loop >> it exits the loop block | for , while, do-while
inside labeled block >> it exits the labeled block


continue >>
inside switch >> not used | one time execution
inside loop >> for , while, do-while | it skips the current iteration and continues with the next iteration of the loop
inside labeled block >>  not used | one time execution

labelled break and continue - nested loops
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

Practise - break and continue statements

l1:
for (int i=0 ; i<3 ; i++) {
    for (int j=0; j<3; j++)  {
        if (i==j) {
            break; // exits the inner loop
                  }
        System.out.println(i + j);
                             }
                          }

       1. break ;
       >>  1..0 , 2..0 , 2..1
       2. break l1 ;
       >>  no op
       3. continue
       >> o..1 , 0..2 , 1..0 , 1..2, 2..0 , 2..1
       4. continue l1
       >> 1..0 , 2..0, 2..1



 int x = 0
 do{
     x++;
     System.out.println(x);
     if(++x<5)
            continue;
    x++;
    System.out.println("x is now: " + x);
 }while (++x<10)
>> 0-1 1 2<5-3<10-4 4 5<5 6 7<10 8 9<5 10 10<10

 >>> 1,4,6,8,10




*/
    public static void main(String[] args){


        for(int i=0; i<3; i++){
            if(i%2!=0){
                System.out.println(i+ " >> woohooo");
                break;
            }
        }

        int j = 0;
        while(j<=10){
            System.out.println(j + " >> zupeee");
            if(j==8) {
                break;
            }
            j++;
                  }

        for(int h=0; h<=5; h++){
            if(h==4)
                continue;
            System.out.println(h);
        }


//-------------------------------------------------------------------------------------------------------------------

        int targetX = 2; // The first number we're looking for
        int targetY = 3; // The second number we're looking for

        boolean foundMatch = false;

        // Label for the outer loop
        SEARCH_GRID:
        for (int x = 1; x <= 5; x++) { // Outer loop for x
            System.out.println("Checking x: " + x);

            for (int y = 1; y <= 5; y++) { // Inner loop for y
                System.out.println("  Checking y: " + y);

                if (x == targetX && y == targetY) {
                    System.out.println("    !!! Found the match: (" + x + ", " + y + ") !!!");
                    foundMatch = true;
                    // Break out of the loop labeled 'SEARCH_GRID'
                    // This will exit BOTH the inner 'y' loop and the outer 'x' loop
                    break SEARCH_GRID;
                }
            }
        }

        if (foundMatch) {
            System.out.println("\nSuccessfully found the target pair. Search concluded.");
        } else {
            System.out.println("\nTarget pair (" + targetX + ", " + targetY + ") not found.");
        }


    }
}
