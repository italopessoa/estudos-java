package br.ufc.si.poo.orkut.beans.comunidade;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.ufc.si.poo.orkut.beans.forum.Forum;

public class ComunidadePrivada extends Comunidade {
    
    private List<Forum> foruns;

    /**
     * Contrutor que inicializa a lista de foruns
     */
    public ComunidadePrivada() {
        this.foruns = new ArrayList<Forum>();
    }

    /**
     * Adicionar um novo forum a comunidade
     * @param novoForum Novo Forum
     */
    public void adicionarForum(Forum novoForum) {
        if (novoForum != null) {
            this.foruns.add(novoForum);
        } else {
            JOptionPane.showMessageDialog(null, "Forum invalido", "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
        
    }

    /**
     * Remover um forum de acordo com sua posição
     * @param forum Forum a ser removido
     */
    public void removerForum(Forum forum) {        
        try {
            foruns.remove(forum);
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Forum não existe",
                    "Erro ao remover forum", 1);
        }

        //this.foruns.remove(posicao);
    }
    
   
    /**
     * Retorna uma lista com os foruns atuais
     * @return List<Forum> lista de foruns
     */
    public List<Forum> getForuns() {
        return this.foruns;
    }

    /**
     * Checar se a comunidade possui o forum indicado
     * @param f Forum que é verificado
     * @return true or false
     */
    public boolean contemForum(Forum f) {
        return this.foruns.contains(f);
    }
}
