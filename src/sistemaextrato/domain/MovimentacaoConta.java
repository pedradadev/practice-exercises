package sistemaextrato.domain;

import java.util.Objects;

public class MovimentacaoConta {
    private Integer id;
    private Double valor;
    private TipoMovimentacao tipo;
    private Conta conta;

    public MovimentacaoConta(Double valor, TipoMovimentacao tipo, Conta conta) {
        this.valor = valor;
        this.tipo = tipo;
        this.conta = conta;
        this.id = (int) ((Math.random() * (1000 - 1)) + 1);         // Gerando o ID aleatorio da movimentação.
    }

    public Double getValor() {
        return valor;
    }

    public TipoMovimentacao getTipo() {
        return tipo;
    }

    public Conta getConta() {
        return conta;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovimentacaoConta that = (MovimentacaoConta) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
