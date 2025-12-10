public class ProdutorConsumidor {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();


        // Criar e iniciar as threads do produtor e consumidor
        var p = new Produtor(buffer);
        var c = new Consumidor(buffer);
        p.start();
        c.start();
        try {
            p.join();
            c.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}