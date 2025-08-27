public class FolhaPagamento {
    private FolhaPagamento() {
        // static class
    }
    public static double calcularLiquido(Funcionario funcionario, CalculadorDeSalario calculo) {
        return calculo.calcular(funcionario.getSalario());
    }
}
