import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ConsultaProdutos {
    public static List<Produto> filtrar(List<Produto> produtos, Predicate<Produto> criterio) {
        var filtrado = new ArrayList<Produto>();
        for (var produto : produtos) {
            if (criterio.test(produto))
                filtrado.add(produto);
        }
        return filtrado;
    }
}
