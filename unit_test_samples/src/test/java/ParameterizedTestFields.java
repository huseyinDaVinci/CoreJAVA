import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ParameterizedTestFields {


    private String stringTested;
    private MyClass myClass;



    @Parameterized.Parameter(value = 0)
    public String testString;


    @Parameterized.Parameters
    public static Collection<Object[]> dataString() {
        Collection<String> coll = Arrays.asList("kavak", "ala", "ısı", "talat");

        Collection<Object[]> params = new ArrayList<Object[]>();
        for (String s : coll) {
            params.add(new Object[]{s});
        }
        return params;
    }





    @Before
    public void beforePalindromeTsst() {
        myClass = new MyClass();
    }

    @Test
    public void shouldCheckBePalindromeCorrectly() {
        System.out.println(String.format("%s will be test as a palindrome or not..", testString));
        assertEquals("Result:", String.valueOf(MyClassTest.isPalindrome(testString)), String.valueOf(true));
    }






/*

    @Test
    public void shouldMultipleEqual() {

        MyClass tester = new MyClass();
        assertEquals("Result", m * n, tester.multiply(m, n));
    }
*/


    class MyClass {
        public int multiply(int m, int n) {
            return (m == 0 || n == 0) ? 0 : m * n;
        }
    }


}
