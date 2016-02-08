import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class SortingTest {
    MySecondClassTest secondClassTest = new MySecondClassTest();

    @Test(timeout = 100)
    public void shouldArraySorted() {


        assertArrayEquals(secondClassTest.sortArrayWithBubble(new int[]{2, 11, 5, 99}), new int[]{2, 5, 11, 99});
        assertArrayEquals(secondClassTest.sortArrayWithBubble(new int[]{-2, 11, 5, -99}), new int[]{-99, -2, 5, 11});

    }

    @Before
    public void beforeSouldThrowException(){

        System.out.println("beforeSouldThrowException");

    }

    @After
    public void afterShouldThrowException(){

        System.out.println("afterShouldThrowException");
    }

    @Test(expected = RuntimeException.class)   //we are sure that this method throw exception not just catch, throw also.
    public void shouldThrowException() {
        try {
            System.out.println("shouldThrowException");
            secondClassTest.makeOperation();
        } catch (Exception ex) {
            System.out.println("a new error more..");
            throw ex;
        }
    }
}
