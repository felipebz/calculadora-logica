package br.edu.fasul.lac.estruturas;
/**
 * Classe privada que implementa um nó
 */
class No {

    Object dados; // dados dos nó
    // usamos um objeto do tipo Object porque, como todas as classes herdam
    // de Object, teoricamente, isso nos permite inserir qualquer tipo de objeto
    // no Nó, desde próprios Nós até Exceções.
    No proximoNo; // referência do nó seguinte

    /**
     * Cria um nó "final"
     * @param objeto objeto do nó
     */
    No(Object objeto) {
        this(objeto, null);
    }

    /**
     * Cria um nó com referência
     * @param objeto objeto do nó
     * @param no próximo nó da lista
     */
    No(Object objeto, No no) {
        dados = objeto;
        proximoNo = no;
    }

    /**
     * Retorna o objeto do nó
     * @return objeto
     */
    Object getObject() {
        return dados;
    }

    /**
     * Obtém o próximo nó
     * @return próximo nó
     */
    No obterProximo() {
        return proximoNo;
    }
}

/**
 * Classe que implementa uma lista encadeada
 * @author Felipe
 */
public class Lista {

    private No primeiroNo;
    private No ultimoNo;
    private String nome; // nome da lista

    /**
     * Cria uma lista chamada "lista"
     */
    public Lista() {
        this("lista");
    }

    /**
     * cria uma lista como nome
     * @param nomeDaLista
     */
    public Lista(String nomeDaLista) {
        nome = nomeDaLista;
        primeiroNo = ultimoNo = null;
    }

    /**
     * Insere um objeto no início da lista
     * @param item objeto a ser inserido
     */
    public void inserirNoInicio(Object item) {
        if (isVazia()) {
            primeiroNo = ultimoNo = new No(item);
        } else {
            primeiroNo = new No(item, primeiroNo);
        }
    }

    /**
     * Insere um objeto no final da lista
     * @param item objeto a ser inserido
     */
    public void inserirNoFinal(Object item) {
        if (isVazia()) {
            primeiroNo = ultimoNo = new No(item);
        } else {
            ultimoNo = ultimoNo.proximoNo = new No(item);
        }
    }

    /**
     * Remove um objeto do início da lista
     * @return objeto retirado
     * @throws br.edu.fasul.lac.estruturas.ListaVaziaException
     */
    public Object removerDoInicio() throws ListaVaziaException {
        if (isVazia()) {
            throw new ListaVaziaException(nome);
        }

        Object removedItem = primeiroNo.dados;
        if (primeiroNo == ultimoNo) {
            primeiroNo = ultimoNo = null;
        } else {
            primeiroNo = primeiroNo.proximoNo;
        }

        return removedItem;
    }

    /**
     * Remove um objeto do final da lista
     * @return objeto retirado
     * @throws br.edu.fasul.lac.estruturas.ListaVaziaException
     */
    public Object removerDoFinal() throws ListaVaziaException {
        if (isVazia()) {
            throw new ListaVaziaException(nome);
        }

        Object itemRemovido = ultimoNo.dados; // armazena o dado a ser removido

        // atualiza referências do primeiro e último nó
        if (primeiroNo == ultimoNo) {
            primeiroNo = ultimoNo = null;
        } else {
            No atual = primeiroNo;

            while (atual.proximoNo != ultimoNo) {
                atual = atual.proximoNo;
            }

            ultimoNo = atual;
            atual.proximoNo = null;
        }

        return itemRemovido;
    }

    /**
     * Mostra o objeto do início da lista
     * @return objeto do início
     * @throws br.edu.fasul.lac.estruturas.ListaVaziaException
     */
    public Object verificarInicio() throws ListaVaziaException {
        if (isVazia()) {
            throw new ListaVaziaException(nome);
        }
        return primeiroNo.dados;
    }

    /**
     * Mostra o objeto do final da lista
     * @return objeto do final
     * @throws br.edu.fasul.lac.estruturas.ListaVaziaException
     */
    public Object verificarFinal() throws ListaVaziaException {
        if (isVazia()) {
            throw new ListaVaziaException(nome);
        }
        return ultimoNo.dados;
    }

    /**
     * Diz se a lista está vazia ou não
     * @return "True" se vazia e "False" se não.
     */
    public boolean isVazia() {
        return ultimoNo == null;
    }

    /**
     * Representação escrita da lista
     * @return a lista
     */
    @Override
    public String toString() {
        String str = "";
        if (isVazia()) {
            str = nome + " vazia\n";
            return str;
        }
        No atual = primeiroNo;

        while (atual != null) {
            str += atual.dados + " ";
            atual = atual.proximoNo;
        }

        str += "\n";
        return str;
    }
}
