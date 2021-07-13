package com.pbe;

// ********
// Simple generic class example
// ********
// Because Gen uses a type parameter <T> it's a generic class, also referred to as a 'parameterized type'.
class Gen<T> {

    // Declare an object of type T with T being the name of a type parameter.
    // T is used as a placeholder for the actual type that will be passed to Gen when the object is created.
    // The name T has no special significance. It's common use to use T as identifier as type parameter.
    // And it's common use to use a single-character capital letter. Other commonly used type parameter names are V and E.
    // Note: as per JDK10 it's not possible to use 'var' as a type parameter name.
    T ob;

    // Constructor, which takes a reference to an object of type T
    Gen(T o) {
        ob = o; // ob will be an object of the type passed to T; if String is passed to T, then in that instance, ob will be of type String
    }

    // Return ob
    // Because ob is of type T, its type is compatible with the return type specified by getob()
    T getob() {
        return ob;
    }

    // Show type of T by calling getname() on the class object returned by the call getClass() on ob
    // The getClass() method is specified by Object and is therefore a member of all class types.
    // It returns a Class object that corresponds to the type of the class of the object on which it is called.
    // The getName() method returns a string representation of the class name.
    void showType() {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}