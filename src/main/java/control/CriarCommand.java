package control;

import log.Log4j;
import model.Diagrama;
import model.Elemento;
import model.ElementoRelacao;
import model.Relacionamento;

public class CriarCommand implements Command {

	private Object objetoCriado;

	public Object execute(Object[] parametros) {

		objetoCriado = parametros[0];

		if (objetoCriado instanceof Diagrama) {

			Diagrama diagrama = (Diagrama) objetoCriado;
			control.Controller.historicoDeAlteracoesNoProjeto.add(diagrama);
			Log4j.log.info("Criou o diagrama: " + diagrama);
			Log4j.log.info("Novo estado do projeto: " + control.Controller.historicoDeAlteracoesNoProjeto);
			return diagrama;

		} else if (objetoCriado instanceof Elemento) {

			Elemento elemento = (Elemento) objetoCriado;
			control.Controller.historicoDeAlteracoesNoProjeto.add(elemento);
			Log4j.log.info("Criou o elemento: " + elemento);
			Log4j.log.info("Novo estado do projeto: " + control.Controller.historicoDeAlteracoesNoProjeto);
			return elemento;
			
		} else if (objetoCriado instanceof Relacionamento) {
			
			Relacionamento relacionamento = (Relacionamento) objetoCriado;
			ElementoRelacao elementosRelacionados = new ElementoRelacao((Elemento) parametros[1], (Elemento) parametros[2]);
			relacionamento.setElementosRelacionados(elementosRelacionados);
			control.Controller.historicoDeAlteracoesNoProjeto.add(relacionamento);
			Log4j.log.info("Criou o relacionamento: " + relacionamento);
			Log4j.log.info("Novo estado do projeto: " + control.Controller.historicoDeAlteracoesNoProjeto);
			return relacionamento;
			
		} else {
			Log4j.log.info("Objeto inválido para ser criado");
			return null;
		}
	}

	public void undo() {
		// Remove a última alteração do histórico da aplicação.
		control.Controller.historicoDeAlteracoesNoProjeto.remove(objetoCriado);
		Log4j.log.info("Desfez a última ação de criar");
		Log4j.log.info("Novo estado do projeto: " + control.Controller.historicoDeAlteracoesNoProjeto);
	}
}