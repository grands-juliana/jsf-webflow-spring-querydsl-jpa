package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.Serializable;

public class NomeRazaoSocial implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String value;

    private NomeRazaoSocial(String value) {
        this.value = value;
    }

    public static NomeRazaoSocial newInstance(String value) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(value), "Campo é obrigatória.");
        Preconditions.checkArgument(value.length() > 3, "Campo deve ter mais que 3 caracteres.");
        return new NomeRazaoSocial(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
