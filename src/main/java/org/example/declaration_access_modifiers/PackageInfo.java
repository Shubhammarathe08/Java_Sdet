package org.example.declaration_access_modifiers;

public class PackageInfo {

    /* valid

    package >> at most 1  | 1 or  0
    import >> multiple | 0 or more
    class / interface / enum / annotation  - declaration >> 0 or more

    Encapsulation mechanism to group related classes and interfaces together into a single unit.
    ex. all classes/interfaces >> required for DB operation grouped into |  java.sql package
        all classes/interfaces >> required for file I/O operation grouped into | java.io package

    *** helpful to avoid name conflicts with classes/interfaces from other packages | unique identification
    *** improves modularity, maintainability, and reusability of code
    *** package level = default access modifier | not defined any modifier
        >> helpful to control access to classes/interfaces + provides security for components
    *** helpful to organize classes/interfaces into logical groups

    >> first non commented line of the source file should be package statement
    >> source file - GFG.java | amost 1 package statement nt allowed | 1 or 0

    fully qualified name: org.example.DeclarationAccessModifiers.PackageInfo
    PackageInfo.java - class >> part of the DeclarationAccessModifiers package.
    package >> org.example.DeclarationAccessModifiers;

    package name >> internet domain name in reverse order
                    www.allstate.com >> com.allstate.www

                    com.allstate.protectionPlans.warranty
     javac GFG.java >> generated .class placed in CWD

     >> to place generated .class file in destination directory
     javac -d . GFG.java  | . for cwd
     java com.allstate.protectionPlans.warranty.Test Test
     javac -d src/main/java GFG.java  | src/main/java for destination directory
        javac -d F: GFG.java
        java com.allstate.protectionPlans.warranty.Test Test
     if corresponding package structure is not present in the destination directory,it will be created automatically

    */
}
