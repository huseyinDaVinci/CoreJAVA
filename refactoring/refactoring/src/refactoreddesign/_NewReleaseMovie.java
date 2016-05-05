package refactoreddesign;

/**
 * Created by barin.huseyin on 5/5/2016.
 */
public class _NewReleaseMovie extends _Movie {
    private String _title;


    public _NewReleaseMovie(String title) {
        super(title);
        _title = title;

    }

    public String getTitle() {
        return _title;
    }


    @Override
    protected double calculateAmountMovie(int daysRented) {
        return daysRented * 3;
    }

    @Override
    protected boolean hasBonus(int daysRented) {
        return (daysRented > 1);
    }
}
