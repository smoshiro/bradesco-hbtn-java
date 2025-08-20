import java.util.ArrayList;

public class GestaoAlunos {
    private ArrayList<Aluno> alunos = new ArrayList<>();
    public void adicionarAluno(String nome, int idade) {
        alunos.add(new Aluno(nome, idade));
    }
    public void excluirAluno(String nome) {
        for (int i=0; i < alunos.size(); i++) {
            var aluno = alunos.get(i);
            if (aluno.getNome().equals(nome)) {
                System.out.printf("O aluno %s foi excluido\n", aluno.getNome());
                alunos.remove(i);
                return;
            }
        }
        System.out.printf("Nao foi possivel excluir o aluno %s\n", nome);
    }
    public Aluno buscarAluno(String nome) {
        for (var aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                System.out.printf("O aluno %s foi encontrado\n", aluno.getNome());
                return aluno;
            }
        }
        System.out.printf("O aluno %s nao foi encontrado\n", nome);
        return null;
    }
    public void listarAlunos() {
        System.out.println("Alunos:");
        for (var aluno : alunos) {
            System.out.println(aluno.toString());
        }
    }

    public static void main(String[] args) {
        var gestao = new GestaoAlunos();
        gestao.adicionarAluno("Aluno A", 10);
        gestao.adicionarAluno("Aluno B", 11);
        gestao.adicionarAluno("Aluno C", 12);
        gestao.listarAlunos();
        var aluno = gestao.buscarAluno("Aluno B");
        gestao.excluirAluno(aluno.getNome());
        gestao.excluirAluno("Aluno D");
        aluno = gestao.buscarAluno("Aluno A");
    }
}
