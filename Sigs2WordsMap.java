package predictive;

/**
 * This is a command-line program for calling the signatureToWords method that exists in the
 * MapDictionary class
 * @author Ellen Sutton
 *
 */
public class Sigs2WordsMap {
	
	/**
	 * print is a method that takes the arguments from the command line as signatures and prints the  
	 * valid words
	 * @param array - the arguments given in the command line
	 */
	public static void print(String[] array) {
		MapDictionary map = new MapDictionary("dictionary.txt");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " : " + map.signatureToWords(array[i]));
		}
	}

	public static void main(String[] args) {
		print(args);
	}
	

}
