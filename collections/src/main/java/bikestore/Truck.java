package bikestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by barin.huseyin on 2/4/2016.
 */


//lets say this truck will carry on only products bike and wheel
public class Truck<T> {


    List<T> elements=new ArrayList<>();

    public void addElement(T t){

        elements.add(t);
    }

}
