package entities;

public class Funcionario {

	private int id;
	private String name;
	private double salario;
	
	public Funcionario(int id, String name, double salario) {
		this.id = id;
		this.name = name;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", name=" + name + ", salario=" + salario + "]";
	}
	
	public double aumentaSalario(double percentual) {
		return this.salario + ((percentual / 100) * this.salario);
	}
}
