package bikestore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by barin.huseyin on 2/4/2016.
 */
public class Main {


    public Main() {

        //Here at this point, Truck only will allow Products and subclass of it not the extends one()
        Truck<Product> t = new Truck<>();

        Bike bike = new Bike();
        Wheel wheel = new Wheel();

        Person person = new Person();
        MainProduct mainProduct = new MainProduct();

        t.addElement(bike);
        t.addElement(wheel);

       // t.addElement(person);  //compile time error
        // t.addElement(mainProduct);  //again compile time error even if MainProduct is the base class of Product....


        List<Product> productList = new ArrayList<>();
        List<Bike> bikeList = new ArrayList<>();

        getProducts(productList);
        //getProducts(bikeList);  //tatataa you can use it here since ArrayList<Product>  is not the base class of ArrayList<Bike>      Bike : Prodcut


        //we can handle that by using type boundries here
        getProductsTypeBound(productList);
        getProductsTypeBound(bikeList);
    }

    public void getProductsTypeBound(List<? extends Product> products) {   //only allows arraylist which holding type either Product or subclasses of it
    }

    public void getProducts(List<Product> products) {
    }

    public static void main(String[] args) {
        new Main();
    }

}
