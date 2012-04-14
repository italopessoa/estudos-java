/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.si.poo.orkut.util.filecontrol;

import br.ufc.si.poo.orkut.beans.comunidade.Comunidade;
import br.ufc.si.poo.orkut.util.XMLNodes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 *Class responsavel por ler os dados salvos nos arquivos
 * @author Italo Ney
 */
public class ReadSerializedData {

    public Map<String, Comunidade> readXmlDataComunidade(String file) {
        Map<String, Comunidade> comunidades = new HashMap<String, Comunidade>();
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        try {
            //doc = builder.build("c:/umItem.xml");
            doc = builder.build(file);

        } catch (Exception e) {

            e.printStackTrace();
        }

        Element com = doc.getRootElement();
        //TODO estudar mai spbre isso
        @SuppressWarnings("unchecked")
        List<Element> c = com.getChildren();
        for (Element e : c) {
            System.out.println("Titulo: " + e.getAttributeValue(XMLNodes.TITULO_PROPERTE));
            System.out.println("Categoria: " + e.getChildText(XMLNodes.CATEGORIA_PROPERTE));
            System.out.println("Publica: " + e.getChildText(XMLNodes.COMUNIDADE_TYPE));

//            for (Element x : f) {
//                System.out.println("\tTitulo: " + e.getAttributeValue(XMLNodes.FORUMTITULO_PROPERTE));
//            }
        }


        return comunidades;
    }
}
