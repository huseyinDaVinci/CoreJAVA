import java.util.ArrayList;
import java.util.Observer;

/**
 * Probably look at this project later and you will see this class indeed Subscription in RxJava (but dont know)
 * Simple class to be observable This class can be though as the object we are
 * observing if a change occurs in the class then notify all subscribers to know
 * about this change
 * 
 * @author barin.huseyin
 *
 */
public class MyDataCenter extends MyObserverable {

	/**
	 * This array list simply hold the subscribers. These subscribers are hold
	 * in the stack (@LIFO)
	 * 
	 */
	ArrayList<Observer> observers = new ArrayList<Observer>();

	private int n = 0;

	public MyDataCenter(int n) {
		this.n = n;
	}

	/**
	 * We are observing in the class the number "n" actually if update this
	 * number indeed we fire all subscribers
	 * 
	 * @param n
	 */
	public void setValue(int n) {
		this.n = n;
		setChanged();

		notifyObservers();
	}

	public int getValue() {
		return n;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observable#addObserver(java.util.Observer)
	 */
	@Override
	public synchronized void addObserver(Observer o) {

		System.out.println("@addObserver :" + ((TestObserver) o).name + " yeni biri geldi demek dikislenmeye geliyor vaziyet alin burasi birazdan karisacak");
		observers.add(o);
		super.addObserver(o);
	}

}
