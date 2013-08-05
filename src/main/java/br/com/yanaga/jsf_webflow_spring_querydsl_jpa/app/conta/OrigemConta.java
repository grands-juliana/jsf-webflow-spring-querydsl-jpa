package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public enum OrigemConta {

    FECHAMENTO("Fechamento"),
    DEVOLUCAO_CHEQUE("Devolução Cheque"),
    MANUAL("Manual");

    private final String descricao;

    private static final Map<String, OrigemConta> descricaoMap;

    static {
        ImmutableMap.Builder<String, OrigemConta> builder = ImmutableMap.builder();
        for (OrigemConta origem : OrigemConta.values()) {
            builder.put(origem.getDescricao(), origem);
        }
        descricaoMap = builder.build();
    }

    public static OrigemConta fromDescricao(String descricao) {
        return descricaoMap.get(descricao);
    }

    private OrigemConta(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
