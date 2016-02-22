import java.util.function.Consumer;

/**
 * Created by barin.huseyin on 2/22/2016.
 */

/**
 * Just to know that: The signature of the referenced method needs to match the signature of the functional interface method..
 */
public class MethodReferences {


    public static void doSomething(int i) {
        System.out.println("The result is :" + i);
    }


    public static void main(String[] args) {

        //ALL will print the same results but using a different approach

        Consumer<Integer> consumer1 = x -> System.out.println("The result is :" + x);  //this is normal expression HOWEVA.. there is already a written one available.
        consumer1.accept(3);
        Consumer<Integer> consumer2 = x -> doSomething(x);  //this is using static method existing and doing the same job .
        consumer2.accept(6);
        Consumer<Integer> consumer3 = MethodReferences::doSomething;  //this is using the class's method.
        consumer2.accept(9);

    }

}
