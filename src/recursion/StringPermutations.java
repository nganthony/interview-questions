package recursion;

/**
 * Solution to Q8.4 of Cracking the Coding Interview
 * @author Anthony
 *
 */
public class StringPermutations {
	public static void main(String [] args) {
		String s = "abcd";
		printPermutations(s);
	}
	
	private static void printPermutationsHelper(String s, String currentString) {
		if(s.isEmpty()) {
			// Base case
			System.out.println(currentString);
		}
		else {
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				StringBuilder stringBuilder = new StringBuilder(s);
				stringBuilder.deleteCharAt(i);
				printPermutationsHelper(stringBuilder.toString(), currentString + c);
			}
		}
	}
	
	private static void printPermutations(String s) {
		printPermutationsHelper(s, "");
	}
}
