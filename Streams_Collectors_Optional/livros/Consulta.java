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
}
