package br.ufc.si.poo.orkut.interfaces;

import br.ufc.si.poo.orkut.beans.comunidade.Comunidade;
import br.ufc.si.poo.orkut.beans.forum.Forum;
import br.ufc.si.poo.orkut.beans.usuario.Usuario;
import java.util.Map;

/**
 *
 * @author italoney
 */
public interface ModosSerializacao {

    /**
     * Serializar lista de comunidades em um arquivo codificado em bytes
     * @param comunidades Lista que será salva
     * @param arquivo arquivo onde sera escrita a lista
     */
    void serializaMapComunidades(Map<String, Comunidade> comunidades, String arquivo);

    /**
     * Serializar lista de usuarios em um arquivo codificado em bytes
     * @param usuarios Lista que será salva
     * @param arquivo arquivo onde sera escrita a lista
     */
    void serializaMapUsuarios(Map<String, Usuario> usuarios, String arquivo);

    /**
     * Serializar lista de foruns em um arquivo codificado em bytes
     * @param foruns Lista que será salva
     * @param arquivo arquivo onde sera escrita a lista
     */
    void serializaMapForuns(Map<String, Forum> foruns, String arquivo);

    /**
     * Serializar lista de comunidades em um arquivo codificado em xml
     * @param comunidades Lista que será salva
     * @param arquivo arquivo onde sera escrita a lista
     */
    void xmlMapComunidades(Map<String, Comunidade> comunidades, String arquivo);

    /**
     * Serializar lista de usuarios em um arquivo codificado em xml
     * @param usuarios Lista que será salva
     * @param arquivo arquivo onde sera escrita a lista
     */
    void xmlMapUsuarios(Map<String, Usuario> usuarios, String arquivo);

    /**
     * Serializar lista de foruns em um arquivo codificado em xml
     * @param foruns Lista que será salva
     * @param arquivo arquivo onde sera escrita a lista
     */
    void xmlMapForuns(Map<String, Forum> foruns, String arquivo);

    /**
     * Ler arquivo xml com as comunidades salvas
     * @param filePath caminho do arquivo
     * @return Um mapa de comunidades
     */
    Map<String, Comunidade> xmlReadComunidades(String filePath);

    /**
     * Ler arquivo xml com os foruns salvos
     * @param filePath caminho do arquivo
     * @return Um mapa de foruns
     */
    Map<String, Forum> xmlReadForuns(String filePath);

    /**
     * Ler arquivo xml com os usuários salvos
     * @param filePath caminho do arquivo
     * @return Um mapa de usuários
     */
    Map<String, Usuario> xmlReadUsuarios(String filePath);

    /**
     * Ler arquivo serializado com os foruns salvos
     * @param filePath caminho do arquivo
     * @return Um mapa de foruns
     */
    Map<String, Forum> desserializaMapForuns(String filePath);

    /**
     * Ler arquivo serializado com os usuarios salvos
     * @param filePath caminho do arquivo
     * @return Um mapa de usuarios
     */
    Map<String, Usuario> desserializaMapUsuarios(String filePath);

    /**
     * Ler arquivo serializado com os comunidades salvos
     * @param filePath caminho do arquivo
     * @return Um mapa de comunidades
     */
    Map<String, Comunidade> desserializaMapComunidades(String filePath);
}