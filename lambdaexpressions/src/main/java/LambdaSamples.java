import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by barin.huseyin on 2/21/2016.
 */
public class LambdaSamples {


    public LambdaSamples() {

        printAListOfIntegers();

    }

    private void printAListOfIntegers() {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> names = Arrays.asList("bora", "ilker", "bülent");

        //integers.forEach(i-> System.out.println(i));
        Consumer<Integer> consumer = x -> System.out.println(x);
        integers.forEach(consumer);



        integers.forEach(i -> {
            i += 10;
            System.out.println(i);
        });

            /*
                 public void print(T i){
                    System.out.println(i);
                 }
                 i->System.out.println(i)   is lambda expression that defines an anonymous function with one parameter named x of type integer.
            */


    }

    public static void main(String[] args) {

        new LambdaSamples();
    }


}
