package br.ufc.so.st.process;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author italopessoa
 * Produtor, responsável por inserir objetos no buffer
 */
public class Produtor extends Thread{
    private Prateleira prateleira;
    private int numero;
    
    /**
     * 
     * @param prateleira buffer utilizado para armazenar objetos
     * @param qtdProdutos tamanho do buffer
     * @param numero identificador do produtor
     */
    public Produtor(Prateleira prateleira, int qtdProdutos,int numero){
        this.prateleira = prateleira;
        this.numero = numero;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < this.prateleira.getPrateleiraSize(); i++) {
            int v = (int)(Math.random() * 250);
            
            //System.out.println(this.prateleira.getTime() + " - Produtor Nº"+this.numero +" repõe produto: "+v);
            this.prateleira.putProduto(v,this.numero);
            try {
                sleep((int)Math.random()*100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
 }
   