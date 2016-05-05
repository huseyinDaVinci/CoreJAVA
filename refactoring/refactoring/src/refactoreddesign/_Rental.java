package refactoreddesign;

/**
 * Created by barin.huseyin on 5/5/2016.
 */
public class _Rental implements IRental {


    private _Movie _movie;
    private int _daysRented;

    public _Rental(_Movie movie, int daysRented) {
        _movie = movie;
        _daysRented = daysRented;
    }

    public _Movie getMovie() {
        return _movie;
    }

    @Override
    public boolean hasBonus() {
        return _movie.hasBonus(_daysRented);
    }


    @Override
    public double calculateAmount() {
        return _movie.calculateAmountMovie(_daysRented);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "movie title=" + _movie.getTitle() +
                "amount=" + _movie.calculateAmountMovie(_daysRented) +
                '}';
    }
}
