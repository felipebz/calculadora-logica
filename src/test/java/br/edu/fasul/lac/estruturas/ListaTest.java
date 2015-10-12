package br.edu.fasul.lac.estruturas;

import org.junit.Test;
import static org.junit.Assert.*;

public class ListaTest {

    @Test
    public void testRemoverDoInicio() {
        Lista l = new Lista();
        l.inserirNoInicio(1);
        assertEquals("Falha ao remover do início", 1, l.removerDoInicio());
    }

    @Test
    public void testRemoverDoFinal() {
        Lista l = new Lista();
        l.inserirNoFinal(1);
        assertEquals("Falha ao remover do início", 1, l.removerDoFinal());
    }

    @Test
    public void testIsVazia() {
        Lista l = new Lista();
        assertTrue("Lista deveria estar vazia", l.isVazia());
        l.inserirNoFinal(1);
        assertFalse("Lista não deveria estar vazia", l.isVazia());
    }
}