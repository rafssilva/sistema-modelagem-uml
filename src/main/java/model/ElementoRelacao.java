package model;

public class ElementoRelacao {

	private String multiplicidade;
	private String navegabilidade;
	private String papel;
	// private Modificador modificadorDeAcesso; ???
	private Elemento primeiroElemento;
	private Elemento segundoElemento;

	public ElementoRelacao(Elemento primeiroElemento, Elemento segundoElemento) {
		this.primeiroElemento = primeiroElemento;
		this.segundoElemento = segundoElemento;
	}
	
	@Override
	public String toString() {
		return primeiroElemento + " - " + segundoElemento;
	}

	public String getMultiplicidade() {
		return multiplicidade;
	}

	public void setMultiplicidade(String multiplicidade) {
		this.multiplicidade = multiplicidade;
	}

	public String getNavegabilidade() {
		return navegabilidade;
	}

	public void setNavegabilidade(String navegabilidade) {
		this.navegabilidade = navegabilidade;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}

	public Elemento getPrimeiroElemento() {
		return primeiroElemento;
	}

	public void setPrimeiroElemento(Elemento primeiroElemento) {
		this.primeiroElemento = primeiroElemento;
	}

	public Elemento getSegundoElemento() {
		return segundoElemento;
	}

	public void setSegundoElemento(Elemento segundoElemento) {
		this.segundoElemento = segundoElemento;
	}
}