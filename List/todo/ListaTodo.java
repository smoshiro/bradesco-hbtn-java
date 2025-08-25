import java.util.ArrayList;
import java.util.List;

public class ListaTodo {
    private final List<Tarefa> tarefas;

    public ListaTodo() {
        this.tarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        if (localizarTarefa(tarefa.getIdentificador()) >= 0)
            throw new IllegalArgumentException(String.format("Tarefa com identificador %d ja existente na lista", tarefa.getIdentificador()));
        tarefas.add(tarefa);
    }

    public boolean marcarTarefaFeita(int identificador) {
        int pos = localizarTarefa(identificador);
        if (pos < 0) return false;
        tarefas.get(pos).marcar(true);
        return true;
    }

    public boolean desfazerTarefa(int identificador) {
        int pos = localizarTarefa(identificador);
        if (pos < 0) return false;
        tarefas.get(pos).marcar(false);
        return true;
    }

    public void desfazerTodas() {
        for (var t : tarefas)
            t.marcar(false);
    }

    public void fazerTodas() {
        for (var t : tarefas)
            t.marcar(true);
    }

    public void listarTarefas() {
        for (var t : tarefas) {
            System.out.println(t.toString());
        }
    }

    private int localizarTarefa(int identificador) {
        for (int i=0; i < tarefas.size(); i++) {
            var t = tarefas.get(i);
            if (t.getIdentificador() == identificador)
                return i;
        }
        return -1;
    }
}
