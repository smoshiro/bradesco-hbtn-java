import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {
    private String nome;
    private double preco;
    private double percentualMarkup = 10;

    public Supplier<Double> precoComMarkup = () -> preco * (100 + percentualMarkup) / 100;
    public Consumer<Double> atualizarMarkup = (p) -> percentualMarkup = p;

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public double getPercentualMarkup() {
        return percentualMarkup;
    }

    public Supplier<Double> getPrecoComMarkup() {
        return precoComMarkup;
    }

    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

}
