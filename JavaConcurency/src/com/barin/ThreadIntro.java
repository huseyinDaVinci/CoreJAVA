package com.barin;

import java.math.BigInteger;
import java.util.Random;

public class ThreadIntro {

	
	/*Parallel tasks are done through multithreading here  by calculating fibonacci numbers in parallel 
	 * the difference between  threadX.start()   threadX.run()    start() open a new thread    run()  will run the task of thread in the thread where it is called.
	 * thread.join()  here say wait this thread to finish its job. Then continue your thread  imagine  2-3 threads can run in parallel and you can join these thread and stop the current thread to wait for them. 
	 * */
	
	private static final int FIBONACCI_NUM_COUNT = 50;

	private static Random RADNOM = new Random();

	public ThreadIntro() throws Exception {

		Thread[] threads = new Thread[FIBONACCI_NUM_COUNT];

		for (int i = 0; i < FIBONACCI_NUM_COUNT; i++) {

			threads[i] = new Thread(new Runnable() {

				@Override
				public void run() {

					int rndNumber = RADNOM.nextInt(40);

					System.out.format("Fib(%d) = %s\n", rndNumber,
							fib(rndNumber));
				}
			});

			threads[i].start();

		}

		for (Thread t : threads) {

			if (t.isAlive()) {
				t.join();
			}

		}
		System.out.println("Fibo tasks done");

	}

	public static BigInteger fib(int n) {

		return n < 2 ? BigInteger.ONE : fib(n - 1).add(fib(n - 2));

	}

	public static void main(String[] args) throws Exception {

		new ThreadIntro();

	}

}
