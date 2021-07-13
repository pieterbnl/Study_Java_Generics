package com.pbe;

/** Study on Generics
 * Following Java The Complete Reference by Herbert Schildt i.c.w. (Udemy) Java programming masterclass for software developers Tim Buchalka.
 @author Pieter Beernink
 @version 1.0
 @since 1.0
 */

// *********************
// GENERICS
// *********************
// Generics, meaning parameterized types, enable classes, interfaces and methods to be created in which the type of data upon which they operate is specified as a parameter.
// A class, interface or method that operates on a parameterized type is called generic: a generic class or generic method.
//
// For example, an algorithm can be defined once, independently of any specific type of data.
// It can then be applied to a wide variety of data types, without additional efforts.
// Java Collections Framework has been significantly affected by generics.
// The Collections Framework defines several classes, such as lists and maps, that manage collections (a group of objects).
// The benefit added by generics is that the collection classes can now be used with complete type safety.
//
// Prior generics, generalized classes, interfaces, and methods used Object references to operate on various types of objects. This was without type safety.
// Generics added type safety and streamlined the process as it's no longer necessary to explicitly employ casts to translate between Object and the type of data being operated upon.
// With generics all casts are automatic and implicit.
//
// Note: When declaring an instance of a generic type, the type argument passed to the type parameter must be a reference type. It can't be a primitive type such as int or char.
// This is not an issue, because type wrappers (in combination with autoboxing/unboxing) can be used to encapsulate a primitive type.


public class Main {

    public static void main(String[] args) {

        // **********************
        // Generics example
        // **********************
        System.out.println("Generics example");

        // Create a Gen reference for Integers
        // Integer is specified within the angle brackets, making it the type argument that's passed to Gen's type parameter T
        // This effectively creates a version of Gen in which all references to T are translated into references to Integer
        // Note: the compiler does not actually create different version of Gen or of any other generic class -
        // it makes the code behave as if a specific version of Gen were created
        // There's only one version of Gen that actually exists. The process of removing generic type info is called 'erasure'.
        Gen<Integer> intOb;

        // Create a Gen<Integer> object and assign its reference to intOb (using autoboxing)
        // Type argument Integer is also specified because the type of the object (intOb) to which the reference is being assigned, is of type Gen<Integer>
        // If it wouldn't be specified, or if a different type would be specified it would result in a compile-time error. Thus: type safety.
        intOb = new Gen<Integer>(88);
        // alternative on one line: Gen<Integer> intOb = new Gen<Integer>(88);

        // Show the type of data used by intOb
        intOb.showType();

        // Get the value in iOb (using unboxing)
        // Because the return type of getob() is T, which was replaced by Integer when iOb was declared, the return type of getob() is also Integer
        // This then unboxes to int, as v is specified as an int value.
        int v = intOb.getob();
        System.out.println("Value of v is: " + v + "\n");

        // Create a Gen reference for Strings
        Gen<String> strOb;

        // Create a Gen object as String, and assign its reference to strOb (using autoboxing)
        strOb = new Gen<String> ("Generics test");
        // alternative on one line: Gen<String> strOb = new Gen<String> ("Generics test");

        // Show the type of data used by strOb
        strOb.showType();

        // Get and display value of strOb (using unboxing)
        String str = strOb.getob();
        System.out.println("Value of str is: " + str + "\n");
    }
}