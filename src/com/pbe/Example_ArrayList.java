package com.pbe;

import java.util.ArrayList;

public class Example_ArrayList {

    public static void main(String[] args) {

//        // Non-generic solution
        ArrayList items1 = new ArrayList(); // will cause a 'raw use of parameterized class' warning; i.e. hinting to use generics
        items1.add(1);
        items1.add(2);
        items1.add(3);
    //  items1.add("pieter"); // won't trigger a compilation error.. but will cause a runtime error as printDoubled1 casts to Integer
        items1.add(4);
        items1.add(5);
        printDoubled1(items1);

        // Generic solution
    //    ArrayList<Integer> items2 = new ArrayList<Integer>(); // will cause an 'explicit type argument warning; can be replaced with just <>
        ArrayList<Integer> items2 = new ArrayList<Integer>();
        items2.add(1);
        items2.add(2);
        items2.add(3);
    //  items2.add("pieter"); // will now immediately be indicated as error due to generic type safety
        items2.add(4);
        items2.add(5);
        printDoubled2(items2);
    }

//    // Non-generic solution
    private static void printDoubled1(ArrayList n) {
        System.out.println("Printer ArrayList contents, non generic solution");
        for(Object i : n) {
            System.out.println((Integer) i * 2); // need to cast
        }
        System.out.println();
    }

    // Generic solution
    private static void printDoubled2(ArrayList<Integer> n) {
        System.out.println("Printer ArrayList contents, generic solution");
        for(int i : n) {
            System.out.println( i * 2); // note: no need for a cast anymore
        }
        System.out.println();
    }
}