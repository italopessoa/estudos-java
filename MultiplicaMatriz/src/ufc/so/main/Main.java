package ufc.so.main;

import javax.swing.JOptionPane;

/**
 *
 * @author italoney
 */
public class Main {

    public static void main(String args[]) {
        // o numero de linhas colunas de A tem que ser igualo numero de colunas
        // de B
        
        //linhas e colunas de A e B
        final int LA = 3,LB = 3;
        final int CA = 3,CB = 2;
        
        int A[][] = new int[LA][CA];
        int B[][] = new int[LB][CB];
        int resultado[][] = new int[LA][CB];
        
        // <editor-fold defaultstate="collapsed" desc="Valores para teste">  
        A[0][0] = 2;
        A[0][1] = 1;
        A[0][2] = 2;

        A[1][0] = 3;
        A[1][1] = -2;
        A[1][2] = 0;

        A[2][0] = 1;
        A[2][1] = -1;
        A[2][2] = 2;

        B[0][0] = 1;
        B[0][1] = 2;

        B[1][0] = -2;
        B[1][1] = 4;

        B[2][0] = -1;
        B[2][1] = 3;
        // </editor-fold> 
        
        // primeiro percorrer a matriz B, coluna por coluna
        // multiplicando todos os itens da respectiva coluna em A pelo valor atual
        
        // <editor-fold defaultstate="collapsed" desc="Multiplicar matrizes">  
        for (int colunaB = 0; colunaB < CB; colunaB++) {
            
            for (int linhaB = 0; linhaB < LB; linhaB++) {
                //variavel auxiliar para armazenar valor temporário
                //para posteriormente adicionar a matriz resultado    
                int aux =0;
                //laço para multiplicar os valores
                for (int x = 0; x < LA; x++) {
                    aux = aux + (A[linhaB][x] * B[x][colunaB]);
                    
                }
                resultado[linhaB][colunaB] = aux;
            }
        }
        // </editor-fold>  
    
        // <editor-fold defaultstate="collapsed" desc="Imprimir matriz resultado">  
        for(int l=0; l<LA;l++){
            for(int c=0; c<CB; c++){
                System.err.print(resultado[l][c] +"|");
            }
            System.err.println("");
        }
        // </editor-fold>  

    }
}