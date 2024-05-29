package develop.java.map.Pesquisa.ContagemDePalavras;

import java.util.HashMap;
import java.util.Map;

public class ContagemPalavras {

    private Map<String, Integer> stringIntegerMap;

    public ContagemPalavras() {
        this.stringIntegerMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem){
        stringIntegerMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra){
        stringIntegerMap.remove(palavra);
    }

    public void exibirContagemPalavras(){
        System.out.println(stringIntegerMap);
    }

    public Map.Entry<String, Integer> encontrarPalavraMaisFrequente(){
        Map.Entry<String, Integer> palavraMaiorFrequencia = null;
        for (Map.Entry<String, Integer> entry : stringIntegerMap.entrySet()){
            if (palavraMaiorFrequencia == null) palavraMaiorFrequencia = entry;
            if (entry.getValue() > palavraMaiorFrequencia.getValue()) palavraMaiorFrequencia = entry;
        }
        return palavraMaiorFrequencia;
    }

    public static void main(String[] args) {
        ContagemPalavras contagemPalavras = new ContagemPalavras();

        // Adiciona linguagens e suas contagens
        contagemPalavras.adicionarPalavra("Java", 2);
        contagemPalavras.adicionarPalavra("Python", 8);
        contagemPalavras.adicionarPalavra("JavaScript", 1);
        contagemPalavras.adicionarPalavra("C#", 6);

        // Exibe a contagem total de linguagens
        contagemPalavras.exibirContagemPalavras();

        // Encontra e exibe a linguagem mais frequente
        Map.Entry<String, Integer> linguagemMaisFrequente = contagemPalavras.encontrarPalavraMaisFrequente();
        System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente.getKey() + " com frequencia de: " + linguagemMaisFrequente.getValue());
    }
}
