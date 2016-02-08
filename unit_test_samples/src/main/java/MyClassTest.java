import com.sun.istack.internal.NotNull;

/**
 * Created by barin.huseyin on 2/7/2016.
 */
public class MyClassTest {

    public static boolean isPalindrome(@NotNull String s) {

        if (s.length() == 1 || (s.charAt(0) == s.charAt(s.length() - 1) && s.length() == 2))
            return true;

        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            isPalindrome(s.substring(1, s.length() - 1));
        } else {
            return false;
        }
        return true;
    }


    public MyClassTest(){


    }

    public static void main(String[] args) {


        System.out.println("Test kavak is palindrome:" + isPalindrome("kavak"));
        System.out.println("Test canan is palindrome:" + isPalindrome("canan"));
        System.out.println("Test a is palindrome:" + isPalindrome("a"));
        System.out.println("Test ece is palindrome:" + isPalindrome("ece"));
        System.out.println("Test atta is palindrome:" + isPalindrome("attta"));
        System.out.println("Test atta is palindrome:" + isPalindrome("dfsfa"));

    }

}
