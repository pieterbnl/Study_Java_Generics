package com.pbe;

// MyClass implements the GenericInterface interface
// T is set to extend Comparable and is then passed to the GenericInterface
// Because GenericInterface requires a type that implements Comparable,
// the implementing class (MyClass), must specify the same bound.
//
// Once the bound is established, it does not need to be specified again in the implements clause:
// - Good: class MyClass<T extends Comparable<T>> implements GenericInterface<T> {
// - Wrong: class MyClass<T extends Comparable<T>> implements GenericInterface<T extends Comparable<T>> {
//
// Once the type parameter has been established, it's simply passed to the interface directly.
class MyClass<T extends Comparable<T>> implements GenericInterface<T> {
    T[] myvalues;

    MyClass(T[] o) {
        myvalues = o;
    }

    // Return the minimum value in myvalues
    public T min() {
        T v = myvalues[0];
        for (int i = 1; i < myvalues.length; i++)
            if (myvalues[i].compareTo(v) < 0) v = myvalues[i];
        return v;
    }

    // Return the maximum value in myvalues
    public T max() {
        T v = myvalues[0];
        for (int i = 1; i < myvalues.length; i++)
            if (myvalues[i].compareTo(v) > 0) v = myvalues[i];
        return v;
    }
}