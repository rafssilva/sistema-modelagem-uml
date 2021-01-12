package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Composto {

	private List<Object> listaDeFilhos;

	public Composto() {
		listaDeFilhos = new ArrayList<Object>();
	}

	public void addFilho(Object objeto) {
		listaDeFilhos.add(objeto);
	}
}