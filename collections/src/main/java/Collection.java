import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by barin.huseyin on 2/4/2016.
 */
public class Collection {


    public void arrayLists() {

        /**
         * ArrayLists in runtime dynamically increase or decrease its size (internally use array actually :))
         * Do not accept primitive types,  allow duplication of elements
         *
         */

    }
    public <T> void getList(List<T> array) {

        array.forEach(t -> System.out.println(t));

    }

    public Collection() {
        List<String> names = new ArrayList<String>();
        Set<String> namesSet = new HashSet<String>();


        for (int i = 10; i-- > 0; ) {
            names.add("Test" + i);
        }

        for (int i = 8; i-- > 0; ) {
            System.out.println("Result:" + namesSet.add("Test" + i));
            System.out.println("Result:" + namesSet.add("Test" + i));
        }


        //Java 8 style like RxJava
        names.forEach(name -> System.out.println(name));


    }


    public static void main(String[] args) {
        new Collection();
    }

}
