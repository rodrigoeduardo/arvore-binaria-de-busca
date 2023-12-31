package src.br.ufrn.imd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArvoreABB {
    public No raiz;
    public int qtdNos;
    
    public ArvoreABB(List<Integer> nums) {
        this.qtdNos = 0;
        for (Integer num : nums) {
            inserir(this.raiz, num);
        }
    }

    public No buscar(No no, int x){
        if (no == null) {
            System.out.printf("Elemento %d não está presente na árvore\n", x);
            return null;
        }

        if (x > no.valor){
            return buscar(no.dir, x);
        } else if (x < no.valor) {
            return buscar(no.esq, x);
        } else {
            System.out.printf("Elemento %d encontrado\n", x);
            return no;
        }
    }

    public void remover(int x){
        if (buscar(raiz, x) == null) return;
        remover(this.raiz, x);
        System.out.printf("Elemento %d removido da árvore\n", x);
    }

    public No remover(No no, int x){
        if (no == null) {
            return no;
        }
        
        if (no.valor == x) {
            if (no.esq == null){
                return no.dir;
            } else if (no.dir == null) {
                return no.esq;
            } else {
                No paiSucessor = no;
                No sucessor = no.dir;

                while (sucessor.esq != null) {
                    paiSucessor = sucessor;
                    sucessor = sucessor.esq;
                }

                if (paiSucessor != no) paiSucessor.esq = sucessor.dir;
                else paiSucessor.dir = sucessor.dir;

                no.valor = sucessor.valor;

                return no;
            }
        } else {
            if (x > no.valor){
                no.dir = remover(no.dir, x);
            } else if (x < no.valor) {
                no.esq = remover(no.esq, x);
            }
            return no;
        }
    }

    public void inserir(No no, int valor) {
        if (this.raiz == null) {
            this.raiz = new No(valor);
            qtdNos++;
            return;
        }

        if (valor < no.valor) {
            if (no.esq != null) inserir(no.esq, valor);
            else {
                no.esq = new No(valor);
                qtdNos++;
                System.out.printf("%d adicionado", valor);
                System.out.println();
            }
        } else if (valor > no.valor) {
            if (no.dir != null) inserir(no.dir, valor);
            else {
                no.dir = new No(valor);
                qtdNos++;
                System.out.printf("%d adicionado", valor);
                System.out.println();
            }
        } else {
            System.out.printf("%d já está na árvore, não pode ser inserido", valor);
            System.out.println();
            return;
        }
    }

    public String preOrdem() {
        return preOrdem(raiz);
    }

    public String preOrdem(No no) {
        String percurso = "";
        Stack<No> pilha = new Stack<No>();
        pilha.push(no);

        while (!pilha.empty()) {
            No aux = pilha.pop();
            percurso += aux.valor;

            if (aux.dir != null) pilha.push(aux.dir);
            if (aux.esq != null) pilha.push(aux.esq);

            if (!pilha.empty()) percurso += " ";
        }

        System.out.println(percurso);
        return percurso;
    }

    public void imprimeArvore(int s) {
        if (s == 1) imprimeArvore1(raiz, raiz.altura());
        if (s == 2) imprimeArvore2();
    }

    private void imprimeArvore1(No no, int altura) {
        for(int i = raiz.altura() - altura; i != 0; i--) System.out.print("    ");
        System.out.println(no.valor + "--------------");
        if (no.esq != null) imprimeArvore1(no.esq, altura-1);
        if (no.dir != null) imprimeArvore1(no.dir, altura-1);
    }

    private void imprimeArvore2() {
        System.out.print("(");
        imprimeArvore2(raiz);
        System.out.print(")\n");
    }

    private void imprimeArvore2(No no) {
        System.out.print(no.valor);

        if (no.esq != null) {
            System.out.print("(");
            imprimeArvore2(no.esq);
            System.out.print(")");
        }

        if (no.dir != null) {
            System.out.print("(");
            imprimeArvore2(no.dir);
            System.out.print(")");
        }
    }

    public boolean ehCompleta() {
        if (qtdNos >= Math.pow(2, raiz.altura() - 1) && qtdNos <= Math.pow(2, raiz.altura()) - 1) {
            System.out.println("A árvore é completa");
            return true;
        }

        System.out.println("A árvore não é completa");
        return false;
    }

    public boolean ehCheia() {
        if (qtdNos == Math.pow(2, raiz.altura()) - 1) {
            System.out.println("A árvore é cheia");
            return true;
        }
        
        System.out.println("A árvore não é cheia");
        return false;
    }

    public int enesimoElemento(int posicaoDesejada){
        int n = posicaoDesejada;
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
                    System.out.printf("O %d° elemento em ordem simétrica é %d\n", posicaoDesejada, noAtual.valor);
                    return noAtual.valor;
                }
                noAtual = noAtual.dir;
            }
        }
        System.out.printf("%d está fora do alcance da árvore\n", n);
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
                    System.out.printf("Elemento %d é o %d° em ordem simétrica\n", x, n);
                    return n;
                }
                n += 1;
                noAtual = noAtual.dir;
            }
        }
        System.out.printf("Elemento %d não está presente na árvore\n", x);
        return -1;
    }

    // recebe um No e uma lista vazia e preenche a lista de maneira ordenada com os descendentes da raiz
    private void paraListaOrdenada(No raiz, List<Integer> lista){
        if (raiz != null){
            paraListaOrdenada(raiz.esq, lista);
            lista.add(raiz.valor);
            paraListaOrdenada(raiz.dir, lista);
        }
    }

    public int mediana(){
        List<Integer> listaOrdenada = new ArrayList<>();
        int mediana;
        this.paraListaOrdenada(this.raiz, listaOrdenada);

        if (listaOrdenada.size() % 2 == 0){
            mediana = listaOrdenada.get((listaOrdenada.size() / 2) - 1);
        } else {
            mediana = listaOrdenada.get(listaOrdenada.size() / 2);
        }

        System.out.println("Mediana da árvore igual a " + mediana);
        return mediana;
    }

    public double media(){
        List<Integer> listaOrdenada = new ArrayList<>();
        this.paraListaOrdenada(this.raiz, listaOrdenada);

        int soma = 0;
        for(int elemento : listaOrdenada){
            soma += elemento;
        }

        double media = ((double) soma) / ((double) listaOrdenada.size());
        System.out.println("Média da árvore igual a " + media);
        return media;
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
