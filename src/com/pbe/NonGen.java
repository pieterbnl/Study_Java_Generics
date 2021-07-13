package com.pbe;

// ********
// A non generic version of Gen
// ********
// Using Object, this makes NonGen able to store any type of object, like the generic version.
// At the same time it prevents the compiler from having any real knowledge about the type of data actually stored in NonGen.
// This is bad for 2 reasons:
// 1. Explicit casts must be used to retrieve the stored data
// 2. Potential mismatch errors will only reveal themselves at run-time
class NonGen {

    // Declare an object of type Object
    Object ob;

    // Constructor, passing a reference to an object of type Object
    NonGen(Object o) {
        ob = o;
    }

    // Return type Object
    Object getob() {
        return ob;
    }

    // Show type of ob
    void showType() {
        System.out.println("Type of ob is: " + ob.getClass().getName());
    }

}