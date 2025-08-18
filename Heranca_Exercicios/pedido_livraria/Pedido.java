public class Pedido {
  private double percentualDesconto;
  private ItemPedido[] itens;
  public Pedido(double percentualDesconto, ItemPedido[] itens) {
    this.percentualDesconto = percentualDesconto;
    this.itens = itens;
  }
  public double calcularTotal() {
    double total = 0;
    for (int i=0; i < itens.length; i++) {
      total += itens[i].getQuantidade() * itens[i].getProduto().obterPrecoLiquido();
    }
    return total - total * percentualDesconto / 100;
  }
}
