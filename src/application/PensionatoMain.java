package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Estudante;

public class PensionatoMain {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		Estudante[] estudanteQuarto = new Estudante[10];
		
		System.out.print("How many rooms will be rented?: ");
		int qtdAlunos = sc.nextInt();
		
		if(qtdAlunos > estudanteQuarto.length) {
			System.err.println("Capacidade de acomodação insuficiente. de 1 a 10.");
		} else {
			for(int i=0; i<qtdAlunos; i++) {
				System.out.print("Number bedroom: ");
				int bedroom = sc.nextInt();
				
				if(bedroom < 10 && estudanteQuarto[bedroom] == null) {
					System.out.print("Name: ");
					String name = sc.next();
					
					System.out.print("Email: ");
					String email = sc.next();
					
					estudanteQuarto[bedroom] = new Estudante(name, email, bedroom);
				} else {
					System.err.println("Other bedroom, please.");
					i--;
					continue;
				}
			}
			
			System.out.println("===============================================================");
			
			int cont = 1;
			for(Estudante e : estudanteQuarto) {
				if(e != null) {
					System.out.println("Rent #"+cont);
					System.out.println(e);
					cont++;
				}
			}
		}
		
		System.out.println("===============================================================");
		
		int cont2 = 0;
		
		System.out.println("Busy rooms:");

		for(Estudante e : estudanteQuarto) {
			if(e != null) {
				System.out.println((cont2 + 1) + ": " + e);
				cont2++;
			}
		}
		
		sc.close();
	}
}
