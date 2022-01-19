package demo;

import java.util.Scanner;

public class MatrizDemo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] matriz = new int[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				matriz[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Main diagonal:");
		for(int i=0; i<matriz.length; i++) {			
			System.out.print(matriz[i][i] + " ");
		}
		
		int sum = 0;
		for(int i=0; i<matriz.length; i++) {
			for(int j=0; j<matriz.length; j++) {
				if(matriz[i][j] < 0)
					sum++;
			}
		}
		System.out.print("\nNegative numbers = " + sum);
		
		sc.close();
	}
}
