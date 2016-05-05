package refactoreddesign;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by barin.huseyin on 5/5/2016.
 */
public class _Customer {

    private final Vector _rentals = new Vector();
    private String _name;

    public _Customer(String name) {
        _name = name;
    }

    public void addRental(_Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;


        Enumeration rentals = _rentals.elements();
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for ");
        result.append(getName());
        result.append("\n");

        while (rentals.hasMoreElements()) {
            _Rental each = (_Rental) rentals.nextElement();
            // add frequent renter points
            frequentRenterPoints++;
            if (each.hasBonus()) {
                System.out.println(each.getMovie().toString() + " has bonus");
                frequentRenterPoints++;
            }
            result.append(each.toString());
            result.append("\n");
            totalAmount += each.calculateAmount();
        }


        //add footer lines
        result.append("Amount owed is ");
        result.append(String.valueOf(totalAmount));
        result.append("\n");

        result.append("You earned ");
        result.append(String.valueOf(frequentRenterPoints));
        result.append(" frequent renter points");


        return result.toString();
    }
}
