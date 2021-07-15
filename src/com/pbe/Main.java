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

// Java generic type naming convention
// Generics comes with its own naming conventions.
// Usually, type parameter names are single, uppercase letters to make it easily distinguishable from java variables.
// The most commonly used type parameter names are:
// - E: Element (used extensively by the Java Collections Framework, for example ArrayList, Set etc.)
// - K: Key (Used in Map)
// - N: Number
// - T: Type
// - V: Value (Used in Map)
// - S,U,V etc.: 2nd, 3rd, 4th types

// Bounded Types
// Sometimes it's useful to limit the types that can be passed to a type parameter.
// For example when creating a generic class for a calculation that's only to handle numbers, you want to tell the compiler and ensure, that only numeric types are passed.
// This is possible by using 'bounded types': when specifying a type parameter, an upper bound can be created,
// that declares the superclass from which all type arguments must be derived.
// This is accomplished through the use of an extends clause when specifying the type parameter: <T extends superclass>
// See Stats example

// Using wildcard arguments
// Sometimes, type safety gets in the way of perfectly acceptable constructs.
// For example in the Stats model, when you would like to add an method that determines if two Stat objects contain arrays that yield the same average, no matter their type of numeric data.
// However, because Stats is a parameterized type, what to be specified for Stats' type parameter when declaring a parameter of that type?
// Comparing the averages of 2 Stat objects will require both Stats objects type to be equal. For example, both should be of type Integer or Double.
// To create a generic average value comparison method, requires the use of the Java generics feature: the 'wildcard argument'.
// The wildcard argument is specified by ? and it represents an unknown type.
// See Stats2 example

// Bounded wildcards
// Wildcard arguments can be bounded in a similar fashion as a type parameter can be bounded.
// Bounded wildcards are especially important when creating a generic type that operates on a class hierarchy.
// See BoundedWildCard class example
// This example consists of a two-dimensional (TwoD), three-dimensional (ThreeD) and four-dimensional (FourD) class, that respectively store xy, xyz, and xyzt coordinates.
// With the four-d class extending from three-d and the three-d class extending from two-d. I.e. it's an hierarchy of classes.
// A separate class, Coords, is used to hold an array of coordinate objects, which can be objects of any of the just mentioned classes.
// When adding a method that displays X, Y and Z coordinates for each element in the coordinates array, this will be a problem with TwoD being the top class, having only X Y coordinates.
// To write a method that displays X, Y and Z coordinates for the ThreeD and FourD class, while preventing that method from being used with TwoD objects,
// a "bounded wildcard argument" can be used.
// This enables to restrict the type of objects upon which a method will operate.
//
// The most common bounded wildcard is the upper bound, which is created using and extend clause,
// in much the same way it's used to create a bounded type. Form: <? extends superclass>
// Where superclass is the name of the class that serves as upper bound and which is an inclusive clause (it will include both the specified class as well as it's subclasses).
// It's also possible to specify a lower bound by using super: <? super subclass>
// In this case, only classes that are superclasses of subclass are acceptable arguments. This is an inclusive clause as well.

// Generic method
// Methods inside a generic class, can make use of a class' type parameter.
// By doing so, these methods are automatically generic, relative to the type parameter.
// It's possible to declare a generic method that uses one or more type parameters of its own.
// It's possible to create a generic method that is enclosed within a non-generic class.

// Generic constructor
// A generic constructor is a constructor that has at least one parameter of a generic type.
// Generic constructors are the same as generic methods. For generic constructors after the public keyword and before the class name the type parameter must be placed.
// Constructors can be generic, even its class is not generic.
// See GenericConstructor example

// Generic interface
// Generic interfaces in Java are the interfaces that deal with abstract data types.
// They are specified just like generic classes.
// If a class implements a generic interface, then the class must also be generic.
// At least to the extend that it takes a type parameter passed to the interface.
// A generic interface offers two benefits:
// 1. It can be implemented for different types of data.
// 2. It allows constraints (read: bounds) to be used on the types of data for which the interface can be implemented.

