import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import data.SimpleWordList;
import util.Permutation;

class Test {

	@org.junit.jupiter.api.Test
	void getPermutationOfWord() {
		Permutation perm = new Permutation("rule");
		assertEquals("elru", perm.getNormalized());
	}
	
	@org.junit.jupiter.api.Test
	void  testEquals() {
		Permutation perm = new Permutation("rainbow");
		assertTrue(perm.equals(new Permutation("abinorw")));
	}
	@org.junit.jupiter.api.Test
	void testEquals2() {
		Permutation perm = new Permutation("rainbow");
		assertFalse(perm.equals(new Permutation("abbnorw")));
	}
	@org.junit.jupiter.api.Test
	void testToString() {
		String word = "java";
		//Permutation word = new Permutation("java");
		assertEquals("java / aajv", new Permutation(word).toString());
	}
	
	@org.junit.jupiter.api.Test
	void testHashCode() {
		Permutation perm1 = new Permutation("bla");
		Permutation perm2 = new Permutation("lab");
		assertTrue(perm1.hashCode() == perm2.hashCode());
		//assertEquals(perm1.hashCode(), perm2.hashCode());
	}
	
//	@org.junit.jupiter.api.Test
//	void testSearchValidsInSet() {
//	
//		SimpleWordList wordList = new SimpleWordList();
//		wordList.initFromFile("C:\\Users\\beeem\\Documents\\Uni Modulen\\info2\\wordLsts.txt");
//		//Set <String> set = wordList.validWordsUsingAllTiles("ab");
//		//assertEquals("ab, ba", wordList.validWordsUsingAllTiles("ab") );
//		assertEquals("ab, ba", wordList.initFromFile("C:\\Users\\beeem\\Documents\\Uni Modulen\\info2\\wordLsts.txt") );
//	
//	}
}
