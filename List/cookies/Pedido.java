import java.util.ArrayList;

public class Pedido {
    private final ArrayList<PedidoCookie> cookies;

    public Pedido() {
        this.cookies = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie cookie) {
        cookies.add(cookie);
    }

    public int obterTotalCaixas() {
        int total = 0;
        for (var cookie : cookies) {
            total += cookie.getQuantidadeCaixas();
        }
        return total;
    }

    public int removerSabor(String sabor) {
        int total = 0;
        for (int i=cookies.size()-1; i>=0; i--) {
            var cookie = cookies.get(i);
            if (sabor.equals(cookie.getSabor())) {
                cookies.remove(i);
                total += cookie.getQuantidadeCaixas();
            }
        }
        return total;
    }
}
