package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public enum SituacaoConta {

    ABERTA("Aberta"),
    QUITADA("Quitada"),
    VENCIDA("Vencida"),
    BLOQUEADA("Bloqueada");

    private final String descricao;

    private static final Map<String, SituacaoConta> descricaoMap;

    static {
        ImmutableMap.Builder<String, SituacaoConta> builder = ImmutableMap.builder();
        for (SituacaoConta situacao : SituacaoConta.values()) {
            builder.put(situacao.getDescricao(), situacao);
        }
        descricaoMap = builder.build();
    }

    public static SituacaoConta fromDescricao(String descricao) {
        return descricaoMap.get(descricao);
    }

    private SituacaoConta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
