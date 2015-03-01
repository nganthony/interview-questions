package recursion;

import java.util.ArrayList;

public class SubsetsInSet {
	public static void main(String [] args) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(5);
		set.add(3);
		set.add(1);
		set.add(4);
		
		getSubsetsOfSet(set);
	}
	
	// Iterative approach
	private static void getSubsetsOfSet(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<ArrayList<Integer>>();
		
		int iteration = 1 << set.size();
		
		for(int i = 0; i < iteration; i++) {
			ArrayList<Integer> subset = new ArrayList<Integer>();
			int k = i;
			int index = 0;
			
			while(k > 0) {
				if((k & 1) > 0) {
					subset.add(set.get(index));
				}
				
				k >>= 1;
				index++;
			}
			
			allSubsets.add(subset);
		}
		
		// Print
		for(ArrayList<Integer> subset: allSubsets) {
			for(Integer number: subset) {
				System.out.print(number);
			}
			System.out.println();
		}
	}
}
