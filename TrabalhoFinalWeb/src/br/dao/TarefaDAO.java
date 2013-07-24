package br.dao;

import br.model.Tarefa;;

public class TarefaDAO extends GenericDAO<Tarefa> {

	private static final long serialVersionUID = 1L;

	public TarefaDAO() {
		super(Tarefa.class);
	}

	public void delete(Tarefa agenda) {
    	super.delete(agenda);
	}
}
