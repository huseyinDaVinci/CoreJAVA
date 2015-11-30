package com.barin;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import java.lang.*;
import java.math.BigInteger;

import com.barin.ExecutorServiceUsage.Logger;
import com.barin.list.ImmutableList;

public class ExecutorServiceUsageAtomic {

	// Immutable lists are in stack LIFO (not queue)

	private static final int FIBONACCI_NUM_COUNT = 20;

	private static final int THREAD_COUNT = 10;

	private static Random RADNOM = new Random();

	// create a thread pool
	ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

	public static class Logger implements Runnable {

		private AtomicReference<ImmutableList<String>> messagesRef = new AtomicReference<ImmutableList<String>>(new ImmutableList<String>());

		ImmutableList<String> logs=new ImmutableList<>();

		@Override
		public void run() {

			
lol:			while(true){
				
	
	
	/*
	
haci:				do {					
					logs = messagesRef.get();					
					if (logs.tail == null) {						
						Thread.yield();//yep we should  go to sleep a little
						//break lol;
						break haci;
			}

				} while (!messagesRef.compareAndSet(logs,logs.tail)); // log remove here
				
		*/
	
	
	
		//much nicer can be written
	
		do{
			
			logs=messagesRef.get();
			
			
		}while(logs.tail!=null && !messagesRef.compareAndSet(logs, logs.tail));
	
				if(logs.head!=null){
					System.out.println("Added Log will be removed:" + logs.head);
				}

			}

		}

		public void log(String message) {

			do {
				logs = messagesRef.get();
			} while (!messagesRef.compareAndSet(logs, logs.prepend(message)));

		}

	}

	public ExecutorServiceUsageAtomic() {

		Logger logger = new Logger();
	
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
				

			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}

		}


	}

	public static void main(String[] args) {

		new ExecutorServiceUsageAtomic();

	}

	public static BigInteger fib(int n) {

		return n < 2 ? BigInteger.ONE : fib(n - 1).add(fib(n - 2));

	}

}
