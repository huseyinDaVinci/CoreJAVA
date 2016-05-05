package refactoreddesign;

/**
 * Created by barin.huseyin on 5/5/2016.
 */
public class TestMain {

    public TestMain() {


        _Movie movie1 = new _ChildrenMovie("narnia günlükleri");
        _Rental rental1=new _Rental(movie1,5);

        _Movie movie2 = new _NewReleaseMovie("subarro");
        _Rental rental2=new _Rental(movie2,8);

        _Movie movie3 = new _RegularMovie("Matrix");
        _Rental rental3=new _Rental(movie3,1);

        _Movie movie4 = new _RegularMovie("terminator");
        _Rental rental4=new _Rental(movie4,9);


        _Customer customer1 = new _Customer("cafer");

        customer1.addRental(rental1);
        customer1.addRental(rental2);
        customer1.addRental(rental3);
        customer1.addRental(rental4);

        System.out.println(customer1.statement());




    }

    public static void main(String[] args) {

        new TestMain();
    }
}
