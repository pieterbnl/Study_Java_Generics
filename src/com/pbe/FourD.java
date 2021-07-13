package com.pbe;

// This class holds four-dimensional coordinates
public class FourD extends ThreeD {
    int t;

    FourD(int a, int b, int c, int d) {
        super(a, b, c); // calls ThreeD constructor with passing a, b & c; this constructor saves a, b & c as x, y & z coordinates respectively
        t = d;
    }
}