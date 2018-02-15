package predictive;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * This is a class that contains first methods for converting words to numeric signatures
 * and numeric signatures to words
 * @author Ellen Sutton
 *
 */
public class PredictivePrototype {
	
	/**
	 * wordToSignature is a method that takes a word and returns a numeric signature, for
	 * example, "ellie" will return "35543". Any non-alphabetic characters produce a space.
	 * 
	 * This method uses StringBuffer instead of String because the method includes a lot of
	 * concatenations, which is much more efficient to do with StringBuffers than Strings.
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
	 * signatureToWords is a method that takes a given numeric signature and returns a set of 
	 * possible matching words from the dictionary.
	 * 
	 * This implementation is inefficient as the dictionary is unsorted and so every single word 
	 * in the dictionary is checked. 
	 * 
	 * @param signature - a numeric signature of type string
	 * @return a set of possible matching words from the dictionary (all lower case) with no 
	 * duplicates
	 */
	public static Set<String> signatureToWords(String signature) {
		Set<String> matchingWords = new HashSet<String>();
		try {
			File dictionary = new File("dictionary.txt");
			Scanner scanner = new Scanner(dictionary);
			while (scanner.hasNext()) {
				String word = scanner.next();
				if (isValidWord(word)) {
					word = word.toLowerCase();
					if (wordToSignature(word).equals(signature) && !matchingWords.contains(word))
						matchingWords.add(word);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return matchingWords;	
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
