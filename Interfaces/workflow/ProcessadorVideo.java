import java.util.ArrayList;
import java.util.List;

public class ProcessadorVideo {
    private List<CanalNotificacao> canais = new ArrayList<>();
    public void registrarCanal(CanalNotificacao canal) {
        canais.add(canal);
    }
    public void processar(Video video) {
        var message = String.format("%s - %s", video.getArquivo(), video.getFormato());
        canais.forEach(c -> c.notificar(new Mensagem(TipoMensagem.LOG, message)));
    }
}
