package br.ufc.si.poo.orkut.beans.comunidade;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.ufc.si.poo.orkut.beans.usuario.Usuario;
import java.io.Serializable;

/**
 * 
 * @author italoney
 * 
 */
public abstract class Comunidade implements Serializable {

    static final long serialVersionUID = 5166192255899651794L;
    
    // membros privados
    private String titulo;
    private int categoria;
    private List<Usuario> usuarios;

    /**
     * @author italoney
     * Construtor padrão
     */
    public Comunidade() {
        this.titulo = "";
        this.categoria = 0;
        this.usuarios = new ArrayList<Usuario>();
    }

    /**
     * @author italoney
     * Titulo da comunidade
     * 
     * @return titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @author italoney
     * Descrever o titulo da comunidade
     * 
     * @param titulo
     *            titulo da comunidade
     */
    public void setTitulo(String titulo) {
        if (!titulo.isEmpty()) {
            this.titulo = titulo;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Informe o titulo da comunidade", "Atenção",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @author italoney
     * Categoria da comunidade
     * 
     * @return codigo da categoria
     */
    public int getCategoria() {
        return this.categoria;
    }

    /**
     * @author italoney
     * Indicar qual a categoria da comunidade
     * 
     * @param categoria
     *            condigo da categoria
     */
    public void setCategoria(int categoria) {
        if (categoria >= 0) {
            this.categoria = categoria;
        } else {
            JOptionPane.showMessageDialog(null, "Categoria invalida",
                    "Atenção", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @author italoney
     * Adicionar novo usuario a comunidade
     * 
     * @param usuario
     *            Usuario a ser adicionado
     */
    public void adicionarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    /**
     * @author italoney
     * Remover usuario
     * 
     * @param usuario
     *            Usuario a ser removido
     */
    public void removerUsuario(Usuario usuario) {
        try {
            this.usuarios.remove(usuario);

            /*JOptionPane.showMessageDialog(null,
            "Usuário removido com sucesso! " + usuarios.size(), "Sucesso",
            JOptionPane.INFORMATION_MESSAGE);*/

        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Usuário não existe",
                    "Erro ao remover usuário", 1);
        }

    }

    /**
     * @author italoney
     * Recuperar todos os usuários da comunidade
     * @return usuarios
     */
    public List<Usuario> getUsuarios() {
        return this.usuarios;

    }

    /**
     * @author italoney
     * Verifica se a comunidad contem o usuário indicado
     * @param usuario usuários procurado
     * @return true ou false
     */
    public boolean contemUsuario(Usuario usuario) {
        return this.usuarios.contains(usuario);
    }

    @Override
    public String toString() {
        return this.getTitulo();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comunidade other = (Comunidade) obj;
        if ((this.titulo == null) ? (other.titulo != null) : !this.titulo.equals(other.titulo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + (this.titulo != null ? this.titulo.hashCode() : 0);
        return hash;
    }
}
