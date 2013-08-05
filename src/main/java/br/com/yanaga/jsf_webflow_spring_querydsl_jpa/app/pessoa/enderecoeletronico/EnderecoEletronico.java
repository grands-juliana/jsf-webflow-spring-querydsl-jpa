package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.enderecoeletronico;

import br.com.insula.opes.Email;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.AbstractEntity;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.Pessoa;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class EnderecoEletronico extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private Email email;

    @NotNull
    private String descricao;

    @NotNull
    private TipoEnderecoEletronico tipoEnderecoEletronico;

    @NotNull
    private TipoEmail tipoEmail = TipoEmail._;

    private String responsavel;

    @ManyToOne
    @JoinColumn(name = "pessoa_fk", nullable = false)
    Pessoa pessoa;

    protected EnderecoEletronico() {
    }

    private EnderecoEletronico(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public static EnderecoEletronico newInstance(Pessoa pessoa) {
        Preconditions.checkNotNull(pessoa);
        return new EnderecoEletronico(pessoa);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof EnderecoEletronico) {
            EnderecoEletronico other = (EnderecoEletronico) obj;
            return Objects.equal(this.descricao, other.descricao) && Objects.equal(this.pessoa, other.pessoa)
                    && Objects.equal(this.tipoEnderecoEletronico, other.tipoEnderecoEletronico);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.descricao, this.tipoEnderecoEletronico, this.pessoa);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("Email", email).add("Descricao", descricao)
                .add("Pessoa", pessoa).add("Responsavel", responsavel).add("Tipo Email", tipoEmail)
                .add("Tipo endereco eletronico", tipoEnderecoEletronico).toString();
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoEnderecoEletronico getTipoEnderecoEletronico() {
        return tipoEnderecoEletronico;
    }

    public void setTipoEnderecoEletronico(
            TipoEnderecoEletronico tipoEnderecoEletronico) {
        this.tipoEnderecoEletronico = tipoEnderecoEletronico;
    }

    public TipoEmail getTipoEmail() {
        return tipoEmail;
    }

    public void setTipoEmail(TipoEmail tipoEmail) {
        this.tipoEmail = tipoEmail;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
