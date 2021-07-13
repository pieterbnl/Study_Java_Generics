package com.pbe;

// ********
// Example of declaring more than one type parameter in a generic type, using a comma-seperated list.
// ********
class TwoGen<T, V> { // two type parameters are defined: T and V

    T ob1;
    V ob2;

    // Constructor, passed a reference to an object of type T and type V
    TwoGen(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }

    // Show types of T and V
    void showTypes() {
        System.out.println("Type of T is: " + ob1.getClass().getName());
        System.out.println("Type of V is: " + ob2.getClass().getName());
    }

    T getob1() {
        return ob1;
    }

    V getob2() {
        return ob2;
    }
}
