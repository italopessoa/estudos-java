package br.ufc.si.poo.orkut.beans.usuario;

import java.util.List;

import java.util.ArrayList;

/**
 * Usuário vip
 * @author italoney
 *
 */
public class UsuarioVip extends Usuario{

    private List<String> recados = new ArrayList<String>();

    /**
     * @author italoney
     * Adicionar um recado para o usuário
     * @param recado Recado para o usuário
     */
    public void adicionarRecado(String recado) {
        this.recados.add(recado);
    }

    /**
     * @author italoney
     * Remover o recado de acordo com sua posicao
     * @param recado Recado que deve ser removido
     */
    public void removerRecado(String recado) {
        for (String r : this.recados) {
            if (r.equals(recado)) {
                this.recados.remove(r);
                break;
            }
        }
    }

    /**
     * @author italoney
     * Retornar todos os recados do usuario
     * @return recados
     */
    public List<String> getRecados() {
        return this.recados;
    }
}
