package ufc.so.thread;

import java.util.Date;
import ufc.so.gui.jfrmPrincipal;
import ufc.so.main.Matriz;

/**
 *
 * @author Italo Pessoa - italoneypessoa@gmail.com
 */
public class ThreadMultiplicar implements Runnable {

    // <editor-fold defaultstate="collapsed" desc="Atributos privados">
    
    private int linhaA, linhaB, colunaB,t;

    // </editor-fold>
    
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
        
        int aux = 0;
        //laço para multiplicar os valores
        for (int x = 0; x < this.colunaB; x++) {
            aux = aux + (Matriz.getA(linhaB, x) * Matriz.getB(x, colunaB));
        }
        Matriz.setResultado(linhaB, colunaB, aux);
        
        jfrmPrincipal.updateQtdThreadsExecutadas(t);
    }
    // </editor-fold>
}
