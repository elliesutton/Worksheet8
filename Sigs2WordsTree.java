package predictive;

/**
 * This is a command-line program for calling the signatureToWords method that exists in the
 * TreeDictionary class
 * @author exs404
 *
 */
public class Sigs2WordsTree {
	
	/**
	 * print is a method that takes the arguments from the command line as signatures and prints the  
	 * valid words
	 * @param array - the arguments given in the command line
	 */
	public static void print(String[] array) {
		TreeDictionary dictionary = new TreeDictionary("dictionary.txt");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " : " + dictionary.signatureToWords(array[i]));
		}
	}

	public static void main(String[] args) {
		print(args);
	}

}
