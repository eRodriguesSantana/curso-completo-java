package application;

import java.util.Scanner;

public class MatrizExercicio {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int linha = sc.nextInt();
		int coluna = sc.nextInt();
		
		int[][] mat = new int[linha][coluna];
		
		for(int i=0; i<linha; i++) {
			for(int j=0; j<coluna; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		int numero = sc.nextInt();
		
		for(int i=0; i<linha; i++) {
			for(int j=0; j<coluna; j++) {
				if(mat[i][j] == numero) {
					System.out.print("Position " + i + "," + j + ":");
					
					// Se for a primeira a linha, não lê elementos acima
					if(i == 0 && j == 0) {
						System.out.print("\nRight: " + mat[i][j+1]);
						System.out.print("\nDown: " + mat[i+1][j]);
					}
					
					// Se for a última linha, não lê elementos abaixo
					if(i == linha-1 && j == 0) {
						System.out.print("\nRight: " + mat[i][j+1]);
						System.out.print("\nUp: " + mat[i-1][j]);
					}
					
					// Valida se há elementos a esquerda e se não está lendo a primeira linha
					if((j-1) <= coluna && (j-1) >= 0) {
						System.out.println("\nLeft: " + mat[i][j-1]);
						
						// Valida se há elementos a direita
						if(j < coluna -1)
							System.out.println("\nRight: " + mat[i][j+1]);
						
						// Valida se há elementos a acima
						if(i > 0)
							System.out.println("\nUp: " + mat[i-1][j]);
						
						// Valida se há elementos a abaixo
						if(i < linha -1)
							System.out.println("\nDown: " + mat[i+1][j]);
					}
					System.out.println("\n==============\n");
				}				
			}
		}		
		sc.close();
	}
}
