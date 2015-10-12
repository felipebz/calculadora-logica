package br.edu.fasul.lac.estruturas;

/**
 * Classe que implementa a estrutura 'pilha'.
 */
public class Pilha {
    
    private Lista pilha;

    /**
     * Constutor que cria a pilha.
     */
    public Pilha() {
        pilha = new Lista("pilha");
    }

    /**
     * Insere um objeto na pilha.
     * @param dado objeto a ser adicionado.
     */
    public void insere(Object dado) {
        pilha.inserirNoFinal(dado);
    }

    /**
     * Retira um objeto da pilha.
     * @return objeto retirado.
     */
    public Object retira() throws ListaVaziaException {
        return pilha.removerDoFinal();
    }
    
    /**
     * Diz se a pilha está vazia ou não
     * @return "True" se vazia e "False" se não.
     */
    public boolean isVazia(){
        return pilha.isVazia();
    }
    
    /**
     * Mostra o objeto do final da pilha
     * @return objeto do final
     * @throws br.edu.fasul.lac.estruturas.ListaVaziaException
     */
    public Object verificarFinal() throws ListaVaziaException {
        return pilha.verificarFinal();
    }

    /**
     * Representação escrita da pilha
     * @return a pilha
     */
    public String toString() {
        return pilha.toString();
    }
}