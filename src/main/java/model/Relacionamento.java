package model;

public class Relacionamento {

	private String tipo;
	private String nome;
	private String direcaoDeLeitura;
	private ElementoRelacao elementosRelacionados;
	private static int id = 1;
	
	public Relacionamento() {
		// Nome default.
		nome = "Relacionamento" + id;
	}
	
	@Override
	public String toString() {
		return nome + " (" + elementosRelacionados + ")" ;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDirecaoDeLeitura() {
		return direcaoDeLeitura;
	}

	public void setDirecaoDeLeitura(String direcaoDeLeitura) {
		this.direcaoDeLeitura = direcaoDeLeitura;
	}

	public ElementoRelacao getElementosRelacionados() {
		return elementosRelacionados;
	}

	public void setElementosRelacionados(ElementoRelacao elementosRelacionados) {
		this.elementosRelacionados = elementosRelacionados;
	}
}