package br.edu.fasul.lac;

import org.junit.Test;
import static org.junit.Assert.*;

public class OperacoesLogicasTest {

    @Test
    public void testAnd() {
        assertEquals("T^T falhou", "T", OperacoesLogicas.and("T", "T"));
        assertEquals("T^F falhou", "F", OperacoesLogicas.and("T", "F"));
        assertEquals("F^T falhou", "F", OperacoesLogicas.and("F", "T"));
        assertEquals("F^F falhou", "F", OperacoesLogicas.and("F", "F"));
    }

    @Test
    public void testOr() {
        assertEquals("TvT falhou", "T", OperacoesLogicas.or("T", "T"));
        assertEquals("TvF falhou", "T", OperacoesLogicas.or("T", "F"));
        assertEquals("FvT falhou", "T", OperacoesLogicas.or("F", "T"));
        assertEquals("FvF falhou", "F", OperacoesLogicas.or("F", "F"));
    }

    @Test
    public void testNot() {
        assertEquals("~T falhou", "F", OperacoesLogicas.not("T"));
        assertEquals("~F falhou", "T", OperacoesLogicas.not("F"));
    }

    @Test
    public void testImplicacao() {
        assertEquals("T->T falhou", "T", OperacoesLogicas.implicacao("T", "T"));
        assertEquals("T->F falhou", "F", OperacoesLogicas.implicacao("T", "F"));
        assertEquals("F->T falhou", "T", OperacoesLogicas.implicacao("F", "T"));
        assertEquals("F->F falhou", "T", OperacoesLogicas.implicacao("F", "F"));
    }

    @Test
    public void testBicondicional() {
        assertEquals("T<->T falhou", "T", OperacoesLogicas.bicondicional("T", "T"));
        assertEquals("T<->F falhou", "F", OperacoesLogicas.bicondicional("T", "F"));
        assertEquals("F<->T falhou", "F", OperacoesLogicas.bicondicional("F", "T"));
        assertEquals("F<->F falhou", "T", OperacoesLogicas.bicondicional("F", "F"));
    }

}