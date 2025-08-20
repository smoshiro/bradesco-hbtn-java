public class Mensagem {
    private String texto;
    private TipoMensagem tipoMensagem;

    public Mensagem(TipoMensagem tipoMensagem, String texto) {
        this.tipoMensagem = tipoMensagem;
        this.texto = texto;
    }

    public TipoMensagem getTipoMensagem() {
        return tipoMensagem;
    }

    public String getTexto() {
        return texto;
    }
}
