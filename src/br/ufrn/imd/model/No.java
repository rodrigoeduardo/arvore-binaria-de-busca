package src.br.ufrn.imd.model;

public class No {
    int valor;
    No esq;
    No dir;
    // int nivel;

    public No(int valor) {
        this.valor = valor;
        this.esq = null;
        this.dir = null;
    }

    public int altura() {
        int alturaEsq, alturaDir;

        if (this.esq != null) alturaEsq = this.esq.altura();
        else alturaEsq = 0;

        if (this.dir != null) alturaDir = this.dir.altura();
        else alturaDir = 0;

        if (alturaEsq > alturaDir) return alturaEsq + 1;
        else return alturaDir + 1;
    }
}