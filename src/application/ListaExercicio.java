package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

/**
 * 
 * @author Eduardo Rodrigues Santana
 *
 *Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de
 *N funcionarios. Não deve haver repetição de id.
 *
 *Em seguida, efetuar o aumnento de X por cento no salário de um determinado funcionario.
 *Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma
 *mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionarios.
 *
 *Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa
 *ser mudado livremente. Um salário só pode ser aumentado com base em uma operação de
 *aumento por porcentagem dada.
 */
public class ListaExercicio {
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Funcionario> listFuncionario = new ArrayList<>();
		
		System.out.print("How many employees will be registred: ");
		int qtdFuncionarios = sc.nextInt();
		
		for(int i=0; i<qtdFuncionarios; i++) {
			int id = sc.nextInt();			
			
			if(confereID(id, listFuncionario) == null)
				listFuncionario.add(new Funcionario(id, sc.next(), sc.nextDouble()));
			else {
				System.err.println("ID já existe, insira outro.");
				i--;
			}
		}
		
		exibeFuncionarios(listFuncionario);		
		
		System.out.println("===========================");
		
		System.out.print("Enter the employee id that will have salary increase: ");
		Funcionario id = confereID(sc.nextInt(), listFuncionario);
		if(id != null) {
			System.out.print("Enter the percentage: ");
			double percentSalario = sc.nextDouble();
			id.setSalario(id.aumentaSalario(percentSalario));
			exibeFuncionarios(listFuncionario);	
		} else {
			System.err.println("This id does not exist!");
			exibeFuncionarios(listFuncionario);
		}
			
		
		
		sc.close();
	}
	
	public static Funcionario confereID(int id, List<Funcionario> listFuncionario) {
		return listFuncionario
				.stream()
				.filter(x -> x.getId() == id)
				.findFirst()
				.orElse(null);
	}
	
	public static void exibeFuncionarios(List<Funcionario> listFuncionario) {
		int cont = 1;
		for(Funcionario f : listFuncionario) {
			System.out.println("Employee #"+cont);
			System.out.println(f);
			cont++;
		}
	}

}
