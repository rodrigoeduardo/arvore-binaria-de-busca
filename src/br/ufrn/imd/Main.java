package src.br.ufrn.imd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import src.br.ufrn.imd.model.ArvoreABB;

public class Main {
    public static void main(String[] args) {
        List<String> abbInicial;
        List<String> entradas;

        try {
            abbInicial = readFile("utils/abb-inicial.txt");
            entradas = readFile("utils/entrada.txt");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        List<Integer> abbInicialFormatada = new ArrayList<>();

        for (String num : abbInicial) {
            abbInicialFormatada.add(Integer.parseInt(num));
        }

        ArvoreABB arvore = new ArvoreABB(abbInicialFormatada);

        System.out.println();
        System.out.println("OPERAÇÕES DE entrada.txt:");
        System.out.println();

        for (String entrada : entradas) {
            String[] split = entrada.split(" ");
            String comando = split[0];
            String argumento = "";

            try {
                argumento = split[1];
            } catch (Exception e) {
                
            }

            executarComando(comando, argumento, arvore);
        }
    }

    private static void executarComando(String comando, String argumento, ArvoreABB arvore) {
        switch (comando) {
            case "INSIRA":
                arvore.inserir(arvore.raiz, Integer.parseInt(argumento));
                break;
            case "REMOVA":
                arvore.remover(Integer.parseInt(argumento));
                break;
            case "BUSCAR":
                arvore.buscar(arvore.raiz, Integer.parseInt(argumento));
                break;
            case "ENESIMO":
                arvore.enesimoElemento(Integer.parseInt(argumento));
                break;
            case "POSICAO":
                arvore.posicao(Integer.parseInt(argumento));
                break;
            case "MEDIANA":
                arvore.mediana();
                break;
            case "MEDIA":
                arvore.media();
                break;
            case "CHEIA":
                arvore.ehCheia();
                break;
            case "COMPLETA":
                arvore.ehCompleta();
                break;
            case "PREORDEM":
                arvore.preOrdem();
                break;
            case "IMPRIMA":
                arvore.imprimeArvore(Integer.parseInt(argumento));
                break;
        
            default:
                break;
        }
    }

    private static List<String> readFile(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;

        List<String> output = new ArrayList<>();

        while((line = br.readLine()) != null){
            output.add(line);
        }

        br.close();
        fr.close();
        
        return output;
    }
}
