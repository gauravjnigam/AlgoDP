package com.gn.dp.fibnum.fibonacci;

public class FibonacciBottumUp {
	
	// solution has time and space complexity of O(n).
		public int CalculateFibonacci(int n) {
			int[] fibs = new int[n + 1];

			return CalculateFibonacciMemo(fibs, n);
		}

		private int CalculateFibonacciMemo(int[] fibs, int n) {
			fibs[0] = 0;
			fibs[1] = 1;

			for (int i = 2; i <= n; i++) {
				fibs[i] = fibs[i - 1] + fibs[i - 2];
			}
			return fibs[n];
		}

		public static void main(String[] args) {
			FibonacciBottumUp fibbp = new FibonacciBottumUp();
			System.out.println("2nd Fibonacci is ---> " + fibbp.CalculateFibonacci(2));
			System.out.println("6th Fibonacci is ---> " + fibbp.CalculateFibonacci(6));
			System.out.println("7th Fibonacci is ---> " + fibbp.CalculateFibonacci(7));
			System.out.println("7th Fibonacci is ---> " + fibbp.CalculateFibonacci(27));
		}

}
