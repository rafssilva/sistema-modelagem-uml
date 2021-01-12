package main;

import model.Diagrama;
import model.Elemento;
import view.View;

public class Main {

	public static void main(String[] args) throws Exception {

		View telaMenu = new View();

		Diagrama diagrama = (Diagrama) telaMenu.criarDiagrama();
		
		Elemento elemento1 = (Elemento) telaMenu.criarElemento();
		
		Elemento elemento2 = (Elemento) telaMenu.criarElemento();
		
		telaMenu.criarRelacionamento(elemento1, elemento2);
		
		telaMenu.salvar(diagrama);
		
		telaMenu.desfazer();
		telaMenu.desfazer();
		telaMenu.desfazer();
		telaMenu.desfazer();
		telaMenu.desfazer();
		telaMenu.desfazer();
	}
}