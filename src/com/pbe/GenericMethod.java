package com.pbe;

// Example of a simple generic method
public class GenericMethod {

    // The below isIN() method determines if an object is an array
    // Remarks on this method:
    // - Because isIn is made static, it can be called independently of any object
    // - Note that the type parameters are declared BEFORE the method name
    // - T extends Comparable<T>, as such requiring an upper bound of Comparable
    //   Classes that implement Comparable, define objects that can be ordered
    //   Requiring an upper bound of Comparable ensures that isIn() can be used only with objects capable of being compared
    // - Comparable is generic, and its type parameter specifies the type of objects that it compares
    // - The type V is upper-bounded by T, meaning that V must either be of type T, or a subclass of T
    //   This relationship enforces that isIn() can be called only with arguments that are compatible

    static <T extends Comparable<T>, V extends T> void isIn(T x, V[] y) {
        boolean numfound = false;
        for (int i = 0; i < y.length; i++) {
            if (x.equals(y[i]) && !numfound) {
                System.out.println(x + " is in nums");
                numfound = true;
            } else if (i == (y.length - 1) && numfound == false)
                System.out.println(x + " is not in nums");
        }
    }

// Solution with boolean as return value -- note that for a generic method, the type parameter list precedes the return type
//    static <T extends Comparable<T>, V extends T> void boolean isIn(T x, V[] y) {
//        for (int i = 0; i < y.length; i++) {
//            if (x.equals(y[i]) return true;
//       return false;
//    }

    public static void main(String[] args) {

        // Create an array with integer values
        // And use isIn() to see if a given number is present in the nums array
        Integer nums[] = { 1, 2, 3, 4, 5 };
        isIn(3, nums);
        isIn(8, nums);

        // Note that isIn() can be called by use of the normal call syntax, without needing to specify specific type arguments
        // This is because the types of the arguments are automatically discerned, and the types of T and V are adjusted accordingly
        // If needed, the type argument can still be explicitly specified
        GenericMethod.<Integer, Integer>isIn(3, nums);

        // Create an array with String values
        // And use isIn() to see if a given String is present in the nums array
        String strs[] = { "one", "two", "three", "four", "five" };
        isIn("three", strs);
        isIn("eight", strs);

        // The following won't compile because the types are not compatible
        // isIn("two", nums);
    }
}