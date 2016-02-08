import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class PalindromeTest {



    MyClassTest myClassTest=new MyClassTest();

    @Test
    public void shouldBePalindrome(){

        assertEquals(String.valueOf(myClassTest.isPalindrome("kavak")), String.valueOf(true));
        assertEquals(String.valueOf(myClassTest.isPalindrome("ada")), String.valueOf(true));
        assertEquals(String.valueOf(myClassTest.isPalindrome("lale")), String.valueOf(false));
        assertEquals(String.valueOf(myClassTest.isPalindrome("a")), String.valueOf(true));
    }



}
