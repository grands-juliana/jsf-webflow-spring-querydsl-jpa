package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.contato;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;

public enum TipoOperadora {

    CTBC_TELECOM("CTBC Telecom"),
    CLARO("Claro"),
    NEXTEL("Nextel"),
    OI("Oi"),
    SERCOMTEL("Sercomtel"),
    TIM("Tim"),
    VIVO("Vivo"),
    _("-");

    private static final Map<String, TipoOperadora> descricaoMap;

    static {
        Builder<String, TipoOperadora> builder = ImmutableMap.builder();
        for (TipoOperadora operadora : values()) {
            if (operadora.descricao != null) {
                builder.put(operadora.descricao, operadora);
            }
        }
        descricaoMap = builder.build();
    }

    public static TipoOperadora fromDescricao(String descricao) {
        return descricaoMap.get(descricao);
    }

    private final String descricao;

    private TipoOperadora(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
