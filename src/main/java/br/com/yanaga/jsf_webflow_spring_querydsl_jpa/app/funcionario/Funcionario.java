package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.funcionario;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.AbstractEntity;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.Pessoa;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

@Entity
public class Funcionario extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    private String discriminatorClass = getClass().getSimpleName();

    @NotNull
    private boolean enable;

    @NotNull
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAdmissao;

    @ManyToOne
    @JoinColumn(nullable = false, name = "pessoa_fk")
    private Pessoa pessoa;

    private Funcionario(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    protected Funcionario() {
    }

    public static Funcionario newInstance(Pessoa pessoa) {
        Preconditions.checkNotNull(pessoa);
        return new Funcionario(pessoa);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Funcionario) {
            Funcionario other = (Funcionario) obj;
            return Objects.equal(this.pessoa, other.pessoa)
                    && Objects.equal(this.discriminatorClass, other.discriminatorClass);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.pessoa, this.discriminatorClass);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("enabel", enable).add("dataAdmissao", dataAdmissao)
                .add("discriminatorClass", discriminatorClass).add("pessoa", pessoa.toString()).toString();
    }

    public String getDiscriminatorClass() {
        return discriminatorClass;
    }

    public void setDiscriminatorClass(String discriminatorClass) {
        this.discriminatorClass = discriminatorClass;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
