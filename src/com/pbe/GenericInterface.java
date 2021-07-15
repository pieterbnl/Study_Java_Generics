package com.pbe;

// Generic interface example
// A generic interface is declared in the same manner as a generic class.
// Here, T is the type parameter, and it's upper bound is Comparable,
// meaning only types that implement the Comparable interface can be passed to T.
//  Note: comparable -an interface defined by java.lang- specifies how objects are compared.
// It's type parameter specifies the type of the objects being compared.
interface GenericInterface<T extends Comparable<T>> {
    T min();
    T max();
}