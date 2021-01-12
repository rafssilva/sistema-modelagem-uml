package view;

import control.Invoker;
import model.Diagrama;
import model.Elemento;

// Anteriormente chamamos de DiagramaView, mas, antes de criarmos um diagrama, essa tela já existe para o usuário do software.
// Então, dei um nome genérico para depois decidirmos melhor.
public class View {

	public Object criarDiagrama() throws Exception {
		return Invoker.executarComando("criar Diagrama");
	}

	public Object criarElemento() throws Exception {
		return Invoker.executarComando("criar Elemento");
	}
	
	public Object criarRelacionamento(Elemento primeiroElemento, Elemento segundoElemento) throws Exception {
		return Invoker.executarComando("criar Relacionamento", primeiroElemento, segundoElemento);
	}
	
	public Object salvar(Diagrama diagrama) throws Exception {
		return Invoker.executarComando("salvar", diagrama);
	}

	public void desfazer() throws Exception {
		Invoker.executarComando("undo");
	}
}