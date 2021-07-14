package com.pbe;

// Example of a generic constructor
// A generic constructor is a constructor that has at least one parameter of a generic type.
// Note the class itself is not generic
// Generic constructors can be used in both generic and non generic classes
public class GenericConstructor {

    private double val;

    // Normal constructor - only exception double values
    GenericConstructor(double value) {
        val = value;
    }

    // Generic constructor
    // With a parameter element T, bounded with type Number (i.e.: Number is set as 'upper bound').
    // Using bounds, makes the constructor type safe
    <T extends Number> GenericConstructor(T value) {
        val = value.doubleValue(); // sets the passed value
    }

    // Displaying value
    void showval() {
        System.out.println("val is: " + val);
    }
}