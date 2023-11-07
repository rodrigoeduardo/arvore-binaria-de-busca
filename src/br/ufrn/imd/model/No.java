package src.br.ufrn.imd.model;

public class No {
    int valor;
    No esq;
    No dir;
    // int altura;
    // int nivel;

    public No(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }
}