// Raw types and legacy code
// Generics did not exists prior to JDK5.
// To handle the transition to generics, Java allows a generic class to be used without type arguments.
// This creates a 'raw type' of the class, which is compatible with legacy code.
// Main drawback is the loss of type safety of generics.
// See RawGen example
// Raw types should only be used in those cases where legacy code is mixed with newer, generic code.
// Raw types are a transitional feature. Not something to be used for new code.

// Generic class hierarchies
// Generic classes can be part of a class hierarchy, like a non generic-class, and act as a superclass or be a subclass.
// However, key difference between generic and non generic hierarchies:
// In a generic hierarchy, any type arguments needed by a generic superclass must be passed up the hierarchy by all subclasses.
// Similar to how constructor arguments must be passed up a hierarchy.
// See GenHierarchy example
//
// Note: A non-generic class can be the superclass of a generic subclass
//
// Run-time type comparisons within a generic hierarchy
// Operator 'instanceof' determines if an object is an instance of a class.
// It returns true if an object is of the specified type or can be cast to the specified type.
// It can be applied to objects of generic classes.
// See example involving Gen and Gen2

// Casting
// It's possible to cast one instance of a generic class into another.
// But only if the two are compatible and their type arguments are the same.

// Overriding methods in a generic class
// a Method in a generic class can be overridden  like any other method.

// Type inference with generics
// As per JDK7 it's possible to shorten the syntax used to create an instance of a generic type.
// Instead of specifying type arguments twice:
//      MyClass<Integer, String> mcOb = new MyClass<Integer, String>(01, "some text");
// The following, less verbose syntax, is also correct:
//      MyClass<Integer, String> mcOb = new MyClass<>(01, "some text");
// The 'diamond' operator <> tells the compiler to infer the type arguments by the constructor in the new expression.
//
// Type inference can also be applied to parameter passing. For example, with:
//      boolean isSame(MyClass<T, V> o) {
//          if(ob1 == o.ob1 && ob2 == o.ob2) return true;
//          else return false
//          }
// The following call is legal: if (mcOb.isSame(new MyClass<>(1, "test")) System.out.println("Same");
// Here, the type arguments for the argument passed to isSame() is inferred from the parameter's type.

// Local variable type inference and generics
// As per JDK10, it's also possible to use the new local variable type inference feature (var)
// For example, this declaration:
// MyClass<Integer, String> mcOb = new MyClass<Integer, String>(11, "some text");
// Can also be rewritten like this, using local variable type reference:
// var mcOb = new MyClass<Integer, String>(11, "some text");
// Here, the type of mcOb is inferred to be MyClass<Integer,String> because that's the type of initializer.

// Type Erasure
// Generics were introduced to the Java language to provide tighter type checks at compile time and to support generic programming.
// To implement generics, while maintaining compatible with preexisting, non generic code, type eraser is applied.
// Type erasure ensures that no new classes are created for parameterized types.
// Consequently, generics incur no runtime overhead.
// The Java compiler applies type erasure to:
// - Replace all type parameters in generic types with their bounds or Object if the type parameters are unbounded.
//   The produced bytecode, therefore, contains only ordinary classes, interfaces, and methods.
// - Insert type casts if necessary to preserve type safety.
// - Generate bridge methods to preserve polymorphism in extended generic types.
//
// Sometimes type erasure causes a situation that may not have been anticipated.
// For example when sometimes the compiler creates a synthetic method (which is called a bridge method),
// as part of the type erasure process.
// After type erasure, method signatures do not match.
// For example a method "Node.setData(T)" becomes "Node.setData(Object)"
// As a result, the MyNode.setData(Integer) method does not override the Node.setData(Object) method.
// The compiler will generate a bridge method to ensure that subtyping works as expected.

// Non-reifiable types / heap pollution
// t.b.d

