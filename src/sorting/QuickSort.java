package sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String [] args) {
		int[] array = new int[]{1, 2, 3, 5, 4};
		
		String[] array1 = new String[]{"hello"};
		Arrays.sort(array1);
		quickSort(array, 0, array.length - 1);
		
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
	}
	
	private static void quickSort(int[] array, int start, int end) {
		if(start < end) {
			int pIndex = partition(array, start, end);
			quickSort(array, start, pIndex - 1);
			quickSort(array, pIndex + 1, end);
		}
	}
	
	private static int partition(int[] array, int start, int end) {
		int pIndex = start;
		
		for(int i = start; i < end; i++) {
			if(array[i] <= array[end]) {
				swap(array, pIndex, i);
				pIndex++;
			}
		}
		
		swap(array, pIndex, end);
		return pIndex;
	}
	
	private static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
}
