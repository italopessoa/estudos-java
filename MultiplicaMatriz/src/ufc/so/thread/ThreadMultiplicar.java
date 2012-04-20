package ufc.so.thread;

import java.util.Date;
import ufc.so.gui.jfrmPrincipal;
import ufc.so.main.Main;
import ufc.so.main.Matriz;

/**
 *
 * @author Italo Pessoa - italoneypessoa@gmail.com
 */
public class ThreadMultiplicar implements Runnable {

    // <editor-fold defaultstate="collapsed" desc="Atributos privados">
    
    private int linhaA, linhaB, colunaB;

    // </editor-fold>
    
    private int t;
    
    // <editor-fold defaultstate="collapsed" desc="Construtor">
    /**
     * Construtor para inicializar atributos da Thread
     * @param linhaB Número da linha da matriz B
     * @param colunaB Número da coluna da matriz B
     * @param linhaA Número da linha da matriz A
     */
    public ThreadMultiplicar(int linhaB, int colunaB, int linhaA, int t) {
        this.colunaB = colunaB;
        this.linhaA = linhaA;
        this.linhaB = linhaB;
        this.t = t;
    }

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Métodos sobreescritos">
    @Override
    public void run() {
        Date data = new Date();
        //String time = ++"/" +(data.getYear() + 1900) + data.getHours() +":" +data.getMinutes() +":"+data.getSeconds();
        StringBuilder time = new StringBuilder();
        time.append(data.getDay()).append("/");
        time.append(data.getMonth()).append("/");
        time.append(data.getYear()).append("/");
        time.append(" - ").append(data.getHours()).append(":");
        time.append(data.getMinutes()).append(":");
        time.append(data.getSeconds());
        
        //System.out.println("Thread "+ t + "START");
        //jfrmPrincipal.logThreadStatus("[ "+ time.toString() +"] Thread "+ t + " status = 'START'\n");
        System.out.println("[ "+ time.toString() +"] Thread "+ t + " status = 'START'");
        //Main.escrever("Thread "+ t + "START");
        //variavel auxiliar para armazenar valor temporário
        //para posteriormente adicionar a matriz resultado    
        int aux = 0;
        //laço para multiplicar os valores
        for (int x = 0; x < this.linhaA; x++) {
            aux = aux + (Matriz.getA(linhaB, x) * Matriz.getB(x, colunaB));

        }
        Matriz.setResultado(linhaB, colunaB, aux);
        //System.err.println("Thread "+ t + "STOP");
        //jfrmPrincipal.logThreadStatus("[ "+ time.toString() +"] Thread "+ t + " status = 'STOP'\n");
        System.out.println("[ "+ time.toString() +"] Thread "+ t + " status = 'STOP'");
        //Main.escrever("Thread "+ t + "STOP");
    }
    // </editor-fold>
}
