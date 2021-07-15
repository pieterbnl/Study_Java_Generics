package com.pbe;

// A subclass of GenHierarchy
// GenHierarchy2 extends from GenHierarchy
// With type parameter T specified by GenHierarchy2 and passed to GenHierarchy
// Meaning that whatever type is passed to GenHierarchy2 will also be passed to GenHierarchy

//class GenHierarchy2<T> extends GenHierarchy<T> {
//    GenHierarchy2(T o) {
//        super(o);
//    }

// It's also possible of course for a subclass to add it's own type parameters if needed
// Below a variation in which GenHierarchy2 adds a second type parameter of its own, called V
// Here, T is the type passed to GenHierarchy and V is the type that is specific to GenHierarchy2
class GenHierarchy2<T, V> extends GenHierarchy<T> {

    // declare an object of type T
    V ob2;

    // constructor passing a reference to an object of type T and V, of which T via the superclass
    GenHierarchy2(T o, V o2) {
        super(o);
        ob2 = o2;
    }

    V getOb2() {
        return ob2;
    }
}