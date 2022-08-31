package sistemaextrato.domain;

import java.util.Objects;

public class Banco {
    private String nome;
    private String cnpj;

    public String getNome() {
        return nome;
    }

    public Banco(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banco banco = (Banco) o;
        return cnpj.equals(banco.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj);
    }
}
