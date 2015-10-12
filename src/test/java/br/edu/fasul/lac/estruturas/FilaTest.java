package br.edu.fasul.lac.estruturas;

import org.junit.Test;
import static org.junit.Assert.*;

public class FilaTest {

    @Test
    public void testInsere() {
        Fila fila = new Fila();
        for (int i = 0; i < 100; i++) {
            fila.insere(i);
            assertEquals("Falha ao inserir", i, fila.verificarFinal());
        }
    }

    @Test
    public void testRetira() {
        Fila fila = new Fila();
        for (int i = 0; i < 10; i++)
            fila.insere(i);
        
        for (int i = 0; i < 10; i++)
            assertEquals("Problema ao retirar", i, fila.retira());
    }
    
    @Test(expected=ListaVaziaException.class)
    public void testRetiraExcecao() {
        Fila fila = new Fila();
        fila.retira(); // provoca propositalmente uma exceção
    }

    @Test
    public void testIsVazia() {
        Fila fila = new Fila();
        assertTrue("A fila deveria estar vazia", fila.isVazia());
        fila.insere(1);
        assertFalse("A fila não deveria estar vazia", fila.isVazia());
    }
}