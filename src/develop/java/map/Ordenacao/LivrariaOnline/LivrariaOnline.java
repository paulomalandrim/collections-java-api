package develop.java.map.Ordenacao.LivrariaOnline;

import java.util.*;

public class LivrariaOnline {

    private Map<String, Livro> livroMap;

    public LivrariaOnline() {
        this.livroMap = new HashMap<>();
    }

    public void adicionarLivro(String link, Livro livro){
        livroMap.put(link, livro);
    }

    public void removerLivro(String titulo){
        for (Map.Entry<String, Livro> livroEntry : livroMap.entrySet()){
            if (livroEntry.getValue().getTitulo().equalsIgnoreCase(titulo)){
                livroMap.remove(livroEntry.getKey());
                break;
            }
        }
    }

    public void exibirLivrosOrdenadosPorPreco(){
        List<Map.Entry<String, Livro>> livroOrdenadoPorPreco = new ArrayList<>(livroMap.entrySet());
        Collections.sort(livroOrdenadoPorPreco, new ComparatorPorPreco());

        Map<String, Livro> livrosOrdenadosMap = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livroOrdenadoPorPreco){
            livrosOrdenadosMap.put(entry.getKey(),entry.getValue());
        }

        System.out.println("Livros ordenados por preco:" + livroOrdenadoPorPreco);

    }

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor){
        List<Map.Entry<String, Livro>> listLivros = new ArrayList<>(livroMap.entrySet());
        Map<String, Livro> livrosDoAutor = new HashMap<>();

        for (Map.Entry<String, Livro> entry : listLivros){
            if (entry.getValue().getAutor().equalsIgnoreCase(autor)){
                livrosDoAutor.put(entry.getKey(), entry.getValue());
            }
        }
        return livrosDoAutor;
    }

    public Livro obterLivroMaisCaro(){
        List<Map.Entry<String, Livro>> listLivros = new ArrayList<>(livroMap.entrySet());
        Livro livroMaisCaro = null;

        for (Map.Entry<String, Livro> entry : listLivros){
            if (livroMaisCaro == null) livroMaisCaro = entry.getValue();
            if (entry.getValue().getPreco() > livroMaisCaro.getPreco()){
                livroMaisCaro = entry.getValue();
            }
        }

        return livroMaisCaro;
    }

    public Livro obterLivroMaisBarato(){
        List<Map.Entry<String, Livro>> listLivros = new ArrayList<>(livroMap.entrySet());
        Livro livroMaisBarato = null;

        for (Map.Entry<String, Livro> entry : listLivros) {
            if (livroMaisBarato == null) livroMaisBarato = entry.getValue();
            if (entry.getValue().getPreco() < livroMaisBarato.getPreco()){
                livroMaisBarato = entry.getValue();
            }
        }

        return livroMaisBarato;

    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();

        livrariaOnline.adicionarLivro("https://x.gd/tK9eF", new Livro("Titulo 1", "Autor 1", 20.90D));
        livrariaOnline.adicionarLivro("https://x.gd/FKHND", new Livro("Titulo 2", "Autor 2", 45.90D));
        livrariaOnline.adicionarLivro("https://x.gd/FKHN3", new Livro("Titulo 4", "Autor 2", 85.90D));
        livrariaOnline.adicionarLivro("https://x.gd/4AQi1", new Livro("Titulo 3", "Autor 3", 17.90D));

        livrariaOnline.exibirLivrosOrdenadosPorPreco();

        System.out.println("Livros do Autor 2: " + livrariaOnline.pesquisarLivrosPorAutor("Autor 2"));
        System.out.println("O livro mais caro e: " + livrariaOnline.obterLivroMaisCaro());
        System.out.println("O livro mais barato e: " + livrariaOnline.obterLivroMaisBarato());
    }
}

class ComparatorPorPreco implements Comparator<Map.Entry<String, Livro>>{
    @Override
    public int compare(Map.Entry<String, Livro> o1, Map.Entry<String, Livro> o2) {
        return Double.compare(
                o1.getValue().getPreco(),
                o2.getValue().getPreco());
    }
}