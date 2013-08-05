package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.parcela;

import br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.AbstractEntity;
import com.google.common.base.Objects;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class ValorPagoParcela extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    private BigDecimal valorPago;

    protected ValorPagoParcela() {
    }

    private ValorPagoParcela(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public static ValorPagoParcela newInstance(BigDecimal valorPago) {
        return new ValorPagoParcela(valorPago);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ValorPagoParcela) {
            ValorPagoParcela other = ((ValorPagoParcela) obj);
            Objects.equal(this.valorPago, other.valorPago);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.valorPago);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("valorPago", valorPago).toString();
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }
}
