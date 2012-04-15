/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

        int A[][] = new int[3][3];
        int B[][] = new int[3][2];
        int C[][] = new int[3][6];
        int resultado[][] = new int[3][2];
        // [linha][coluna]

        A[0][0] = 2;
        A[0][1] = 1;
        A[0][2] = 2;

        A[1][0] = 3;
        A[1][1] = -2;
        A[1][2] = 0;

        A[2][0] = 1;
        A[2][1] = -1;
        A[2][2] = 2;

        System.err.println("");

        B[0][0] = 1;
        B[0][1] = 2;

        B[1][0] = -2;
        B[1][1] = 4;

        B[2][0] = -1;
        B[2][1] = 3;

        // primeiro percorrer a matriz B, coluna por coluna
        // multiplicando todos os itens da respsctiva coluna em A pelo valor
        // atual

        for (int colunaB = 0; colunaB < 2; colunaB++) {
            for (int linhaB = 0; linhaB < 3; linhaB++) {

                // System.err.print("|"+B[linhaB][colunaB]+"|");
                int valor = B[linhaB][colunaB];

                for (int z = 0; z < 3; z++) {
                        //System.out.println(A[z][linhaB] + " * " + valor);
                    if(colunaB == 1){
                        //System.out.println("C["+z+"]["+(linhaB+3)+"] = "+A[z][linhaB] + " * " + valor);
                         C[z][linhaB+3] = A[z][linhaB]* valor;
                        //System.out.print((A[z][linhaB]* valor) + " ");
                    }else{
                        //System.out.println("C["+z+"]["+linhaB+"] = "+A[z][linhaB] + " * " + valor);
                        C[z][linhaB] = A[z][linhaB]* valor;
                        //System.out.print((A[z][linhaB]* valor) + " ");
                    }
                }
            }
                System.err.println("");
        }

//        for (int x = 0; x < 3; x++) {
//             for (int y = 0; y < 6; y++) {
//                    System.out.print(C[x][y] + "|");
//                }
//                System.err.println("");
//        }
        
        
        for (int l = 0; l < 3; l++) {
            int v1 = 0;
            int v2 = 0;
            for (int c = 0; c < 6; c++) {
                if(c<=2)
                {
                    v1+= C[l][c];
                    System.out.print(v1 +"|");
                }else{
                    v2+= C[l][c];
                    System.err.print(v2 +"|");
                }

            }
            System.out.println("");
        }
        

        //soma algebrica
//        for (int c = 0; c < 2; c++) {
//                for (int l = 0; l < 3; l++) {
//                    System.err.print(resultado[l][c]);
//                }
//                System.out.println("");
//        }

	}
}