import java.util.LinkedList;

public class Fila {
    private final int tamanhoMaximo;
    private final LinkedList<Integer> fila;
    public Fila(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.fila = new LinkedList<>();
    }
    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() == tamanhoMaximo) {
            wait();
        }
        fila.add(item);
        notifyAll();
    }
    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {
            wait();
        }
        var item = fila.removeFirst();
        notifyAll();
        return item;
    }
}
