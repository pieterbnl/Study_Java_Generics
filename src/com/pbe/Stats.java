package com.pbe;

// ********
// Example using generics with bounded types
// ********
// This class computes the average of an array of numbers of a given type.
// By extending the type parameter T with Number, the provided type argument for T must be either Number, or a class derived from Number
class Stats<T extends Number> {

    // Array of Number or subclass
    T[] nums;

    // Constructor, passed a reference to an array of type Number or subclass
    Stats(T[] o) {
        nums = o;
    }

    // Return type double in all cases
    double average() {
        double sum = 0.0;

        for (int i=0; i <nums.length; i++)
            sum += nums[i].doubleValue(); // casting as double value

        return sum / nums.length;
    }
}