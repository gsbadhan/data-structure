package com.trie;

public class Test {

	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();
		dictionary.insert("johan");
		dictionary.insert("arjun");
		dictionary.insert("raman singh");
		dictionary.insert("devika");
		dictionary.insert("sunam");
		dictionary.insert("preet");
		dictionary.insert("dev");
		
		dictionary.prefixSearch("arju");
	}

}
