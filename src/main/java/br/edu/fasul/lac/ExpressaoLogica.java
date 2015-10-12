package br.edu.fasul.lac;

import br.edu.fasul.lac.estruturas.Fila;
import br.edu.fasul.lac.estruturas.Pilha;

public class ExpressaoLogica {

    String expressao;
    String[] segmentos;
    Fila fila;
    Pilha pilha;


    public ExpressaoLogica() {
    }

    /**
     * Contrutor da clase ExpressaoLogica.
     * @param expressao Expressão a ser avaliada.
     */
    public ExpressaoLogica(String expressao) {
        this.expressao = expressao;
    }

    public void executa() {
        segmentos = quebra();
        separa();
        resolve();
    }

    /**
     * Separa uma string de expressão lógica em segmentos.
     * @param s String a ser quebrada.
     * @return Array dos segmentos.
     */
    public String[] quebra() {
        expressao = expressao.replaceAll(" ", "").replaceAll("", " ");
        expressao = expressao.replaceAll("< - >", "<->").replaceAll("- >", "->").trim().toUpperCase();
        return expressao.split(" ");
    }


    /**
     * Método estático que verifica se a string passada como parâmetro
     * é válida. Valida o número de parênteses e o formato.
     * @param expressao Expressão a ser testada.
     * @return 'True' se a expressão for uma expressão lógica válida, e 'False' se não for.
     */
    public static boolean isValida(String expressao) {
        int c_parenteses = 0;
        expressao = expressao.replaceAll(" ", "").toUpperCase();

        while (true) {
            // for para verificar se todos os parênteses abertos foram fechados
            for (int i = 0; i < expressao.length(); i++) {
                if (expressao.charAt(i) == '(') {
                    c_parenteses++;
                }
                if (expressao.charAt(i) == ')') {
                    c_parenteses--;
                }
            }
            
            // se os parênteses abertos foram fechados
            if (c_parenteses == 0) {
                // verifica se a expressão é compatível com a expressão regular (regex)
                if (expressao.matches("^(~*[(]*?|([FT]|[(]*[~]*?[FT])[)]*?(V|\\^|->|<->)[(]?~?[(]?)*(F|T|[FT][)]*)$")) {
                    return true;
                }
                return false;
            }
            return false;
        }
    }


    /**
     * Testa a precedência do parâmetro com a precedência do operador do topo da pilha.
     * @param dado Operador a ser testado
     * @return 'True' se o operador do topo pilha tiver precedência maior e 'false' caso contrário.
     */
    public boolean isMaisImportante(String valor, String topo_pilha) {
        String precedencia = "~^V-<"; // string necessária para a ordem de precedência
        if (topo_pilha.equals("(")) {
            return false;
        } else if (precedencia.indexOf(topo_pilha) >= precedencia.indexOf(valor)) { // verifica a precedência
            return false;
        }
        return true;
    }

    /**
     * Separa a expressão em uma fila e uma pilha, seguindo a notação polonesa reversa.
     */
    public void separa() {
        fila = new Fila();
        pilha = new Pilha();
        for (String token : segmentos) {
            if (token.matches("[FT]")) { // se o token for um operando
                fila.insere(token);
            } else if (token.equals("~") || token.equals("(")) {
                pilha.insere(token);
            } else if (token.equals(")")) {
                while (!(pilha.verificarFinal().equals("("))) { // enquanto o topo da pilha não tiver um '('
                    fila.insere(pilha.retira());
                }
                pilha.retira(); // retira o '(' restante
            } else { // se o token for qualquer outro operador
                if (!pilha.isVazia()) {
                    if (isMaisImportante(token, (String) pilha.verificarFinal()))
                    {
                        fila.insere(pilha.retira());
                    }
                }
                pilha.insere(token);
            }
        }
        
        while (!pilha.isVazia()) {
            fila.insere(pilha.retira());
        }
        // ao fim desse método, a fila terá os elementos escritos na forma de notação polonesa reversa
    }

    /**
     * Resolve a notação polonesa reversa
     */
    public void resolve() {
        String i, j;
        while (!fila.isVazia()) {
            String x = (String) fila.retira();
            if (x.equals("F") || x.equals("T")) { // se ele for um operando
                pilha.insere(x);
            } else {
                switch (x.charAt(0)) {
                    case '^': // se for um E LÓGICO
                        i = (String) pilha.retira();
                        j = (String) pilha.retira();
                        pilha.insere(OperacoesLogicas.and(j, i));
                        break;
                    case 'V': // se for um OU LÓGICO
                        i = (String) pilha.retira();
                        j = (String) pilha.retira();
                        pilha.insere(OperacoesLogicas.or(j, i));
                        break;
                    case '~':  // se for um NÃO LÓGICO
                        i = (String) pilha.retira();
                        pilha.insere(OperacoesLogicas.not(i));
                        break;
                    case '-':  // se for uma IMPLICAÇÃO
                        i = (String) pilha.retira();
                        j = (String) pilha.retira();
                        pilha.insere(OperacoesLogicas.implicacao(j, i));
                        break;
                    case '<':  // se for uma BICONDICIONAL
                        i = (String) pilha.retira();
                        j = (String) pilha.retira();
                        pilha.insere(OperacoesLogicas.bicondicional(i, j));
                        break;
                }
            }
        }
    }

    /**
     * Mostra a resposta da expressão
     * @return A resposta da expressão
     */
    public String resposta() {
        return pilha.toString();
    }
}
