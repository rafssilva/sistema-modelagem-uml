package control;

public interface Command {

	// Adicionando retorno genérico para os testes da turma de ES.
	public Object execute(Object[] parametros);

	public void undo();

}