package org.example.oops;

public class CouplingCohesion {

    /*
          ==================        Coupling          =================
         >> degree of dependence between components is called coupling
         tight coupling >> high dependence between components >> worst
         loose coupling >> low dependence between components >> good

         class A {
               String my_val = B.s;
         }
         class B {
         static{
           String s = "class B";
         }

         above component -tightly coupled
         serious dis adv -
                           w/o affecting remaining components we cant modify, any component
                           suppresses reusability of components
                           it reduces maintainability of the application
        loosely coupling - good programming practise

       ==================        Cohesion          =================
       for every component - clear well-defined functionality
      high cohesion - component has well-defined functionality, component said to be followed - highly cohesive
     low cohesion - component has multiple functionality, not clear what it does


         }




    */
}