// Generic restrictions
// There are a few restrictions to keep in mind when using generics,
// involving creation of objects of a type parameter, static members, exceptions and arrays.
// - Type parameters can't be instantiated
//   It's not possible to create an instance of a type parameter. The following is not possible: ob = new T()
// - Restrictions on static members
//   No static member can use a type parameter declared by the enclosing class.
// - Generic Array restrictions
//   Two important generic restrictions apply to arrays:
//   1. You cannot instantiate an array whose element type is a type parameter. This won't work: vals = new T[10]
//   2. You cannot create an array of type-specific generic references. This won't work: Gen<Integer> gens[] = new Gen<Integer>[10]
//   It's not possible to create an array of T because there is no way for the compiler to know what type of array to create.
//   You CAN create an array of references to a generic type with the use of a wildcard: Gen<?> gens[] = new Gen<?>[10]
// - Generic exception restriction
//   A generic class cannot extend Throwable, meaning that you can't create generic exception classes.

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
        strOb = new Gen<String>("Generics test");
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
        Integer inums[] = {1, 2, 3, 4, 5};
        Stats<Integer> intOb1 = new Stats<Integer>(inums);
        double avg = intOb1.average();
        System.out.println("average value of intOb1 is: " + avg);

        Double dnums[] = {1.11, 2.21, 3.32, 4.43};
        Stats<Double> dOb = new Stats<Double>(dnums);
        double d = dOb.average();
        System.out.println("average value of dOb is: " + d + "\n");

        // The following wont compile as String is not a subclass of Number
