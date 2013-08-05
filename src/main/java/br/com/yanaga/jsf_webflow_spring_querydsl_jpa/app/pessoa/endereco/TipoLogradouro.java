package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.endereco;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;

public enum TipoLogradouro {

    AVENIDA("Avenida"),
    DISTRITO("Distrito"),
    ESTRADA("Estrada"),
    LOTEAMENTO("Loteamento"),
    OUTROS("Outros"),
    RESIDENCIAL("Residencial"),
    RODOVIA("Rodovia"),
    RUA("Rua"),
    VIA("Via");

    private static final Map<String, TipoLogradouro> descricaoMap;

    static {
        Builder<String, TipoLogradouro> builder = ImmutableMap.builder();
        for (TipoLogradouro logradouro : values()) {
            if (logradouro.descricao != null) {
                builder.put(logradouro.descricao, logradouro);
            }
        }
        descricaoMap = builder.build();
    }

    public static TipoLogradouro fromDescricao(String string) {
        return descricaoMap.get(string);
    }

    private final String descricao;

    private TipoLogradouro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
