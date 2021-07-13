package com.pbe;

// This class holds three-dimensional coordinates
public class ThreeD extends TwoD {
    int z;

    ThreeD(int a, int b, int c) {
        super(a, b); // calls TwoD constructor with passing a & b; this constructor saves a & b as x & y coordinates respectively
        z = c;
    }
}