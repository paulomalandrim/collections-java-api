package develop.java.map.Pesquisa.EstoqueDeProdutosComPreco;

import java.util.HashMap;
import java.util.Map;

public class EstoqueProdutos {

    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueProdutosMap.put(cod, new Produto(nome, quantidade, preco));
    }

    public void exibirProdutos(){
        System.out.println(estoqueProdutosMap);
    }

    public double calcularValorTotalEstoque(){
        double valorTotal = 0d;
        for (Produto p : estoqueProdutosMap.values()){
            valorTotal += p.getPreco() * p.getQuantidade();
        }
        return valorTotal;
    }
    // retornar apenas 1 produto como mais caro
    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        for (Produto p : estoqueProdutosMap.values()){
            if (produtoMaisCaro == null) produtoMaisCaro = p; // somente para preencher produto mais caro
            if (p.getPreco() > produtoMaisCaro.getPreco()) produtoMaisCaro = p;
        }
        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato(){
        Produto produtoMaisBarato = null;
        for (Produto p : estoqueProdutosMap.values()){
            if (produtoMaisBarato == null) produtoMaisBarato = p; // somente para preencher produto mais barato
            if (p.getPreco() < produtoMaisBarato.getPreco()) produtoMaisBarato = p;
        }
        return produtoMaisBarato;
    }

    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        Produto estoqueMaisCaro = null;
        for (Produto p : estoqueProdutosMap.values()){
            if (estoqueMaisCaro == null) estoqueMaisCaro = p; // somente para preencher produto mais caro
            if ((p.getPreco() * p.getQuantidade()) > (estoqueMaisCaro.getPreco() * estoqueMaisCaro.getQuantidade()))
                estoqueMaisCaro = p;
        }
        return estoqueMaisCaro;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.adicionarProduto(1L, "Produto 1", 1, 1.00);
        estoqueProdutos.adicionarProduto(2L, "Produto 2", 10, 2.00);
        estoqueProdutos.adicionarProduto(3L, "Produto 3", 3, 3.00);
        estoqueProdutos.adicionarProduto(4L, "Produto 4", 4, 4.00);

        estoqueProdutos.exibirProdutos();

        System.out.println("Valor total do estoque: " + estoqueProdutos.calcularValorTotalEstoque());
        System.out.println("Produto mais caro: " + estoqueProdutos.obterProdutoMaisCaro());
        System.out.println("Produto mais barato: " + estoqueProdutos.obterProdutoMaisBarato());
        System.out.println("Produto(valor*qtde) mais caro: " + estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());

    }

}
