package ufc.so.main;

/**
 *
 * @author Italo Pessoa - italoneypessoa@gmail.com
 */
public class Matriz {

    private static int A[][];
    private static int B[][];
    private static int resultado[][];

    /**
     * Inicializar matrizes
     * @param lA Numero de linhas de A
     * @param cA Numero de colunas de A
     * @param lB Numero de linhas de B
     * @param cB Numero de coluans de B
     */
    public static void iniciarMatrizes(int lA, int cA, int lB, int cB) {
        A = new int[lA][cA];
        B = new int[lB][cB];
        resultado = new int[lA][cB];
    }

    /**
     * Retorna o valor no bloco da matriz
     * @param linha
     * @param coluna
     * @return A[linha][coluna];
     */
    public static int getA(int linha, int coluna) {
        return A[linha][coluna];
    }

    /**
     * Armazenar valor na matriz
     * @param <b>linha</b> Número da linha da matriz
     * @param <b>coluna</b> Número da coluna da matriz
     * @param <b>valor</b> Valor a ser armazenado na matriz
     */
    public static void setA(int linha, int coluna, int valor) {
        Matriz.A[linha][coluna] = valor;
    }

    /**
     * Retorna o valor no bloco da matriz
     * @param linha
     * @param coluna
     * @return B[linha][coluna];
     */
    public static int getB(int linha, int coluna) {
        return B[linha][coluna];
    }

    /**
     * Armazenar valor na matriz
     * @param <b>linha</b> Número da linha da matriz
     * @param <b>coluna</b> Número da coluna da matriz
     * @param <b>valor</b> Valor a ser armazenado na matriz
     */
    public static void setB(int linha, int coluna, int valor) {
        Matriz.B[linha][coluna] = valor;
    }

    /**
     * @return A matriz com o resultado da multiplcação AxB
     */
    public static int getResultado(int linha, int coluna) {
        return resultado[linha][coluna];
    }

    /**
     * Armazenar valor na matriz resultado o resultado da multiplicação
     * de termos das matrizes <b>A</b> e <b>B</b>
     * @param <b>linha</b> Número da linha da matriz
     * @param <b>coluna</b> Número da coluna da matriz
     * @param <b>valor</b> Valor a ser armazenado na matriz
     */
    public static void setResultado(int linha, int coluna, int valor) {
        Matriz.resultado[linha][coluna] = valor;
    }
    
    /**
     * Cópia da matriz
     * @param A matriz a ser copiada
     */
    public static void cloneMatrizA(int [][] cloneA){
       Matriz.A = cloneA;
    }
    
    /**
     * Cópia da matriz
     * @param B matriz a ser copiada
     */
    public static void cloneMatrizB(int [][] cloneB){
       Matriz.B = cloneB;
    }
}
