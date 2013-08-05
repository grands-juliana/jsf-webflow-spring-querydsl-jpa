package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta.parcela;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public enum SituacaoParcela {

    ABERTA("Aberta"),
    QUITADA("Quitada"),
    VENCIDA("Vencida"),
    QUITADA_PARCIAL("Quitada Parcial"),
    APROVAR("Aprovar");

    private final String descricao;

    private static final Map<String, SituacaoParcela> descricaoMap;

    static {
        ImmutableMap.Builder<String, SituacaoParcela> builder = ImmutableMap.builder();
        for (SituacaoParcela parcela : values()) {
            builder.put(parcela.getDescricao(), parcela);
        }
        descricaoMap = builder.build();
    }

    public static SituacaoParcela fromDescricao(String descricao) {
        return descricaoMap.get(descricao);
    }

    private SituacaoParcela(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
