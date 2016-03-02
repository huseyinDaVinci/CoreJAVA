package exercises;

import java.util.stream.IntStream;

/**
 * Created by barin.huseyin on 2/28/2016.
 */
public class Exercise1 {


    public static void main(String[] args) {

        Runnable runnable=()->IntStream.range(1,10).forEach(System.out::println);
        new Thread(runnable).start();








    }
}
