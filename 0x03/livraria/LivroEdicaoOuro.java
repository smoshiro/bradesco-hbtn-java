import exceptions.AutorInvalidoException;
import exceptions.LivroInvalidoException;

public class LivroEdicaoOuro extends Livro {
    public LivroEdicaoOuro(String titulo, String autor, double valor) throws AutorInvalidoException, LivroInvalidoException {
        super(titulo, autor, valor);
    }
    @Override
    public double getPreco() {
        return super.getPreco() * 1.3;
    }
}
