import java.util.ArrayList;
import java.util.List;

public class Biblioteca<T extends Midia> {

    private List<T> biblioteca;

    public Biblioteca() {
        this.biblioteca = new ArrayList<>();
    }

    public void adicionarMidia(T midia) {
        biblioteca.add(midia);
    }

    public List<T> obterListaMidias() {
        return biblioteca;
    }
}
