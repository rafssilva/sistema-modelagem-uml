package model;

import log.Log4j;

public class Metodo extends Composto {

	private String tipoDeRetorno;
	private String nome;
	// Adicionar modificadores e parâmetros pelo composite ???
	// private List<Modificador> listaDeModificadores;
	// private List<Parametro> listaDeParametros;
	private static int id = 1;

	public Metodo() {
		// Nome default.
		nome = "Método" + id;
		id++;
	}

	@Override
	public void addFilho(Object objeto) {
		if (objeto instanceof Modificador || objeto instanceof Parametro) {
			super.addFilho(objeto);
		} else {
			Log4j.log.info("Filho de tipo inválido");
		}
	}

	@Override
	public String toString() {
		return nome;
	}

	public String getTipoDeRetorno() {
		return tipoDeRetorno;
	}

	public void setTipoDeRetorno(String tipoDeRetorno) {
		this.tipoDeRetorno = tipoDeRetorno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}