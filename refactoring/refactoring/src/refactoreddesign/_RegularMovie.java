package refactoreddesign;

/**
 * Created by barin.huseyin on 5/5/2016.
 */
public class _RegularMovie extends _Movie {


    private String _title;

    public _RegularMovie(String title) {
        super(title);
        _title = title;
    }


    public String getTitle() {
        return _title;
    }

    @Override
    protected double calculateAmountMovie(int daysRented) {

        double amount = 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }
        return amount;
    }

    @Override
    protected boolean hasBonus(int daysRented) {
        return false;
    }
}
