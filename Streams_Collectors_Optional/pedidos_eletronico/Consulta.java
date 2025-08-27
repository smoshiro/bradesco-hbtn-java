import java.util.Comparator;
import java.util.List;

public class Consulta {
    private Consulta() {
        //static class
    }
    public static List<Produto> obterLivrosDoPedido(Pedido pedido) {
        return pedido
                .getProdutos()
                .stream()
                .filter(p -> p.getCategoria() == CategoriaProduto.LIVRO)
                .toList()
                ;
    }

    public static Produto obterProdutoMaiorPreco(List<Produto> produtos) {
        return produtos
                .stream()
                .max(Comparator.comparing(Produto::getPreco, Double::compareTo))
                .orElse(null)
                ;
    }

    public static List<Produto> obterProdutosPorPrecoMinimo(List<Produto> produtos, double precoMinimo) {
        return produtos
                .stream()
                .filter(p -> p.getPreco() >= precoMinimo)
                .toList()
                ;
    }

    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        return pedidos
                .stream()
                .filter(p -> p
                        .getProdutos()
                        .stream()
                        .anyMatch(pp -> pp.getCategoria() == CategoriaProduto.ELETRONICO))
                .toList();
    }
}
