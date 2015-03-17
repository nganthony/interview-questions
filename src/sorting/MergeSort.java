package sorting;

public class MergeSort {
	public static void main(String [] args) {
		int[] array = new int[]{5, 1, 3, 8, 10, 4, 2, 6, 2, 11, 7};
		array = mergeSort(array);
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}
	
	private static int[] mergeSort(int[] array) {
		if(array.length <= 1) {
			return array;
		}
		
		int[] leftArray = new int[array.length/2];
		int[] rightArray = new int[array.length - array.length/2];
		
		// Divide the array into two halves
		for(int i = 0; i < array.length; i++) {
			if(i < array.length/2) {
				leftArray[i] = array[i];
			}
			else {
				rightArray[i - array.length/2] = array[i];
			}
		}
		
		// Sort each of the halves
		leftArray = mergeSort(leftArray);
		rightArray = mergeSort(rightArray);
		
		int l = 0;
		int r = 0;
		int a = 0;
		
		// Merge the two halves
		while(l < leftArray.length && r < rightArray.length) {
			if(leftArray[l] <= rightArray[r]) {
				array[a] = leftArray[l];
				l++;
			}
			else {
				array[a] = rightArray[r];
				r++;
			}
			a++;
		}
		
		while(l < leftArray.length) {
			array[a] = leftArray[l];
			l++;
			a++;
		}
		
		while(r < rightArray.length) {
			array[a]= rightArray[r];
			r++;
			a++;
		}
		
		return array;
	}
}
