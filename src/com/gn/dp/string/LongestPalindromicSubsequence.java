package com.gn.dp.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a sequence, find the length of its Longest Palindromic Subsequence
 * (LPS). In a palindromic subsequence, elements read the same backward and
 * forward.
 * 
 * A subsequence is a sequence that can be derived from another sequence by
 * deleting some or no elements without changing the order of the remaining
 * elements.
 * 
 * Example 1:
 * 
 * Input: "abdbca" Output: 5 Explanation: LPS is "abdba". Example 2:
 * 
 * Input: = "cddpd" Output: 3 Explanation: LPS is "ddd". Example 3:
 * 
 * Input: = "pqr" Output: 1 Explanation: LPS could be "p", "q" or "r".
 * 
 * @author Gaurav Nigam
 *
 */
public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
		System.out.println(lps.findLPSLength("abdbca"));
		System.out.println(lps.findLPSLength("cddpd"));
		System.out.println(lps.findLPSLength("pqr"));

		System.out.println(lps.findLPSLengthWithTopDownMemo("abdbca"));
		System.out.println(lps.findLPSLengthWithTopDownMemo("cddpd"));
		System.out.println(lps.findLPSLengthWithTopDownMemo("pqr"));

	}

	private int findLPSLengthWithTopDownMemo(String string) {
		Map<String, Integer> dp = new HashMap<>();
		return findLPSLengthWithTopDownMemoRecursive(dp, string, 0, string.length() - 1);
	}

	private int findLPSLengthWithTopDownMemoRecursive(Map<String, Integer> dp, String string, int start, int end) {
		if (start > end) {
			return 0;
		}
		if (start == end) {
			return 1;
		}

		String key = String.format("%d|%d", start, end);
		if (!dp.containsKey(key)) {

			int currentMax = 0;
			if (string.charAt(start) == string.charAt(end)) {
				currentMax = findLPSLengthRecursive(string, start + 1, end - 1) + 2;
			} else {
				currentMax = Math.max(findLPSLengthRecursive(string, start + 1, end),
						findLPSLengthRecursive(string, start, end - 1));
			}

			dp.put(key, currentMax);

		}

		return dp.get(key);
	}

	private int findLPSLength(String string) {
		// at every point (while comparing first and last character)
		// we got two option
		// - if both char(fist and last) matches
		// - if doesn't match, this got two option
		// - skip last
		// - skip first

		return findLPSLengthRecursive(string, 0, string.length() - 1);

	}

	private int findLPSLengthRecursive(String string, int start, int end) {

		// base case for empty string, string of length 1
		if (start > end)
			return 0;
		if (start == end)
			return 1;

		int currentMax = 0;
		if (string.charAt(start) == string.charAt(end)) {
			currentMax = findLPSLengthRecursive(string, start + 1, end - 1) + 2;
		} else {
			currentMax = Math.max(findLPSLengthRecursive(string, start + 1, end),
					findLPSLengthRecursive(string, start, end - 1));
		}

		return currentMax;
	}

}
