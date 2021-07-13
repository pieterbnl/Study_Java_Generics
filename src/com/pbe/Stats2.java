package com.pbe;

// ********
// Example using generics with bounded types
// Copy of Stats class, but now using a wildcard argument
// ********
// This class computes the average of an array of numbers of a given type.
// By extending the type parameter T with Number, the provided type argument for T must be either Number, or a class derived from Number
class Stats2<T extends Number> {

    // Array of Number or subclass
    T[] nums;

    // Constructor, passed a reference to an array of type Number or subclass
    Stats2(T[] o) {
        nums = o;
    }

    // Return type double in all cases
    double average() {
        double sum = 0.0;
        for (int i=0; i <nums.length; i++)
            sum += nums[i].doubleValue(); // casting as double value
        return sum / nums.length;
    }

    // Determine if two averages are the same, using a wildcard
    // Note that the wildcard does NOT affect what type of Stats2 objects can be created.
    // This is governed by the extends clause in the Stats declaration.
    // The wildcard simply matches any valid Stats object.
    boolean sameAvg(Stats2<?> ob) {
        if(average() == ob.average())
            return true;
        else
            return false;
    }
}