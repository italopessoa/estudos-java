package ufc.so.gui.data;

import java.util.List;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import ufc.so.gui.xml.XMLFileProperties;

/**
 *
 * @author Italo Pessoa - italoneypessoa@gmail.com
 */
public class MatrizFileRead {
    
    
    
    /**
     * Ler arquivo xml com esquema de matriz
     * @param filePath Caminho do arquivo XML
     * @return Uma matriz com as dimensões e valores contidos no XML
     */
    public int[][] readMatriz(String filePath){
        
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        try {
            doc = builder.build(filePath);

        } catch (Exception e) {

            e.printStackTrace();
        }
        
        Element com = doc.getRootElement();
        
        int linha = Integer.parseInt(com.getAttributeValue(XMLFileProperties.LINHAS_MATRIZ));
        int coluna = Integer.parseInt(com.getAttributeValue(XMLFileProperties.COLUNAS_MATRIZ));
        int matriz[][] = new int[linha][coluna];
                
        List<Element> linhas = com.getChildren();
        for (Element l : linhas) {
            
            int linhaMatriz = Integer.parseInt(l.getAttributeValue(XMLFileProperties.INDICE));
            List<Element> colunas = l.getChildren();
            
            for(Element e : colunas){
                System.err.println(e.getContent().size());
                int colunaMatriz = Integer.parseInt(e.getAttributeValue(XMLFileProperties.INDICE));
                int valor = Integer.parseInt(e.getChildText(XMLFileProperties.VALOR));
                
                System.out.println("matriz["+linhaMatriz+"]["+colunaMatriz+"] ="+ valor);
                
                matriz[linhaMatriz][colunaMatriz] = valor;
            }
        }
        
        return matriz;
    }
}
