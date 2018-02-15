package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

/**
 * MapDictionary is a class that includes an improved implementation of the Dictionary
 * interface using a Map data structure (HashMap).
 * @author Ellen Sutton
 *
 */
public class MapDictionary implements Dictionary {
	
	HashMap<String, Set<String>> map;
	
	
	/**
	 * MapDictionary is a constructor that takes a path to a dictionary and stores the
	 * dictionary in a hashmap which maps each signature to a set of words
	 * hashmap because lookup is more efficient than a Treemap
	 * @param path
	 */
	public MapDictionary(String path) {
		HashMap<String, Set<String>> hmap = new HashMap<String, Set<String>>();
		try { 
			File dictionary = new File(path);
			Scanner scanner = new Scanner(dictionary);
			while (scanner.hasNextLine()) {
				String word = scanner.nextLine();
				if (isValidWord(word)) {
					String signature = wordToSignature(word);
					if (hmap.containsKey(signature)) {
						hmap.get(signature).add(word);
					} else {
						Set<String> newSet = new HashSet<String>();
						newSet.add(word);
						hmap.put(signature, newSet);
					}
				}
				
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.map = hmap;
	}
	
	
	/**
	 * sigantureToWords is a method that takes a given numeric signature and returns
	 * the corresponding set of words from the HashMap
	 * @param signature - a numeric signature
	 * @return the set of words corresponding to signature
	 */
	public Set<String> signatureToWords(String signature) {
		if (map.containsKey(signature)) {
			return map.get(signature);
		} else {
			Set<String> emptySet = new HashSet<String>();
			return emptySet;
		}		
	}
	

	
	/**
	 * wordToSignature is a method that takes a word and returns a numeric signature, for
	 * example, "ellie" will return "35543". Any non-alphabetic characters produce a space.
	 * 
	 * @param word - a word
	 * @return the numeric signature of the word
	 */
	public static String wordToSignature(String word) {
		StringBuffer signature = new StringBuffer(word.length());
		for (int i = 0; i < word.length(); i++) {
			char letter = word.charAt(i);
			if (letter == 'a' || letter == 'b' || letter == 'c')
				signature.append("2");
			else if (letter == 'd' || letter == 'e' || letter == 'f')
				signature.append("3");
			else if (letter == 'g' || letter == 'h' || letter == 'i')
				signature.append("4");
			else if (letter == 'j' || letter == 'k' || letter == 'l')
				signature.append("5");
			else if (letter == 'm' || letter == 'n' || letter == 'o')
				signature.append("6");
			else if (letter == 'p' || letter == 'q' || letter == 'r' || letter == 's')
				signature.append("7");
			else if (letter == 't' || letter == 'u' || letter == 'v')
				signature.append("8");
			else if (letter == 'w' || letter == 'x' || letter == 'y' || letter == 'z')
				signature.append("9");
			else
				signature.append(" ");
		}
			
		return signature.toString();		
	}
	
	/**
	 * isValidWord is a method that checks if a given word is valid or not
	 * @param word - a string 
	 * @return true if word is a valid word, false otherwise
	 */
	private static boolean isValidWord(String word) {
		for (int i = 0; i < word.length(); i++) {
			if (!Character.isLetter(word.charAt(i)))
				return false;
		}
		return true;	
	}
	

}
