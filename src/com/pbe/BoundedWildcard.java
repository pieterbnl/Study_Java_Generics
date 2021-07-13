package com.pbe;

public class BoundedWildcard {

    // method to show X, Y coordinates
    static void showXY(Coords<?> c) {
        System.out.println("X Y coordinates: ");
        for (int i = 0; i < c.coords.length; i++) // looping through the coords array, displaying the applicable coordinates
            System.out.println(c.coords[i].x +
                    " " + c.coords[i].y);
        System.out.println();
    }

    // method to show X, Y, Z coordinates
    // extending from ThreeD as a bounded wildcard argument
    // limiting operation of this method to the ThreeD class and it's subclasses only
    static void showXYZ(Coords<? extends ThreeD> c) {
        System.out.println("X Y Z coordinates: ");
        for (int i = 0; i < c.coords.length; i++) // looping through the coords array, displaying the applicable coordinates
            System.out.println(c.coords[i].x +
                    " " + c.coords[i].y +
                    " " + c.coords[i].z);
        System.out.println();
    }

    // method to show X, Y, Z, T coordinates
    // extending from FourD as a bounded wildcard argument
    // limiting operation of this method to the FourD class and it's subclasses only
    static void showAll(Coords<? extends FourD> c) {
        System.out.println("X Y Z T coordinates: ");
        for (int i = 0; i < c.coords.length; i++) // looping through the coords array, displaying the applicable coordinates
            System.out.println(c.coords[i].x +
                    " " + c.coords[i].y +
                    " " + c.coords[i].z +
                    " " + c.coords[i].t);
        System.out.println();
    }

    public static void main(String[] args) {

        // Creating an array with Two-D objects, passing 2-d coordinates for x, y
        TwoD td[] = {
                new TwoD(0, 0),
                new TwoD(7, 9),
                new TwoD(18, 4),
                new TwoD(-1, -23),
        };

        // Creating an object of type Coords, supplied with a Two-D object, holding two-d coordinates
        Coords<TwoD> tdlocs = new Coords<TwoD>(td);

        // Displaying TwoD coordinates
        System.out.println("Contents of tdlocs.");
        showXY(tdlocs);  // calling showXY to print the X, Y coordinates
        // showXYZ(tdlocs); // causes compilation error as this method demands a ThreeD object to operate - bounded wildcard arguments prevent it
        // showAll(tdlocs); // causes compilation error as this method demands a FourD object to operate - bounded wildcard arguments prevent it

        // Creating an array with Four-D objects, passing 4-d coordinates for x, y, z, t
        FourD fd[] = {
                new FourD(1, 2, 3, 4),
                new FourD(6, 8, 14, 8),
                new FourD(22, 9, 4, 9),
                new FourD(3, -2, -23, 17)
        };

        // Creating an object of type Coords, supplied with a Four-D object, holding four-d coordinates
        Coords<FourD> fdlocs = new Coords<FourD>(fd);

        // Displaying FourD coordinates
        System.out.println("Contents of fdlocs.");
        showXY(fdlocs); // calling showXY to print the X, Y coordinates
        showXYZ(fdlocs);  // calling showXY to print the X, Y, Z coordinates
        showAll(fdlocs);  // calling showXY to print the X, Y, Z, T coordinates
    }
}