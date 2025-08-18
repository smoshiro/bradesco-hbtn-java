public class PersonagemGame {
  private int saudeAtual;
  private String nome;
  private String status;
  public int getSaudeAtual() { return saudeAtual; }
  public void setSaudeAtual(int saudeAtual) {
    this.saudeAtual = saudeAtual;
    this.status = this.saudeAtual > 0 ? "vivo" : "morto";
  }
  public String getNome() { return nome; }
  public void setNome(String nome) { this.nome = nome; }
  public void tomarDano(int quantidadeDeDano) {
    int saude = getSaudeAtual();
    if (saudeAtual < quantidadeDeDano) setSaudeAtual(0);
    else setSaudeAtual(saude - quantidadeDeDano);
  }
  public void receberCura(int quantidadeDeCura) {
    int saude = getSaudeAtual();
    if (saude + quantidadeDeCura > 100) setSaudeAtual(100);
    else setSaudeAtual(saude + quantidadeDeCura);
  }
  public String getStatus() { return status; }
}
