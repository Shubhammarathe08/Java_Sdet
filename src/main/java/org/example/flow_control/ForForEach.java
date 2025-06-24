package org.example.flow_control;

public class ForForEach {

    /*

          for ( init , condition check , incr/decr) {
              // body
          }

          step 1 >> init - executed once before the loop starts
          step 2 >> condition check -
          step3 >> if true, body is executed, if false, loop ends
          step 4 >> incr/decr - executed after the body is executed
          repeat step 2, 3, 4 until condition is false

           Curly braces -  optional
           without {} >> only one statement allowed in body
           statement should not be declarative statement

            for ( int i=0; i<=5; i++){
            System.out.println("test body");
            }

            init -> only once executed before the loop starts
            declare local var for - for loop
            can declare multiple variables of the same type
            int a,b,c = 10; // valid
            int a=10 , int b=20; // in valid


           Condition check - boolean expression // optional default val - true

           ncr/decr - executed after the body is executed // optional default val - 0

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
                              Un Reachable Statements

         if the condition is always true, then the loop will run infinitely , next statement will not be
         if the condition is always false, then the loop will never run , inside loop statements will not be executed
         if final var or constants >> true/false condition, then the loop will never run or run infinitely

         int a = 10, b = 20;
         for(int i=0; a<b; i++){
             System.out.println("test body");
         }
         System.out.println("after");
        // valid - compiler don't know - at run time it will work - infinite loop
        // test body ...


         int a = 10, b = 20;
         for(int i=0; a>b; i++){
             System.out.println("test body");
         }
         System.out.println("after");
         // valid - compiler don't know - at run time it will work
         // after


         final int a = 10, b = 20;
         for(int i=0; a<b; i++){
             System.out.println("test body");
         }
         System.out.println("after");
        // valid - compiler knows , true always - unreachable next statement

         final int a = 10, b = 20;
         for(int i=0; a>b; i++){
             System.out.println("test body");
         }
         System.out.println("after");
        // valid - compiler knows , true always - unreachable inside statement

         for(int i=0; true; i++){
             System.out.println("test body");
         }
         System.out.println("after");
        // valid - compiler knows , true always - unreachable next statement

         for(int i=0; false; i++){
             System.out.println("test body");
         }
         System.out.println("after");
        // valid - compiler knows , true always - unreachable inside statement

>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

              For Each loop / enhanced for loop
// arrays , collection - retrieve elements one by one
// only applicable for Arrays and Collections
// cant print elements in reverse order

for ( each_item x : target ){
}
// target >> should be iterable | *** if class implements java.lang.iterable
iterable >> interface | only method Iterator (return type) - iterator() >> next() >> hasNext() >> remove()
// all Arrays , Collection - implemented classes implements >> iterable interface

Feature	                 java.lang.Iterable<T>	                                                  java.util.Iterator<T>
Primary Role	Defines "what can be iterated over."                                          Performs the "how to iterate."
               Makes an object compatible with the enhanced for loop.	        The actual mechanism for traversing elements one by one.
Methods	                       Iterator<T> iterator()	                    boolean hasNext(),  T next() , void remove() (optional)








    */

    public static void main(String[] args){

        int[] arr = {1,2,3,4,5};
        for(int ele:arr){
         System.out.println(ele);
        }

        int[][] arr2 = {{1,2,3},{4,5,6}};
        for(int[] a:arr2)
        {
              for(int b:a) {
                  System.out.println(b);
              }

        }

        int[][][] arr3 = {  {  {  1,2,3},{4,5,6}  },  {  {  7,8,9},{10,11,12  }  }  };
        for(int[][] a:arr3)
        {
            for(int[] b:a){
                for(int c:b){
                    System.out.println(c);
                }

            }
        }

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

        for(int a=10, b=10; a<=10; a++){
            System.out.println("test body");
        }

        int a=0;
        for(System.out.println("init"); a<=2; a++){
            System.out.println("test body 2");
        }

        for (int l = 0; l < 5; ) {
            System.out.println("optional incr/decr");
            l++; // The increment happens inside the loop body
        }

        int i = 0;
        for (; i < 5; i++) {
            System.out.println("optional init");
        }

        for (int l = 0; l < 2; System.out.println(l)) {
            System.out.println("pritn anything incr/decr");
            i++; // The increment happens inside the loop body
        }

        for(int k=3; ; k--){
            System.out.println("optional conditional check");
        }

//        for(;;){
//            System.out.println("optional all");
//        }    >>> infinite loop, no exit condition, will run forever






    }
}