//        String strs[] = { "1", "2", "3.1", "4.2" };
//        Stats<String> strings = new Stats<String>(strs);
//        double d2 = strings.average();
//        System.out.println("average value of strings is: " + d2);

        // **********************
        // Generics example using a wildcard: using Stats2 class
        // **********************
        System.out.println("Generics using a wildcard");
        Integer intnums[] = { 1, 2, 3, 4, 5 };
        Stats2<Integer> integersOb = new Stats2<Integer>(intnums);
        double intavg = integersOb.average();
        System.out.println("average value of integersOb is: " + intavg);

        Double dblnums[] = { 1.11, 2.21, 3.32, 4.43 };
        Stats2<Double> doublesOB = new Stats2<Double>(dblnums);
        double dblavg = doublesOB.average();
        System.out.println("average value of dOb2 is: " + dblavg);

        Float fltnums[] = { 1.0F, 2.0F, 3.0F, 4.0F };
        Stats2<Float> floatsOb = new Stats2<Float>(fltnums);
        double fltavg = floatsOb.average();
        System.out.println("average value of floatsOb is: " + fltavg);

        // See which arrays have the same average
        System.out.println("Averages of integersOb & floatsOb: ");
        if (integersOb.sameAvg(floatsOb))
            System.out.println("are the same.");
        else
            System.out.println("differ.");
        System.out.println();

        // **********************
        // Generics example using bounded wildcard arguments
        // See BoundWildCard class example, which involves classes TwoD, ThreeD, FourD and Coords
        // **********************
        System.out.println("Generics example using bounded wilcdcard arguments");
        System.out.println("..." + "\n");

        // **********************
        // Generic method example
        // See GenericMethod class
        // **********************
        System.out.println("Generics method example");
        System.out.println("..." + "\n");

        // **********************
        // Generic constructor example
        // **********************
        System.out.println("Generic constructor");
        GenericConstructor genconOb1 = new GenericConstructor(50);
        GenericConstructor genconOb2 = new GenericConstructor(101.5F);
        genconOb1.showval();
        genconOb2.showval();
        System.out.println();

        // **********************
        // Generic interface example
        // **********************
        System.out.println("Generic interface");
        Integer intvalues[] = { 2, 1, 9, 8, 3 };
        Character charvalues[] = { 'p', 'b', 'w', 'h', 't' };

        MyClass<Integer> iOb = new MyClass<>(intvalues);
        MyClass<Character> cOb = new MyClass<>(charvalues);

        System.out.println("Max val in intvalues: " + iOb.max());
        System.out.println("Min val in intvalues: " + iOb.min());

        System.out.println("Max val in charvalues: " + cOb.max());
        System.out.println("Min val in charvalues: " + cOb.min());
        System.out.println();

        // **********************
        // Raw type example
        // **********************
        System.out.println("Raw type example");
        // create a RawGen object for integers
        RawGen<Integer> rawgen_iOb = new RawGen<Integer>(88);

        // create a RawGen object for Strings
        RawGen<String> rawgen_strOb = new RawGen<String>("Raw type test");

        // create a raw-type RawGen object, and give it a double value
        // Notice that no type arguments are specified
        // This in essence results in the creation of a RawGen object whose type T is replaced by Object
        RawGen rawgen = new RawGen(Double.valueOf(11.12));

        double dbl = (Double) rawgen.getob(); // cast is required because type is unknown
        System.out.println("value of dbl is: " + dbl);

        // Examples of the use of raw type leading to run-time exceptions
        // A raw type is not type safe.
        // Meaning, a variable of a raw type can be assigned a reference to any type of RawGen object.
        // Or reverse: a variable of a specific RawGen type can be assigned a reference to a raw RawGen object.
        // Both operations are potentially unsafe because the type checking mechanism of generics is circumvented.
    //  int i = (Integer) rawgen.getob(); // this cast will cause a ClassCastException
    //  rawgen_strOb = rawgen.getob(); // this assignment overrides type safety; both are of different types, which cannot be detected at compile time because the rawgen type is unknown
    //  String strvalue = rawgen_strOb.getob();
    //  rawgen = rawgen_iOb; // works, but is potentially wrong
    //  dbl = (Double) rawgen.getob();
        System.out.println();

        // **********************
        // Generic class hierarchies
        // **********************
        // In this example, Gen2 is a subclass of Gen, which is generic on type Parameter T
        // Three objects are created on which several instanceof tests are performed
        // The use of wildcards enables instanceof to determine if the given object is of the tested type.

        System.out.println("Example of generic class hierarchy");

        // Create a GenHierarchy2 object for String and Integer
        GenHierarchy2<String, Integer> x =
                new GenHierarchy2<String, Integer>("It's value is: ", 01);
        System.out.print(x.getob());

        System.out.println(x.getOb2() + "\n");

        // **********************
        // Run-time type comparisons within a generic hierarchy
        // **********************
        System.out.println("Example of run-time type comparisons within a generic hierarchy");

        // Create a Gen object for Integers
        Gen<Integer> int_genOb = new Gen<Integer>(11);

        // Create a Gen2 object for Integers
        Gen2<Integer> int_genOb2 = new Gen2<Integer>(22);

        // Create a Gen2 object for Strings
        Gen2<String> str_genOb = new Gen2<String>("This is a string of text");

        // See if int_genOb2 is some form of Gen2
        if(int_genOb2 instanceof Gen2<?>)
            System.out.println("int_genOb2 is an instance of Gen2");

        // See if int_genOb2 is some form of Gen
        if(int_genOb2 instanceof Gen<?>)
            System.out.println("int_genOb2 is an instance of Gen \n");

        // See if str_genOb is some form of Gen2
        if(str_genOb instanceof Gen2<?>)
            System.out.println("str_genOb is an instance of Gen2");

        // See if str_genOb is a Gen
        if(str_genOb instanceof Gen<?>)
            System.out.println("str_genOb is an instance of Gen \n");

        // see if int_genOb is an instance of Gen2 (which it's not)
        // int_genOb is not some type of Gen2 object
        if(int_genOb instanceof Gen2<?>)
            System.out.println("int_genOb is an instance of Gen2");

        // see if int_genOb is an instance of Gen (which it is)
        if(int_genOb instanceof Gen<?>)
            System.out.println("int_genOb is an instance of Gen");

        // The following will cause a compile error,
        // as generic type info (i.e. the specifying on Integer in this example) is not available at run time
        // Therefore there is no way for instanceof to know if int_genOb2 is an instance of Gen2<Integer>
    //  if(int_genOb2 instanceof Gen<Integer>)
    //      System.out.println("int_genOb2 is an instance of Gen2<Integer>");
    }
}