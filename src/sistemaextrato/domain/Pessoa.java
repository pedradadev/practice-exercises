package sistemaextrato.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pessoa {
    private String nome;
    private String rg;
    private String cpf;
    private List<Pessoa> dependetes = new ArrayList<>();
    private List<Conta> contas = new ArrayList<>();

    public Pessoa(String nome, String rg, String cpf) {
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Pessoa> getDependetes() {
        return dependetes;
    }

    public List<Conta> getContas() {
        return contas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return cpf.equals(pessoa.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
