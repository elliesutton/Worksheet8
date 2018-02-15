package predictive;

/**
 * This class is for creating a WordSig object (an object consisting of a word and its
 * numeric signature. It implements the comparable interface in order to compare two 
 * WordSigs
 * @author Ellen Sutton
 *
 */
public class WordSig implements Comparable<WordSig> {
	

	private String words;
	private String signature;
	
	/**
	 * WordSig is a constructor that makes an object consisting of a word
	 * and its signature
	 * @param words - the word
	 */
	public WordSig(String words) {
		this.words = words;
		this.signature = wordToSignature(words);
		
	}
	
	/**
	 * getter for the word of a WordSig
	 * @return the word
	 */
	public String getWords() {
		return words;
	}




	/**
	 * getter for the signature of a WordSig
	 * @return the signature
	 */
	public String getSignature() {
		return signature;
	}



	/**
	 * compareTo is a method that compares two WordSig objects with respect to their 
	 * numeric signatures.
	 * 
	 * @param ws - a WordSig
	 * @return +1 if this.signature > ws.signature, -1 if this.signature < ws.signature and 0 
	 * if they are equal
	 */
	@Override
	public int compareTo(WordSig ws) {
		return this.getSignature().compareTo(ws.getSignature());
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
	 * toString method 
	 * @return the word sig written as 'word signature'
	 */
	public String toString() {
		return words + " " + signature;
	}

}
