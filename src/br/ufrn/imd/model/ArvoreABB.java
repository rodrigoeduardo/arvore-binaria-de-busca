package src.br.ufrn.imd.model;

import java.util.List;

public class ArvoreABB {
    public No raiz;
    
    public ArvoreABB(List<Integer> nums) {
        for (Integer num : nums) {
            inserir(this.raiz, num);
        }
    }

    public void inserir(No no, int valor) {
        if (this.raiz == null) {
            this.raiz = new No(valor);
            return;
        }

        if (valor < no.valor) {
            if (no.esq != null) inserir(no.esq, valor);
            else no.esq = new No(valor);
        } else if (valor > no.valor) {
            if (no.dir != null) inserir(no.dir, valor);
            else no.dir = new No(valor);
        } else {
            System.out.printf("%d já está na árvore, não pode ser inserido", valor);
            System.out.println();
            return;
        }
    }

    public void calcularAltura(No no) {
        if (no.esq != null) calcularAltura(no.esq);
        if (no.dir != null) calcularAltura(no.dir);
        no.calcularAltura(no);
    }

    public void preOrdem(No no) {
        System.out.print(no.valor + " ");
        if (no.esq != null) preOrdem(no.esq);
        if (no.dir != null) preOrdem(no.dir);
    }

    public void imprimeArvore(int s) {
        if (s == 1) imprimeArvore1();
        if (s == 2) imprimeArvore2();
    }

    public void imprimeArvore1() {
        
    }

    public void imprimeArvore2() {
        
    }

    /*

    // - Métodos Extra -

    public void preOrdemIterativo(No no) {
        Stack<No> pilha = new Stack<No>();
        pilha.push(no);

        while (!pilha.empty()) {
            No aux = pilha.pop();
            System.out.print(aux.valor + " ");

            if (aux.dir != null) pilha.push(aux.dir);
            if (aux.esq != null) pilha.push(aux.esq);
        }
    }

    public void ordemSimetrica(No no) {
        if (no.esq != null) ordemSimetrica(no.esq);
        System.out.print(no.valor + " ");
        if (no.dir != null) ordemSimetrica(no.dir);
    }

    public void posOrdem(No no) {
        if (no.esq != null) posOrdem(no.esq);
        if (no.dir != null) posOrdem(no.dir);
        System.out.print(no.valor + " ");
    }
    */
}
