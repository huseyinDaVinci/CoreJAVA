import java.util.Observable;
import java.util.Observer;

/**
 * Simple TestObserver implements Observer and then can behave like an Observer
 * We will request to be register itself to Observable stack And if any change
 * occurs this will be notified @I think basic implementation of RxJava
 * 
 * @author barin.huseyin
 *
 */
public class TestObserver implements Observer {

	String name;

	public TestObserver(String name) {
		this.name = name;
		ObservableManager.getInstance().getMyDataCenter().addObserver(this);

	}

	@Override
	public void update(Observable o, Object arg) {

		// check the we are notified from the observable (MyDataCenter)
		// since this class can subscribe mmore than one observable

		if (ObservableManager.getInstance().getMyDataCenter() == o) {
			System.out.println(name + "  @Data changed baba baksana this is trigerred");

		}

	}

}
