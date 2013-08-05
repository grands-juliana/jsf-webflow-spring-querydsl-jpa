package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.documento;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.AbstractEntity;
import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.Conta;
import com.google.common.base.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Documento extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @JoinColumn(name = "conta_fk")
    @OneToOne(mappedBy = "documento")
    private Conta conta;

    @NotNull
    private String numeroDocumento;

    protected Documento() {
    }

    public static Documento newInstance() {
        return new Documento();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Documento) {
            Documento other = new Documento();
            return Objects.equal(this.conta, other.conta)
                    && Objects.equal(this.numeroDocumento, other.numeroDocumento);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.conta, this.numeroDocumento);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("numeroDocumento", numeroDocumento).add("conta", conta).toString();
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Conta getConta() {
        return conta;
    }
}
