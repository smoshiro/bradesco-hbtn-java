public class Consumidor extends Thread {
    private final int id;
    private final Fila fila;
    public Consumidor(int id, Fila fila) {
        this.id = id;
        this.fila = fila;
    }
    @Override
    public void run() {
        try {
            while (true) {
                var item = fila.retirar();
                System.out.printf("Consumidor %d consumiu: %d\n", id, item);
                Thread.sleep(500);  // Simula o tempo para consumir um item
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
