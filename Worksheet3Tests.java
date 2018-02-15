package predictive;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * This class contains the tests for the first half of WS2-3
 * @author exs404
 *
 */
public class Worksheet3Tests {
	
	
	ListDictionary listDictionary = new ListDictionary("dictionary.txt");
	
	//section1 tests
	
	//wordToSignature
	
	@Test
	public void test1() {
		String word = "hello";
		String expected = "43556";
		String actual = PredictivePrototype.wordToSignature(word);
		
		assertEquals(expected, actual);	
	}
	
	@Test
	public void test2() {
		String word = "hello my name is ellie";
		String expected = "43556 69 6263 47 35543";
		String actual = PredictivePrototype.wordToSignature(word);
		
		assertEquals(expected, actual);	
	}
	
	@Test
	public void test3() {
		String word = "hiiiiii friend";
		String expected = "4444444 374363";
		String actual = PredictivePrototype.wordToSignature(word);
		
		assertEquals(expected, actual);	
	}
	
	@Test
	public void test4() {
		String word = "abcdefg hijklmnop qrs tuv wxyz";
		String expected = "2223334 445556667 777 888 9999";
		String actual = PredictivePrototype.wordToSignature(word);
		
		assertEquals(expected, actual);	
	}
	
	
	//signatureToWord
	
	@Test
	public void test5() {
		String signature = "43556";
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("hello");
		
		Set<String> actualSet = PredictivePrototype.signatureToWords(signature);

		assertEquals(expectedSet, actualSet);	
	}
	
	@Test
	public void test6() {
		String signature = "4663";
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("good");
		expectedSet.add("gone");
		expectedSet.add("home");
		
		Set<String> actualSet = PredictivePrototype.signatureToWords(signature);

		assertEquals(expectedSet, actualSet);
	}
	
	@Test
	public void test7() {
		String signature = "293";
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("axe");
		expectedSet.add("bye");
		
		Set<String> actualSet = PredictivePrototype.signatureToWords(signature);

		assertEquals(expectedSet, actualSet);	
	}
	
	@Test
	public void test8() {
		String signature = "22222222222";
		Set<String> expectedSet = new HashSet<String>();

		Set<String> actualSet = PredictivePrototype.signatureToWords(signature);

		assertEquals(expectedSet, actualSet);	
	}
	
	
	
	//section2 tests
	
	@Test
	public void test9() {
		String signature = "43556";
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("hello");
		
		Set<String> actualSet = listDictionary.signatureToWords(signature);

		assertEquals(expectedSet, actualSet);	
	}
	
	@Test
	public void test10() {
		String signature = "4663";
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("gone");
		expectedSet.add("home");
		expectedSet.add("good");
		
		Set<String> actualSet = listDictionary.signatureToWords(signature);

		assertEquals(expectedSet, actualSet);
		
	}
	
	@Test
	public void test11() {
		String signature = "293";
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("axe");
		expectedSet.add("bye");
		
		Set<String> actualSet = listDictionary.signatureToWords(signature);

		assertEquals(expectedSet, actualSet);	
	}
	
	@Test
	public void test12() {
		String signature = "22222222222";
		Set<String> expectedSet = new HashSet<String>();

		Set<String> actualSet = listDictionary.signatureToWords(signature);

		assertEquals(expectedSet, actualSet);
	}
	

}
