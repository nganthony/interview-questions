package recursion;

import java.util.ArrayList;

/**
 * Solution to Q8.4 of Cracking the Coding Interview
 * @author Anthony
 *
 */
public class StringPermutations {
	public static void main(String [] args) {
		String s = "abc";
		ArrayList<String> permutations = getPermutations(s, 0);
		
		for(String permutation: permutations) {
			System.out.println(permutation);
		}		
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
	
	private static ArrayList<String> getPermutations(String s, int index) {
		ArrayList<String> permutations = new ArrayList<String>();;
		
		if(s.length() == index) {
			permutations.add("");
		}
		else {
			ArrayList<String> oldPermutations = getPermutations(s, index + 1);
			char first = s.charAt(index);
			
			for(int i = 0; i < oldPermutations.size(); i++) {
				String oldPermutation = oldPermutations.get(i);
				for(int j = 0; j <= oldPermutation.length(); j++) {
					permutations.add(insertChar(oldPermutation, first, j));
				}
			}
 		}
		
		return permutations;
	}
	
	private static String insertChar(String s, char c, int index) {
		String newString;
		
		if(index == 0) {
			newString = c + s;
		}
		else if(index == s.length()) {
			newString = s + c;
		}
		else {
			newString = s.substring(0, index) + c + s.substring(index);
		}
		
		return newString;
	}
}
