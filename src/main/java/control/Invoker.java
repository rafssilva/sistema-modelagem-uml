package control;

import java.util.HashMap;
import java.util.Stack;
import log.Log4j;

public class Invoker {

	private static HashMap<String, Class<?>> comandos = new HashMap<String, Class<?>>();
	private static Stack<Command> comandosExecutados = new Stack<Command>();

	static {
		comandos.put("criar Diagrama", CriarCommand.class);
		comandos.put("criar Elemento", CriarCommand.class);
		comandos.put("criar Relacionamento", CriarCommand.class);
	}

	public static Object executarComando(String instrucao, Object... objetos) throws Exception {

		Object instrucaoCommand = comandos.get(instrucao);
		
		// Retorno para os testes da turma de ES.
		Object retorno;

		if (instrucaoCommand != null) {

			Command comando = (Command) comandos.get(instrucao).newInstance();
			
			// Obtendo o nome da classe através da instrução recebida:
			// "nomeDoPacote. + a segunda palavra da instrução" (Ex.: model.Diagrama).
			String nomeDaClasse = "model." + instrucao.split(" ")[1];
			
			// O array de parâmetros deve ser do tamanho do array variável de objetos + 1
			// (esse 1 é referente a nova instância do que queremos criar no CriarCommand)
			Object[] parametros = new Object[objetos.length + 1];
			
			// Gerando o primeiro parâmetro que é a instância do objeto que iremos trabalhar no CriarCommand
			parametros[0] = Class.forName(nomeDaClasse).newInstance();
			
			for (int i = 0; i < objetos.length; i++) {
				parametros[i + 1] = objetos[i];
			}
			retorno = comando.execute(parametros);
			comandosExecutados.push(comando);
			return retorno;

		} else if (instrucao.equals("salvar")) {
			
			SalvarCommand comando = SalvarCommand.class.newInstance();
			retorno = comando.execute(objetos);
			comandosExecutados.push(comando);
			return retorno;
			
		} else if (instrucao.equals("undo")) {
			if (comandosExecutados.isEmpty()) {
				Log4j.log.info("Não há ações recentes para serem desfeitas");
			} else {
				comandosExecutados.pop().undo();
			}
		} else {
			Log4j.log.info("Instrução inválida");
		}
		return null;
	}
}