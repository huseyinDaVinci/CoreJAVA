package com.barin;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {

	// Lets take a bank example checking money the same with database
	// transaction cycle.

	AtomicReference<Integer> balance = new AtomicReference<Integer>();

	/*
	 * class AtomicReference<V>{
	 * 
	 * boolean compareAndSet(V expect,V actual); }
	 */

	public void getMoney(int amount, int balance) {

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * what can we do
	 * 
	 * we can use synchronized block to ensure this witdrawing case will be
	 * thread-safe However, this will expensive and slow interm of performance.
	 * 
	 * Making balance volatile but not the solution only flush the CPU cache
	 * nothing else.
	 * 
	 * So we can use both cheap and guarenteed way atomic references and much
	 * faster.
	 */

	
	class AccountAtomic {

		private AtomicReference<Integer> balanceRef;

		public void withdraw(int amount) throws Exception {

			

			boolean synchronizedFlag = false;

			// between these two line the value of balance we should be
			// sure.
			// ok, first we get the reference it the balance changes between
			// these two lines
			// compareAndSet method will return false. it not will.

			while (!synchronizedFlag) {

				int balance = balanceRef.get();
				
				if (amount <= balance) {
					synchronizedFlag = balanceRef.compareAndSet(balance, balance - amount);
				} else {
					throw new Exception();
				}

			}

		}

	}

	class Account {

		// Body absolutely not thread safe class:(

		private Integer balance;

		public void withdraw(int amount) {

			synchronized (balance) {
				if (amount <= balance) {

					balance = balance - amount;
				}

			}

		}

	}

}
