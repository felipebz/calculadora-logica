package br.edu.fasul.lac.estruturas;

import org.junit.Test;
import static org.junit.Assert.*;

public class PilhaTest {

    @Test
    public void testInsere() {
        Pilha pilha = new Pilha();
        for (int i = 0; i < 100; i++) {
            pilha.insere(i);
            assertEquals("Falha ao inserir", i, pilha.verificarFinal());
        }
    }

    @Test
    public void testRetira() {
        Pilha pilha = new Pilha();
        for (int i = 0; i < 10; i++)
            pilha.insere(i);
        
        for (int i = 0; i < 10; i++)
            assertEquals("Problema ao retirar", (9 - i), pilha.retira());
    }
    
    @Test(expected=ListaVaziaException.class)
    public void testRetiraExcecao() {
        Pilha pilha = new Pilha();
        pilha.retira(); // provoca propositalmente uma exceção
    }

    @Test
    public void testIsVazia() {
        Pilha pilha = new Pilha();
        assertTrue("A pilha deveria estar vazia", pilha.isVazia());
        pilha.insere(1);
        assertFalse("A pilha não deveria estar vazia", pilha.isVazia());
    }
}