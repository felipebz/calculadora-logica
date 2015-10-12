package br.edu.fasul.lac.estruturas;

/**
 * Classe que implementa a estrutura 'fila'.
 */
public class Fila {
    private Lista fila;
    
    /**
     * Contrutor que cria a pilha. 
     * @param tamanho Número de posições da fila.
     */
    public Fila() {
        fila = new Lista("fila");
    }
    
    /**
     * Insere um objeto na fila
     * @param dado objeto a ser inserido
     */
    public void insere(Object dado) {
        fila.inserirNoFinal(dado);
    }

    /**
     * Retira um objeto da pilha.
     * @return objeto retirado.
     */
    public Object retira() throws ListaVaziaException {
        return fila.removerDoInicio();
    }
    
    /**
     * Diz se a fila está vazia ou não
     * @return "True" se vazia e "False" se não.
     */
    public boolean isVazia(){
        return fila.isVazia();
    }
    
    /**
     * Mostra o objeto do inicio da fila
     * @return objeto do início
     * @throws br.edu.fasul.lac.estruturas.ListaVaziaException
     */
    public Object verificarFinal() throws ListaVaziaException {
        return fila.verificarFinal();
    }

    /**
     * Representação escrita da fila
     * @return a fila
     */
    public String toString() {
        return fila.toString();
    }
}
