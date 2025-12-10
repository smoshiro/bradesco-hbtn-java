import java.util.ArrayList;

public class SistemaFilas {
    public static void main(String[] args) throws InterruptedException {
        var fila = new Fila(10);
        var threads = new ArrayList<Thread>(4);
        threads.add(new Produtor(1, fila));
        threads.add(new Produtor(2, fila));
        threads.add(new Consumidor(1, fila));
        threads.add(new Consumidor(2, fila));
        for (var t : threads) {
            t.start();
        }
        Thread.sleep(20000);
        System.exit(0);
    }
}
