package myfavorites;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * Created by huseyinbarin on 5/22/17.
 */


@RunWith(value = Parameterized.class)
public class FindIntegerSquareRootCloseToGivenIntegerParameterizedTest {


    private int expected;
    private int value;

    @Parameterized.Parameters
    public static Collection<Integer[]> getTestParameters() {
        return Arrays.asList(new Integer[][]{
                {17, 300},
                {4, 20},
                {1, 1,},
        });
    }
    public FindIntegerSquareRootCloseToGivenIntegerParameterizedTest(int expected, int value) {
        this.expected = expected;
        this.value = value;

    }

    @Test
    public void findSquareOfInteger() throws Exception {
        int actual = FindIntegerSquareRootCloseToGivenInteger.findIntegerSquareRootCloseToGivenInteger(value);
        System.out.println(value + " => " + expected + "=" + actual);
        assertTrue(expected == actual);
    }
}


