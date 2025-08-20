import exceptions.OperacaoInvalidaException;

public class ContaBancariaBasica {
    private String numeracao;
    private double saldo;
    private double taxaJurosAnual;

    public ContaBancariaBasica(String numeracao, double taxaJurosAnual) {
        this.numeracao = numeracao;
        this.taxaJurosAnual = taxaJurosAnual;
        this.saldo = 0;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public void depositar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0)
            throw new OperacaoInvalidaException("Valor para deposito deve ser maior que 0");
        saldo += valor;
    }

    public void sacar(double valor) throws OperacaoInvalidaException {
        if (valor <= 0)
            throw new OperacaoInvalidaException("Valor de saque deve ser maior que 0");
        if (saldo < valor)
            throw new OperacaoInvalidaException("Valor de saque deve ser menor que o saldo atual");
        saldo -= valor;
    }

    public double calcularTarifaMensal() {
        var tarifa = 0.1 * saldo;
        return tarifa < 10 ? tarifa : 10;
    }

    public double calcularJurosMensal() {
        return saldo > 0
                //? saldo * (Math.pow(1 + taxaJurosAnual/100, 1.0 / 12) - 1)
                ? saldo * taxaJurosAnual / 12 / 100
                : 0;
    }
    public void aplicarAtualizacaoMensal() throws OperacaoInvalidaException {
        /*
        sacar(calcularTarifaMensal());
        depositar(calcularJurosMensal());
        */
        var tarifa = calcularTarifaMensal();
        var juros = calcularJurosMensal();
        saldo += juros - tarifa;
    }
}
