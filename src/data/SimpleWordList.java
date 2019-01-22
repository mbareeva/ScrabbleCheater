package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import util.Permutation;
import util.SubSets;

public class SimpleWordList implements WordList {
	
//	private Set<String> words = new HashSet<>();
	private Map<Integer, ArrayList<String>> wordsMap = new HashMap<>();
	
//	@Override
	//Implementation 1st - for Sets
//	public Set<String> validWordsUsingAllTiles(String tileRackPart) {
//		Set<String> valids = new HashSet<>();
//		Permutation tiles = new Permutation(tileRackPart);
//		
//		for (String word : words ) {
//			Permutation perm = new Permutation(word);
//			if(perm.equals(tiles)) {
//				valids.add(perm.getWord());
//			}
//		}
//		return valids;
//	}
//	
	// The implementation with maps. Retrieve the element from wordsMap 12 lab.
	public Set<String> validWordsUsingAllTiles(String tileRackPart) {
		ArrayList<String> list = new ArrayList<>();
		Permutation tiles = new Permutation(tileRackPart);
		
		if(wordsMap.containsKey(tiles.hashCode())) {
			list = wordsMap.get(tiles.hashCode());
		}
		Set<String> valids = new HashSet<>(list);

		return valids;
	}
	
	//The implementation with hashFunc()
//	public Set<String> validWordsUsingAllTiles(String tileRackPart){
//		Set<String> valids = new HashSet<>();
//		Permutation tiles = new Permutation(tileRackPart);
//		
//		for (Map.Entry<Permutation, ArrayList<String>> entry : wordsMap.entrySet()) {
//		   Permutation perm = entry.getKey();
//			if(perm.hashCode() == tiles.hashCode()) {
//				valids.addAll(entry.getValue());
//				}
//		}
//		//heck whether hashmap contains hashcode
//		return valids;
//	}
	
	

	@Override
	public Set<String> allValidWords(String tileRack) {
		Set <String> subsets = SubSets.getSubSets(tileRack);
		Set<String> valids = new HashSet<>();
		for(String s : subsets) {
			 valids.addAll(validWordsUsingAllTiles(s));
		}
		return valids;
	}

	@Override
	public boolean add(String word) {
		Permutation perm = new Permutation(word);
		if(!wordsMap.containsKey(perm.hashCode())) {
			ArrayList<String> perms = new ArrayList<>(); 
			perms.add(word);
			wordsMap.put(perm.hashCode(), perms);
		}
		else{
			//after get I get the value, the list
			//why get key and then add to it a value
			wordsMap.get(perm.hashCode()).add(perm.getWord());
		}
		return true;
	}
//	
//	 public Collection<String> getWordList(){
//	        return words;
//	    }
	 
	@Override
	public boolean addAll(Collection<String> words) {
		for(String w: words)
			add(w);
		return true;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return wordsMap.values().stream().mapToInt(List::size).sum();
	}

//	@Override
//	public WordList initFromFile(String fileName) {
//		//read the words that user wants to construct on a board.
//		try {
//			BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
//			String word  = reader.readLine();
//			while(word != null){
//				add(word);
//				word = reader.readLine();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return this;
//	}
	
	@Override
	public WordList initFromFile(String fileName) {
		//read the words that user wants to construct on a board.
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
			String word  = reader.readLine();
			while(word != null){
				add(word);
				word = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
}