package ctci.ch1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class RotateMatrix {

	/**
	 * Rotate a n x n matrix 90 degrees
	 * @param m
	 * @return
	 */
	public int[][] rotateMatrix(int[][] m) {
		
		int[][] rotated = new int[m.length][m.length];
		for(int i = 0; i<m.length; i++) {
			for(int j = 0; j<m.length; j++) {
				rotated[j][m.length - i - 1] = m[i][j];
			}
		}
		return rotated;
	}
	
	@Test
	public void test() {
		int[][] m = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int[][] rotated = rotateMatrix(m);
		printMatrix(rotated);
		assertTrue(Arrays.deepEquals(rotated, new int[][]{{7,4,1},{8,5,2},{9,6,3}}));
		
		m = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		rotated = rotateMatrix(m);
		printMatrix(rotated);
		assertTrue(Arrays.deepEquals(rotated, new int[][]{{13,9,5,1},{14,10,6,2},{15,11,7,3},{16,12,8,4}}));
	}
	
	public void printMatrix(int [][] m) {
		for(int[] i : m) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
