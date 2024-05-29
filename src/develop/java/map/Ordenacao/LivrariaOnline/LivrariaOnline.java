package develop.java.map.Ordenacao.LivrariaOnline;

import java.util.HashMap;
import java.util.Map;

public class LivrariaOnline {

    private Map<String, Livro> livroMap;

    public LivrariaOnline() {
        this.livroMap = new HashMap<>();
    }

    public void adicionarLivro(String isbn, Livro livro){
        livroMap.put(isbn, livro);
    }

    public void removerLivro(String titulo){
        livroMap.
    }



}
