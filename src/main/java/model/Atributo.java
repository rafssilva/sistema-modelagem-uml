package model;

import log.Log4j;

public class Atributo extends Composto {

	private String tipoDeDado;
	private String nome;
	// Adicionar modificadores pelo composite ???
	// private List<Modificador> listaDeModificadores;
	private static int id = 1;

	public Atributo() {
		// Nome default.
		nome = "Atributo" + id;
		id++;
	}

	@Override
	public void addFilho(Object objeto) {
		if (objeto instanceof Modificador) {
			super.addFilho(objeto);
		} else {
			Log4j.log.info("Filho de tipo inválido");
		}
	}
	
	@Override
	public String toString() {
		return nome;
	}

	public String getTipoDeDado() {
		return tipoDeDado;
	}

	public void setTipoDeDado(String tipoDeDado) {
		this.tipoDeDado = tipoDeDado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}