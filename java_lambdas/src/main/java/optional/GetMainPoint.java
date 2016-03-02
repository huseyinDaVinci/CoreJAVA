package optional;

import java.util.Optional;

/**
 * Created by barin.huseyin on 2/29/2016.
 */
public class GetMainPoint {



    public static void showMessage(Optional<String> message){

        System.out.println("Coming name:" + message);
        System.out.println("look I continues");

    }



    public static void main(String[] args) {

        Optional<String> name=Optional.empty();

        name=null;

        showMessage(name);





    }

}
