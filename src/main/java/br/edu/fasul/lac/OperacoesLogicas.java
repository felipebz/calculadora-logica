package br.edu.fasul.lac;

public class OperacoesLogicas {
    public static String and(String i, String j) {
        int v1 = (i.equals("T")) ? 1 : 0;
        int v2 = (j.equals("T")) ? 1 : 0;
        return ((v1&v2) == 1) ? "T" : "F";
    }
    
    public static String or(String i, String j) {
        int v1 = (i.equals("T")) ? 1 : 0;
        int v2 = (j.equals("T")) ? 1 : 0;
        return ((v1|v2) == 1) ? "T" : "F";
    }
    
    public static String not(String i) {
        return (i.equals("T")) ? "F" : "T";
    }
    
    public static String implicacao(String i, String j) {
        return or(not(i), j);
    }
    
    public static String bicondicional(String i, String j) {
        return (i.equals(j)) ? "T" : "F";
    }
}
