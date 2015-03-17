package sorting;

public class MergeAB {
	public static void main(String [] args) {
		int[] a = new int[]{5, 8, 10, 12, 0, 0, 0, 0, 0};
		int[] b = new int[]{2, 3, 6, 7, 10};
		
		a = merge2(a, b);
		
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
	}
	
	/**
	 * My solution
	 * @param a
	 * @param b
	 * @return
	 */
	private static int[] merge(int[] a, int[] b) {
		int aIndex = 0;
		int bIndex = 0;
		int aLength = a.length - b.length - 1;
		
		while(bIndex < b.length) {
			if(b[bIndex] <= a[aIndex]) {
				// Shift values to right
				for(int i = aLength; i >= aIndex; i--) {
					a[i+1] = a[i];
				}
				
				a[aIndex] = b[bIndex];
				aIndex++;
				bIndex++;
				aLength++;
			}
			else {
				aIndex++;
			}
		}
		
		return a;
	}
	
	/**
	 * Textbook solution
	 * @param a
	 * @param b
	 * @return
	 */
	private static int[] merge2(int[] a, int[] b) {
		int aIndex = a.length - b.length - 1;
		int bIndex = b.length - 1;
		int aEndIndex = a.length - 1;
		
		while(bIndex >= 0 && aIndex >= 0) {
			if(a[aIndex] >= b[bIndex]) {
				a[aEndIndex--] = a[aIndex--];
			}
			else {
				a[aEndIndex--] = b[bIndex--];
			}
		}
		
		while(bIndex >= 0) {
			a[aEndIndex--] = b[bIndex--];
		}
		
		return a;
	}
}
