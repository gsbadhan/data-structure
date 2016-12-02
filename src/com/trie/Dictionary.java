package com.trie;

import java.util.Map;

public class Dictionary {
	private Tree head = new Tree();

	public void insert(String word) {
		char[] charArr = word.toCharArray();

		Map<Character, Tree> map = head.getNode();
		for (int i = 0; i < charArr.length; i++) {
			if (!map.containsKey(charArr[i])) {
				if (i == (charArr.length - 1)) {
					map.put(charArr[i], new Tree(true));
				} else {
					map.put(charArr[i], new Tree());
				}
			}
			map = map.get(charArr[i]).getNode();
		}

	}

	public void prefixSearch(String pattern) {
		String matchChars = "";
		int matchCounter = 0;
		boolean completeWordFound = false;
		char[] charArr = pattern.toCharArray();
		Map<Character, Tree> map = head.getNode();
		for (int i = 0; i < charArr.length; i++) {
			if (map.containsKey(charArr[i])) {
				Tree t = map.get(charArr[i]);
				map = t.getNode();
				matchChars = matchChars + charArr[i];
				completeWordFound = t.isEndOfWord();
				++matchCounter;
			} else {
				completeWordFound = false;
				break;
			}
		}
		
		if (completeWordFound) {
			System.out.println("word found:" + matchChars);
		} else {
			System.out.println("word match upto [" + matchCounter + "] : " + matchChars);
		}
		
	}



}
