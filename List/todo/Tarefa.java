public class Tarefa {
    private String descricao;
    private boolean estahFeita;
    private int identificador;

    public Tarefa(String descricao, int identificador) {
        this.identificador = identificador;
        modificarDescricao(descricao);
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isEstahFeita() {
        return estahFeita;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void marcar(boolean feita) {
        this.estahFeita = feita;
    }

    public void modificarDescricao(String descricao) {
        if (descricao == null || descricao.isBlank())
            throw new IllegalArgumentException("Descricao de tarefa invalida");
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return String.format("[%s]  Id: %d - Descricao: %s"
                , estahFeita ? "X" : " "
                , identificador
                , descricao
        );
    }
}
