package entidades;

public class Funcionario {

	private int id;
	private String nome;
	private double salario;

	public Funcionario(int id, String nome, double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void aumentarSalario(double percentual) {
		double valor = (salario * percentual) / 100;
		salario += valor;
	}

	@Override
	public String toString() {
		return id + ", " + nome + ", " + salario;
	}

}
