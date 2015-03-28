package sorting;

public class PivotedBinarySearch {
	public static void main(String [] args) {
		int[] array = new int[]{4, 5, 6, 7, 8, 1, 2, 3};
		
		System.out.println(pivotedBinarySearch(array, 5, 0, array.length-1));
	}
	
	private static int pivotedBinarySearch(int[] array, int val, int l, int r) {
		while(l <= r) {
			int mid = (l + r)/2;
			
			if(array[mid] == val) {
				return mid;
			}
			
			if(array[l] <= array[mid]) {
				if(val >= array[l] && val <= array[mid]) {
					r = mid - 1;
				}
				else {
					l = mid + 1;
				}
			}
			else {
				if(val >= array[mid] && val <= array[r]) {
					l = mid + 1;
				}
				else {
					r = mid - 1;
				}
			}
		}
		
		return -1;
	}
}
