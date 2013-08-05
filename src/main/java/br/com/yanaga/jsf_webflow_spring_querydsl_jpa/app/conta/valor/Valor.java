package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.valor;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.math.BigDecimal;

public class Valor implements Serializable {

    private static final long serialVersionUID = 1L;

    public final BigDecimal valor;

    private Valor(BigDecimal valor) {
        this.valor = valor;
    }

    public static Valor newInstance(BigDecimal valor) {
        Preconditions.checkNotNull(valor, "Valor não pode ser nulo.");
        Preconditions.checkArgument(valor.compareTo(BigDecimal.ZERO) < 0, "Valor tem que ser maior que zero.");

        return new Valor(valor);
    }

    @Override
    public String toString() {
        return valor.toString();
    }
}
