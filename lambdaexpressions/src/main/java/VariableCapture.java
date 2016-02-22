import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by barin.huseyin on 2/21/2016.
 */
public class VariableCapture {

    static int staticCounter = 0;

    private static VariableCapture VARIABLE_CAPTURE = new VariableCapture();
    List<Integer> digits = Arrays.asList(1, 2, 3, 4, 5);
    public int number=3;

    public void doExercise() {

        int num = 369;
        digits.forEach(x -> System.out.println(num + x));  //variable capturing with "num" outside of the lambda expression.


        int counter = 0;
        digits.forEach(x -> {

            /*Local variable counter defined in an enclosing scope must be final or effectively final
                counter++;

                //because this will be generated like this.. while compiling...
                public static void generatedForEachName(Integer x,final int num){
                        System.out.println(x+num);}*/

        });


        //capturing static variables
        digits.forEach(i -> {
            staticCounter++;
            if (this == VARIABLE_CAPTURE) {
                System.out.println("Yeap this points enclosing lambda object...");
            }
            System.out.println(staticCounter + i);
        });

    }

    public void doSomething(){

        digits.forEach(new Consumer<Integer>() {
            int localNumber=6;
            @Override
            public void accept(Integer integer) {
                int res=this.localNumber+integer+VariableCapture.this.number;
                System.out.println("Anonymous class:"+ res);
            }
        });


    }
    public static void main(String[] args) {

        VARIABLE_CAPTURE.doExercise();
        VARIABLE_CAPTURE.doSomething();

    }


    //Effectively final...

}
