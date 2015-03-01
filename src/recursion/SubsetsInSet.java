package recursion;

import java.util.ArrayList;

public class SubsetsInSet {
	public static void main(String [] args) {
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(5);
		set.add(3);
		set.add(1);
		
		ArrayList<ArrayList<Integer>> allSubsets = rGetSubsetsOfSet(set, 0);
		
		// Print
		for(ArrayList<Integer> subset: allSubsets) {
			for(Integer number: subset) {
				System.out.print(number);
			}
			System.out.println();
		}
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
	
	private static ArrayList<ArrayList<Integer>> rGetSubsetsOfSet(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allSubsets;
		
		if(set.size() == index) {
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>()); // Base case with empty set
		}
		else {
			allSubsets = rGetSubsetsOfSet(set, index + 1);
			int first = set.get(index);
			ArrayList<ArrayList<Integer>> addedSubsets = new ArrayList<ArrayList<Integer>>();
			
			for(ArrayList<Integer> subset: allSubsets) {
				ArrayList<Integer> addedSubset = new ArrayList<Integer>(subset);
				addedSubset.add(first);
				addedSubsets.add(addedSubset);
			}
			
			allSubsets.addAll(addedSubsets);
		}
		
		return allSubsets;
	}
}
