package br.dao;

import java.util.HashMap;
import java.util.Map;

import br.dao.GenericDAO;
import br.model.Usuario;;

public class UsuarioDAO extends GenericDAO<Usuario> {

	private static final long serialVersionUID = 1L;

	public UsuarioDAO() {
		super(Usuario.class);
	}

	public void delete(Usuario usuario) {
    	super.delete(usuario);
	}
	
	public Usuario findUsuario(int id) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("usuarioId", id);

		return super.findOneResult(Usuario.FIND_USER_BY_ID_WITH_TAREFAS, parameters);
	}
}
