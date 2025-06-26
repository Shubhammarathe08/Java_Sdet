package org.example.exception_handling;

public class FinalFInallyFInalize {

    /*
          Final | keyword :-

          class >> cant be extended | child classes not possible for the class | inheritance not possible
          method >> cant be over ride | cant have separate implementation in child class
          var >> cant perform reassignment for that var

     ----------------------------------------------------------------------------------------------------------------
           Finally{} | block :-

           always associated with try-catch >> to maintain clean up code
           >> clean up activity related to try block
           >> whatever resources opened as part of try block will be closed inside finally block
           executes ir respective of
                   exception raised / not raised
                   handled / not handled
                   normal or ab-normal termination of program
           except :- JVM shutdown

     ----------------------------------------------------------------------------------------------------------------
          Finalize() | method  :-

          just before destroying an object
          garbage collector calls/invokes finalize method
          to perform clean up activities
          once finalize method execution completes , GC immediately destroys object
         >> clean up activities related to Object ,
         >> whatever resources associated with Obj will be deallocated before destroying an object



    */
}
