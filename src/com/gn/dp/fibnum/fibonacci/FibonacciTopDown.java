package com.gn.dp.fibnum.fibonacci;

public class FibonacciTopDown {

	// solution has time and space complexity of O(n).
	public int CalculateFibonacci(int n) {
		int[] fibs = new int[n + 1];
		fibs[0] = 0;
		fibs[1] = 1;
		return CalculateFibonacciMemo(fibs, n);
	}

	private int CalculateFibonacciMemo(int[] fibs, int n) {
		if(n < 2) {
			return fibs[n];
		}
		
		fibs[n] = CalculateFibonacciMemo(fibs, n-1) +  CalculateFibonacciMemo(fibs, n-2);
		return fibs[n];
	}

	public static void main(String[] args) {
		FibonacciTopDown fibtd = new FibonacciTopDown();
		System.out.println("2nd Fibonacci is ---> " + fibtd.CalculateFibonacci(2));
		System.out.println("6th Fibonacci is ---> " + fibtd.CalculateFibonacci(6));
		System.out.println("7th Fibonacci is ---> " + fibtd.CalculateFibonacci(7));
		System.out.println("7th Fibonacci is ---> " + fibtd.CalculateFibonacci(27));
	}

}
