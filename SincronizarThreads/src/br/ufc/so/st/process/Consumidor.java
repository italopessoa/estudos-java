package br.ufc.so.st.process;

/**
 *
 * @author italopessoa
 * Consumidor, responsável por remover objetos do buffer, inseridos pelo produtor
 */
public class Consumidor extends Thread{
    private Prateleira prateleira;
    private int numero;

    /**
     * 
     * @param prateleira buffer utilizado pelo consumidor
     * @param qtdProdutos tamanho do buffer
     * @param numero identificador do consumidor
     */
    public Consumidor(Prateleira prateleira, int qtdProdutos, int numero){
        this.prateleira = prateleira;
        this.numero = numero;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.prateleira.getPrateleiraSize(); i++) {
            int produto = this.prateleira.getProduto(this.numero);
        }
    }
}