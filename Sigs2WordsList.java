package predictive;

/**
 * This is a command-line program for testing the ListDictionary class
 * @author Ellen Sutton
 *
 */
public class Sigs2WordsList {
	
	
	/**
	 * print is a method that takes the arguments from the command line and a path 
	 * to a dictionary and returns the possible words for each numeric signature, using
	 * that dictionary
	 * @param array - an array of numeric sigatures
	 * @param path - the path to the dictionary
	 */
	public static void print(String[] array, String path) {
		ListDictionary list = new ListDictionary(path);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " : " + list.signatureToWords(array[i]));
		}
	}


	public static void main(String[] args) {
		print(args, "dictionary.txt");
	}
	
	


}
