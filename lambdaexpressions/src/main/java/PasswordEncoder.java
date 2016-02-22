import java.lang.*;

/**
 * Created by barin.huseyin on 2/21/2016.
 */

@java.lang.FunctionalInterface
public interface PasswordEncoder {

    public String encode(String password,String salt);
    //public String decode(String password,String salt);  will give a compilation error since this is a functional interface should be one.


}
