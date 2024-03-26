package StarFighter;

import java.io.*;
import java.util.*;
import static java.lang.System.*;

/**
 * Runs Ship to test accuracy.  Contains main method.
 * @author Alice
 */
public class Shiptest
{
    /**
     * Main method to run Ship to test accuracy
     * @param args The standard default array for main methods
     */
    public static void main( String args[] )
    {
        MovingThing test = new Ship();
        System.out.println("Ship 1 " + test.toString());

        Ship test2 = new Ship(50,75);
        System.out.println("Ship 2 " + test2.toString());

        Ship test3 = new Ship();
        test3.setX(3);
        test3.setY(5);
        System.out.println("Ship 3 " + test3.toString());
    }
}
