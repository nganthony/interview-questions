package recursion;

import java.util.HashSet;

/**
 * Solution to Q8.5 of CTCI
 * @author Anthony
 *
 */
public class Parentheses {

	public static void main(String [] args) {
//		HashSet<String> allP = getParentheses(4);
//		
//		for(String p: allP) {
//			System.out.println(p);
//		}
		
		printPar(3);
	}
	
	private static HashSet<String> getParentheses(int n) {
		HashSet<String> allP = new HashSet<String>();
		
		if(n < 1) {
			return null;
		}
		else if(n == 1) {
			allP.add("()");
			return allP;
		}
		
		HashSet<String> parentheses = getParentheses(n-1);
		
		for(String p: parentheses) {
			for(int i = 0; i < p.length(); i++) {
				allP.add(insertParentheses(p, i));
			}
		}
		
		return allP;
	}
	
	private static String insertParentheses(String p, int index) {
		String start = p.substring(0, index);
		String end = p.substring(index);
		return start + "()" + end;
	}
	
	public static void printPar(int l, int r, char[] str, int count) {
		if (l < 0 || r < l) return; // invalid state
		
		if (l == 0 && r == 0) {
				System.out.println(str); // found one, so print it
		} else {
			if (l > 0) { // try a left paren, if there are some available
				str[count] = '(';
				printPar(l - 1, r, str, count + 1);
			}
			if (r > l) { // try a right paren, if there’s a matching left
				str[count] = ')';
				printPar(l, r - 1, str, count + 1);
			}
		}
	}
		
	public static void printPar(int count) {
		char[] str = new char[count*2];
		printPar(count, count, str, 0);
	}
}
