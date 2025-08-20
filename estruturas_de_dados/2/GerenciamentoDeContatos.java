import java.util.HashMap;
import java.util.Map;


public class GerenciamentoDeContatos {
    private Map<String, Contato> contatos;


    // Construtor
    public GerenciamentoDeContatos() {
        contatos = new HashMap<>();
    }


    // Adiciona um novo contato
    public void adicionarContato(String nome, String telefone, String email) {
        // IMPLEMENTE ESTE METODO
        if (contatos.containsKey(nome)) {
            System.out.printf("Erro: Contato com nome %s já existe!\n", nome);
            return;
        }
        var contato = new Contato();
        contato.adicionarTelefone(telefone);
        contato.adicionarEmail(email);
        contatos.put(nome, contato);
        System.out.printf("Contato %s adicionado com sucesso!\n", nome);
    }


    // Exibe todos os contatos
    public void exibirContatos() {
        // IMPLEMENTE ESTE METODO
        for (var entry : contatos.entrySet()) {
            System.out.printf("Nome: %s\n", entry.getKey());
            entry.getValue().exibirContato();
            System.out.println("-------------------------------");
        }
    }


    // Busca um contato pelo nome
    public void buscarContato(String nome) {
        // IMPLEMENTE ESTE METODO
        if (contatos.containsKey(nome)) {
            System.out.printf("Contato encontrado: %s\n", nome);
            contatos.get(nome).exibirContato();
        }
    }


    // Remove um contato pelo nome
    public void removerContato(String nome) {
        // IMPLEMENTE ESTE METODO
        if (contatos.remove(nome) == null) {
            System.out.printf("Contato %s não encontrado.\n", nome);
        } else {
            System.out.printf("Contato %s removido com sucesso!\n", nome);
        }
    }


    public static void main(String[] args) {
        GerenciamentoDeContatos gestao = new GerenciamentoDeContatos();


        // Adicionando contatos
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com");
        gestao.adicionarContato("Maria", "8765-4321", "maria@email.com");
        gestao.adicionarContato("Ana", "1122-3344", "ana@email.com");
        gestao.adicionarContato("Carlos", "1234-5678", "carlos@email.com"); // Tentando duplicar


        // Exibindo todos os contatos
        System.out.println("\n\nExibindo todos os contatos:");
        gestao.exibirContatos();


        // Buscando um contato
        System.out.println("\n\nBuscando contato 'Maria':");
        gestao.buscarContato("Maria");


        // Removendo um contato
        System.out.println("\n\nRemovendo contato 'Carlos':");
        gestao.removerContato("Carlos");


        // Tentando remover um contato inexistente
        System.out.println("\n\nTentando remover contato 'João' que não existe:");
        gestao.removerContato("João");


        // Exibindo todos os contatos após remoções
        System.out.println("\n\nExibindo todos os contatos após remoções:");
        gestao.exibirContatos();
    }
}
