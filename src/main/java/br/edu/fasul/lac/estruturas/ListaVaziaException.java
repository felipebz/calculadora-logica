package br.edu.fasul.lac.estruturas;

/**
 * Classe que cria um exceção para a lista
 */
public class ListaVaziaException extends RuntimeException {

    public ListaVaziaException() {
        this("Lista");
    }

    public ListaVaziaException(String name) {
        super(name + " está vazia");
    }
} 

