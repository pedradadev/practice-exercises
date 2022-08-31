package sistemaextrato.application;

import sistemaextrato.domain.*;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Gabriel","99999-99","999.999.99-99");
        Banco banco = new Banco("Bradesco","00.000.000/0000-00");
        Conta conta = criaConta(1,22,TipoConta.CORRENTE,pessoa,banco);
        conta.depositar(2000D);
        conta.sacar(1000D);
        conta.vizualizarExtrato();
    }

    public static Conta criaConta(Integer numero, Integer agencia, TipoConta tipoConta, Pessoa pessoa, Banco banco){
        Conta conta = new Conta(numero, agencia, tipoConta, pessoa, banco);
        pessoa.getContas().add(conta);
        return conta;
    }
}
