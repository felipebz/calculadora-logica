package br.edu.fasul.lac;

import org.junit.Test;
import static org.junit.Assert.*;

public class ExpressaoLogicaTest {

    @Test
    public void testQuebra() {
        ExpressaoLogica exp = new ExpressaoLogica("TFv^~-><->()");
        String[] p = exp.quebra();
        String[] m = {"T", "F", "V", "^", "~", "->", "<->", "(", ")"};
        assertArrayEquals("Tokenização falhou", m, p);
    }

    @Test
    public void testIsValida() {
        // Expressões válidas
        String validas[] = {"TVF", "T^F", "TVF^~(T->F)", "(((FVT)))", "(~F)"};
        for (String v : validas) {
            assertTrue(v + " falhou na validação", ExpressaoLogica.isValida(v));
        }

        // Expressões inválidas
        String invalidas[] = {"TVVF", "T~^F", "TVF~(T->F)", "a", "((()"};
        for (String v : invalidas) {
            assertFalse(v + " falhou na validação", ExpressaoLogica.isValida(v));
        }
    }

    @Test
    public void testIsMaisImportante() {
        ExpressaoLogica e = new ExpressaoLogica();

        String valores[] = {"~", "^", "V", "-", "<"};
        for (int i = 0; i < valores.length; i++) {
            for (int j = 0; j < valores.length; j++) {
                if (i <= j) {
                    assertEquals("Erro: " + valores[i] + " é menos importante que " + valores[j],
                            false, e.isMaisImportante(valores[i], valores[j]));
                } else {
                    assertEquals("Erro: " + valores[i] + " é mais importante que " + valores[j],
                            true, e.isMaisImportante(valores[i], valores[j]));
                }
            }
        }
    }

    @Test
    public void testSepara() {
        ExpressaoLogica e;
        String[] c = {
            "TvF",
            "T->F",
            "T<->F->T",
            "TV(~T<->F)"
        };
        String[][] p = {
            {"T", "V", "F"},
            {"T", "->", "F"},
            {"T", "<->", "F", "->", "T"},
            {"T", "V", "(", "~", "T", "<->", "F", ")"}
        };

        for (int i = 0; i < c.length; i++) {
            e = new ExpressaoLogica(c[i]);
            assertArrayEquals(c[i] + " não quebrada corretamente", p[i], e.quebra());
        }
    }

    @Test
    public void testResposta() {
        ExpressaoLogica e;
        String a;

        String[] resultaT = {
            "TvF",
            "T^t",
            "t->t",
            "t->f^fvt",
            "((~f))",
            "~~~~~F"
        };
        String[] resultaF = {
            "FvF",
            "((f))",
            "t->f",
            "f^f",
            "t     <-> (f  v F)"
        };
        for (String t : resultaT) {
            a = t;
            e = new ExpressaoLogica(a);
            e.executa();
            assertEquals(a + " resolvida incorretamente", "T", e.resposta().trim());
        }
        for (String f : resultaF) {
            a = f;
            e = new ExpressaoLogica(a);
            e.executa();
            assertEquals(a + " resolvida incorretamente", "F", e.resposta().trim());
        }
    }
}