import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxJavaTutorial {

	class Customer {

		String name;

		Customer(String name) {

			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Customer Mr:" + name;
		}

	}

	public void simplyEmitFromObservable(String s) {

		Observable.just(s).subscribe(new Action1<String>() {
			@Override
			public void call(String s) {
				System.out.println(s);
			}
		});

	}

	
	
	public void lambdaExpressionExample(){
		
		Observable.just(" Nine Six Six !")
	    .map(s -> s)
	    .map(i -> String.format("Coming message:%s", i))
	    .subscribe(s -> System.out.println(s));
		
	}
	
	public void flatMapOperatorExample(List<String> urls){
	
		
		
		
		/*
		Observable.just(urls).map(new Func1<List<String>, String>() {

			@Override
			public String call(List<String> arg0) {
				// TODO Auto-generated method stub
				return arg0;
			}
		});*/
		
		
		
		
		
		
		
	
		
	}
	
	
	public void mapOperatorExample(String theWordEmitted) {

		Observable.just(theWordEmitted).map(new Func1<String, Customer>() {

			@Override
			public Customer call(String arg0) {

				return new Customer(arg0);
			}
		}).subscribe(new Subscriber<Customer>() {

			@Override
			public void onCompleted() {
				System.out.println("@onCompleted:");

			}

			@Override
			public void onError(Throwable arg0) {
				System.out.println("@onError: map");

			}

			@Override
			public void onNext(Customer customer) {
				System.out.println("@onNext: map" + customer.toString());

			}
		});

	}

	public void hello(String... names) {

		Observable<String> myObservable = Observable.create(new OnSubscribe<String>() {

			@Override
			public void call(Subscriber<? super String> subscriber) {

				int a = 5 / 0;
				subscriber.onNext("naber-baskan");

				subscriber.onCompleted();

			}

		});

		Observable<String> myObservable2 = Observable.just("Hello, world!");

		Action1<String> onNextAction = new Action1<String>() {
			@Override
			public void call(String s) {
				System.out.println("@Simple Action onNext:" + s);
			}
		};

		Action1<Throwable> onErrorAction = new Action1<Throwable>() {
			@Override
			public void call(Throwable t) {
				System.out.println("@Simple Action onError:" + t.getMessage().toLowerCase());
			}
		};

		Action0 onCompletedAction = new Action0() {

			@Override
			public void call() {
				System.out.println("@Simple Action onCompleted:");

			}
		};

		myObservable2.subscribe(onNextAction, onErrorAction, onCompletedAction);

		Subscriber<String> mySubscriber = new Subscriber<String>() {

			@Override
			public void onNext(String arg0) {

				System.out.println("@onNext mySubscriber1:" + arg0);
			}

			@Override
			public void onError(Throwable arg0) {

				System.out.println("@onError:" + arg0);
			}

			@Override
			public void onCompleted() {

				System.out.println("@onCompleted");
			}
		};

		Subscriber<String> mySubscriber2 = new Subscriber<String>() {

			@Override
			public void onNext(String arg0) {

				System.out.println("@onNext mySubscriber2:" + arg0);
			}

			@Override
			public void onError(Throwable arg0) {

				System.out.println("@onError:" + arg0);
			}

			@Override
			public void onCompleted() {

				System.out.println("@onCompleted");
			}
		};

		// myObservable2.subscribe(mySubscriber);
		// myObservable2.subscribe(mySubscriber2);

	}

	public RxJavaTutorial() {

		// hello("Naber");

		// simplyEmitFromObservable("naber babalik");

		//mapOperatorExample(" Kemalettin");

		
		//getWebSiteURLs("test");
		
		
		
		List<String> messages=new ArrayList<String>();
		messages.add("TEST");
		messages.add("TEXT");
		messages.add("OQUERY");
		
		
		//flatMapOperatorExample(messages);
		
		lambdaExpressionExample();
		
		
	}

	public void getWebSiteURLs(String text) {

		// Returns a List of website URLs based on a text search
		// Observable<List<String>> query(String text);

		Subscriber<List<String>> mySubscriber = new Subscriber<List<String>>() {

			@Override
			public void onNext(List<String> arg0) {

				
				
				System.out.println("Coming websites:" );
			
				for(String s:arg0){
					System.out.println(s);
				}
			
			}

			@Override
			public void onError(Throwable arg0) {

			}

			@Override
			public void onCompleted() {

			}
		};

		Observable.just(text).map(new Func1<String, List<String>>() {

			@Override
			public List<String> call(String arg0) {
				List<String> websites = new ArrayList<String>();

				for (char c : arg0.toCharArray()) {

					websites.add("" + c + ".com");

				}

				return websites;
			}
		}).subscribe(mySubscriber);

	}

	public static void main(String[] args) {

		new RxJavaTutorial();

	}

}
