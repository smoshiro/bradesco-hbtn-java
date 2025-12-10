import java.util.Random;

public class Produtor extends Thread {
    private final int id;
    private final Fila fila;
    private final Random generator;
    private final int min;
    private final int max;

    public Produtor(int id, Fila fila, int min, int max) {
        this.id = id;
        this.fila = fila;
        this.generator = new Random();
        this.min = min;
        this.max = max;
    }

    @Override
    public void run() {
        try {
            while (true) {
                var item = generateItem();
                fila.adicionar(item);
                System.out.printf("Produtor %d produziu: %d\n", id, item);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected int generateItem() {
        return generator.nextInt(max - min + 1) + min;
    }
}
