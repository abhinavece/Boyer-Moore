package com.heapdev.boyerMoore;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity O(n/m)
 * 
 * @author singh09.abhinav@gmail.com
 *
 */

public class BoyerMoore {

	private String text;
	private String pattern;
	private Map<Character, Integer> mismatchTable;

	public BoyerMoore(String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
		mismatchTable = new HashMap<>();
	}

	public void preComputeMismatchTable() {

		int patternLength = pattern.length();

		for (int i = 0; i < pattern.length(); i++) {
			char charAtIndex = pattern.charAt(i);
			int maxShift = Math.max(1, patternLength - i - 1);
			mismatchTable.put(charAtIndex, maxShift);
		}
	}

	public int search() {

		int patternLength = this.pattern.length();
		int textLength = this.text.length();
		int skips;

		for (int i = 0; i < textLength - patternLength; i = i + skips) {
			skips = 0;
			for (int j = patternLength - 1; j >= 0; j--) {
				if (text.charAt(i + j) != pattern.charAt(j)) {

					if (mismatchTable.get(pattern.charAt(j)) != null) { // Why pattern at j ???? why not text.chartAt(j)
						skips = mismatchTable.get(pattern.charAt(j));
						break;
					} else {
						skips = patternLength;
						break;
					}
				}
			}
			if (skips == 0)
				return i;
		}
		return -1;
	}
}
