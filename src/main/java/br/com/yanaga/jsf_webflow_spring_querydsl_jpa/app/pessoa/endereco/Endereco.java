package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.endereco;

import br.com.insula.opes.Cep;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.AbstractEntity;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.Pessoa;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Endereco extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Cep cep;

    @NotNull
    private TipoEndereco tipoEndereco = TipoEndereco.PRINCIPAL;

    @NotNull
    private TipoLogradouro tipoLogradouro = TipoLogradouro.OUTROS;

    @NotNull
    private String logradouro;

    @NotNull
    private String numero;

    private String complemento;

    @NotNull
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "pessoa_fk", nullable = false)
    Pessoa pessoa;

    protected Endereco() {
    }

    private Endereco(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public static Endereco newInstance(Pessoa pessoa) {
        Preconditions.checkNotNull(pessoa);
        return new Endereco(pessoa);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Endereco) {
            Endereco other = (Endereco) obj;
            return Objects.equal(other.logradouro, this.logradouro)
                    && Objects.equal(other.tipoEndereco, this.tipoEndereco)
                    && Objects.equal(other.tipoLogradouro, this.tipoLogradouro)
                    && Objects.equal(other.bairro, this.bairro)
                    && Objects.equal(other.numero, this.numero)
                    && Objects.equal(other.cep, this.cep);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.logradouro, this.tipoEndereco, this.tipoLogradouro, this.bairro, this.numero, this.cep);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("logradouro", logradouro)
                .add("tipoEndereco", tipoEndereco).add("tipoLogradouro", tipoLogradouro)
                .add("numero", numero).add("complemento", complemento).add("bairro", bairro)
                .add("cep", cep).toString();
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }
}
