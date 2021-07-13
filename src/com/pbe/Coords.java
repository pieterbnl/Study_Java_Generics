package com.pbe;

// This class holds an array of coordinate objects.
// Coords is a generic class/parameterized type as it specifies a type parameter <T>,
// which in turn is 'bounded' as it extends TwoD.
// By extending TwoD, TwoD is set as upper bound for Coords,
// meaning all supplied objects must be of class TwoD or its subclasses.
public class Coords<T extends TwoD> {
    T[] coords;

    // Constructor - accepts an array of coordinate objects
    Coords(T[] o) {
        coords = o;
    }
}