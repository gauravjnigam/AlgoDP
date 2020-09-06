package com.gn.dp.fibnum.staircase;

/**
 * 
 * Given a stair with ‘n’ steps, implement a method to count how many possible
 * ways are there to reach the top of the staircase, given that, at every step
 * you can either take 1 step, 2 steps, or 3 steps.
 * 
 * Example 1:
 * 
 * Number of stairs (n) : 3 Number of ways = 4 Explanation: Following are the
 * four ways we can climb : {1,1,1}, {1,2}, {2,1}, {3} Example 2:
 * 
 * Number of stairs (n) : 4 Number of ways = 7 Explanation: Following are the
 * seven ways we can climb : {1,1,1,1}, {1,1,2}, {1,2,1}, {2,1,1}, {2,2}, {1,3},
 * {3,1}
 * 
 * @author Gaurav Nigam
 *
 */
public class StairCase {

	private int countWays(int steps) {

		if (steps == 0)
			return 1;
		if (steps == 1) {
			return 1;
		}
		if (steps == 2) {
			return 2;
		}

		int countWithStep1 = countWays(steps - 1);
		int countWithStep2 = countWays(steps - 2);
		int countWithStep3 = countWays(steps - 3);

		return countWithStep1 + countWithStep2 + countWithStep3;
	}

	private int countWaysTopDownMemo(int steps) {
		int[] dp = new int[steps + 1];
		return countWaysTopDownMemoRecursive(dp, steps);

	}

	private int countWaysTopDownMemoRecursive(int[] dp, int steps) {
		if (steps == 0)
			dp[steps] = 1;

		if (steps == 1) {
			dp[steps] = 1;
		}

		if (steps == 2) {
			dp[steps] = 2;
		}
		if (dp[steps] != 0) {
			return dp[steps];
		}

		int take1Step = countWaysTopDownMemoRecursive(dp, steps - 1);
		int take2Step = countWaysTopDownMemoRecursive(dp, steps - 2);
		int take3Step = countWaysTopDownMemoRecursive(dp, steps - 3);

		dp[steps] = take1Step + take2Step + take3Step;

		return dp[steps];
	}

	public static void main(String[] args) {
		// normal recursion
		System.out.println("Recursion without memo");
		StairCase sc = new StairCase();
		System.out.println(sc.countWays(3));
		System.out.println(sc.countWays(4));
		System.out.println(sc.countWays(5));
		System.out.println(sc.countWays(10));

		// top down
		System.out.println("Recursion with memo using topdown");
		System.out.println(sc.countWaysTopDownMemo(3));
		System.out.println(sc.countWaysTopDownMemo(4));
		System.out.println(sc.countWaysTopDownMemo(5));
		System.out.println(sc.countWaysTopDownMemo(10));
		
		
	}

}
