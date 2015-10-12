package br.edu.fasul.lac.estruturas;

import org.junit.Test;
import static org.junit.Assert.*;

public class NoTest {
    
    @Test
    public void testGetObject() {
        No no = new No(1, null);
        assertEquals("O objeto não foi obtido", 1, no.getObject());
    }

    @Test
    public void testObterProximo() {
        No x = new No(4, null);
        No no = new No(1, x);
        assertEquals("O próximo nó não foi obtido", x, no.obterProximo());
    }

}