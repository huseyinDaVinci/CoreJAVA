package refactoreddesign;

/**
 * Created by barin.huseyin on 5/5/2016.
 */
public class _ChildrenMovie extends _Movie {

    private String _title;


    public _ChildrenMovie(String title) {
        super(title);
        _title = title;
    }

    public String getTitle() {
        return _title;
    }

    @Override
    protected double calculateAmountMovie(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3) {
            amount += (daysRented - 3) * 1.5;
        }
        return amount;
    }

    @Override
    protected boolean hasBonus(int daysRented) {
        return false;
    }


}
