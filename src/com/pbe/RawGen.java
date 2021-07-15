package com.pbe;

// Example of 'raw type', a generic class without any type arguments
public class RawGen<T> {

    T ob; // declare an object of type T

    RawGen(T o) { // pass constructor a reference to an object of type T
        ob = o;
    }

    T getob() { // return ob
        return ob;
    }
}