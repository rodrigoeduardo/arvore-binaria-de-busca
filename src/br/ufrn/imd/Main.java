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

        arvore.preOrdem(arvore.raiz);
        System.out.println();
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
