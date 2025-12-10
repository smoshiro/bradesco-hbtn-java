import java.util.Locale;

public class Principal {
    public static final Locale LOCALE = new Locale("pt", "BR");
    public static void main(String[] args) {
        var contador = new Contador();
        var t1 = new ThreadContador(contador);
        var t2 = new ThreadContador(contador);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException iex) {
            System.err.println(iex.getMessage());
        }
        System.out.printf(LOCALE, "Valor final do contador: %d\n", contador.getContagem());
    }
}
