package br.ufc.si.poo.orkut.beans.forum;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Forum
 * @author italo.pessoa
 */
public class Forum implements Serializable {

    static final long serialVersionUID = -6996401670208922695L;
    private String titulo;
    private List<String> menssagens = new ArrayList<String>();

    /**
     * Retorna o titulo do forum atual
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Setar o valor de titulo
     * @param titulo Valor de titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Adicionar uma mensagem ao forum
     * @param mensagem Mensagem a ser adicionada
     */
    public void adicionarMensagem(String mensagem) {
        this.menssagens.add(mensagem);
    }

    /**
     * Remover uma mensagem selecionada
     * @param mensagem  Mensagem que deve ser removida
     */
    public void removerMensagem(String mensagem) {
        for (String m : this.menssagens) {
            if (m.equals(mensagem)) {
                this.menssagens.remove(m);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return this.titulo;
    }

    /**
     * Retorna todas as mensagens do forum
     * @return mensangens
     */
    public List<String> getMensagens() {
        return this.menssagens;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Forum other = (Forum) obj;
        if ((this.titulo == null) ? (other.titulo != null) : !this.titulo.equals(other.titulo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.titulo != null ? this.titulo.hashCode() : 0);
        return hash;
    }
}
