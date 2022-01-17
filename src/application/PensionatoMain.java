package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Estudante;

/**
 * 
 * @author Eduardo Rodrigues Santana
 * 
 *A dona de um pensionato possui dez quartos para alugar para estudantes,
 *sendo esses quartos identificados pelos números 0 e 9.
 *
 *Fazer um programa que inicie com todos os dez quartos vazios, e depois
 *leia uma quantidade N representando o número de estudantes que vão
 *alugar quartos (N pode ser de 1 a 10). Em seguida, registre o aluguel dos
 *N estudantes. Para cada registro de aluguel, informar o nome e email do 
 *estudante, bem como qual dos quartos ele escolheu (de 0 a 9). Suponha
 *que seja escolhido um quarto vago. Ao final, seu programa deve imprimir
 *um relatório de todas ocupações do pensionato, por ordem de quarto.
 */
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
