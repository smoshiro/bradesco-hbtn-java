import java.util.ArrayList;
import java.util.List;

public class ConsultaProdutos {
    public static List<Produto> filtrar(List<Produto> produtos, CriterioFiltro criterio) {
        var filtrado = new ArrayList<Produto>();
        for (var produto : produtos) {
            if (criterio.testar(produto))
                filtrado.add(produto);
        }
        return filtrado;
    }
}
