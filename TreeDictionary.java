package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 * This class includes another improved implementation of the Dictionary interface using
 * a tree structure
 * @author Ellen Sutton
 *
 */
public class TreeDictionary implements Dictionary{
	

	private Tree tree;
	
	/**
	 * TreeDictionary is a constructor that takes a path to a dictionary and stores the words
	 * in a tree structure
	 * @param path - the path to the dictionary
	 */
	public TreeDictionary(String path) {
		Set<String> set = new HashSet<String>();
		Tree tree = new Tree(set);
		try { 
			File dictionary = new File(path);
			Scanner scanner = new Scanner(dictionary);
			while (scanner.hasNextLine()) {
				String word = scanner.nextLine();
				if (isValidWord(word)) {
					addWord(word, word, tree);
				}
				
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.tree = tree;
	}
	
	/**
	 * addWord is a method that adds a word to the TreeDictionary
	 * @param word - the full word to be added to the dictionary
	 * @param remainingWord - the remaining part of the word
	 * @param tree - the tree in which to add the word
	 */
	public static void addWord(String word, String remainingWord, Tree tree) {
		if (remainingWord.length() != 0) {
			char letter = remainingWord.charAt(0);
			
			if (letter == 'a' || letter == 'b' || letter == 'c') {
				tree = tree.getTwo();
				tree.addMatchingWord(word);
				remainingWord = remainingWord.substring(1);
				addWord(word, remainingWord, tree);
			} 
			
			else if (letter == 'd' || letter == 'e' || letter == 'f') {
				tree = tree.getThree();
				tree.addMatchingWord(word);
				remainingWord = remainingWord.substring(1);
				addWord(word, remainingWord, tree);
			}
			
			
			else if (letter == 'g' || letter == 'h' || letter == 'i') {
				tree = tree.getFour();
				tree.addMatchingWord(word);
				remainingWord = remainingWord.substring(1);
				addWord(word, remainingWord, tree);
			}
			
			
			else if (letter == 'j' || letter == 'k' || letter == 'l') {
				tree = tree.getFive();
				tree.addMatchingWord(word);
				remainingWord = remainingWord.substring(1);
				addWord(word, remainingWord, tree);
			}
				
				
				
			else if (letter == 'm' || letter == 'n' || letter == 'o') {
				tree = tree.getSix();
				tree.addMatchingWord(word);
				remainingWord = remainingWord.substring(1);
				addWord(word, remainingWord, tree);
			}
			
			
			else if (letter == 'p' || letter == 'q' || letter == 'r' || letter == 's') {
				tree.getSeven();
				tree.addMatchingWord(word);
				remainingWord = remainingWord.substring(1);
				addWord(word, remainingWord, tree);
			}
			
			
			else if (letter == 't' || letter == 'u' || letter == 'v') {
				tree = tree.getEight();
				tree.addMatchingWord(word);
				remainingWord = remainingWord.substring(1);
				addWord(word, remainingWord, tree);
			}
			
			
			else if (letter == 'w' || letter == 'x' || letter == 'y' || letter == 'z') {
				tree = tree.getNine();
				tree.addMatchingWord(word);
				remainingWord = remainingWord.substring(1);
				addWord(word, remainingWord, tree);
			}
		} 
		
		else { //if length = 0
			return; 
		}
	}
	
	

	/**
	 * signatureToWords is a method that takes a numeric signature and returns
	 * the set of matching words for that signature
	 * @param signature - a numeric signature of type string
	 * @return the set of matching words to that signature
	 */
	public Set<String> signatureToWords(String signature) {
		if (isValidSignature(signature)) {
			return bubbleDown(signature, this.tree).getMatchingWords();	
		} else {
			return new HashSet<String>();
		}
	}
	
	
	/**
	 * bubbleDown is a method that takes a signature and a tree and bubbles down each
	 * node that corresponds to each number in the signature to eventually return the 
	 * final node where that signature exists
	 * @param signature - a numeric signature of type string
	 * @param tree - a tree
	 * @return the final node where that signature exists
	 */
	public static Tree bubbleDown(String signature, Tree tree) {
		if (signature.length() == 0)
			return tree;
		else {
			char number = signature.charAt(0);
			if (number == '2') 
				return bubbleDown(signature.substring(1), tree.getTwo());
			else if (number == '3')
				return bubbleDown(signature.substring(1), tree.getThree());
			else if (number == '4')
				return bubbleDown(signature.substring(1), tree.getFour());
			else if (number == '5')
				return bubbleDown(signature.substring(1), tree.getFive());
			else if (number == '6')
				return bubbleDown(signature.substring(1), tree.getSix());
			else if (number == '7')
				return bubbleDown(signature.substring(1), tree.getSeven());
			else if (number == '8')
				return bubbleDown(signature.substring(1), tree.getEight());
			else //if number == 9
				return bubbleDown(signature.substring(1), tree.getNine());			
		}
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
	
	/**
	 * isValidSignature is a method that checks if a given signature is valid or not
	 * @param signature - a string 
	 * @return true if signature is a valid signature, false otherwise
	 */
	private static boolean isValidSignature(String signature) {
		return signature.matches("[2-9]+");
	}
	
	
/*	public static void main(String[] args) {
		TreeDictionary dictionary = new TreeDictionary("dictionary.txt");
		System.out.println(dictionary.signatureToWords("4663"));
		
		} */



}
