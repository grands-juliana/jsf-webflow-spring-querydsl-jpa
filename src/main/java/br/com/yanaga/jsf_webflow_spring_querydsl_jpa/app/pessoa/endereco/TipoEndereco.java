package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.pessoa.endereco;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;

public enum TipoEndereco {

    COBRANCA("Cobrança"),
    COMERCIAL("Comercial"),
    ENTREGA("Entrega"),
    PRINCIPAL("Principal"),
    RESIDENCIAL("Residencial");

    private final String descricao;

    private static final Map<String, TipoEndereco> descricaoMap;

    static {
        Builder<String, TipoEndereco> builder = ImmutableMap.builder();
        for (TipoEndereco endereco : values()) {
            builder.put(endereco.getDescricao(), endereco);
        }
        descricaoMap = builder.build();
    }

    public static TipoEndereco fromDescricao(String descricao) {
        return descricaoMap.get(descricao);
    }

    private TipoEndereco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
