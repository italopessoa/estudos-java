package br.ufc.so.st;

import java.util.ArrayList;
import br.ufc.so.st.process.Consumidor;
import br.ufc.so.st.process.Prateleira;
import br.ufc.so.st.process.Produtor;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author italo.pessoa
 */
public class SincronizarThreads {

    private static ArrayList<String> logs;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        logs = new ArrayList<String>();

        int qtdProdutos = 100;
        Prateleira prateleira = new Prateleira(qtdProdutos);
        
        Produtor produtor = new Produtor(prateleira,qtdProdutos,1);
        Produtor produtor2 = new Produtor(prateleira,qtdProdutos,2);
        Produtor produtor3 = new Produtor(prateleira,qtdProdutos,3);
        Produtor produtor4 = new Produtor(prateleira,qtdProdutos,4);
        
        Consumidor consumidor = new Consumidor(prateleira, qtdProdutos,1);
        Consumidor consumidor2 = new Consumidor(prateleira, qtdProdutos,2);
        Consumidor consumidor3 = new Consumidor(prateleira, qtdProdutos,3);
        Consumidor consumidor4 = new Consumidor(prateleira, qtdProdutos,4);
        
        int j = 0;
        //disparar produtores
        for(int i = 0; i<3;i++){
            Produtor p = new Produtor(prateleira,qtdProdutos,i+1);
            p.start();
            
            //disparar consumidores
            for(j = 0; j<3;j++){
                Consumidor c = new Consumidor(prateleira, qtdProdutos,j+1);    
                c.start();
                break;
            }
        }
               
//        produtor.start();
//        consumidor.start();
//        produtor2.start();
//        consumidor2.start();
//        produtor3.start();
//        consumidor3.start();
//        produtor4.start();
//        consumidor4.start();
        
        
//        produtor.start();
//        produtor2.start();
//        produtor3.start();
//        produtor4.start();
//        consumidor.start();
//        consumidor2.start();
//        consumidor3.start();
//        consumidor4.start();
        
        
    }
    
    public static void addLog(String log){
        logs.add(log);
    }
}