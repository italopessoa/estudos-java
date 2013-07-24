package br.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "Usuario.findUsuario", query = "select u from Usuario u left join fetch u.tarefas where u.id = :usuarioId")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FIND_USER_BY_ID_WITH_TAREFAS = "Usuario.findUsuario";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int idade;
	private String nome;
	
	@OneToMany
	private List<Tarefa> tarefas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)return true;
		if (obj == null)return false;
		if (getClass() != obj.getClass())return false;
		Usuario other = (Usuario) obj;
		if (id != other.id)	return false;
		return true;
	}
}
