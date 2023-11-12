package src.br.ufrn.imd.model;

import java.util.List;
import java.util.Stack;

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

    public int enesimoElemento(int n){
        Stack<No> pilha = new Stack<>();
        No noAtual = this.raiz;

        while(pilha.isEmpty() == false || noAtual != null){
            if (noAtual != null){
                pilha.push(noAtual);
                noAtual = noAtual.esq;
            } else {
                noAtual = pilha.pop();
                n -= 1;
                if (n == 0){
                    return noAtual.valor;
                }
                noAtual = noAtual.dir;
            }
        }
        return -1;
    }

    public int posicao(int x){
        Stack<No> pilha = new Stack<>();
        No noAtual = this.raiz;
        int n = 1;

        while(pilha.isEmpty() == false || noAtual != null){
            if (noAtual != null){
                pilha.push(noAtual);
                noAtual = noAtual.esq;
            } else {
                noAtual = pilha.pop();
                if (x == noAtual.valor){
                    return n;
                }
                n += 1;
                noAtual = noAtual.dir;
            }
        }
        return -1;
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
