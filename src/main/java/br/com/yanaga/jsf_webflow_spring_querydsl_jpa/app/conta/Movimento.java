package br.com.yanaga.jsf_webflow_spring_querydsl_jpa.app.conta;

import com.google.common.collect.ImmutableMap;
import java.util.Map;

public enum Movimento {

    ENTRADA("Entrada"),
    SAIDA("Saída");

    private final String descricao;

    private static final Map<String, Movimento> descricaoMap;

    static {
        ImmutableMap.Builder<String, Movimento> builder = ImmutableMap.builder();
        for (Movimento movimento : Movimento.values()) {
            builder.put(movimento.getDescricao(), movimento);
        }
        descricaoMap = builder.build();
    }

    public static Movimento fromString(String descricao) {
        return descricaoMap.get(descricao);
    }

    private Movimento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
