package model;

public class Diagrama extends Composto {

	private String nome;
	private static int id = 1;

	public Diagrama() {
		// Nome default.
		nome = "Diagrama" + id;
		id++;
	}

	@Override
	public String toString() {
		return nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}