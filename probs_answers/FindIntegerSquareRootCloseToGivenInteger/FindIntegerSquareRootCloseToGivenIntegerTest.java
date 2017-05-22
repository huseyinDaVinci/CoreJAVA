package myfavorites;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Created by huseyinbarin on 5/21/17.
 */
public class FindIntegerSquareRootCloseToGivenIntegerTest {


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void findSquareOfIntegerWithException() throws Exception {
        expectedException.expect(Exception.class);
        expectedException.expectMessage("k cannot be lower than zero.");
        FindIntegerSquareRootCloseToGivenInteger.findIntegerSquareRootCloseToGivenInteger(-8);

    }

    @Test
    public void findSquareOfInteger() throws Exception {
        int[] k = {1, 300, 17, 26, 37, 100};
        int[] expected = {1, 17, 4, 5, 6, 10};
        int[] actual = new int[k.length];

        for (int i = 0; i < k.length; i++) {
            actual[i] = FindIntegerSquareRootCloseToGivenInteger.findIntegerSquareRootCloseToGivenInteger(k[i]);
            System.out.println(k[i] + " => " + expected[i] + " =" + actual[i]);
            assertTrue(expected[i] == actual[i]);
        }
    }

    @Test
    public void findSquareOfInteger2() throws Exception {
        int[] k = {1, 300, 17, 26, 37, 100};
        int[] expected = {1, 17, 4, 5, 6, 10};
        int[] actual = new int[k.length];

        for (int i = 0; i < k.length; i++) {
            actual[i] = FindIntegerSquareRootCloseToGivenInteger.findIntegerSquareRootCloseToGivenInteger2(k[i]);
            System.out.println(k[i] + " => " + expected[i] + " =" + actual[i]);
            assertTrue(expected[i] == actual[i]);
        }
    }

}