package com.gn.dp.fibnum.housethief;

public class HouseThief {

	public static void main(String[] args) {
		HouseThief ht = new HouseThief();
		int[] wealth = { 2, 5, 1, 3, 6, 2, 4 };
		System.out.println(ht.findMaxSteal(wealth));
		wealth = new int[] { 2, 10, 14, 8, 1 };
		System.out.println(ht.findMaxSteal(wealth));

		// top down approach
		wealth = new int[] { 2, 5, 1, 3, 6, 2, 4 };
		System.out.println(ht.findMaxStealUsingTopDownMemo(wealth));
		wealth = new int[] { 2, 10, 14, 8, 1 };
		System.out.println(ht.findMaxStealUsingTopDownMemo(wealth));

		// bottom up
		wealth = new int[] { 2, 5, 1, 3, 6, 2, 4 };
		System.out.println(ht.findMaxStealUsingBottomUp(wealth));
		wealth = new int[] { 2, 10, 14, 8, 1 };
		System.out.println(ht.findMaxStealUsingBottomUp(wealth));
	}

	// normal recursion - complexity would be 2^n
	private int findMaxSteal(int[] wealth) {
		return findMaxStealRecursive(wealth, 0);
	}

	private int findMaxStealRecursive(int[] wealth, int index) {
		// base case
		if (index >= wealth.length) {
			return 0;
		}
		// for every index - thief has two option
		// - steal from ith house
		// - steal from (i+1)st house

		int profitAtI = wealth[index] + findMaxStealRecursive(wealth, index + 2);
		int profitAtIplus1 = findMaxStealRecursive(wealth, index + 1);

		// max profit at current index would be max [ profit at ith house + profit at
		// i+2 , profit at i+1
		return Math.max(profitAtI, profitAtIplus1);
	}

	// recursion with memotization ( top down approach)
	private int findMaxStealUsingTopDownMemo(int[] wealth) {
		int[] profit = new int[wealth.length + 1];
		return findMaxStealRecursiveUsingTopDownMemo(wealth, profit, 0);
	}

	private int findMaxStealRecursiveUsingTopDownMemo(int[] wealth, int[] profit, int index) {
		// base case
		if (index >= wealth.length) {
			return 0;
		}

		if (profit[index] == 0) {
			int profitAtI = wealth[index] + findMaxStealRecursiveUsingTopDownMemo(wealth, profit, index + 2);
			int profitAtIplus1 = findMaxStealRecursiveUsingTopDownMemo(wealth, profit, index + 1);
			profit[index] = Math.max(profitAtI, profitAtIplus1);
		}

		return profit[index];
	}

	// Bottom up
	private int findMaxStealUsingBottomUp(int[] wealth) {
		
		int [] profit = new int[wealth.length + 1];// +1 to consider 0 house
		profit[0] = 0; // zero house
		profit[1] = wealth[0]; // only one house
		
		
		for (int i = 1; i < wealth.length; i++) {
			profit[i+1] = Math.max(profit[i], wealth[i] + profit[i-1]);
		}
		
		return profit[wealth.length];
	}

}
