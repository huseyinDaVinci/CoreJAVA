package refactoreddesign;

/**
 * Created by barin.huseyin on 5/5/2016.
 */
public abstract class _Movie {

    private final String _title;

    public _Movie(String title) {
        this._title = title;
    }

    protected abstract double calculateAmountMovie(int daysRented);

    protected abstract boolean hasBonus(int daysRented);

    public String getTitle() {
        return _title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + _title + '\'' +
                '}';
    }
}
