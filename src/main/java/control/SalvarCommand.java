package control;

import log.Log4j;
import model.BancoDeDados;
import model.Diagrama;

public class SalvarCommand implements Command {

	private String chaveDoObjetoSalvo;
	
	public Object execute(Object[] parametros) {
		
		// Atualmente salvando um dado diagrama a um pseudo banco de dados.
		// Manter desta forma? Se sim, adicionar o histórico de alterações ao diagrama?
		// Se não, salvaríamos o projeto como um todo?
		// (No caso, salvaríamos o histórico inteiro como um projeto,
		// sendo ele um value associado a uma key que seria uma identificação única para cada projeto).
		// Definir.
		if (parametros[0] instanceof Diagrama) {
			Diagrama diagrama = (Diagrama) parametros[0];
			BancoDeDados.diagramas.put(diagrama.getNome(), diagrama);
			chaveDoObjetoSalvo = diagrama.getNome();
			Log4j.log.info("Salvou o diagrama: " + diagrama);
			return BancoDeDados.diagramas.get(diagrama.getNome());
		} else {
			Log4j.log.info("Diagrama inválido para ser salvo");
			return null;
		}
	}

	public void undo() {
		// Conforme mencionado nos comentários do execute,
		// se forem mudar a ideia do salvar ser um salvamento de diagrama,
		// será necessário mudar a lógica do undo também.
		BancoDeDados.diagramas.remove(chaveDoObjetoSalvo);
		Log4j.log.info("Desfez a última ação de salvar");
	}
}