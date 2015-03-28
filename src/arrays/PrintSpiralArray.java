package arrays;

public class PrintSpiralArray {
	public static void main(String [] args) {
		int[][] array1 = new int[][]{{1, 2, 3, 4, 5}, {12, 13, 14, 15, 6}, {11, 10, 9, 8, 7}};
		int[][] array2 = new int[][]{{0, 1, 2}, {5, 4, 3}};
		int[][] array3 = new int[][]{{0, 1, 2, 3}, {11, 12, 13, 4}, {10, 15, 14, 5}, {9, 8, 7, 6}};
		int[][] array4 = new int[][]{{0}, {1}, {2}, {3}};
		int[][] array5 = new int[][]{{0}};
		int[][] array6 = new int[][]{{0, 1, 2, 3, 4, 5}};
		int[][] array7 = new int[][]{{0, 1, 2}, {13, 14, 3}, {12, 15, 4}, {11, 16, 5}, {10, 17, 6}, {9, 8, 7}};
		
		printSpiralArray(array1);
		System.out.println();
		
		printSpiralArray(array2);
		System.out.println();
		
		printSpiralArray(array3);
		System.out.println();
		
		printSpiralArray(array4);
		System.out.println();
		
		printSpiralArray(array5);
		System.out.println();
		
		printSpiralArray(array6);
		System.out.println();
		
		printSpiralArray(array7);
		System.out.println();
	}
	
	private static void printSpiralArray(int[][] array) {
		printSpiralArray(array, 0, array.length-1, 0, array[0].length-1);
	}
	
	private static void printSpiralArray(int[][] array, 
			int startRow, int endRow, 
			int startCol, int endCol) {
		
		if(startRow > endRow || startCol > endCol) {
			return;
		}
		
		// Print out first row
		for(int j = startCol; j <= endCol; j++) {
			System.out.print(array[startRow][j] + ", ");
		}
		
		// Print out last column
		for(int i = startRow + 1; i <= endRow; i++) {
			System.out.print(array[i][endCol] + ", ");
		}

		if(startRow != endRow) {
			// Print out last row in reverse
			for(int j = endCol - 1; j >= startCol; j--) {
				System.out.print(array[endRow][j] + ", ");
			}
		}

		if(startCol != endCol) {
			// Print out first column in reverse
			for(int i = endRow-1; i >= startRow + 1; i--) {
				System.out.print(array[i][startCol] + ", ");
			}
		}

		printSpiralArray(array, startRow + 1, endRow - 1, startCol + 1, endCol - 1);
		
	}
}
