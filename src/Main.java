import java.util.Set;

import data.SimpleWordList;

public class Main {
	static String list = "C:\\Users\\beeem\\eclipse-workspace\\Scrubble\\words\\wordlist.txt";
	
	static SimpleWordList s = new SimpleWordList();
	public static void main(String[] args) {
	//	searchValidsInSet("bla");
		searchValidsInSet("vida");	
	}
	
	/*
	 * Search for words in the list that can be built out of given tile
	 * and are of the same length as the given tile.
	 */
	public static void searchValidsInSet(String tileRack) {
		s.initFromFile(list);
		//create a set of valid words
		Set<String> validWords = s.validWordsUsingAllTiles(tileRack);
		
		System.out.println("The given tile rack: " + tileRack + " & possible words: ");
		for (String w: validWords) {
			System.out.print(" " + w + " ");
		}
	}

}
