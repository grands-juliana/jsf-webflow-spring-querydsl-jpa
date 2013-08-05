package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.contato;

import br.com.insula.opes.Telefone;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.AbstractEntity;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.Pessoa;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Contato extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "pessoa_fk", nullable = false)
    Pessoa pessoa;

    @NotNull
    private Telefone telefone;

    @NotNull
    private TipoTelefone tipoTelefone = TipoTelefone.PRINCIPAL;

    @NotNull
    private TipoOperadora tipoOperadora = TipoOperadora._;

    private Boolean celular;

    private String responsavel;

    protected Contato() {
    }

    private Contato(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public static Contato newInstance(Pessoa pessoa) {
        Preconditions.checkNotNull(pessoa);
        return new Contato(pessoa);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Contato) {
            Contato other = (Contato) obj;
            return Objects.equal(this.celular, other.celular) && Objects.equal(this.pessoa, other.pessoa)
                    && Objects.equal(this.telefone, other.telefone)
                    && Objects.equal(this.tipoOperadora, other.tipoOperadora)
                    && Objects.equal(this.tipoTelefone, other.tipoTelefone);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.pessoa, this.telefone, this.tipoTelefone, this.tipoOperadora, this.celular);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("Celular", celular).add("Pessoa", pessoa)
                .add("Responsavel", responsavel).add("Telefone", telefone)
                .add("Operadora", tipoOperadora).add("Tipo Telefone", tipoTelefone)
                .toString();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public TipoTelefone getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public TipoOperadora getTipoOperadora() {
        return tipoOperadora;
    }

    public void setTipoOperadora(TipoOperadora tipoOperadora) {
        this.tipoOperadora = tipoOperadora;
    }

    public Boolean getCelular() {
        return celular;
    }

    public void setCelular(Boolean celular) {
        this.celular = celular;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
