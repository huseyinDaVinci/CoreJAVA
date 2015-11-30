package com.barin;

public class DeadLock {

	Object a = 5;

	Object b = 6;

	public DeadLock() {

		new Thread(new Runnable() {
			public void run() {

				createDeadLock(a, b);
			}
		}).start();

		new Thread(new Runnable() {
			public void run() {

				createDeadLock(b, a);

			}
		}).start();

	}

	public static void main(String[] args) throws Exception {

		new DeadLock();

	}

	public void createDeadLock(Object a, Object b) {

		synchronized (a) {

			boolean selcukTurn=false;
			while (true) {

				selcukTurn=!selcukTurn;
				synchronized (b) {

					System.out.println(selcukTurn==true?"selcuk Sordu":"laz Sordu");
				}

			}

		}

	}

}
