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

// Bounded Types
// Sometimes it's useful to limit the types that can be passed to a type parameter.
// For example when creating a generic class for a calculation that's only to handle numbers, you want to tell the compiler and ensure, that only numeric types are passed.
// This is possible by using 'bounded types': when specifying a type parameter, an upper bound can be created,
// that declares the superclass from which all type arguments must be derived.
// This is accomplished through the use of an extends clause when specifying the type parameter: <T extends superclass>
// See Stats example

public class Main {

    public static void main(String[] args) {

        // **********************
        // Generics example: using Gen class
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
        System.out.println("Value of v is: " + v);

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

        // **********************
        // Non-generics example: using nonGen class
        // **********************
        System.out.println("Non generics example");
        NonGen intOb2;

        // Create NonGen object and store an Integer in it (using autoboxing)
        intOb2 = new NonGen(88);

        // Show the type of data used by intOb2
        intOb2.showType();

        // Get the value of intOb2 - requiring a cast
        // When using generics, this cast was implicit.
        // In this non-generic version, the cast must be explicit.
        int v2 = (Integer) intOb.getob();
        System.out.println("Value of v2 is: " + v2);

        // Create another NonGen object and store a String in it
        NonGen strOb2 = new NonGen("Non-Generics test");

        // Show the type of data used by strOb2
        strOb2.showType();

        // Get the value of strOb2 - requiring a cast
        String str2 = (String) strOb2.getob();
        System.out.println("Value of str2 is: " + str2);

        // The following compiles as its syntactically valid, but is semantically wrong.
        // strOb2 is assigned to intOb2, however strOb2 refers to an object that contains a string, not an integer.
        // This wouldn't be possible using generics as it would type check.
        intOb2 = strOb2;

        // Resulting in a run-time error
        // The return type of getOb2 is cast to Integer and attempted to be assigned to v2.
        // But intOb2 now refers to a String, not an Integer.
        // Without the use of generics, the compiler has no way of knowing this, resulting in a run-time exception.
        // With generics, in essence, run-time errors are converted into compile-time errors.
     // v2 = (Integer) intOb2.getob();
        System.out.println();

        // **********************
        // Generics example with 2 type parameters: using TwoGen class
        // **********************
        System.out.println("Generics example with 2 type parameters");

        // Creating object
        // Passing values for both the TwoGen T and V type parameters, as Integer and String, which will substitute T and V
        // Note that it would also be possible to pass two type parameters of the same type
        // But that would using two type parameters unnecessary
        TwoGen<Integer, String> tgObj = new TwoGen<Integer, String>(88, "This is a string");

        // Showing the types
        tgObj.showTypes();

        // Obtaining and displaying the values
        int v3 = tgObj.getob1();
        System.out.println("Value of v3 is: " + v3);
        String str3 = tgObj.getob2();
        System.out.println("Value of str3 is: " + str3);
        System.out.println();

        // **********************
        // Generics example with bounded types: using Stats class
        // **********************
        System.out.println("Generics using bounded types");
        Integer inums[] = { 1, 2, 3, 4, 5 };
        Stats<Integer> intOb1 = new Stats<Integer>(inums);
        double avg = intOb1.average();
        System.out.println("average value of avg is: " + avg);

        Double dnums[] = { 1.11, 2.21, 3.32, 4.43 };
        Stats<Double> dOb = new Stats<Double>(dnums);
        double d = dOb.average();
        System.out.println("average value of d is: " + d);

        // The following wont compile as String is not a subclass of Number
//        String strs[] = { "1", "2", "3.1", "4.2" };
//        Stats<String> strings = new Stats<String>(strs);
//        double d2 = strings.average();
//        System.out.println("average value of d2 is: " + d2);

    }
}