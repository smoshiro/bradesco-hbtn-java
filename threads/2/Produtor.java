public class Produtor extends Thread {
    private final int id;
    private final Fila fila;

    public Produtor(int id, Fila fila) {
        this.id = id;
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (true) {
                var item = (int) (100.0 * Math.random() / Math.nextDown(1.0));
                fila.adicionar(item);
                System.out.printf("Produtor %d produziu: %d\n", id, item);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
