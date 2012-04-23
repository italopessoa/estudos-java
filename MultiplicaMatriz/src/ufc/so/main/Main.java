package ufc.so.main;

import ufc.so.gui.data.MatrizFileManager;
import ufc.so.gui.xml.XMLFileProperties;
import ufc.so.thread.ThreadMultiplicar;

/**
 *
 * @author Italo Pessoa - italoneypessoa@gmail.com
 */
public class Main {

    public static void main(String args[]) {
        // o numero de linhas colunas de A tem que ser igualo numero de colunas
        // de B

        //linhas e colunas de A e B
        final int LA = 3, LB = 3;
        final int CA = 3, CB = 2;

        Matriz.iniciarMatrizes(LA, CA, LB, CB);

        MatrizFileManager mfr = new MatrizFileManager();
        int[][] a = null;// = mfr.readMatriz(XMLFileProperties.filePathMatriz3x3);
        int[][] b = null;// = mfr.readMatriz(XMLFileProperties.filePathMatriz3x2);
        
        Matriz.cloneMatrizA(a);
        Matriz.cloneMatrizB(b);
        
        // primeiro percorrer a matriz B, coluna por coluna
        // multiplicando todos os itens da respectiva coluna em A pelo valor atual
        
        int nThreads = 6;  
        int x = 0;
        Thread[] thr = new Thread [nThreads];  
        
        // <editor-fold defaultstate="collapsed" desc="ThreadMultiplicar matrizes">  
        for (int colunaB = 0; colunaB < CB; colunaB++) {
            for (int linhaB = 0; linhaB < LB; linhaB++) {
                //variavel auxiliar para armazenar valor temporário
                //para posteriormente adicionar a matriz resultado   

                //Multiplicar m = new ThreadMultiplicar(linhaB, colunaB, LA);
                //new Thread(m).start();
                thr[x] = new Thread(new ThreadMultiplicar(linhaB, colunaB, LA,x+1));  
                x++;
            }
        }
        
        
            
        for (int i = 0; i < nThreads; ++i) {  
            thr[i].start();  
        }  
          
        for (int i = 0; i < nThreads; ++i) {  
            try {
		thr[i].join();
		} 
		catch (InterruptedException ex) {
			ex.printStackTrace();
		}  
        }  
        System .out .println ("All threads stopped. Exiting...");  
        
        
        
        
        
        
        // </editor-fold>  
        
    // <editor-fold defaultstate="collapsed" desc="Imprimir matriz resultado">  
        for(int l=0; l<LA;l++){
            for(int c=0; c<CB; c++){
                System.err.print(Matriz.getResultado(l,c) +"|");
            }
            System.err.println("");
        }
        // </editor-fold>  
    }
    
    public static void escrever(String msg){
        System.out.println(msg);
    }
           

}