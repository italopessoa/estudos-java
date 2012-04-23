package ufc.so.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import ufc.so.gui.data.MatrizFileManager;
import ufc.so.gui.jfrmPrincipal;
import ufc.so.gui.xml.XMLFileProperties;
import ufc.so.main.Matriz;

/**
 *
 * @author Italo Pessoa - italoneypessoa@gmail.com
 */
public class Multiplicar {

    private int LA, LB, CA, CB;
    private String filePathMatrizA, filePathMatrizB;

    /**
     * Construtor para inicializar valores necessários para multiplicar matrizes
     * @param LA Linhas da matria A
     * @param LB Linhas da matria B
     * @param CA Colunas da matriz A
     * @param CB Colunas da matriz B
     * @param filePathMatrizA Arquivo que contém a matriz A
     * @param filePathMatrizB Arquivo que contém a matriz B
     */
    public Multiplicar(int LA, int LB, int CA, int CB, String filePathMatrizA, String filePathMatrizB) {
        this.LA = LA;
        this.LB = LB;
        this.CA = CA;
        this.CB = CB;
        this.filePathMatrizA = filePathMatrizA;
        this.filePathMatrizB = filePathMatrizB;
        Matriz.iniciarMatrizes(LA, CA, LB, CB);
    }

    /**
     * Multiplicar matrizes com uma thread para cara bloco da matriz resultado
     */
    public void multiplicarComThread() {

        MatrizFileManager mfr = new MatrizFileManager();

        //carrega matrizes a partir dos arquivos
        int[][] a = mfr.readMatriz(this.filePathMatrizA);
        int[][] b = mfr.readMatriz(this.filePathMatrizB);

        Matriz.cloneMatrizA(a);
        Matriz.cloneMatrizB(b);

        //definir a quantidade de threada a serem executadas
        int nThreads = this.LA * this.CB;
        int threadAtual = 0;
        
        jfrmPrincipal.updateQtdTotalThreads(nThreads);
        Thread[] thread = new Thread[nThreads];

        // <editor-fold defaultstate="collapsed" desc="ThreadMultiplicar matrizes">  
        for (int colunaB = 0; colunaB < this.CB; colunaB++) {
            for (int linhaB = 0; linhaB < this.LB; linhaB++) {
                thread[threadAtual] = new Thread(new ThreadMultiplicar(linhaB, colunaB, this.LA, threadAtual + 1));
                threadAtual++;
            }
        }

        ThreadMXBean tmb = ManagementFactory.getThreadMXBean();  
        long t0 = tmb.getCurrentThreadCpuTime();
        //iniciar threads
        for (int i = 0; i < nThreads; ++i) {
            thread[i].start();
        }

        //esperar threads serem executadas
        for (int i = 0; i < nThreads; ++i) {
            try {
                thread[i].join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        t0 = t0 - tmb.getCurrentThreadUserTime();  
        jfrmPrincipal.logThreadStatus("Tempo total com thread:"+t0/1000000+"\n");

        MatrizFileManager mfm = new MatrizFileManager();
        mfm.generateMatrizXML(a, LA, CB, "/home/italoney/NetBeansProjects/matrizes/resultado-"+LA+"x"+CB+".xml");
        // </editor-fold>  
    }

/**
     * Multiplicar matrizes com uma thread para cara bloco da matriz resultado
     */
    public void multiplicarSemThread() {

        MatrizFileManager mfr = new MatrizFileManager();

        //carrega matrizes a partir dos arquivos
        int[][] a = mfr.readMatriz(this.filePathMatrizA);
        int[][] b = mfr.readMatriz(this.filePathMatrizB);

        Matriz.cloneMatrizA(a);
        Matriz.cloneMatrizB(b);
        
        ThreadMXBean tmb = ManagementFactory.getThreadMXBean();  
        long t0 = tmb.getCurrentThreadCpuTime();
        
        // <editor-fold defaultstate="collapsed" desc="ThreadMultiplicar matrizes">  
        for (int colunaB = 0; colunaB < this.CB; colunaB++) {
            for (int linhaB = 0; linhaB < this.LB; linhaB++) {
            int aux = 0;
            //laço para multiplicar os valores
                for (int x = 0; x < this.LA; x++) {
                    aux = aux + (Matriz.getA(linhaB, x) * Matriz.getB(x, colunaB));
                }
        
                Matriz.setResultado(linhaB, colunaB, aux);
            }
        }
        t0 = t0 - tmb.getCurrentThreadUserTime();  
        jfrmPrincipal.logThreadStatus("Tempo total semm thread:"+t0/1000000+"\n");

        MatrizFileManager mfm = new MatrizFileManager();
        mfm.generateMatrizXML(a, LA, CB, "/home/italoney/NetBeansProjects/matrizes/resultado-"+LA+"x"+CB+".xml");
    }
}
