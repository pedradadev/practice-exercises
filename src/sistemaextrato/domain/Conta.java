package sistemaextrato.domain;


import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Conta {
    private Integer numero;
    private Integer agencia;
    private Double saldo = 0D;
    private TipoConta tipoConta;
    private Pessoa pessoa;
    private Banco banco;
    private List<MovimentacaoConta> movimentacoes = new ArrayList<>();

    public Conta(Integer numero, Integer agencia, TipoConta tipoConta, Pessoa pessoa, Banco banco) {
        this.numero = numero;
        this.agencia = agencia;
        this.tipoConta = tipoConta;
        this.pessoa = pessoa;
        this.banco = banco;
    }


    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(Double valor){
        MovimentacaoConta movimentacaoConta = new MovimentacaoConta(valor,TipoMovimentacao.DEPOSITO,this);
        movimentacoes.add(movimentacaoConta);
        this.saldo += valor;
    }

    public void sacar(Double valor){
        if(valor > saldo){
            System.out.println("Não á saldo na conta suficiente para esse saque! ");
            return;
        }
        MovimentacaoConta movimentacaoConta = new MovimentacaoConta(valor,TipoMovimentacao.SAQUE,this);
        movimentacoes.add(movimentacaoConta);
        this.saldo -= valor;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void vizualizarExtrato(){
        System.out.println("Nome:"+pessoa.getNome()+" Agencia:"+this.getAgencia()+" Numero da conta:"+this.getNumero()+" Tipo da conta:"+ this.getTipoConta());
        for (MovimentacaoConta movimentacao : movimentacoes) {
            Double valorTruncado = BigDecimal.valueOf(movimentacao.getValor())
                    .setScale(3, RoundingMode.HALF_UP)
                    .doubleValue();
            System.out.println(movimentacao.getId()+ " "+movimentacao.getTipo()+ " R$"+ valorTruncado);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return numero.equals(conta.numero) && agencia.equals(conta.agencia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, agencia);
    }
}
