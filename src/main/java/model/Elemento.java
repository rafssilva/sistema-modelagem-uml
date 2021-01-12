package model;

import log.Log4j;

public class Elemento extends Composto {

	private String nome;
	// Adicionar atributos e métodos pelo composite ???
	// private List<Atributo> listaDeAtributos;
	// private List<Metodo> listaDeMetodos;
	private static int id = 1;

	public Elemento() {
		// Nome default.
		nome = "Elemento" + id;
		id++;
	}

	@Override
	public void addFilho(Object objeto) {
		if (objeto instanceof Atributo || objeto instanceof Metodo) {
			super.addFilho(objeto);
		} else {
			Log4j.log.info("Filho de tipo inválido");
		}
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