package org.example.language_fundamentals;

public class StaticExecutionOrder {

    // step 1- identify static member >> top to bottom
    // execution - static var - assignment >>  Then >> static blocks Top-Bottom
    // execution of main method
    // i, block 1 , main method ,m1, second block , j
    // i = 10
    // block 1 >> m1() >> j=0 + first static block
    // second static block
    // j=20
    // main method >> m1() >> 20 + main method

    // inside static block >> access static var -> direct read
    // calling static methods >> within that read var -> in direct read

    // at the time of java class loading >> use static block and code within that
    // ex. for every driver class static block to register with driver manager

    /*
      print statement to console w/o main method >>

      static{
      System.out.println("hello");
      System.exit(0);
      }
  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

         static int x = m1();

         public static int m1(){
         System.out.println("printed hello");
         System.exit(0);
         return 100;
         }
   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

   static test = new Test();

       {
        System.out.println("printed hello");
        System.exit(0);
        }

        Test{
        System.out.println("printed hello");
        System.exit(0);
        }


    * */

        static int i = 10;

        static {
            m1();  // Static method call
            System.out.println("First static block");
        }

        static{
        m2();
              }

        public static void m2(){
        System.out.println(oll); // indirect read - works fine
               }

        static int oll=100;

        public static void main(String[] args) {
            m1();  // Static method call from main
            System.out.println("main method");
        }

        public static void m1() {
            System.out.println(j);  // Using static variable j
        }

        static {
            System.out.println("Second static block");
        }

        static int j = 20;




}
