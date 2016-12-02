package com.trie;

import java.util.HashMap;
import java.util.Map;

public class Tree {
	private Map<Character, Tree> node;
	private boolean endOfWord = false;

	public Tree() {
		node = new HashMap<>();
	}
	
	public Tree(boolean endOfWord) {
		super();
		node = new HashMap<>();
		this.endOfWord = endOfWord;
	}


	public Map<Character, Tree> getNode() {
		return node;
	}

	public void setNode(Map<Character, Tree> node) {
		this.node = node;
	}

	public boolean isEndOfWord() {
		return endOfWord;
	}

	public void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}

	@Override
	public String toString() {
		return "Tree [node=" + node + ", end=" + endOfWord + "]";
	}

	
	
	

}
