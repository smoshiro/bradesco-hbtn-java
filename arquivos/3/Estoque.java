import java.io.*;
import java.util.TreeMap;

public class Estoque {
    private final String filename;
    private TreeMap<Integer,Produto> estoque;

    public Estoque(String filename) {
        this.filename = filename;
        carregarEstoque();
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        if (nome == null || nome.isEmpty()) {
            System.out.println("O nome do produto deve ter pelo menos 1 caracter");
        }
        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior que zero");
            return;
        }
        if (preco <= 0) {
            System.out.println("O preco deve ser maior que zero");
            return;
        }
        int nextId = 1 + estoque.lowerKey(Integer.MAX_VALUE);
        estoque.put(nextId, new Produto(nextId, nome, quantidade, preco));
        salvarEstoque();
    }

    public void excluirProduto(int idProduto) {
        if (!estoque.containsKey(idProduto)) {
            System.out.println("Este produto nao existe no estoque");
            return;
        }
        estoque.remove(idProduto);
        salvarEstoque();
    }

    public void exibirEstoque() {
        for (var produto : estoque.values()) {
            System.out.println(produto.toString());
        }
    }

    public void atualizarQuantidade(int idProduto, int quantidade) {
        if (!estoque.containsKey(idProduto)) {
            System.out.println("Este produto nao existe no estoque");
            return;
        }
        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior que zero");
            return;
        }
        estoque.get(idProduto).setQuantidade(quantidade);
        salvarEstoque();
    }

    protected void carregarEstoque() {
        estoque = new TreeMap<>();
        try (var reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                var fields = line.split(",", -1);
                var id =  Integer.parseInt(fields[0]);
                var produto = new Produto(
                        id,
                        fields[1],
                        Integer.parseInt(fields[2]),
                        Double.parseDouble(fields[3]));
                estoque.put(id, produto);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected void salvarEstoque() {
        try (var writer = new BufferedWriter(new FileWriter(filename))) {
            for (var produto : estoque.values()) {
                writer.write(produto.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
