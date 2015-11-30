package com.barin;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceUsage {

	/*
	 * Use Executor service to decouple task submission. If not necessary, do
	 * not handle threads explicitly by yourself.create a thread pool easily
	 * than submit tasks as Runnable or Callable<V> which is generic you can get
	 * result.you can first submit then execute no matter in this example I skip
	 * the submit step and directly execute the Runnable code. !!!!! If we want
	 * to our current thread should wait the these threads.we can use
	 * executor.shutdown(); however this will not solve the problem. In this
	 * case, we should use awaitTermination(Give a some time to wait the
	 * executor service to finish its job.) executor.shutdown();
	 * executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
	 */

	
	
	
	//this code sucks bro. yanlis anlama
	
	
	private static final int FIBONACCI_NUM_COUNT = 20;

	private static final int THREAD_COUNT = 10;

	private static Random RADNOM = new Random();

	// create a thread pool
	ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

	ExecutorService executor2 = Executors.newFixedThreadPool(THREAD_COUNT);

	public static class Logger implements Runnable {

		String loggerName = "";

		public String getLoggerName() {
			return loggerName;
		}

		public void setLoggerName(String loggerName) {
			this.loggerName = loggerName;
		}

		static LinkedBlockingQueue<String> logs = new LinkedBlockingQueue<String>();

		@Override
		public void run() {

			while (true) {

				synchronized (logs) {

					if (logs.isEmpty()) {

						try {
							logs.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

					} else {
						System.out.println(loggerName+ "  Added Log will be removed:" + logs.poll());

					}

				}

			}

		}

		public void log(String message) {

			try {

				synchronized (logs) {
					logs.put(message);
					logs.notifyAll();

				}

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	public ExecutorServiceUsage() {

		Logger logger = new Logger();
		
		logger.setLoggerName("Logger 1");
		
		Logger logger2=new Logger();
		
		logger2.setLoggerName("Logger 2");
		
		executor.execute(logger2);
		executor.execute(logger);

		while (true) {

			Callable<String> callable = new Callable<String>() {

				@Override
				public String call() throws Exception {
					int rndNumber = RADNOM.nextInt(40);

					String a = String.format("Fib(%d) = %s\n", rndNumber, fib(rndNumber));

					System.out.println("Log Message From Executor Callable: " + a);
					return a;
				}

			};

			Future<String> f = executor.submit(callable);

			try {
				// logs.put(f.get());

				logger.log(f.get());
				logger2.log(f.get());

			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}

		}

		/*
		 * for (int i = 0; i < FIBONACCI_NUM_COUNT; i++) {
		 * 
		 * 
		 * 
		 * }
		 * 
		 * try {
		 * 
		 * 
		 * executor.shutdown();
		 * 
		 * executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
		 * 
		 * 
		 * // loggerThread.interrupt(); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 * 
		 * 
		 * 
		 * System.out.println("Fibo tasks done");
		 */

	}

	public static void main(String[] args) {

		new ExecutorServiceUsage();

	}

	public static BigInteger fib(int n) {

		return n < 2 ? BigInteger.ONE : fib(n - 1).add(fib(n - 2));

	}

}
