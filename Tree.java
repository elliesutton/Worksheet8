package predictive;

import java.util.HashSet;
import java.util.Set;

/**
 * Tree is a class for creating Tree objects where each node has 8 children 
 * @author Ellen Sutton
 *
 */
public class Tree {
	
	private boolean empty;
	private Tree two, three, four, five, six, seven, eight, nine;
	private Set<String> matchingWords;
	
	/**
	 * A constructor for an empty tree
	 */
	public Tree() {
		this.empty = true;
	}
	
	/**
	 * A constructor for a non-empty tree
	 * @param words
	 */
	public Tree(Set<String> words) {
		this.empty = false;
		this.matchingWords = words;
		createChildren();
	}
	
	/**
	 * createChildren is a method that creates the 8 child nodes for a node
	 */
	public void createChildren() {
		this.two = new Tree();
		this.three = new Tree();
		this.four = new Tree();
		this.five = new Tree();
		this.six = new Tree();
		this.seven = new Tree();
		this.eight = new Tree();
		this.nine = new Tree();
	}
	
	/**
	 * Getter for the matchingWords
	 * @return the matching words
	 */
	public Set<String> getMatchingWords() {
		if (empty)
			throw new IllegalStateException("No match");
		else
			return matchingWords;
	}
	
	/**
	 * Getter for the child node two
	 * @return - Tree two
	 */
	public Tree getTwo() {
		if (empty)
			throw new IllegalStateException("No match");
		else
			return two;
	}
	
	/**
	 * Getter for the child node three
	 * @return - Tree three
	 */
	public Tree getThree() {
		if (empty)
			throw new IllegalStateException("No match");
		else
			return three;
	}
	
	
	/**
	 * Getter for the child node four
	 * @return - Tree four
	 */
	public Tree getFour() {
		if (empty)
			throw new IllegalStateException("No match");
		else
			return four;
	}
	
	
	/**
	 * Getter for the child node five
	 * @return - Tree five
	 */
	public Tree getFive() {
		if (empty)
			throw new IllegalStateException("No match");
		else
			return five;
	}
	
	
	/**
	 * Getter for the child node six
	 * @return - Tree six
	 */
	public Tree getSix() {
		if (empty)
			throw new IllegalStateException("No match");
		else
			return six;
	}
	
	
	/**
	 * Getter for the child node seven
	 * @return - Tree seven
	 */
	public Tree getSeven() {
		if (empty)
			throw new IllegalStateException("No match");
		else
			return seven;
	}
	
	
	/**
	 * Getter for the child node eight
	 * @return - Tree eight
	 */
	public Tree getEight() {
		if (empty)
			throw new IllegalStateException("No match");
		else
			return eight;
	}
	
	
	/**
	 * Getter for the child node nine
	 * @return - Tree nine
	 */
	public Tree getNine() {
		if (empty)
			throw new IllegalStateException("No match");
		else
			return nine;
	}
	
	

	
	/**
	 * isEmpty checks if a tree is empty
	 * @return true if the tree is empty, false otherwise
	 */
	public boolean isEmpty() {
		return empty;
	}
	

	
	/**
	 * addMatchingWord adds a word to matchingWords
	 * @param word - a String
	 */
	public void addMatchingWord(String word) {
		if (empty) {
			Set<String> set = new HashSet<String>();
			set.add(word);
			this.matchingWords = set;
			this.empty = false;
			createChildren();
		} else {
			matchingWords.add(word);
		}
	}

}
