package org.example.language_fundamentals;

public class Jdk_Jre_Jvm {

    /*


JDK ( java development kit. JRE + JVM + Utilities )


                          GFG.java

                          Compiler (javac)

                          ByteCode

                         Java Virtual Machine (javap)
             ** Need to give entry point >> file name >> should include method main
             checks method signature [ method name + arguments ** Exclude - Arguements]
                public static void main(String[] args){
                                          }

                        Jvm + Lib >> JRE

                        Operating System

                        Hardware

** to develop jdk{ jre{ jvm{} } }
** to run NO JDK >> only JRE >> jre{ jvm{} }
JVM = platform dependent differs for different platform like windows, mac, linux etc.
JVM = RUns bytecode and doesnt matter on which platforn it was compiled
applications code .java can run on any machine ( provided the machine have compatible JVM )
WORA = write once run anyhwere


JDK (Java Development Kit) is for developing Java programs,
JRE (Java Runtime Environment) is for running them
JVM (Java Virtual Machine) is the platform that executes Java bytecode.

Program File name >> TestJava.java
Class name >> TestJava
*** class name >> HelloWorld
javac >> file name >>  javac TestJava.java
print program content >> javap TestJava.java
run java program >> java TestJava

*** name of file and public class should be same otherwise it will throw error
TestJava.java:1: error: class HelloWorld is public, should be declared in a file named HelloWorld.java
public class HelloWorld {

>>>>> When u have multiple classes in a single file
Rule                                                            Reason
Only one public class per file                 Enforces clarity, modularity, easy loading
Filename must match public class                     Helps JVM locate .class file
Multiple classes in the same file                             Allowed if not public

*/
}
