import java.util.*;
import java.util.stream.Collectors;

public class ConsultaPessoas {
    private ConsultaPessoas() {
        // private constructor
    }

    public static Map<String, Map<Integer, Long>> obterContagemPessoasPorCargoEIdade(List<Pessoa> pessoas) {
        return pessoas
                .stream()
                .collect(
                        Collectors.groupingBy(Pessoa::getCargo,
                                Collectors.groupingBy(Pessoa::getIdade,
                                        Collectors.counting() )));
    }
}
