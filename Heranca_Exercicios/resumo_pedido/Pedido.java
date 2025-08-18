public class Pedido {
  private double percentualDesconto;
  private ItemPedido[] itens;
  public Pedido(double percentualDesconto, ItemPedido[] itens) {
    this.percentualDesconto = percentualDesconto;
    this.itens = itens;
  }
  public double calcularDesconto() {
    return calcularTotalLiquido() * percentualDesconto / 100;
  }
  public double calcularTotal() {
    double total = calcularTotalLiquido();
    return total - total * percentualDesconto / 100;
  }
  public double calcularTotalLiquido() {
    double total = 0;
    for (int i=0; i < itens.length; i++) {
      total += itens[i].getQuantidade() * itens[i].getProduto().obterPrecoLiquido();
    }
    return total;
  }
  public void apresentarResumoPedido() {
    System.out.println("------- RESUMO PEDIDO -------");
    for (int i=0; i < itens.length; i++) {
      System.out.println(itens[i].toString());
    }
    System.out.println("----------------------------");
    System.out.printf("DESCONTO: %.2f\n", calcularDesconto());
    System.out.printf("TOTAL PRODUTOS: %.2f\n", calcularTotalLiquido());
    System.out.println("----------------------------");
    System.out.printf("TOTAL PEDIDO: %.2f\n", calcularTotal());
    System.out.println("----------------------------");
  }
}
