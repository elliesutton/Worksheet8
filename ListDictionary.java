package predictive;

import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/**
 * This is a class that contains a more efficient method for the signatureToWords method
 * as it uses a sorted dictionary and conducts binary search to find the required words.
 * @author Ellen Sutton
 *
 */
public class ListDictionary implements Dictionary {
	
	private ArrayList<WordSig> listDictionary;
	

	/**
	 * ListDictionary is a constructor to form a sorted list of words from
	 * a dictionary
	 * @param path - the path to the dictionary
	 */
	public ListDictionary(String path) {
		ArrayList<WordSig> arraylist = new ArrayList<WordSig>();
		try { 
			File dictionary = new File(path);
			Scanner scanner = new Scanner(dictionary);
			while (scanner.hasNextLine()) {
				String word = scanner.nextLine();
				if (isValidWord(word)) {
					WordSig wordsig = new WordSig(word);
					if (!arraylist.contains(wordsig))
						arraylist.add((wordsig));
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Collections.sort(arraylist);
		this.listDictionary = arraylist;
	}
	
	

	
	
    /**
     * Getter for the Words Signature ArrayList created.
     *
     * @return the Words Signature ArrayList.
     */
    public ArrayList<WordSig> getlistDictionary() {
        return listDictionary;
    }
	
	
	/**
	 * signatureToWords is a method that takes a given numeric signature and returns a set of 
	 * possible matching words from the list dictionary.
	 * 
	 * @param signature - a numeric signature of type string
	 * @return a set of possible matching words from the dictionary (all lower case) with no 
	 * duplicates
	 */
	public Set<String> signatureToWords(String signature) {
		WordSig wordSig = randomWordSig(signature);
		int index = Collections.binarySearch(listDictionary, wordSig);

		Set<String> matchingWords = new HashSet<String>();
		if (index < 0) {
			return matchingWords;
		} else {
			matchingWords.add(listDictionary.get(index).getWords());
		
			int currentIndex = index;
			if (currentIndex < listDictionary.size() - 1){
				currentIndex++;
				while (currentIndex < listDictionary.size() 
						&& listDictionary.get(currentIndex).getSignature().equals(signature)) {
					matchingWords.add(listDictionary.get(currentIndex).getWords());
				currentIndex++;
				}
			}
		

			currentIndex = index;
			if (currentIndex > 0) {
				currentIndex--;
				while (currentIndex >= 0 && 
						listDictionary.get(currentIndex).getSignature().equals(signature)) {
					matchingWords.add(listDictionary.get(currentIndex).getWords());
					currentIndex--;
				}
			} 
		}
		
			return matchingWords;	
	} 
	

	/**
	 * randomWordSig is a method that is used to help the method signatureToWords by
	 * taking a signature and generating a word to make a WordSig object with.
	 * @param signature - a numeric signature
	 * @return a WordSig object with that signature and a random, valid word
	 */
	public static WordSig randomWordSig(String signature) {
		StringBuffer word = new StringBuffer();
		for (int i = 0; i < signature.length(); i++) {
			char number = signature.charAt(i);
			if (number == '2')
				word.append('a');
			else if (number == '3')
				word.append('d');
			else if (number == '4')
				word.append('g');
			else if (number == '5')
				word.append('j');
			else if (number == '6')
				word.append('m');
			else if (number == '7')
				word.append('p');
			else if (number == '8')
				word.append('t');
			else //if number == 9
				word.append('w');
		}
		return new WordSig(word.toString());
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
