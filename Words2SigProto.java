package predictive;

/**
 * This is a command-line program for calling the wordToSignature method that exists in
 * the PredictivePrototype class
 * @author Ellen Sutton
 *
 */
public class Words2SigProto {
	
	/**
	 * print is a method that takes the arguments from the command line as words and returns
	 * their numeric signatures
	 * @param array - the arguments given in the command line
	 */
	public static void print(String[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println(PredictivePrototype.wordToSignature(array[i]));
		}
	}

	public static void main(String[] args) {
		print(args);
	}
	

}
