package ufc.so.gui.data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import ufc.so.gui.xml.XMLFileProperties;

/**
 *
 * @author Italo Pessoa - italoneypessoa@gmail.com
 */
public class MatrizFileManager {
    
    //<editor-fold defaultstate="collapsed" desc="Recuperar matriz de arquivo xml">
    
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
                int colunaMatriz = Integer.parseInt(e.getAttributeValue(XMLFileProperties.INDICE));
                int valor = Integer.parseInt(e.getChildText(XMLFileProperties.VALOR));
                matriz[linhaMatriz][colunaMatriz] = valor;
            }
        }
        
        return matriz;
    }
    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Gerar valores para arquivo xml">
    
    /**
     * Gerar arqvui xml para uma matriz
     * @param matriz Matriz 
     * @param L Quantidade de linha da matriz
     * @param C Quantidade de colunas da matriz
     * @param arquivo Arquivo onde deve ser salva a matriz
     */
    public void generateMatrizXML(int[][] matriz, int L, int C, String arquivo) {
        Element root = new Element(XMLFileProperties.ROOT);
        // Define documento como root
        Document matrizXML = new Document(root);
        root.setAttribute(XMLFileProperties.LINHAS_MATRIZ, String.valueOf(L));
        root.setAttribute(XMLFileProperties.COLUNAS_MATRIZ, String.valueOf(C));
        
       for (int l =0;l<L;l++) {
                Element linha = new Element(XMLFileProperties.LINHAS_MATRIZ);
                linha.setAttribute(XMLFileProperties.INDICE, String.valueOf(l));
                
                for (int c =0;c<C;c++) {
                    
                    Element coluna = new Element(XMLFileProperties.COLUNAS_MATRIZ);
                    coluna.setAttribute(XMLFileProperties.INDICE, String.valueOf(c));
                
                    Element valor = new Element(XMLFileProperties.VALOR);
                    valor.setText(String.valueOf(matriz[l][c]));
                    
                    coluna.addContent(valor);
                    linha.addContent(coluna);
                }
                root.addContent(linha);
       }
       
       Format codificacao = Format.getPrettyFormat();

        codificacao.setEncoding("UTF-8");
        XMLOutputter xout = new XMLOutputter(codificacao);

        try {
            // Criando o arquivo de saida
            FileWriter file = new FileWriter(new File(arquivo));
            // Imprimindo o XML no arquivo
            xout.output(matrizXML, file);

            JOptionPane.showMessageDialog(null, "Arquivo salvo em: "+arquivo,"Arquivo gerado!", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //</editor-fold>
}

