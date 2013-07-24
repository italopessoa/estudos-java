package br.model;

import br.dao.TarefaDAO;
import br.dao.UsuarioDAO;

public class Teste {
	static UsuarioDAO  usuarioDAO = new UsuarioDAO();
	static TarefaDAO tarefaDAO = new TarefaDAO();
	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		usuario.setIdade(1);
		usuario.setNome("aaaaa");
		usuarioDAO.save(usuario);
		/*
		TarefaDAO tarefaDAO = new TarefaDAO();
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("blablabla2");
		tarefa.setTempo(12);
		tarefaDAO.beginTransaction();
		tarefaDAO.save(tarefa);
		tarefaDAO.commit();
		tarefaDAO.closeTransaction();*/
		
		/*Usuario u = getUsuario(3);
		usuarioDAO.beginTransaction();
		usuarioDAO.delete(u);
		usuarioDAO.commit();
		usuarioDAO.closeTransaction();*/
	}
	
	private static void addTarefaUsuario(int tarefa, int usuario) {
		usuarioDAO.beginTransaction();
		tarefaDAO.joinTransaction();
		Tarefa t = tarefaDAO.find(tarefa);
		Usuario u = usuarioDAO.find(usuario);
		u.getTarefas().add(t);
		usuarioDAO.commitAndCloseTransaction();
	}
	
	private static Usuario getUsuario(int idUsuario){
		usuarioDAO.beginTransaction();
		Usuario usuario = usuarioDAO.findUsuario(idUsuario);
		usuarioDAO.closeTransaction();
		return usuario;
	}

}
