package predictive;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * This class contains the tests for the second half of WS2-3
 * @author Ellen Sutton
 *
 */
public class Worksheet3Tests2 {
	
	MapDictionary map = new MapDictionary("dictionary.txt");
	TreeDictionary dictionary = new TreeDictionary("dictionary.txt");
	
	//section3 tests

	@Test
	public void test1() {
		String signature = "4663";
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("good");
		expectedSet.add("gone");
		expectedSet.add("home");
		
		Set<String> actualSet = map.signatureToWords(signature);
		
		assertEquals(expectedSet, actualSet);
	}
	
	@Test
	public void test2() {
		String signature = "293";
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("bye");
		expectedSet.add("axe");
		
		Set<String> actualSet = map.signatureToWords(signature);
		
		assertEquals(expectedSet, actualSet);
	}
	
	
	@Test
	public void test3() {
		String signature = "222222";
		Set<String> expectedSet = new HashSet<String>();

		
		Set<String> actualSet = map.signatureToWords(signature);
		
		assertEquals(expectedSet, actualSet);
	}
	
	
	@Test
	public void test4() {
		String signature = "35543";
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("ellie");

		
		Set<String> actualSet = map.signatureToWords(signature);
		
		assertEquals(expectedSet, actualSet);
	}
	
	
	
	//section4 tests
	
	@Test
	public void test5() {
		String signature = "";
		Set<String> expectedSet = new HashSet<String>();

		
		Set<String> actualSet = dictionary.signatureToWords(signature);
		
		assertEquals(expectedSet, actualSet);
	}
	
	
	@Test
	public void test6() {
		String signature = "4663";
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("good");
		expectedSet.add("gone");
		expectedSet.add("home");
		
		Set<String> actualSet = dictionary.signatureToWords(signature);
		
		assertEquals(expectedSet, actualSet);
	}
	
	
	@Test
	public void test7() {
		String signature = "4";
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("good");
		expectedSet.add("gone");
		expectedSet.add("home");
		expectedSet.add("hello");
		expectedSet.add("is");
		
		Set<String> actualSet = dictionary.signatureToWords(signature);
		
		assertEquals(expectedSet, actualSet);
	}
	
	
	@Test
	public void test8() {
		String signature = "43";
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("hello");
		
		Set<String> actualSet = dictionary.signatureToWords(signature);
		
		assertEquals(expectedSet, actualSet);
	}
	
	
	@Test
	public void test9() {
		String signature = "3554";
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("ellie");
		
		Set<String> actualSet = dictionary.signatureToWords(signature);
		
		assertEquals(expectedSet, actualSet);
	}
	
	
	@Test
	public void test10() {
		String signature = "2";
		Set<String> expectedSet = new HashSet<String>();
		expectedSet.add("bye");
		expectedSet.add("axe");
		
		Set<String> actualSet = dictionary.signatureToWords(signature);
		
		assertEquals(expectedSet, actualSet);
	}
	
	

}
