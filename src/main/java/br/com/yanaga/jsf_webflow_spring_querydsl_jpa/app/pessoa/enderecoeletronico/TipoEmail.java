package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.enderecoeletronico;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public enum TipoEmail {

    PRINCIPAL("Principal"),
    COBRANCA("Cobrança"),
    COMERCIAL("Comercial"),
    ADMINISTRATIVO("Administrativo"),
    EMPRESARIAL("Empresarial"),
    _("-");

    private final String descricao;

    private static final Map<String, TipoEmail> descricaoMap;

    static {
        ImmutableMap.Builder<String, TipoEmail> builder = ImmutableMap.builder();
        for (TipoEmail email : values()) {
            builder.put(email.getDescricao(), email);
        }
        descricaoMap = builder.build();
    }

    public static TipoEmail fromDescricao(String descricao) {
        return descricaoMap.get(descricao);
    }

    private TipoEmail(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
