package com.pbe;

// Example of a simple generic class hierarchy
class GenHierarchy<T> {

    // declare an object of type T
    T ob;

    // constructor that's passed a reference to an object of type T
    GenHierarchy(T o) {
        ob = o;
    }

    // return ob
    T getob() {
        return ob;
    }
}