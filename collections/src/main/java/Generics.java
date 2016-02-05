import java.util.*;

/**
 * Created by barin.huseyin on 2/4/2016.
 */
public class Generics {

    //<K> -key  <V>-value   <T>-type  <E>-element    generally used by the programmers

    //ensure the type safe  like we used in Collections generally


    public Generics() {

        //for example ArrayList's source code.
        /*public class ArrayList<E> extends AbstractList<E>
                implements List<E>, RandomAccess, Cloneable, java.io.Serializable

         As possible as get the error in compile time instead of runtime.  If we declared the arraylist: new ArrayList() as raw type
         this means that any type of object can be inserted.
         However if we declare like :  List<String>   <E> will be replaced with <String> and no other types will be allowed.

        */

        List<String> testList=new ArrayList<>();   //no need write <String> again

        processData(testList);

    }


    public void processData(List<?> elements){


    }


    public static void main(String[] args) {

        new Generics();


    }


}
