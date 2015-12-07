import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class LambdaExpressions implements Executor {

	private BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<>();

	private void runLoop() throws InterruptedException {
		while (!Thread.interrupted()) {
			tasks.take().run();
		}
	}

	@Override
	public void execute(Runnable command) {
		tasks.add(command);
	}

	public static void main(String[] args) throws InterruptedException {

		LambdaExpressions sample = new LambdaExpressions();
		sample.runLoop();
		new LambdaExpressions();
	}

	public LambdaExpressions() {

		// simpleObservableWithLambdaExpression("My First Lambda Expression");

		// mapOperatorWithLambdaExpression("My First Lambda Expression");

		// moreMapOperator("My First Lambda Expression");

		List<String> messages = new ArrayList<String>();
		messages.add("TEST");
		messages.add("TEXT");
		messages.add("OQUERY");

		/*
		 * queryLambda(messages); queryFlatMapOperatorWithLambda(messages);
		 * queryFlatMapOperatorWithoutLambda(messages);
		 * getURLTitlesWithFlatMapOperator(messages);
		 */
		getURLTitlesWithFlatMapOperatorWithLambda(messages);

	}

	public void queryLambda(List<String> messages) {

		Observable.just(messages).subscribe(urls -> {
			Observable.from(urls).subscribe(url -> System.out.println(url));
		});

	}

	public void queryFlatMapOperatorWithLambda(List<String> messages) {
		Observable.just(messages).flatMap(urls -> Observable.from(urls)).subscribe(url -> System.out.println(url.toLowerCase()));
	}

	
	

	public void getURLTitlesWithFlatMapOperatorWithLambda(List<String> messages) {
		Observable.just(messages)
		.subscribeOn(Schedulers.newThread())
		.observeOn(Schedulers.from(this))
		.flatMap(urls -> Observable.from(urls))
		.flatMap(s ->getTitle(s))
		.filter(title -> title != null)
		.take(2)
		.doOnNext(title -> System.out.println("The title will be writen to disk also: " + title.toLowerCase()))
		.subscribe(title -> System.out.println("Coming Values with titles:" + title.toLowerCase()));}
	
	

	public void getURLTitlesWithFlatMapOperator(List<String> messages) {

		Observable.just(messages)

		.flatMap(urls -> Observable.from(urls))

		.flatMap(new Func1<String, Observable<String>>() {

			@Override
			public Observable<String> call(String s) {

				return getTitle(s);
			}
		}).subscribe(new Subscriber<String>() {

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub

			}

			@Override
			public void onError(Throwable arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onNext(String arg0) {

				System.out.println("Coming Values with titles:" + arg0);
			}
		});

	}

	Observable<String> getTitle(String URL) {
		return Observable.just(URL);
	}

	public void queryFlatMapOperatorWithoutLambda(List<String> messages) {

		Observable.just(messages).flatMap(new Func1<List<String>, Observable<String>>() {

			@Override
			public Observable<String> call(List<String> list) {

				return Observable.from(list);
			}
		}).subscribe(new Subscriber<String>() {

			@Override
			public void onCompleted() {
				// TODO Auto-generated method stub

			}

			@Override
			public void onError(Throwable arg0) {
				System.out.println("@onError:" + arg0.getMessage().toString());

			}

			@Override
			public void onNext(String arg0) {
				System.out.println("Coming value:" + arg0.toLowerCase());

			}
		});

	}

	public void simpleObservableWithLambdaExpression(String comingText) {

		Observable.just(comingText).subscribe(s -> System.out.println(String.format("Coming text: %s", s.toString())));

	}

	public void mapOperatorWithLambdaExpression(String text) {

		Observable.just(text).map(s -> s.toString().replace("Lambda", "Bishmeck")).subscribe(s -> System.out.println(String.format("Coming text: %s", s.toString())));

	}

	public void moreMapOperator(String text) {

		Observable.just(text).map(s -> s.hashCode()).map(s1 -> s1).subscribe(i -> System.out.println("The final result is :" + i));

	}

}
