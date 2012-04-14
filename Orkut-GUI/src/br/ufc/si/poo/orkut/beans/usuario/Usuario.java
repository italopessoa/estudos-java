package br.ufc.si.poo.orkut.beans.usuario;

import java.io.Serializable;

/**
 * @author italoney
 * 
 */
public abstract class Usuario implements Serializable {

    static final long serialVersionUID = -8282043920808720601L;
    // membros privados
    private String nome;
    private int idade;

    /**
     * Construtor padrão
     */
    public Usuario() {
        this.nome = "";
        this.idade = 0;
    }

    /**
     * Nome do usuario
     * 
     * @return Nome do usuario
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Indica o nome do usuario
     * 
     * @param nome
     *            Nome do usuario
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Idade do usuario
     * 
     * @return idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Indica a idade do usuario
     * 
     * @param idade
     *            Idade do usuario
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        return hash;
    }
}
