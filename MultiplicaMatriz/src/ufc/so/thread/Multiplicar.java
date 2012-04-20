package ufc.so.thread;

import ufc.so.gui.data.MatrizFileRead;
import ufc.so.gui.jfrmPrincipal;
import ufc.so.main.Matriz;

/**
 *
 * @author Italo Pessoa - italoneypessoa@gmail.com
 */
public class Multiplicar {

    private int LA, LB, CA, CB;
    private String filePathMatrizA, filePathMatrizB;

    public Multiplicar(int LA, int LB, int CA, int CB, String filePathMatrizA, String filePathMatrizB) {
        this.LA = LA;
        this.LB = LB;
        this.CA = CA;
        this.CB = CB;
        this.filePathMatrizA = filePathMatrizA;
        this.filePathMatrizB = filePathMatrizB;
        //System.err.println(LA+","+ CA+","+ LB+","+ CB);
        Matriz.iniciarMatrizes(LA, CA, LB, CB);
    }

    public void multiplicarComThread() {

        MatrizFileRead mfr = new MatrizFileRead();

        int[][] a = mfr.readMatriz(this.filePathMatrizA);
        int[][] b = mfr.readMatriz(this.filePathMatrizB);

        Matriz.cloneMatrizA(a);
        Matriz.cloneMatrizB(b);

        int nThreads = this.LA * this.CB;
        int threadAtual = 0;
        Thread[] thread = new Thread[nThreads];

        // <editor-fold defaultstate="collapsed" desc="ThreadMultiplicar matrizes">  
        for (int colunaB = 0; colunaB < this.CB; colunaB++) {
            for (int linhaB = 0; linhaB < this.LB; linhaB++) {
                thread[threadAtual] = new Thread(new ThreadMultiplicar(linhaB, colunaB, this.LA, threadAtual + 1));
                threadAtual++;
            }
        }

        for (int i = 0; i < nThreads; ++i) {
            thread[i].start();
        }

        for (int i = 0; i < nThreads; ++i) {
            try {
                thread[i].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        //System.out.println("All threads stopped. Exiting...");
        jfrmPrincipal.logThreadStatus("All threads stopped. Exiting...");

        // </editor-fold>  
    }
}
