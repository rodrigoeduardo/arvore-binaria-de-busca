package src.br.ufrn.imd.model;

public class No {
    int valor;
    No esq;
    No dir;
    public int altura;
    // int nivel;

    public No(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
        this.altura = 1;
    }

    public void calcularAltura(No no) {
        int alturaEsq, alturaDir;

        if (no.esq != null) alturaEsq = no.esq.altura;
        else alturaEsq = 0;

        if (no.dir != null) alturaDir = no.dir.altura;
        else alturaDir = 0;

        if (alturaEsq > alturaDir) no.altura = alturaEsq + 1;
        else no.altura = alturaDir + 1;
    }
}