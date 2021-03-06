package util;

import java.util.Arrays;

public class Permutation {
	private String word;
	private String normalizedWord;
/*
 * 
 */
	public Permutation(String word) {
		this.word = word;
		//Normalise the word by putting the letters into alphabetical order
		char tempArray[] = word.toLowerCase().trim().toCharArray();
		Arrays.sort(tempArray);
		//after the chars were sorted alphabetically, save it to string
		normalizedWord = new String(tempArray);
	}

	@Override
	public int hashCode() {
		//first version of hashCode() method
		int code = 0;
		for(int i = 0; i < getNormalized().length(); i++) {
			code += Character.getNumericValue(getNormalized().charAt(i));}
		return code;
		
		//second version of hashCode() as hashFunction: arrayIndex = hufeNumber % arraySize
		
	}
	
//	public int hashFunc() {
//		
//		//arrayIndex = hugeNumber % arraySize
//		//return getNormalized().hashCode() % code;
//	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Permutation) {
			Permutation other = (Permutation) obj;
			return getNormalized().equals(other.getNormalized());
		}
		return false;
	}

	@Override
	public String toString() {
		return getWord() + " / " + getNormalized();
	}

	public String getNormalized() {
		return normalizedWord;
	}

	public String getWord() {
		return word;
	}

	public int length() {
		// TBD: implement this method
		return 0;
	}

}