package br.ufc.so.st.process;

import br.ufc.so.st.SincronizarThreads;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author italopessoa
 * Prateleira, buffer compartilhado para armazenar objetos
 */
public class Prateleira {
    private Queue<Integer> prateleira;
    private int qtdProdutos;
    private  SimpleDateFormat formater;
    private String auxWarning = "----------------------";
    
    /**
     * 
     * @param qtdProdutos tamanho do buffer
     */
    public Prateleira(int qtdProdutos){
        prateleira = new PriorityQueue<Integer>(qtdProdutos);
        this.qtdProdutos = qtdProdutos;
    }
    
    /**
     * 
     * @param numero identificador do consumidor que remove o objeto
     * @return Primeiro valor inserido no buffer
     */
    public synchronized int getProduto(int numero){
        while(this.prateleira.isEmpty()){
            try{
                // <editor-fold defaultstate="collapsed" desc="Código não utilizado">
//                String warning = this.getTime() + " - Consumidor Nº"+numero+" "
//                        + "PRATELEIRA VAZIA!" + " - ("+this.prateleira.size() 
//                        + ","+ this.qtdProdutos+")";
                
                //sincronizarthreads.SincronizarThreads.addLog(warning);
                //System.err.println(this.getTime() + " - Consumidor Nº"+numero+" PRATELEIRA VAZIA!" + " - ("+this.prateleira.size() + ","+ this.qtdProdutos+")");
//                System.err.println(warning);
//                System.err.println(this.getTime() + " - Consumidor Nº"+numero+" "
//                        + "PRATELEIRA VAZIA!" + " - ("+this.prateleira.size() 
//                        + ","+ this.qtdProdutos+")");
                
                // </editor-fold>
                
                //aguardar o produto ser posto na prateleira
                System.err.println(this.auxWarning + " Consumidor Nº"+numero+" BUFFER VAZIO "+this.auxWarning);
                wait();
            }catch (InterruptedException ex) {
            }
        }
        
        notifyAll();
        int valor = this.prateleira.poll();
        
        // <editor-fold defaultstate="collapsed" desc="Código não utilizado">
//        String log = this.getTime() + " - Consumidor Nº"+numero+ " compra produto: "
//                +valor+ " - ("+this.prateleira.size() + ","+ this.qtdProdutos+")";
//        SincronizarThreads.addLog(log);
        //System.out.println(this.getTime() + " - Consumidor Nº"+numero+ " compra produto: "+valor+ " - ("+this.prateleira.size() + ","+ this.qtdProdutos+")");
        //System.out.println(log);
        //System.out.println(this.getTime() + " - Consumidor Nº"+numero+ " compra produto: "
          //      +valor+ " - ("+this.prateleira.size() + ","+ this.qtdProdutos+")");
        // </editor-fold>
        
             System.out.println("Consumidor Nº"+numero+ " compra produto: "+valor);
        return valor;
    }
    
    /**
     * 
     * @param produto objeto a ser inserido no final do buffer
     * @param numero identificador do produtor
     */
    public synchronized void putProduto(int produto, int numero){
        while(this.prateleira.size() == this.qtdProdutos){
            try{
                // <editor-fold defaultstate="collapsed" desc="Código não utilizado">
                
//                String warning = this.getTime() + " - Produtor Nº"+numero 
//                        +" PRATELEIRA CHEIA!" + " - ("+this.prateleira.size() 
//                        + ","+ this.qtdProdutos+")";
                //System.err.println(this.getTime() + " - Produtor Nº"+numero +" PRATELEIRA CHEIA!" + " - ("+this.prateleira.size() + ","+ this.qtdProdutos+")");
                //SincronizarThreads.addLog(warning);
                //System.err.println(warning);
//                System.err.println(this.getTime() + " - Produtor Nº"+numero 
//                        +" PRATELEIRA CHEIA!" + " - ("+this.prateleira.size() 
//                        + ","+ this.qtdProdutos+")");
                
                // </editor-fold>
                
                //aguardar o produto ser removido da prateleira
                System.err.println(this.auxWarning + " Produtor Nº"+numero +" BUFFER CHEIO "+this.auxWarning);
                wait();
            }catch(InterruptedException ex){
            }
        }
        this.prateleira.offer(produto);
        
        // <editor-fold defaultstate="collapsed" desc="Código não utilizado">
//        String log = this.getTime() + " - Produtor Nº"+numero +" repõe produto: "
//                + ""+produto + " - ("+this.prateleira.size() + ","+ this.qtdProdutos+")";
        //System.out.println(this.getTime() + " - Produtor Nº"+numero +" repõe produto: "+produto + " - ("+this.prateleira.size() + ","+ this.qtdProdutos+")");
        //SincronizarThreads.addLog(log);
        //System.out.println(log);
        //System.out.println(this.getTime() + " - Produtor Nº"+numero +" repõe produto: "
          //      + ""+produto + " - ("+this.prateleira.size() + ","+ this.qtdProdutos+")");
        // </editor-fold>
        
        System.out.println("Produtor Nº"+numero +" repõe produto: "+produto);
        notifyAll();
    }
    
    public int getPrateleiraSize(){
        return this.qtdProdutos;
    }
    
    /**
     * 
     * @return Tempo formatado com
     */
    public String getTime(){
        this.formater = new SimpleDateFormat("hh:mm:ss,SSS"); 
        return formater.format(new Date());
    }
}
